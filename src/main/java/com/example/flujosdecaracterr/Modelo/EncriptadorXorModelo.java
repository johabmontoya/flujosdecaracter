package com.example.flujosdecaracterr.Modelo;

import java.io.*;

public class EncriptadorXorModelo {
    public String encriptar(File origen, File destino, int clave) {
        try (FileInputStream in = new FileInputStream(origen);
             FileOutputStream out = new FileOutputStream(destino)) {

            int b;
            while ((b = in.read()) != -1) {
                out.write(b ^ clave);
            }
            return "Archivo encriptado correctamente.";
        } catch (FileNotFoundException e) {
            return "Archivo no encontrado: " + e.getMessage();
        } catch (SecurityException e) {
            return "Permiso denegado: " + e.getMessage();
        } catch (IOException e) {
            return "Error de E/S: " + e.getMessage();
        }
    }
}