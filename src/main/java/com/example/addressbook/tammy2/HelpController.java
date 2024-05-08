package com.example.addressbook.tammy2;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HelpController {
    private static final String username = UserAccount.getUsername();
    @FXML
    private Label helpText;
    public String helpTextContents =
            "Feeling a bit lost? The Tammy app is made to help you get back on track\n" +
                    "Now that you have created your Tammy, keep it happy with food, water and pats.\n" +
                    "All of which you can buy at the store! To get credits, fill out your logs daily\n" +
                    "to keep track of your progress!\n";;
    @FXML
    private Label userNameLabel;
    @FXML
    private VBox helpPage;

    public void initialize() {
        userNameLabel.setText("User:" + username);
        helpPage.setSpacing(5);

        helpText.setText(helpTextContents);
        helpText.setWrapText(true);
    }

    @FXML
    void handleBackButton() throws Exception {
        HelloApplication.showHomePage();
    }
}
