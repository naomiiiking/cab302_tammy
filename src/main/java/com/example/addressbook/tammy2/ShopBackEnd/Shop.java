package com.example.addressbook.tammy2.ShopBackEnd;

import com.example.addressbook.tammy2.ProgressTracking.ProgressTracker;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Item> items;

    public Shop() {
        this.items = new ArrayList<>();
        //Initialise shop with items
        items.add(new Item("Food", 20));
        items.add(new Item("Water", 10));
    }

    public boolean purchaseItem(String itemName, ProgressTracker tracker) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName) && tracker.getCurrency() >= item.getPrice()) {
                tracker.updateCurrency(-item.getPrice()); // Deduct the price from the user's currency
                return true; // Purchase successful
            }
        }
        return false; // Purchase failed
    }

    public List<Item> getItems() {
        return items;
    }
}
