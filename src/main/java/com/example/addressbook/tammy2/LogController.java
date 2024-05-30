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

    // Set logged in user
    public static UserAccount loggedInUser = AuthenController.userSession.get("loggedInUser");
    public LogController() {
        this.studyLogsDAO = new StudyLogsDAO();// Initialize studyLogsDAO here
        userAccountDAO = new UserAccountDAO();
    }

    public void updateLoggedInUser() {
        loggedInUser = AuthenController.userSession.get("loggedInUser");
    }
    public void setStudyLogsDAO(StudyLogsDAO studyLogsDAO) {
        this.studyLogsDAO = studyLogsDAO;
    }

    //private static final Integer UserID = UserAccount.getID();
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
    private StudyLogsDAO studyLogsDAO;
    private UserAccountDAO userAccountDAO;
    //private UserAccount user;
    public void initialize() {

        updateLoggedInUser();

        StartLabel.setText("Study From:");
        EndLabel.setText("            End:");
        totalTimeLabel.setText("Total Time:   ");
        totalTime.setText("00:00 Hours");
        addedCreditLabel.setText("Credits Gained: ");
        addedCredit.setText("$0");


        buttonsVbox.setSpacing(15);
        buttonsVbox.setAlignment(Pos.CENTER);

        comboboxHbox.setAlignment(Pos.CENTER);
        comboboxHbox.setSpacing(5);

        comboboxHbox2.setAlignment(Pos.CENTER);
        comboboxHbox2.setSpacing(5);

        TotalTimeHBox.setAlignment(Pos.CENTER);
        TotalCreditsHBox.setAlignment(Pos.CENTER);

        populateComboBox();

        timeComboBox.setOnAction(event -> calculateTotalTime());
        timeComboBox2.setOnAction(event -> calculateTotalTime());

        setDateText();

    }
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
    private void setDateText() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        String formattedDate = currentDate.format(formatter);
        date.setText(formattedDate);
    }

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

    @FXML
    private void handleSubmitButtonClicked(){
        updateLoggedInUser();
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

                int userID = loggedInUser.getId();
                loggedInUser.addCredits(creditsInt);

                userAccountDAO.updateCredits(loggedInUser);
                // Insert study log into the database
                studyLogsDAO.insertStudyLog(userID, formattedDate, totalTimeString, creditsInt);

            }
            studyLogsDAO.close();
            HelloApplication.showHomePage();//needs a username



        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleCancelButtonClicked(){
        try {
            HelloApplication.showHomePage(); //needs a username
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
