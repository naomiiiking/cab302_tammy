package com.example.addressbook.tammy2.AuthenLog;


import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to User Registration and Login System!");
        System.out.println("Select an option:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }


        scanner.close();
        // Close the database connection
        UserAccountDAO.close();

    }

    public static void registerUser() {
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

        // Check if the username is already registered
        List<UserAccount> accounts = UserAccountDAO.getAll();
        for (UserAccount acc : accounts) {
            if (acc.getUsername().equals(username)) {
                System.out.println("Username already exists. Please login instead.");
                loginUser();
                return;
            }
        }

        // Register the user
        UserAccount userAccount = new UserAccount(username, email, password);
        UserAccountDAO.insert(userAccount);
        System.out.println("User registered successfully!");
    }

    public static void loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        // Check if the username and password match any entry in the database
        List<UserAccount> accounts = UserAccountDAO.getAll();
        for (UserAccount acc : accounts) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return;
            }
        }
        System.out.println("Invalid username or password.");

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