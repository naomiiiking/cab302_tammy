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


}
