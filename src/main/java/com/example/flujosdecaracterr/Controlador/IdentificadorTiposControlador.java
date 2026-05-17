package com.example.flujosdecaracterr.Controlador;

import com.example.flujosdecaracterr.Modelo.IdentificadorTiposModelo;
import com.example.flujosdecaracterr.Vista.IdentificadorTiposVista;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class IdentificadorTiposControlador {
    public IdentificadorTiposControlador(IdentificadorTiposVista vista, Stage stage) {
        vista.getBtnSeleccionar().setOnAction(e -> {
            FileChooser fc = new FileChooser();
            File archivo = fc.showOpenDialog(stage);
            if (archivo == null) return;

            IdentificadorTiposModelo modelo = new IdentificadorTiposModelo(archivo);
            byte[] bytes = modelo.leerBytes(12);
            vista.getLblResultado().setText("Formato: " + modelo.detectar(bytes));
        });
    }
}