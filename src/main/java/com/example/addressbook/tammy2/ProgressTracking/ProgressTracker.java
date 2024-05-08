package com.example.addressbook.tammy2.ProgressTracking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Tracks the progress of a user's currency and log activities over time.
 */
public class ProgressTracker {
    public int currency; // needs to be integrated
    public List<String> logs; // needs to be integrated or removed
    private final Date startDate; // potentially not needed

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

    /**
     * Returns the current amount of currency.
     *
     * @return the current currency.
     */
    public int getCurrency() {
        return currency;
    }

    /**
     * Updates the currency by a specified amount.
     *
     * @param amount the amount to add or subtract from the current currency.
     */
    public void updateCurrency(int amount) {
        currency += amount;
    }

    /**
     * Returns the list of all progress logs.
     *
     * @return a list of progress log entries.
     */
    public List<String> getLogs() {
        return logs;
    }
}
