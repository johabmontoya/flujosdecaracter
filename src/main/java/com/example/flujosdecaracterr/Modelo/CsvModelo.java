package com.example.flujosdecaracterr.Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvModelo {

    public List<List<String>> leerCsv(String ruta) throws IOException {
        List<List<String>> filas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                List<String> fila = new ArrayList<>();
                for (String p : partes) fila.add(p.trim());
                filas.add(fila);
            }
        }
        return filas;
    }
}