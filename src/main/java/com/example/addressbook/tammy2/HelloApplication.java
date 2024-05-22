package com.example.addressbook.tammy2;

import Memorylogs.StudyLogsDAO;
import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;
import com.example.addressbook.tammy2.ProgressTracking.ProgressTracker;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
        LogController logController = new LogController();
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        userAccountDAO.createTable();
        StudyLogsDAO studyLogsDAO = new StudyLogsDAO();
        studyLogsDAO.createStudyLogsTable();
      //  logController.setUser(); // Set the user object in LogController
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
        Scene scene = new Scene(fxmlLoader.load(), 1100, 750);
        String stylesheet = HelloApplication.class.getResource("stylesheet.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        mainStage.setTitle("Tammy");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void showHelpPage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("help-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 750);
        String stylesheet = HelloApplication.class.getResource("stylesheet.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        mainStage.setTitle("Tammy");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void showMenuPage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 750);
        String stylesheet = HelloApplication.class.getResource("stylesheet.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        mainStage.setTitle("Tammy");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void showShopPage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("shop-view.fxml"));
        VBox shopLayout = fxmlLoader.load();
        ProgressTracker tracker = new ProgressTracker(20);
        ShopController controller = fxmlLoader.getController();
        controller.initialize(tracker, mainStage, mainStage.getScene());
        Scene scene = new Scene(shopLayout, 1100, 750);
        String stylesheet = HelloApplication.class.getResource("stylesheet.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        mainStage.setTitle("Shop");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}