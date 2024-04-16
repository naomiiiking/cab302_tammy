package com.example.addressbook.tammy2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MenuController {
    @FXML
    private Label pageName;

    public void initialize() {
        pageName.setText("menu page");
    }
}
