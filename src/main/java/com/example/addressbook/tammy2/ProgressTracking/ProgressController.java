package com.example.addressbook.tammy2.ProgressTracking;

public class ProgressController {


    // Main method for testing
    public static void main(String[] args){
        ProgressTracker tracker = new ProgressTracker(100); //Initialise with initial currency
        tracker.logProgress("Logged progress", 10); // Example log progress
        System.out.println("Currency: " + tracker.currency); // Example output
        System.out.println("Logs: " + tracker.logs); // Example output
        System.out.println(tracker.getProgress()); // Example output
    }


}
