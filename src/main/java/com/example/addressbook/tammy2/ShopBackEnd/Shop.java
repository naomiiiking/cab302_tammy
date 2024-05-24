package com.example.addressbook.tammy2.ShopBackEnd;

import com.example.addressbook.tammy2.ProgressTracking.ProgressTracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shop that manages a list of items and handles purchases.
 */
public class Shop {
    private final List<Item> items;

    /**
     * Constructs a new Shop and initializes it with a set of default items.
     */
    public Shop() {
        this.items = new ArrayList<>();
        //Initialise shop with items
        items.add(new Item("Food", 1));
        items.add(new Item("Water", 1));
        items.add(new Item("Happiness", 5));
    }

    /**
     * Attempts to purchase an item by its name if sufficient currency is available.
     *
     * @param itemName the name of the item to purchase.
     * @param tracker the ProgressTracker of the user attempting the purchase.
     * @return true if the purchase is successful, false otherwise.
     */
    public boolean purchaseItem(String itemName, ProgressTracker tracker) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName) && tracker.getCurrency() >= item.getPrice()) {
                tracker.updateCurrency(-item.getPrice()); // Deduct the price from the user's currency
                System.out.print(tracker.getCurrency());
                return true; // Purchase successful
            }
        }
        return false; // Purchase failed
    }

    /**
     * Returns the list of items available for purchase in the shop.
     *
     * @return a list of items.
     */
    public List<Item> getItems() {
        return items;
    }
}
