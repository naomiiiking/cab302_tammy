package Memorylogs;

public class MemoryEntry {
    private String date;
    private int hoursStudied;
    private int creditsGained;

    public MemoryEntry(String date, int hoursStudied, int creditsGained) {
        this.date = date;
        this.hoursStudied = hoursStudied;
        this.creditsGained = creditsGained;
    }

    public String getDate() {
        return date;
    }

    public int getHoursStudied() {
        return hoursStudied;
    }

    public double getCreditsGained() {
        return creditsGained;
    }
}

