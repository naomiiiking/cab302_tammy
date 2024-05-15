package com.example.addressbook.tammy2;
import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.tammy.Tammys;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import java.io.IOException;

import static com.example.addressbook.tammy2.HelloApplication.*;


public class HomeController {
    /**
     * To access the current logged in, call the following at the top of your controller
     * static UserAccount loggedInUser = HomeController.loggedInUser;
     * This will return a UserAccount object that is stored in a session hash map.
     * Or just use
     * private static final String username = UserAccount.getUsername();
     * You can now operate on it using all the usual UserAccount functions as normal
     */
    public static UserAccount loggedInUser = AuthenController.userSession.get("loggedInUser");
    static Tammys loggedInTammy = AuthenController.tammySession.get("loggedInTammy");
    private static final String username = loggedInUser.getUsername();

    // Stored and used to select the users Tammy
    private static int UserID;
    public static void setUserID(int id){UserID = id;}


    @FXML
    private Label userNameLabel;
    @FXML
    private Label creditsLabel;
    private int credits =  20; //TODO: Replace this with query to get credits from database
    @FXML
    private Label streakLabel;
    private int streak =  45; //TODO: Replace this with streak variable from database
    @FXML
    private VBox buttonsVbox;
    @FXML
    private HBox buttonsHbox1;
    @FXML
    private HBox buttonsHbox2;
    @FXML
    private ImageView tammyImage;
    @FXML
    private VBox imageVbox;
    @FXML
    private String tammyImageAddress = loggedInTammy.getImage(); //TODO: Replace this with image depending on type of tammy from database
    @FXML
    private Label tammyName;
    private String tammyNameString = loggedInTammy.getName();
    @FXML
    private VBox vitalsVbox;
    @FXML
    private HBox vitalsHbox1;
    @FXML
    private HBox vitalsHbox2;
    @FXML
    private HBox vitalsHbox3;
    @FXML
    private ProgressBar waterProgressBar;
    private float waterprogress = (float) loggedInTammy.getWaterVar() / 100;
    @FXML
    private ProgressBar foodProgressBar;
    private float foodprogress = (float) loggedInTammy.getFoodVar() / 100;
    @FXML
    private ProgressBar happinessProgressBar;

    public void initialize() {
        // Initialize Menu Section
        userNameLabel.setText("Welcome back: " + username);
        creditsLabel.setText("Credits: $" + credits);
        streakLabel.setText("Streak: " + streak + " days");
        buttonsVbox.setSpacing(5);
        buttonsHbox1.setSpacing(5);
        buttonsHbox2.setSpacing(5);

        // Initialize Tammy Image and Name
        Image image = new Image(getClass().getResourceAsStream(tammyImageAddress));
        tammyImage.setImage(image);
        tammyImage.setFitWidth(400);
        tammyImage.setFitHeight(400);
        tammyName.setText(tammyNameString);
        imageVbox.setSpacing(5);

        // Initialize Vitals Progressbars
        vitalsVbox.setSpacing(5);
        vitalsHbox1.setSpacing(2);
        vitalsHbox2.setSpacing(2);
        vitalsHbox3.setSpacing(3);
        waterProgressBar.setProgress(waterprogress);
        waterProgressBar.setMinHeight(30);
        waterProgressBar.setMinWidth(200);
        foodProgressBar.setProgress(foodprogress);
        foodProgressBar.setMinHeight(30);
        foodProgressBar.setMinWidth(200);
        happinessProgressBar.setProgress(0.25);
        happinessProgressBar.setMinHeight(30);
        happinessProgressBar.setMinWidth(200);

    }

    /**
     * Show log page when clicked
     */
    @FXML
    private void handleLogButtonClicked(){
        try {
            showLogPage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Show log memories when clicked
     */
    @FXML
    private void handleMemoriesButtonClicked(){
        try {
            showMemoriesPage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Show log help when clicked
     */
    @FXML
    private void handleHelpButtonClicked(){
        try {
            showHelpPage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Show log menu when clicked
     */
    @FXML
    private void handleMenuButtonClicked(){
        try {
            showMenuPage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void handleShopButtonClicked(){
        try {
            showShopPage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}