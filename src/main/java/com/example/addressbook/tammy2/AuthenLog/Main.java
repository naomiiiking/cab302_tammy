package com.example.addressbook.tammy2.AuthenLog;


import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        userAccountDAO.createTable();




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
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

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


}