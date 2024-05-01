package com.example.addressbook.tammy2;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;


public class HomeController {

    @FXML
    private Label userNameLabel;
    private static String username; //Replace this with query to get username from database
    @FXML
    private Label creditsLabel;
    private int credits =  20; //Replace this with query to get credits from database
    @FXML
    private Label streakLabel;
    private int streak =  45; //Replace this with query to get streak from database
    @FXML
    private VBox buttonsVbox;
    @FXML
    private HBox buttonsHbox;
    @FXML
    private ImageView tammyImage;
    @FXML
    private VBox imageVbox;
    @FXML
    private String tammyImageAddress = "/assets/1.png";
    @FXML
    private Label tammyName;
    @FXML
    private VBox vitalsVbox;
    @FXML
    private ProgressBar waterProgressBar;
    @FXML
    private ProgressBar foodProgressBar;
    @FXML
    private ProgressBar happinessProgressBar;

    public static void setUsername(String UserName){
        username = UserName;
    }

    public void initialize() {
        // Initialize Menu Section
        userNameLabel.setText("Welcome back: " + username);
        creditsLabel.setText("Credits: $" + credits);
        streakLabel.setText("Streak: " + streak + " days");
        buttonsVbox.setSpacing(5);
        buttonsHbox.setSpacing(5);

        // Initialize Tammy Image and Name
        Image image = new Image(getClass().getResourceAsStream(tammyImageAddress));
        tammyImage.setImage(image);
        tammyName.setText("Mr Bean");
        imageVbox.setSpacing(5);

        // Initialize Vitals Progressbars
        vitalsVbox.setSpacing(5);
        waterProgressBar.setProgress(0.5);
        waterProgressBar.setMinHeight(30);
        waterProgressBar.setMinWidth(200);
        foodProgressBar.setProgress(0.75);
        foodProgressBar.setMinHeight(30);
        foodProgressBar.setMinWidth(200);
        happinessProgressBar.setProgress(0.25);
        happinessProgressBar.setMinHeight(30);
        happinessProgressBar.setMinWidth(200);

    }

    // Functions for handling page navigation
    @FXML
    private void handleLogButtonClicked(){
        try {
            HelloApplication.showLogPage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleMemoriesButtonClicked(){
        try {
            HelloApplication.showMemoriesPage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleHelpButtonClicked(){
        try {
            HelloApplication.showHelpPage(username);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleMenuButtonClicked(){
        try {
            HelloApplication.showMenuPage(username);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}