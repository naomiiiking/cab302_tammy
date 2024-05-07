package com.example.addressbook.tammy2;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;
import com.example.addressbook.tammy2.TammyDatabase.TammyDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.example.addressbook.tammy2.tammy.Tammys;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

import static com.example.addressbook.tammy2.HelloApplication.*;

public class AuthenController {

    @FXML
    private HBox topButtons;

    public void initialize() {
        // Top buttons
        topButtons.setSpacing(5);
        topButtons.setAlignment(Pos.CENTER);
    }

    // Load login page
    public void handleLoginButtonClicked() throws Exception {
        showLoginPage();
    }

    // Load register page
    public void handleRegisterButtonClicked() throws Exception {
        showRegisterPage();
    }
}
