package com.example.flujosdecaracterr.Vista;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class CsvVista extends BorderPane {
    private final TableView<javafx.collections.ObservableList<String>> table = new TableView<>();
    private final Button btnAbrir = new Button("Abrir CSV");
    private final HBox topBar = new HBox(10);

    public CsvVista() {
        topBar.getChildren().add(btnAbrir);
        setTop(topBar);
        setCenter(table);
    }

    public void setTopBar(Button volver) {
        topBar.getChildren().add(0, volver);
    }

    public TableView<javafx.collections.ObservableList<String>> getTable() { return table; }
    public Button getBtnAbrir() { return btnAbrir; }
}