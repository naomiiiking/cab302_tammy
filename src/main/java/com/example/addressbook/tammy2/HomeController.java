package com.example.addressbook.tammy2;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;


public class HomeController {

    @FXML
    private Label userName;
    @FXML
    private Label creditsLabel;
    @FXML
    private Label streakLabel;
    @FXML
    private ImageView tammyImage;
    private String tammyImageAddress = "/assets/1.png";
    @FXML
    private ProgressBar waterProgressBar;
    @FXML
    private ProgressBar foodProgressBar;
    @FXML
    private ProgressBar happinessProgressBar;
    @FXML
    private Label tammyName;

    public void initialize() {
        // Initialize Menu Section
        userName.setText("Welcome back: Naomi");
        creditsLabel.setText("Credits: $20");
        streakLabel.setText("Streak: 45 days");

        // Initialize Tammy Image
        Image image = new Image(getClass().getResourceAsStream(tammyImageAddress));
        tammyImage.setImage(image);

        // Initialize Vitals Progressbars
        waterProgressBar.setProgress(0.5);
        foodProgressBar.setProgress(0.75);
        happinessProgressBar.setProgress(0.25);

        // Initialize Tammy Name
        tammyName.setText("Mr Bean");
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
            HelloApplication.showHelpPage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleMenuButtonClicked(){
        try {
            HelloApplication.showMenuPage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /*
    //Instantiating the BorderPane class
    BorderPane bPane = new BorderPane();

    //Load image and set as image view
    ImageView imageView = new ImageView();
        imageView.setImage(new Image(getClass().getResource("/assets/1.png").toString()));
        imageView.setFitWidth(500);
        imageView.setCache(true);
        imageView.setPreserveRatio(true);
    //Set Tammy name
    Label tammyNameLabel = new Label("Mr Bean");
    Label homePageLabel = new Label("Homepage");

    //Menu section
    Label userNameLabel = new Label("Welcome back: Naomi");
    Label creditsLabel = new Label("Credits: $20");
    Label steakLabel = new Label("Streak: 45 days");

    Button logButton = new Button("Log");
    Button memoriesButton = new Button("Memories");
    Button helpButton =  new Button("?");
    Button settingsButton = new Button("Menu");

    VBox buttonsSection =  new VBox(1);
    HBox helpSettingsButtons = new HBox(1);
        helpSettingsButtons.getChildren().addAll(helpButton, settingsButton);
        buttonsSection.getChildren().addAll(logButton, memoriesButton, helpSettingsButtons);

    VBox menuSection = new VBox(2);
        menuSection.getChildren().addAll(userNameLabel, creditsLabel, steakLabel, buttonsSection);

    //Attributes section
    Label attributesLabel = new Label("Attributes");

    Label waterLabel = new Label("Water:");
    ProgressBar waterProgress = new ProgressBar();
        waterProgress.setProgress(0.5);

    Label foodLabel = new Label("Food:");
    ProgressBar foodProgress = new ProgressBar();
        foodProgress.setProgress(0.75);

    Label happinessLabel = new Label("Happiness:");
    ProgressBar happinessProgress = new ProgressBar();
        happinessProgress.setProgress(0.25);

    VBox attributesSection = new VBox(2); // spacing = 8
        attributesSection.getChildren().addAll(attributesLabel, waterLabel, waterProgress, foodLabel, foodProgress, happinessLabel, happinessProgress );

        bPane.setTop(homePageLabel);
        bPane.setBottom(tammyNameLabel);
        bPane.setLeft(menuSection);
        bPane.setRight(attributesSection);

        bPane.setCenter(imageView);

    //Creating a scene object
    Scene scene = new Scene(bPane, 1000, 600);

    <top>
        <Text text="Homepage"/>
    </top>
    <left>
        <Label text="Welcome user"/>
    </left>
    <center>
        <ImageView fx:id="tammyImage"
                   disable="false"
                   pickOnBounds="true"
                   preserveRatio="true" />
    </center>
    <right>

    </right>
    <bottom>
        <Label id="label" fx:id="label"/>
    </bottom>
    */

}