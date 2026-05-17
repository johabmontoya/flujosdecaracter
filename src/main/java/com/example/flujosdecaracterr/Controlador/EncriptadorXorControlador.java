package com.example.flujosdecaracterr.Controlador;

import com.example.flujosdecaracterr.Modelo.EncriptadorXorModelo;
import com.example.flujosdecaracterr.Vista.EncriptadorXorVista;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class EncriptadorXorControlador {
    public EncriptadorXorControlador(EncriptadorXorModelo modelo, EncriptadorXorVista vista, Stage stage) {
        vista.getBtnSeleccionar().setOnAction(e -> {
            try {
                int clave = Integer.parseInt(vista.getTxtClave().getText());
                if (clave < 0 || clave > 255) {
                    vista.getLblEstado().setText("La clave debe estar entre 0 y 255.");
                    return;
                }

                FileChooser fc = new FileChooser();
                File origen = fc.showOpenDialog(stage);
                if (origen == null) return;

                FileChooser fs = new FileChooser();
                fs.setInitialFileName("encriptado_" + origen.getName());
                File destino = fs.showSaveDialog(stage);
                if (destino == null) return;

                String msg = modelo.encriptar(origen, destino, clave);
                vista.getLblEstado().setText(msg);

            } catch (NumberFormatException ex) {
                vista.getLblEstado().setText("Ingresa un número válido.");
            }
        });
    }
}