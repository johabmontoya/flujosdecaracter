package com.example.flujosdecaracterr.Vista;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class EncriptadorXorVista extends VBox {
    private final Label lblClave = new Label("Clave (0-255):");
    private final TextField txtClave = new TextField();
    private final Button btnSeleccionar = new Button("Seleccionar archivo");
    private final Label lblEstado = new Label("");
    private final Button btnVolver = new Button("← Volver al menú");

    public EncriptadorXorVista() {
        setSpacing(15);
        txtClave.setMaxWidth(100);
        getChildren().addAll(lblClave, txtClave, btnSeleccionar, lblEstado, btnVolver);
    }

    public TextField getTxtClave() { return txtClave; }
    public Button getBtnSeleccionar() { return btnSeleccionar; }
    public Label getLblEstado() { return lblEstado; }
    public Button getBtnVolver() { return btnVolver; }
}