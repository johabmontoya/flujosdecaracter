package com.example.flujosdecaracterr.Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class IdentificadorTiposModelo {
    private final File archivo;

    public IdentificadorTiposModelo(File archivo) {
        this.archivo = archivo;
    }

    public byte[] leerBytes(int cantidad) {
        byte[] buffer = new byte[cantidad];
        try (FileInputStream in = new FileInputStream(archivo)) {
            int leidos = in.read(buffer);
            if (leidos == -1) return new byte[0];
            return leidos < cantidad ? Arrays.copyOf(buffer, leidos) : buffer;
        } catch (IOException e) {
            return new byte[0];
        }
    }

    private boolean coincide(byte[] data, int offset, byte[] firma) {
        if (data.length < offset + firma.length) return false;
        for (int i = 0; i < firma.length; i++) {
            if ((data[offset + i] & 0xFF) != (firma[i] & 0xFF)) return false;
        }
        return true;
    }

    public String detectar(byte[] bytes) {
        if (bytes.length == 0) return "No se pudo leer el archivo.";

        byte[] PDF = {(byte)0x25,(byte)0x50,(byte)0x44,(byte)0x46,(byte)0x2D};
        byte[] JPEG_E0 = {(byte)0xFF,(byte)0xD8,(byte)0xFF,(byte)0xE0};
        byte[] JPEG_E1 = {(byte)0xFF,(byte)0xD8,(byte)0xFF,(byte)0xE1};
        byte[] PNG = {(byte)0x89,(byte)0x50,(byte)0x4E,(byte)0x47,(byte)0x0D,(byte)0x0A,(byte)0x1A,(byte)0x0A};
        byte[] ZIP = {(byte)0x50,(byte)0x4B,(byte)0x03,(byte)0x04};
        byte[] MP4 = {(byte)0x66,(byte)0x74,(byte)0x79,(byte)0x70};
        byte[] GIF = {(byte)0x47,(byte)0x49,(byte)0x46,(byte)0x38};

        if (coincide(bytes, 0, PDF)) return "PDF";
        if (coincide(bytes, 0, JPEG_E0) || coincide(bytes, 0, JPEG_E1)) return "JPEG";
        if (coincide(bytes, 0, PNG)) return "PNG";
        if (coincide(bytes, 0, ZIP)) return "ZIP / DOCX / XLSX / JAR";
        if (coincide(bytes, 4, MP4)) return "MP4";
        if (coincide(bytes, 0, GIF)) return "GIF";

        return "Formato desconocido";
    }
}