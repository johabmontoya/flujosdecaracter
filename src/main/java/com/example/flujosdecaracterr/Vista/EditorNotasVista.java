package com.example.flujosdecaracterr.Vista;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class EditorNotasVista extends BorderPane {
    private final TextArea textArea = new TextArea();
    private final Button abrir = new Button("Abrir");
    private final Button guardar = new Button("Guardar");
    private final Button guardarComo = new Button("Guardar como");

    private final HBox topBar = new HBox(10);

    public EditorNotasVista() {
        topBar.getChildren().addAll(abrir, guardar, guardarComo);
        setTop(topBar);
        setCenter(textArea);
    }

    public void setTopBar(Button volver) {
        topBar.getChildren().add(0, volver);
    }

    public TextArea getTextArea() { return textArea; }
    public Button getAbrir() { return abrir; }
    public Button getGuardar() { return guardar; }
    public Button getGuardarComo() { return guardarComo; }
}