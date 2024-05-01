package com.example.addressbook.tammy2.ProgressTracking;

import com.example.addressbook.tammy2.ShopBackEnd.Shop;

public class ProgressController {

    /**
     * Main method for testing
     * @param args
     */
    public static void main(String[] args){
        ProgressTracker tracker = new ProgressTracker(100);
        Shop shop = new Shop();

        // Simulate a purchase
        boolean success = shop.purchaseItem("Food", tracker);
        System.out.println("Purchase successful? " + success);
        System.out.println("Remaining currency: " + tracker.getCurrency());
    }


}
