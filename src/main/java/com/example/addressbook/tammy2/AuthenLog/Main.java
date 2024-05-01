package com.example.addressbook.tammy2.AuthenLog;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Initialize the UserAccountDAO and create the table if it doesn't exist
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        userAccountDAO.createTable();

        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to User Registration and Login System!");
        System.out.println("Select an option:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        int option = Integer.parseInt(scanner.nextLine());

        // Perform action based on user selection
        switch (option) {
            case 1:
                registerUser(userAccountDAO);
                break;
            case 2:
                loginUser();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }

        // Close the scanner
        scanner.close();
        // Close the database connection
        UserAccountDAO.close();
    }

    /**
     * Method to register a new user
     * @param userAccountDAO
     */
    public static void registerUser(UserAccountDAO userAccountDAO) {
        Scanner scanner = new Scanner(System.in);

        // Get username
        String username;
        do {
            System.out.println("Enter username (must be at least 4 characters long):");
            username = scanner.nextLine();
            if (username.length() < 4) {
                System.out.println("Username must be at least 4 characters long.");
            }
        } while (username.length() < 4);

        // Get email
        System.out.println("Enter email:");
        String email = scanner.nextLine();

        // Get password
        String password;
        do {
            System.out.println("Enter password (must be at least 6 characters long):");
            password = scanner.nextLine();
            if (password.length() < 6) {
                System.out.println("Password must be at least 6 characters long.");
            }
        } while (password.length() < 6);

        // Hash the password
        String hashedPassword = hashPassword(password);

        // Get Tammy information
        System.out.println("Enter your Tammy's name:");
        String tammyName = scanner.nextLine();
        System.out.println("Enter your Tammy's type (sleep, study, or fitness):");
        String tammyType = scanner.nextLine();
        System.out.println("Enter your Tammy's species (rabbit, shell, or fish):");
        String tammySpecies = scanner.nextLine();


        // Check if the username is already registered
        List<UserAccount> accounts = UserAccountDAO.getAll();
        for (UserAccount acc : accounts) {
            if (acc.getUsername().equals(username)) {
                System.out.println("Username already exists. Please login instead.");
                loginUser();
                return;
            }
        }

        // Register the user with hashed password
        UserAccount userAccount = new UserAccount(username, email, hashedPassword);
        UserAccountDAO.insert(userAccount);
        System.out.println("User registered successfully!");

        // Get the userID of the newly inserted user
        UserAccount newUser = userAccountDAO.getByUsername(username);
        int userID = newUser.getID();

        // Insert Tammy information into TammyInfo table
        TammyInfoDAO tammyInfoDAO = new TammyInfoDAO();
        tammyInfoDAO.createTammyInfoTable();
        tammyInfoDAO.insertTammyInfo( username, tammyName, tammyType, tammySpecies);

    }

    /**
     * Method to authenticate a user
     */
    public static void loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        // Hash the password for comparison
        String hashedPassword = hashPassword(password);

        // Check if the username and hashed password match any entry in the database
        List<UserAccount> accounts = UserAccountDAO.getAll();
        for (UserAccount acc : accounts) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(hashedPassword)) {
                System.out.println("Login successful!");
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    /**
     * Method to hash the password using SHA-256 algorithm
     * @param password a user's password
     * @return String of the hashed password
     */
    public static String hashPassword(String password) {
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Apply SHA-256 hashing to the password
            byte[] hash = digest.digest(password.getBytes());
            // Convert byte array to hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            // Return the hashed password as a string
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle NoSuchAlgorithmException
            e.printStackTrace();
            return null;
        }
    }
}




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
