package com.example.flujosdecaracterr.Vista;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class EstadisticasTextoVista extends GridPane {

    private final TextField rutaField = new TextField();
    private final Button btnBuscar = new Button("Buscar archivo");
    private final Button btnCalcular = new Button("Calcular");

    private final Label lineasLabel = new Label("Líneas: 0");
    private final Label palabrasLabel = new Label("Palabras: 0");
    private final Label caracteresLabel = new Label("Caracteres: 0");

    private final HBox topBar = new HBox(10);

    public EstadisticasTextoVista() {
        setPadding(new Insets(20));
        setHgap(10);
        setVgap(10);

        topBar.setPadding(new Insets(0,0,10,0));
        add(topBar, 0, 0, 3, 1);

        add(new Label("Ruta del archivo:"), 0, 1);
        add(rutaField, 1, 1);
        add(btnBuscar, 2, 1);

        add(btnCalcular, 1, 2);

        add(lineasLabel, 0, 3);
        add(palabrasLabel, 0, 4);
        add(caracteresLabel, 0, 5);
    }

    public void setTopBar(Button volver) {
        topBar.getChildren().add(volver);
    }

    public TextField getRutaField() { return rutaField; }
    public Button getBtnBuscar() { return btnBuscar; }
    public Button getBtnCalcular() { return btnCalcular; }

    public void setResultados(int lineas, int palabras, int caracteres) {
        lineasLabel.setText("Líneas: " + lineas);
        palabrasLabel.setText("Palabras: " + palabras);
        caracteresLabel.setText("Caracteres: " + caracteres);
    }
}