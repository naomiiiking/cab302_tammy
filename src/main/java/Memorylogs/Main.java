package Memorylogs;

import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize the UserAccountDAO and create the table if it doesn't exist
        UserAccountDAO userAccountDAO = new UserAccountDAO();
        userAccountDAO.createTable();

        // Initialize the StudyLogsDAO and create the table if it doesn't exist
        StudyLogsDAO studyLogsDAO = new StudyLogsDAO();
        studyLogsDAO.createStudyLogsTable();

        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Memory Logs!");

        // Login or register
        UserAccount user = loginOrRegister(scanner, userAccountDAO);

        // Collect study log
        collectStudyLog(scanner, studyLogsDAO, user);

        // Close the scanner
        scanner.close();
        // Close the database connections
        userAccountDAO.close();
        studyLogsDAO.close();
    }

    /**
     * Method to handle user login or registration
     *
     * @param scanner
     * @param userAccountDAO
     * @return
     */
    private static UserAccount loginOrRegister(Scanner scanner, UserAccountDAO userAccountDAO) {
        UserAccount user = null;
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("Enter username:");
            String username = scanner.nextLine();

            // Check if the username exists in the database
            user = userAccountDAO.getByUsername(username);
            if (user != null) {
                loggedIn = true;
            } else {
                System.out.println("Username not found. Do you want to register? (yes/no)");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("yes")) {
                    user = registerUser(scanner, userAccountDAO, username);
                    loggedIn = true;
                }
            }
        }

        return user;
    }

    // Method to register a new user
    private static UserAccount registerUser(Scanner scanner, UserAccountDAO userAccountDAO, String username) {
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

        // Register the user with hashed password
        UserAccount userAccount = new UserAccount(username, email, password);
        userAccountDAO.insert(userAccount);
        System.out.println("User registered successfully!");
        return userAccount;
    }

    // Method to collect study log
    private static void collectStudyLog(Scanner scanner, StudyLogsDAO studyLogsDAO, UserAccount user) {
        // Get current date
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(date);

        // Get hours studied
        System.out.println("Enter hours studied:");
        float hoursStudied = Float.parseFloat(scanner.nextLine());

        // Calculate money earned (assuming $2 per hour)
        float moneyEarned = hoursStudied * 2;

        // Insert study log into database
        //studyLogsDAO.insertStudyLog(user.getId(), formattedDate, hoursStudied, moneyEarned);
        System.out.println("Study log recorded successfully!");
    }
}
