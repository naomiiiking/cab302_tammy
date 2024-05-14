package com.example.addressbook.tammy2;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;
import com.example.addressbook.tammy2.TammyDatabase.TammyDAO;
import com.example.addressbook.tammy2.functions.TimeCalculators;
import com.example.addressbook.tammy2.tammy.Tammys;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.example.addressbook.tammy2.tammy.Tammys;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.addressbook.tammy2.HelloApplication.showHomePage;

public class AuthenController {

    @FXML
    private HBox topButtons;

    private TammyDAO tammyDAO;

    private UserAccountDAO userAccountDAO;
    private TimeCalculators timeCalculators;

    public AuthenController(){
        tammyDAO = new TammyDAO();
        userAccountDAO = new UserAccountDAO();
        timeCalculators = new TimeCalculators();
    }
    // Map for storing user session
    static Map<String, UserAccount> userSession = new HashMap<>();


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
