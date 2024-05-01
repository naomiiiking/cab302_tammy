package com.example.addressbook.tammy2.ProgressTracking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProgressTracker {
    public int currency;
    public List<String> logs;
    private final Date startDate;

    /**
     * Constructor
     * @param initialCurrency user's initial currency
     */
    public ProgressTracker(int initialCurrency){
        this.currency = initialCurrency;
        this.logs = new ArrayList<>();
        this.startDate = new Date(); // Set start date/time
    }

    /**
     * Function to log progress and update currency
     * @param log the log recorded
     * @param currencyChange change in currency from log
     */
    public void logProgress(String log, int currencyChange){
        logs.add(log);
        currency += currencyChange;
    }

    /**
     * Function to get progress based on current date/time compared with start
     * @return returns the progress made and elapsed time
     */
    public String getProgress(){
        Date currentDate = new Date();
        long elapsedTime = currentDate.getTime() - startDate.getTime();
        // Perform calculations based on elapsed time
        // Return progress as a string
        return "Progress: " + elapsedTime + " time passed.";
    }

    public int getCurrency() {
        return currency;
    }

    public void updateCurrency(int amount) {
        currency += amount;
    }
}
