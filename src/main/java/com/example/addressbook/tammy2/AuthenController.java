package com.example.addressbook.tammy2;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.tammy.Tammys;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.HashMap;
import java.util.Map;

import static com.example.addressbook.tammy2.HelloApplication.showLoginPage;
import static com.example.addressbook.tammy2.HelloApplication.showRegisterPage;

public class AuthenController {

    @FXML
    private HBox topButtons;

    public static Map<String, UserAccount> userSession = new HashMap<>();
    static Map<String, Tammys> tammySession = new HashMap<>();

    public void initialize() {

        // Top buttons
        topButtons.setSpacing(20);
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
