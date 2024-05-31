package com.example.addressbook.tammy2;
import Memorylogs.StudyLogsDAO;
import com.example.addressbook.tammy2.AuthenLog.UserAccount;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class LogController {

    // Static variable to hold the currently logged in user
    public static UserAccount loggedInUser = AuthenController.userSession.get("loggedInUser");
    // Constructor to initialize DAOs
    public LogController() {
        this.studyLogsDAO = new StudyLogsDAO();// Initialize studyLogsDAO here
        userAccountDAO = new UserAccountDAO();
    }

    // Method to update the logged in user from the session
    public void updateLoggedInUser() {
        loggedInUser = AuthenController.userSession.get("loggedInUser");
    }
    // Setter for the studyLogsDAO, used for dependency injection
    public void setStudyLogsDAO(StudyLogsDAO studyLogsDAO) {
        this.studyLogsDAO = studyLogsDAO;
    }

    // FXML elements from the view
    public VBox buttonsVbox;
    public Label totalTimeLabel;
    public Label totalTime;
    public Label StartLabel;
    public HBox comboboxHbox;
    public HBox comboboxHbox2;
    public Label EndLabel;
    public Label addedCreditLabel;
    public Label addedCredit;
    public HBox TotalTimeHBox;
    public HBox TotalCreditsHBox;
    @FXML
    private ComboBox<String> timeComboBox;
    @FXML
    private ComboBox<String> timeComboBox2;
    @FXML
    private Integer UserID = loggedInUser.getID();

    public Label date;
    // DAO objects for study logs and user accounts
    private StudyLogsDAO studyLogsDAO;
    private UserAccountDAO userAccountDAO;
    // Method called during initialization of the controller
    public void initialize() {

        updateLoggedInUser(); // Ensure the logged in user is updated

        // Set labels text
        StartLabel.setText("Study From:");
        EndLabel.setText("            End:");
        totalTimeLabel.setText("Total Time:   ");
        totalTime.setText("00:00 Hours");
        addedCreditLabel.setText("Credits Gained: ");
        addedCredit.setText("$0");

        // Set alignment and spacing for various elements
        buttonsVbox.setSpacing(15);
        buttonsVbox.setAlignment(Pos.CENTER);
        comboboxHbox.setAlignment(Pos.CENTER);
        comboboxHbox.setSpacing(5);
        comboboxHbox2.setAlignment(Pos.CENTER);
        comboboxHbox2.setSpacing(5);
        TotalTimeHBox.setAlignment(Pos.CENTER);
        TotalCreditsHBox.setAlignment(Pos.CENTER);

        populateComboBox(); // Populate the time selection combo boxes

        // Set event handlers for combo box selection changes
        timeComboBox.setOnAction(event -> calculateTotalTime());
        timeComboBox2.setOnAction(event -> calculateTotalTime());

        setDateText(); // Set the current date

    }
    // Method to populate the time combo boxes with 30-minute intervals
    private void populateComboBox() {
        int hour = 0;
        int minute = 0;
        String format;
        for (int i = 0; i < 48; i++) {
            format = String.format("%02d:%02d", hour, minute);
            timeComboBox.getItems().add(format);
            timeComboBox2.getItems().add(format);
            minute += 30;
            if (minute >= 60) {
                hour++;
                minute = 0;
            }
        }
    }
    // Method to set the current date in the date label
    private void setDateText() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        String formattedDate = currentDate.format(formatter);
        date.setText(formattedDate);
    }
    // Method to calculate the total study time and credits earned
    public void calculateTotalTime() {
        if (timeComboBox.getValue() != null && timeComboBox2.getValue() != null) {
            LocalTime startTime = LocalTime.parse(timeComboBox.getValue());
            LocalTime endTime = LocalTime.parse(timeComboBox2.getValue());

            Duration duration = Duration.between(startTime, endTime);
            long hours = duration.toHours();
            long minutes = duration.toMinutes() % 60;

            String totalTimeString = String.format("%02d:%02d Hours", hours, minutes);
            totalTime.setText(totalTimeString);

            long totalMinutes = duration.toMinutes();
            long credits = totalMinutes / 30; // 30 minutes = 1 credit
            String creditsString = String.format("$%d", credits);
            addedCredit.setText(creditsString);
        }
    }
    // Method to handle the submit button click event
    @FXML
    private void handleSubmitButtonClicked(){
        updateLoggedInUser(); // Ensure the logged in user is updated
        try {
            if (timeComboBox.getValue() != null && timeComboBox2.getValue() != null) {
                // Get the selected start and end times
                LocalTime startTime = LocalTime.parse(timeComboBox.getValue());
                LocalTime endTime = LocalTime.parse(timeComboBox2.getValue());

                // Calculate duration in minutes
                long totalMinutes = Duration.between(startTime, endTime).toMinutes();

                // Calculate credits earned (assuming 30 minutes = 1 credit)
                long credits = totalMinutes / 30;

                // Get current date
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String formattedDate = currentDate.format(formatter);

                // Format total time
                long hours = totalMinutes / 60;
                long remainingMinutes = totalMinutes % 60;
                String totalTimeString = String.format("%02d:%02d", hours, remainingMinutes);

                // Format credits earned
                String creditsString = String.format("$%d", credits);
                int creditsInt = (int) credits;

                // Update user's credits
                int userID = loggedInUser.getId();
                loggedInUser.addCredits(creditsInt);
                userAccountDAO.updateCredits(loggedInUser);

                // Insert study log into the database
                studyLogsDAO.insertStudyLog(userID, formattedDate, totalTimeString, creditsInt);

            }
            // Close the studyLogsDAO and show the home page
            studyLogsDAO.close();
            HelloApplication.showHomePage();//needs a username



        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // Method to handle the cancel button click event
    @FXML
    private void handleCancelButtonClicked(){
        try {
            HelloApplication.showHomePage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
