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

/**
 * The ShopController class handles the operations and UI updates for the shop in the application.
 */
public class ShopController {

    /**
     * Constructor for the ShopController class. Initializes the tammyDAO.
     */
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


    /**
     * Initializes the ShopController with the given ProgressTracker, Stage, and Scene.
     *
     * @param tracker      The ProgressTracker object to track progress.
     * @param primaryStage The primary Stage of the application.
     * @param mainScene    The main Scene of the application.
     */
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

    /**
     * Handles the purchase of food and updates Tammy's food variable.
     */
    @FXML
    private void buyFood() {
        buyItem("Food");
        loggedInTammy.setADDFoodVar(20);
    }

    /**
     * Handles the purchase of water and updates Tammy's water variable.
     */
    @FXML
    private void buyWater() {
        buyItem("Water");
        loggedInTammy.setADDWaterVar(25);
    }

    /**
     * Handles the purchase of happiness and updates Tammy's happiness.
     */
    @FXML
    private void buyHappiness() {
        buyItem("Happiness");
        loggedInTammy.updateHappiness(50);
    }

    /**
     * Navigates back to the home scene.
     */
    @FXML
    private void goHome() {
        primaryStage.setScene(mainScene);
    }

    /**
     * Handles the home button click event, updates Tammy's vitals, and navigates to the home page.
     */
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

    /**
     * Purchases an item from the shop and updates the credits label.
     *
     * @param itemName The name of the item to be purchased.
     */
    private void buyItem(String itemName) {
        if (shop.purchaseItem(itemName, tracker)) {
            updateCreditsLabel();
        }

    }

    /**
     * Updates the credits label with the current currency.
     */
    private void updateCreditsLabel() {
        creditsLabel.setText("$" + tracker.getCurrency());
    }


}
