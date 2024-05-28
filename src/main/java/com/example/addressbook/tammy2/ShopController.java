package com.example.addressbook.tammy2;

import com.example.addressbook.tammy2.ProgressTracking.ProgressTracker;
import com.example.addressbook.tammy2.ShopBackEnd.Shop;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShopController {
    private Shop shop;
    private ProgressTracker tracker;
    private Stage primaryStage;
    private Scene mainScene;

    @FXML
    private Label creditsLabel;
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
    }

    @FXML
    private void buyWater() {
        buyItem("Water");
    }

    @FXML
    private void buyHappiness() {
        buyItem("Happiness");
    }

    @FXML
    private void goHome() {
        primaryStage.setScene(mainScene);
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
