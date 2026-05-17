package com.example.flujosdecaracterr.Modelo;

import javafx.concurrent.Task;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ClonadorImagenesModelo {
    public Task<Void> clonar(File origen, File carpetaDestino) {
        return new Task<>() {
            @Override
            protected Void call() throws Exception {
                File destino = new File(carpetaDestino, "copia_" + origen.getName());
                try (FileInputStream in = new FileInputStream(origen);
                     FileOutputStream out = new FileOutputStream(destino)) {

                    byte[] buffer = new byte[8192];
                    int leidos;
                    long total = origen.length();
                    long acumulado = 0;

                    while ((leidos = in.read(buffer)) != -1) {
                        out.write(buffer, 0, leidos);
                        acumulado += leidos;
                        updateProgress(acumulado, total);
                    }
                }
                return null;
            }
        };
    }
}