package com.example.addressbook.tammy2;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
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

    //static UserAccount loggedInUser = AuthenController.getCurrentUser();
    @FXML
    private Label userNameLabel;
    private static String username = UserAccount.getUsername(); //Replace this with query to get username from database
    @FXML
    private VBox helpPage;
    public static void setUsername(String UserName){
        username = UserName;
    }

    void initialize() {
        userNameLabel.setText("User:");
        helpPage.setAlignment(Pos.CENTER);
        helpPage.setSpacing(5);
        helpText.setWrappingWidth(0);
    }

    @FXML
    void handleBackButton() throws Exception {
        HelloApplication.showHomePage();
    }
}
