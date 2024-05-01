package com.example.addressbook.tammy2;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;


public class MenuController {
    private static String username;
    public static void setUsername(String UserName){
        username = UserName;
    }

    @FXML
    private VBox settingsBody;
    @FXML

    private HBox usernameSection;
    @FXML
    private Label currentUserName;
    @FXML
    private TextField userNameField;

    @FXML
    private HBox emailSection;
    @FXML
    private Label currentEmail;
    @FXML
    private TextField emailField;

    @FXML
    private HBox passwordSection;
    @FXML
    private Label currentPassword;
    @FXML
    private TextField passwordField;

    public void initialize() {
        settingsBody.setSpacing(5);
        settingsBody.setAlignment(Pos.CENTER);

        usernameSection.setSpacing(5);
        currentUserName.setText("Current username: " + username);
        //userNameField.setMaxWidth(200);

        emailSection.setSpacing(5);
        //emailField.setMaxWidth(200);

        passwordSection.setSpacing(5);
        //passwordField.setMaxWidth(200);

    }

    /**
     * Submit account change by collecting textfield data
     * and calling update function
     */
    public void submitAccountChange(){
        // Get user ID from username then get userAccount from userID
        // int userID = UserAccountDAO.findIDFromName(username);
        // UserAccount userAccount = UserAccountDAO.getById(userID);

        // Use user ID to update user's details with modified details
        // UserAccountDAO.update(userAccount);
    }
}
