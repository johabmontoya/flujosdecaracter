package com.example.flujosdecaracterr.Controlador;

import com.example.flujosdecaracterr.Modelo.EditorNotasModelo;
import com.example.flujosdecaracterr.Vista.EditorNotasVista;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class EditorNotasControlador {
    private final EditorNotasModelo modelo;
    private final EditorNotasVista vista;
    private final FileChooser fileChooser = new FileChooser();

    public EditorNotasControlador(EditorNotasModelo modelo, EditorNotasVista vista, Stage stage) {
        this.modelo = modelo;
        this.vista = vista;

        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Archivos de texto", "*.txt")
        );

        vista.getAbrir().setOnAction(e -> abrir(stage));
        vista.getGuardar().setOnAction(e -> guardar());
        vista.getGuardarComo().setOnAction(e -> guardarComo(stage));
    }

    private void abrir(Stage stage) {
        File archivo = fileChooser.showOpenDialog(stage);
        if (archivo != null) {
            try {
                String contenido = modelo.cargarArchivo(archivo.getAbsolutePath());
                vista.getTextArea().setText(contenido);
            } catch (IOException ex) {
                mostrarError("Error al abrir: " + ex.getMessage());
            }
        }
    }

    private void guardar() {
        try {
            modelo.guardar(vista.getTextArea().getText());
        } catch (IOException ex) {
            mostrarError("Error al guardar: " + ex.getMessage());
        }
    }

    private void guardarComo(Stage stage) {
        File archivo = fileChooser.showSaveDialog(stage);
        if (archivo != null) {
            try {
                modelo.guardarComo(archivo.getAbsolutePath(), vista.getTextArea().getText());
            } catch (IOException ex) {
                mostrarError("Error al guardar: " + ex.getMessage());
            }
        }
    }

    private void mostrarError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}