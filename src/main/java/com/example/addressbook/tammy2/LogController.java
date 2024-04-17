package com.example.addressbook.tammy2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LogController {
    @FXML
    private Label logName;

    public void initialize() {
        logName.setText("log page");
    }
}
