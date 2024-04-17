package com.example.addressbook.tammy2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    private static Stage mainStage;

    @Override
    //Start function will open with displayHomepage for now
    public void start(Stage mainStage) throws Exception {
        this.mainStage = mainStage;
        showHomePage();
    }

    public void showHomePage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 750);
        String stylesheet = HelloApplication.class.getResource("stylesheet.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        mainStage.setTitle("Tammy");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void showLogPage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("log-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 750);
        mainStage.setTitle("Tammy");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void showMemoriesPage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("memories-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 750);
        mainStage.setTitle("Tammy");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void showHelpPage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("help-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 750);
        mainStage.setTitle("Tammy");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void showMenuPage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 750);
        mainStage.setTitle("Tammy");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}