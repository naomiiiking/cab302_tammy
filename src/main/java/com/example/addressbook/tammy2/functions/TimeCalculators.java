package com.example.addressbook.tammy2.functions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeCalculators {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/y HH:mm");
    public String GetTime() {
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }

    /**
     * used to calculate the time passed from the last time it was stored
     * call the get time method whenever the user saves progress to store.
     */
    public Long TimePassed(String oldDate) {
        Date newDate = null;
        Date parsedOldDate = null;
        try {
            newDate = dateFormat.parse(GetTime());
            parsedOldDate = dateFormat.parse(oldDate);
        } catch (ParseException e) {
            System.err.println(e.getMessage());            
        }
        
        long timeDifference = (newDate != null ? newDate.getTime() : 0) - (parsedOldDate != null ? parsedOldDate.getTime() : 0);
        // converting time difference to hours and returning
        return timeDifference / (1000 * 60 * 60);
    }
}
