package com.example.flujosdecaracterr.Controlador;

import com.example.flujosdecaracterr.Modelo.EstadisticasTextoModelo;
import com.example.flujosdecaracterr.Vista.EstadisticasTextoVista;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class EstadisticasTextoControlador {

    private final EstadisticasTextoModelo modelo;
    private final EstadisticasTextoVista vista;
    private final FileChooser fileChooser = new FileChooser();

    public EstadisticasTextoControlador(EstadisticasTextoModelo modelo, EstadisticasTextoVista vista, Stage stage) {
        this.modelo = modelo;
        this.vista = vista;

        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Archivos de texto", "*.txt")
        );

        vista.getBtnBuscar().setOnAction(e -> buscarArchivo(stage));
        vista.getBtnCalcular().setOnAction(e -> calcular());
    }

    private void buscarArchivo(Stage stage) {
        File archivo = fileChooser.showOpenDialog(stage);
        if (archivo != null) {
            vista.getRutaField().setText(archivo.getAbsolutePath());
        }
    }

    private void calcular() {
        String ruta = vista.getRutaField().getText();
        try {
            int lineas = modelo.contarLineas(ruta);
            int palabras = modelo.contarPalabras(ruta);
            int caracteres = modelo.contarCaracteres(ruta);
            vista.setResultados(lineas, palabras, caracteres);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo leer el archivo:\n" + e.getMessage());
            alert.showAndWait();
        }
    }
}