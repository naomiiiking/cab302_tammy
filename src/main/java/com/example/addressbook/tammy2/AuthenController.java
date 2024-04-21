package com.example.addressbook.tammy2;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AuthenController {

    @FXML
    private HBox topButtons;
    @FXML
    private VBox logInContent;
    @FXML
    private TextField loginUserNameInput;
    @FXML
    private PasswordField loginPasswordInput;
    @FXML
    private VBox registerContent;
    @FXML
    private TextField registerUserNameInput;
    @FXML
    private PasswordField registerPasswordInput;
    @FXML
    private TextField tammyNameInput;
    @FXML
    private HBox tammyType;
    @FXML
    private RadioButton sleepTammy;
    @FXML
    private RadioButton studyTammy;
    @FXML
    private RadioButton fitnessTammy;
    @FXML
    private ToggleGroup tammyTypeInput;
    @FXML
    private HBox tammySpecies;
    @FXML
    private RadioButton fishTammy;
    @FXML
    private RadioButton rabbitTammy;
    @FXML
    private RadioButton shellTammy;
    @FXML
    private ToggleGroup tammySpeciesInput;


    public void initialize(){
        // Top buttons
        topButtons.setSpacing(5);
        topButtons.setAlignment(Pos.CENTER);

        // Login content
        logInContent.setSpacing(5);
        logInContent.setAlignment(Pos.CENTER);
        logInContent.setMaxWidth(300);
        logInContent.setVisible(false);

        // Register content
        registerContent.setSpacing(7);
        registerContent.setAlignment(Pos.CENTER);
        registerContent.setMaxWidth(300);
        registerContent.setVisible(false);

        // Tammy type buttons
        tammyTypeInput = new ToggleGroup();
        sleepTammy.setToggleGroup(tammyTypeInput);
        studyTammy.setToggleGroup(tammyTypeInput);
        fitnessTammy.setToggleGroup(tammyTypeInput);
        tammyType.setAlignment(Pos.CENTER);

        // Tammy species buttons
        tammySpeciesInput = new ToggleGroup();
        fishTammy.setToggleGroup(tammySpeciesInput);
        rabbitTammy.setToggleGroup(tammySpeciesInput);
        shellTammy.setToggleGroup(tammySpeciesInput);
        tammySpecies.setAlignment(Pos.CENTER);


    }

    // Makes login elements appear when clicked
    public void handleLoginButtonClicked(){
        registerContent.setVisible(false);
        logInContent.setVisible(true);

    }

    // Makes register elements appear when clicked
    public void handleRegisterButtonClicked(){
        logInContent.setVisible(false);
        registerContent.setVisible(true);
    }
}
