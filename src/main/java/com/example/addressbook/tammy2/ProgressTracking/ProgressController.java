package com.example.addressbook.tammy2.ProgressTracking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProgressController {
    private int currency;
    private List<String> logs;
    private final Date startDate;

    // Constructor
    public ProgressController(int initialCurrency){
        this.currency = initialCurrency;
        this.logs = new ArrayList<>();
        this.startDate = new Date(); // Set start date/time
    }

    // Function to log progress and update currency
    public void logProgress(String log, int currencyChange){
        logs.add(log);
        currency += currencyChange;
    }

    // Function to get progress based on current date/time compared with start
    public String getProgress(){
        Date currentDate = new Date();
        long elapsedTime = currentDate.getTime() - startDate.getTime();
        // Perform calculations based on elapsed time
        // Return progress as a string
        return "Progress: " + elapsedTime + " time passed.";
    }

    // Main method for testing
    public static void main(String[] args){
        ProgressController tracker = new ProgressController(100); //Initialise with initial currency
        tracker.logProgress("Logged progress", 10); // Example log progress
        System.out.println("Currency: " + tracker.currency); // Example output
        System.out.println("Logs: " + tracker.logs); // Example output
        System.out.println(tracker.getProgress()); // Example output
    }


}
