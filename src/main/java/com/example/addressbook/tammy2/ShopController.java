package com.example.addressbook.tammy2;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.ProgressTracking.ProgressTracker;
import com.example.addressbook.tammy2.ShopBackEnd.Shop;
import com.example.addressbook.tammy2.TammyDatabase.TammyDAO;
import com.example.addressbook.tammy2.tammy.Tammys;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ShopController {
    public ShopController(){
        tammyDAO = new TammyDAO();
    }
    public static UserAccount loggedInUser = AuthenController.userSession.get("loggedInUser");
    public static Tammys loggedInTammy = AuthenController.tammySession.get("loggedInTammy");

    TammyDAO tammyDAO;
    private Shop shop;
    private ProgressTracker tracker;
    private Stage primaryStage;
    private Scene mainScene;

    @FXML
    private Label creditsLabel;
    private int credits = loggedInUser.getCredits();
    @FXML
    private VBox shopPage;
    @FXML
    private HBox shopOptions;


    public void initialize(ProgressTracker tracker, Stage primaryStage, Scene mainScene) {
        this.tracker = tracker;
        this.primaryStage = primaryStage;
        this.mainScene = mainScene;
        this.shop = new Shop();
        shopPage.setSpacing(5);
        shopOptions.setSpacing(5);
        shopOptions.setAlignment(Pos.CENTER);
        updateCreditsLabel();
    }

    @FXML
    private void buyFood() {
        buyItem("Food");
        loggedInTammy.setADDFoodVar(20);
    }

    @FXML
    private void buyWater() {
        buyItem("Water");
        loggedInTammy.setADDWaterVar(25);
    }

    @FXML
    private void buyHappiness() {
        buyItem("Happiness");
        loggedInTammy.updateHappiness(50);
    }

    @FXML
    private void goHome() {
        primaryStage.setScene(mainScene);
    }

    @FXML
    private void handleHomeButtonClicked() {
        try {
            tammyDAO.updateTammyVitals(loggedInTammy);
            HelloApplication.showHomePage(); //needs a username
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void buyItem(String itemName) {
        if (shop.purchaseItem(itemName, tracker)) {
            updateCreditsLabel();
        }

    }

    private void updateCreditsLabel() {
        creditsLabel.setText("$" + tracker.getCurrency());
    }

    private void updateProgressBar() {} //function to update progress bars
}
