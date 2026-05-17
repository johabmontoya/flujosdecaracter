package com.example.flujosdecaracterr.Vista;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class IdentificadorTiposVista extends VBox {
    private final Button btnSeleccionar = new Button("Seleccionar archivo");
    private final Label lblResultado = new Label("");
    private final Button btnVolver = new Button("← Volver al menú");

    public IdentificadorTiposVista() {
        setSpacing(15);
        getChildren().addAll(btnSeleccionar, lblResultado, btnVolver);
    }

    public Button getBtnSeleccionar() { return btnSeleccionar; }
    public Label getLblResultado() { return lblResultado; }
    public Button getBtnVolver() { return btnVolver; }
}