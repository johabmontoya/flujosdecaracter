package com.example.flujosdecaracterr.Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EstadisticasTextoModelo {

    public int contarLineas(String ruta) throws IOException {
        int lineas = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            while (reader.readLine() != null) lineas++;
        }
        return lineas;
    }

    public int contarPalabras(String ruta) throws IOException {
        int palabras = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    palabras += linea.trim().split("\\s+").length;
                }
            }
        }
        return palabras;
    }

    public int contarCaracteres(String ruta) throws IOException {
        int caracteres = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                caracteres += linea.length();
            }
        }
        return caracteres;
    }
}