package com.example.addressbook.tammy2;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;
import com.example.addressbook.tammy2.TammyDatabase.TammyDAO;
import com.example.addressbook.tammy2.functions.TimeCalculators;
import com.example.addressbook.tammy2.tammy.Tammys;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.addressbook.tammy2.HelloApplication.showHomePage;

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

    private UserAccountDAO userAccountDAO;
    private TimeCalculators timeCalculators;

    public AuthenController(){
        tammyDAO = new TammyDAO();
        userAccountDAO = new UserAccountDAO();
        timeCalculators = new TimeCalculators();
    }
    // Map for storing user session
    static Map<String, UserAccount> userSession = new HashMap<>();

    static Map<String, Tammys> tammySession = new HashMap<>();

    public void initialize(){


        // Top buttons
        topButtons.setSpacing(5);
        topButtons.setAlignment(Pos.CENTER);

        // Login content
        logInContent.setSpacing(5);
        logInContent.setAlignment(Pos.CENTER);
        logInContent.setMaxWidth(300);
        logInContent.setVisible(true);

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

        // Create connection to user account database and insert new record
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        userAccountDAO.createTable();

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
    public static Tammys getCurrentTammy(){
        return tammySession.get("loggedInTammy");
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

    // Register submit button clicked
    public void handleRegisterSubmitButtonClicked() throws Exception {
        // Checks that no fields are null
        try { String[] fields = {registerUserNameInput.getText(), registerUserEmailInput.getText(),registerPasswordInput.getText(), tammySpeciesInput.getSelectedToggle().toString(), tammyTypeInput.getSelectedToggle().toString()};}
            catch(Exception e) {
                showMissingInfoAlert();
        }

        UserAccount userAccount = new UserAccount(registerUserNameInput.getText(), registerUserEmailInput.getText(), registerPasswordInput.getText());
        userAccountDAO.insert(userAccount);
        //System.out.println(UserAccountDAO.getByUsername(UserAccount.getUsername()).getId());

        System.out.println(userAccountDAO.getByUsername(userAccount.getUsername()));

        int i = userAccountDAO.getByUsername(userAccount.getUsername()).getId();

        Tammys tammy = new Tammys(i,tammyNameInput.getText(),tammyTypeInput.getSelectedToggle().toString(), tammySpeciesInput.getSelectedToggle().toString());
        //System.out.println(tammySpeciesInput.getSelectedToggle().toString());
        tammyDAO.addTammy(tammy);

        userAccountDAO.close();
        tammyDAO.close();

        // Load homepage
        userSession.put("loggedInUser", userAccount);
        tammySession.put("loggedInTammy", tammy);
        showHomePage();
    }

    // Login submit button clicked
    public void handleLoginSubmitButtonClicked() throws Exception {
        // Checks that no fields are null
        try { String[] fields = {loginUserNameInput.getText(), loginPasswordInput.getText()};}
        catch(Exception e) {
            showMissingInfoAlert();
        }

        // Check if the username and password match any entry in the database
        List<UserAccount> accounts = userAccountDAO.getAll();
        for (UserAccount acc : accounts) {
            if (acc.getUsername().equals(loginUserNameInput.getText()) && acc.getPassword().equals(loginPasswordInput.getText())) {
                // Store the logged-in user's information in the session map
                userSession.put("loggedInUser", acc);
                tammySession.put("loggedInTammy", tammyDAO.getTammy(acc.getId()));
                // update Tammy water and food with value below
                ChangeTammyWaterFood(getCurrentTammy());
                //tammyDAO.close();
                showHomePage();
                return;
            }
            else {
                showInvalidLoginAlert();
            }
        }

    }

    private void ChangeTammyWaterFood(Tammys tammy){
        // this currently only works for one tammy, need to change if more tammys are needed
        String oldDate = tammyDAO.getTammyTime(tammy.getOwnerId());
        System.out.println(oldDate);
        int timePassed = Math.toIntExact(timeCalculators.TimePassed(oldDate));
        int waterLoss = (int) (timePassed * -1.5);
        int foodLoss = (int) (timePassed * -1.2);
        System.out.println(tammy);
        tammy.setFoodVar(tammy.getFoodVar() + foodLoss);
        tammy.setWaterVar(tammy.getWaterVar() + waterLoss);
        System.out.println(getCurrentTammy().getFoodVar());
        System.out.println(getCurrentTammy().getWaterVar());
        //add TAMMY
        // db locked error
        tammyDAO.updateTammy(tammy);
//        tammyDAO.updateTammy(tammy,Math.toIntExact(timeCalculators.TimePassed(oldDate)));
//        tammyDAO.updateTammyWater(tammy,waterLoss);
//        tammyDAO.updateTammyTime(tammy.getOwnerId());
    }

    // Displays missing information alert box
    private void showMissingInfoAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Fill in all fields before submitting.");

        alert.showAndWait();
    }

    // Displays incorrect login alert
    private void showInvalidLoginAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid login");
        alert.setHeaderText("Incorrect username or password.");

        alert.showAndWait();
    }

    private void showTakenUsername(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Register");
        alert.setHeaderText("Username taken.");

        alert.showAndWait();
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

}
