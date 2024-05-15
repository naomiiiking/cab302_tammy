package com.example.addressbook.tammy2;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class MenuController {
    private static final String username = AuthenController.userSession.get("loggedInUser").getUsername();

    @FXML
    private VBox settingsBody;
    @FXML
    private Label currentUserName;
    @FXML
    private TextField userNameField;
    @FXML
    private Label currentEmail;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private VBox settingsButtons;

    public void initialize() {
        settingsBody.setSpacing(10);
        settingsBody.setAlignment(Pos.CENTER);

        currentUserName.setText("Current username: " + username);
        userNameField.setMaxWidth(400);
        userNameField.setPromptText("Change username");

        currentEmail.setText("Current email: null");
        emailField.setMaxWidth(400);
        emailField.setPromptText("Change email");

        passwordField.setMaxWidth(400);
        passwordField.setPromptText("Change password");

        settingsButtons.setAlignment(Pos.CENTER);
        settingsButtons.setSpacing(10);
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

    public void handleBackButton() throws Exception {
        HelloApplication.showHomePage();
    }
}
