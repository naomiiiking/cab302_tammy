package com.example.addressbook.tammy2;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.TammyDatabase.TammyDAO;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.example.addressbook.tammy2.TammyDatabase.TammyDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.example.addressbook.tammy2.tammy.Tammys;

import static com.example.addressbook.tammy2.HelloApplication.showHomePage;

public class LoginController {
    @FXML
    private VBox logInContent;
    @FXML
    private TextField loginUserNameInput;
    @FXML
    private PasswordField loginPasswordInput;
    private TammyDAO tammyDAO;
    public LoginController(){
        tammyDAO = new TammyDAO();
    }
    // Map for storing user session
    static Map<String, UserAccount> userSession = new HashMap<>();

    public void initialize() {
        // Create connection to user account database and insert new record
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        userAccountDAO.createTable();
        logInContent.setAlignment(Pos.CENTER);
        logInContent.setSpacing(30);


        // Insert some new records
        //        userAccountDAO.insert(new UserAccount("LauraG", "lauraagallowayy@gmail.com", "CAB203"));
        //        userAccountDAO.insert(new UserAccount("JaneS", "JaneS23@hotmail.com", "CAB203!"));
        //        userAccountDAO.insert(new UserAccount("AliceM", "Smith", "CAB302&"));

        // Retrieve all records
        //        List<UserAccount> accounts = UserAccountDAO.getAll();
        //        for (UserAccount acc : accounts) {
        //            System.out.println(acc);
        //        }

        //        // Retrieve a record by ID
        //        UserAccount account = UserAccountDAO.getById(2);
        //        System.out.println(account);

//        // Retrieve a record by ID
//        UserAccount account = UserAccountDAO.getById(3);
//        System.out.println("Before update:");
//        System.out.println(account);

        // Update a record

//        account.setEmail("1234smith@hotmail.com.au");
//        UserAccountDAO.update(account);
//        System.out.println("After update email:");
//        System.out.println(UserAccountDAO.getById(3));
//
//        UserAccountDAO.close();
    }
    // Method to get the current logged-in user
    public static UserAccount getCurrentUser() {
        return userSession.get("loggedInUser");
    }

    // Login submit button clicked
    public void handleLoginSubmitButtonClicked() throws Exception {
        // Checks that no fields are null
        try {
            String[] fields = {loginUserNameInput.getText(), loginPasswordInput.getText()};
        } catch (Exception e) {
            showMissingInfoAlert();
        }

        // Check if the username and password match any entry in the database
        List<UserAccount> accounts = UserAccountDAO.getAll();
        for (UserAccount acc : accounts) {
            if (UserAccount.getUsername().equals(loginUserNameInput.getText()) && UserAccount.getPassword().equals(loginPasswordInput.getText())) {
                // Store the logged-in user's information in the session map
                userSession.put("loggedInUser", acc);
                showHomePage();
                return;
            } else {
                showInvalidLoginAlert();
            }
        }
    }
    // Displays missing information alert box
    private void showMissingInfoAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Fill in all fields before submitting.");

        alert.showAndWait();
    }

    // Displays incorrect login alert
    private void showInvalidLoginAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid login");
        alert.setHeaderText("Incorrect username or password.");

        alert.showAndWait();
    }
}
