package com.example.flujosdecaracterr.Vista;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ClonadorImagenesVista extends VBox {
    private final Button btnSeleccionar = new Button("Seleccionar imagen");
    private final ProgressBar barra = new ProgressBar(0);
    private final Label lblProgreso = new Label("");
    private final Label lblEstado = new Label("");
    private final Button btnVolver = new Button("← Volver al menú");

    public ClonadorImagenesVista() {
        setSpacing(15);
        getChildren().addAll(btnSeleccionar, barra, lblProgreso, lblEstado, btnVolver);
    }

    public Button getBtnSeleccionar() { return btnSeleccionar; }
    public ProgressBar getBarra() { return barra; }
    public Label getLblProgreso() { return lblProgreso; }
    public Label getLblEstado() { return lblEstado; }
    public Button getBtnVolver() { return btnVolver; }
}