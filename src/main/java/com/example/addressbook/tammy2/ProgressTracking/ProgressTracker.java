package com.example.addressbook.tammy2.ProgressTracking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Tracks the progress of a user's currency and log activities over time.
 */
public class ProgressTracker {
    public int currency;
    public List<String> logs;
    private final Date startDate;

    /**
     * Constructs a new ProgressTracker with an initial currency amount.
     *
     * @param initialCurrency the initial amount of currency the user has.
     */
    public ProgressTracker(int initialCurrency){
        this.currency = initialCurrency;
        this.logs = new ArrayList<>();
        this.startDate = new Date(); // Set start date/time
    }

    /**
     * Logs a new progress entry and updates the currency based on a provided change.
     *
     * @param log the progress log to add.
     * @param currencyChange the change in currency to apply.
     */
    public void logProgress(String log, int currencyChange){
        logs.add(log);
        currency += currencyChange;
    }

    /**
     * Returns a string describing the current progress based on the time elapsed
     * since the start date.
     *
     * @return a string representing the elapsed time and progress.
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
