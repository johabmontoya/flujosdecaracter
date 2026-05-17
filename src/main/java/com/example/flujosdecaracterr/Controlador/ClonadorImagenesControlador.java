package com.example.flujosdecaracterr.Controlador;

import com.example.flujosdecaracterr.Modelo.ClonadorImagenesModelo;
import com.example.flujosdecaracterr.Vista.ClonadorImagenesVista;
import javafx.concurrent.Task;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ClonadorImagenesControlador {
    public ClonadorImagenesControlador(ClonadorImagenesModelo modelo, ClonadorImagenesVista vista, Stage stage) {
        vista.getBtnSeleccionar().setOnAction(e -> {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp"));
            File origen = fc.showOpenDialog(stage);
            if (origen == null) return;

            DirectoryChooser dc = new DirectoryChooser();
            dc.setInitialDirectory(origen.getParentFile());
            File destino = dc.showDialog(stage);
            if (destino == null) return;

            Task<Void> tarea = modelo.clonar(origen, destino);
            vista.getBarra().progressProperty().bind(tarea.progressProperty());
            tarea.progressProperty().addListener((o,v,n) ->
                    vista.getLblProgreso().setText((int)(n.doubleValue()*100) + "%"));

            tarea.setOnSucceeded(ev -> vista.getLblEstado().setText("Archivo copiado correctamente."));
            tarea.setOnFailed(ev -> vista.getLblEstado().setText("Error al copiar."));
            new Thread(tarea).start();
        });
    }
}