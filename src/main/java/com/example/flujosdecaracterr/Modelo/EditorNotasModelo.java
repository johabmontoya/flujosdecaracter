package com.example.flujosdecaracterr.Modelo;

import java.io.*;

public class EditorNotasModelo {
    private File archivoActual;

    public String cargarArchivo(String ruta) throws IOException {
        File archivo = new File(ruta);
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        archivoActual = archivo;
        return contenido.toString();
    }

    public void guardar(String texto) throws IOException {
        if (archivoActual == null) throw new IOException("No hay archivo actual.");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoActual))) {
            writer.write(texto);
        }
    }

    public void guardarComo(String ruta, String texto) throws IOException {
        File archivo = new File(ruta);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(texto);
        }
        archivoActual = archivo;
    }

    public File getArchivoActual() {
        return archivoActual;
    }
}