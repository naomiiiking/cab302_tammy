package com.example.addressbook.tammy2;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;
import com.example.addressbook.tammy2.TammyDatabase.TammyDAO;
import com.example.addressbook.tammy2.tammy.Tammys;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.example.addressbook.tammy2.HelloApplication.showHomePage;

public class RegisterController {
    @FXML
    private VBox registerContent;
    @FXML
    private TextField registerUserNameInput;
    @FXML
    private PasswordField registerPasswordInput;
    @FXML
    private TextField registerUserEmailInput;
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
    private TammyDAO tammyDAO;
    public RegisterController(){
        tammyDAO = new TammyDAO();
    }
    // Map for storing user session
    static Map<String, UserAccount> userSession = new HashMap<>();

    public void initialize(){
        // Create connection to user account database and insert new record
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        userAccountDAO.createTable();

        // Register content
        registerContent.setSpacing(8);
        registerContent.setAlignment(Pos.CENTER);


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

    // Method to get the current logged-in user
    public static UserAccount getCurrentUser() {
        return userSession.get("loggedInUser");
    }

    // Register submit button clicked
    public void handleRegisterSubmitButtonClicked() throws Exception {
        // Checks that no fields are null
        try { String[] fields = {registerUserNameInput.getText(), registerUserEmailInput.getText(),registerPasswordInput.getText(), tammySpeciesInput.getSelectedToggle().toString(), tammyTypeInput.getSelectedToggle().toString()};
            System.out.println(Arrays.toString(fields));}
        catch(Exception e) {
            showMissingInfoAlert();
        }

        UserAccount userAccount = new UserAccount(registerUserNameInput.getText(), registerUserEmailInput.getText(), registerPasswordInput.getText());
        UserAccountDAO.insert(userAccount);

        Tammys tammy = new Tammys(1,tammyNameInput.getText(),tammyTypeInput.getSelectedToggle().toString(), tammySpeciesInput.getSelectedToggle().toString());
        System.out.println(tammySpeciesInput.getSelectedToggle().toString());
        tammyDAO.addTammy(tammy);

        UserAccountDAO.close();

        // Load homepage
        userSession.put("loggedInUser", userAccount);
        showHomePage();
    }

    // Displays missing information alert box
    private void showMissingInfoAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Fill in all fields before submitting.");

        alert.showAndWait();
    }
}
// Inside the Main class

//    public static void loginUser() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter username:");
//        String username = scanner.nextLine();
//        System.out.println("Enter password:");
//        String password = scanner.nextLine();
//
//        // Check if the username and password match any entry in the database
//        List<UserAccount> accounts = UserAccountDAO.getAll();
//        for (UserAccount acc : accounts) {
//            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
//                System.out.println("Login successful!");
//                openHomePage();
//                return;
//            }
//        }
//        System.out.println("Invalid username or password.");
//    }
//
//    public static void openHomePage() {
//        // Close the login window
//        // Launch the home page window
//        HomePage homePage = new HomePage();
//        try {
//            homePage.start(new Stage());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//// Inside the switch case in the main method
//case 2:
//    loginUser();
//    break;


