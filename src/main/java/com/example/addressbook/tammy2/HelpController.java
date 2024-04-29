package com.example.addressbook.tammy2;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HelpController {

    @FXML
    private Text helpText;
    // Set username on help page and set back button to take user back to homepage
    @FXML
    private Label usernameLabel;
    @FXML
    private VBox helpPage;

    private static String username;

    void initialize() {
        usernameLabel.setText(username);
        helpPage.setAlignment(Pos.CENTER);
        helpPage.setSpacing(5);
        helpText.setWrappingWidth(0);
    }

    @FXML
    void handleBackButton() throws Exception {
        HelloApplication.showHomePage(username);
    }
}
