package com.example.flujosdecaracterr;

import com.example.flujosdecaracterr.Controlador.*;
import com.example.flujosdecaracterr.Modelo.*;
import com.example.flujosdecaracterr.Vista.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #f4f4f4;");

        // Vistas
        EditorNotasVista vistaEditor = new EditorNotasVista();
        EstadisticasTextoVista vistaEst = new EstadisticasTextoVista();
        CsvVista vistaCsv = new CsvVista();
        ClonadorImagenesVista vistaClonador = new ClonadorImagenesVista();
        EncriptadorXorVista vistaXor = new EncriptadorXorVista();
        IdentificadorTiposVista vistaTipos = new IdentificadorTiposVista();

        // Modelos y controladores
        new EditorNotasControlador(new EditorNotasModelo(), vistaEditor, stage);
        new EstadisticasTextoControlador(new EstadisticasTextoModelo(), vistaEst, stage);
        new CsvControlador(new CsvModelo(), vistaCsv, stage);
        new ClonadorImagenesControlador(new ClonadorImagenesModelo(), vistaClonador, stage);
        new EncriptadorXorControlador(new EncriptadorXorModelo(), vistaXor, stage);
        new IdentificadorTiposControlador(vistaTipos, stage);

        // Botones volver
        Button volver1 = new Button("← Volver al menú");
        Button volver2 = new Button("← Volver al menú");
        Button volver3 = new Button("← Volver al menú");

        String btnBack = "-fx-background-color: #e0e0e0; -fx-text-fill: #111; -fx-border-color: #bbb; -fx-border-radius: 6; -fx-background-radius: 6; -fx-padding: 8 14;";

        volver1.setStyle(btnBack);
        volver2.setStyle(btnBack);
        volver3.setStyle(btnBack);

        vistaEditor.setTopBar(volver1);
        vistaEst.setTopBar(volver2);
        vistaCsv.setTopBar(volver3);

        vistaClonador.getBtnVolver().setStyle(btnBack);
        vistaXor.getBtnVolver().setStyle(btnBack);
        vistaTipos.getBtnVolver().setStyle(btnBack);

        // Inicio
        VBox inicio = new VBox(15);
        inicio.setAlignment(Pos.CENTER);
        inicio.setPadding(new Insets(40));
        inicio.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-border-radius: 10; -fx-background-radius: 10;");

        Label titulo = new Label("Flujos de Caracteres");
        titulo.setStyle("-fx-text-fill: #111; -fx-font-size: 26px; -fx-font-weight: bold;");

        Button btnEditor = new Button("Editor de Notas");
        Button btnEst = new Button("Estadísticas de Texto");
        Button btnCsv = new Button("Visualizador CSV");
        Button btnClonador = new Button("Clonador de Imágenes");
        Button btnXor = new Button("Encriptador XOR");
        Button btnTipos = new Button("Identificador de Tipos");

        String btnPrimary = "-fx-background-color: #1976d2; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10 18; -fx-background-radius: 6;";

        btnEditor.setStyle(btnPrimary);
        btnEst.setStyle(btnPrimary);
        btnCsv.setStyle(btnPrimary);
        btnClonador.setStyle(btnPrimary);
        btnXor.setStyle(btnPrimary);
        btnTipos.setStyle(btnPrimary);

        inicio.getChildren().addAll(titulo, btnEditor, btnEst, btnCsv, btnClonador, btnXor, btnTipos);

        // Navegación
        btnEditor.setOnAction(e -> root.setCenter(vistaEditor));
        btnEst.setOnAction(e -> root.setCenter(vistaEst));
        btnCsv.setOnAction(e -> root.setCenter(vistaCsv));
        btnClonador.setOnAction(e -> root.setCenter(vistaClonador));
        btnXor.setOnAction(e -> root.setCenter(vistaXor));
        btnTipos.setOnAction(e -> root.setCenter(vistaTipos));

        volver1.setOnAction(e -> root.setCenter(inicio));
        volver2.setOnAction(e -> root.setCenter(inicio));
        volver3.setOnAction(e -> root.setCenter(inicio));
        vistaClonador.getBtnVolver().setOnAction(e -> root.setCenter(inicio));
        vistaXor.getBtnVolver().setOnAction(e -> root.setCenter(inicio));
        vistaTipos.getBtnVolver().setOnAction(e -> root.setCenter(inicio));

        root.setCenter(inicio);

        Scene scene = new Scene(root, 900, 600);
        stage.setTitle("App de Flujos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}