package com.example.flujosdecaracterr.Controlador;

import com.example.flujosdecaracterr.Modelo.CsvModelo;
import com.example.flujosdecaracterr.Vista.CsvVista;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class CsvControlador {

    private final CsvModelo modelo;
    private final CsvVista vista;
    private final FileChooser fileChooser = new FileChooser();

    public CsvControlador(CsvModelo modelo, CsvVista vista, Stage stage) {
        this.modelo = modelo;
        this.vista = vista;

        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("CSV", "*.csv")
        );

        vista.getBtnAbrir().setOnAction(e -> abrir(stage));
    }

    private void abrir(Stage stage) {
        File archivo = fileChooser.showOpenDialog(stage);
        if (archivo != null) {
            try {
                List<List<String>> filas = modelo.leerCsv(archivo.getAbsolutePath());
                cargarTabla(filas);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Error al leer CSV: " + e.getMessage());
                alert.showAndWait();
            }
        }
    }

    private void cargarTabla(List<List<String>> filas) {
        vista.getTable().getColumns().clear();
        vista.getTable().getItems().clear();

        if (filas.isEmpty()) return;

        int columnas = filas.get(0).size();
        for (int i = 0; i < columnas; i++) {
            final int colIndex = i;
            TableColumn<ObservableList<String>, String> col = new TableColumn<>("Col " + (i + 1));
            col.setCellValueFactory(data
                    -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(colIndex)));
            col.setCellFactory(TextFieldTableCell.forTableColumn());
            vista.getTable().getColumns().add(col);
        }

        for (List<String> fila : filas) {
            ObservableList<String> row = FXCollections.observableArrayList(fila);
            vista.getTable().getItems().add(row);
        }
    }
}