package com.example.addressbook.tammy2;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;

public class HelloApplication extends Application {
    private static Stage mainStage;

    @Override
    //Start function will open with displayHomepage for now
    public void start(Stage mainStage) throws Exception {
        this.mainStage = mainStage;
        showAuthenPage();
    }

    public void showAuthenPage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("authen-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 750);
        String stylesheet = HelloApplication.class.getResource("stylesheet.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        mainStage.setTitle("Tammy");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void showLoginPage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-content.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 750);
        String stylesheet = HelloApplication.class.getResource("stylesheet.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        mainStage.setTitle("Login");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void showRegisterPage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register-content.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 750);
        String stylesheet = HelloApplication.class.getResource("stylesheet.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        mainStage.setTitle("Register");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void showHomePage() throws Exception {
        HomeController.setUserID(UserAccount.getID());
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
        String stylesheet = HelloApplication.class.getResource("stylesheet.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        mainStage.setTitle("Tammy");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void showMemoriesPage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("memories-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 750);
        String stylesheet = HelloApplication.class.getResource("stylesheet.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        mainStage.setTitle("Tammy");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void showHelpPage(String UserName) throws Exception {
        MenuController.setUsername(UserName);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("help-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 750);
        String stylesheet = HelloApplication.class.getResource("stylesheet.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        mainStage.setTitle("Tammy");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void showMenuPage(String username) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 750);
        String stylesheet = HelloApplication.class.getResource("stylesheet.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        mainStage.setTitle("Tammy");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}