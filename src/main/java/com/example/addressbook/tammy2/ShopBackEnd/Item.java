package com.example.addressbook.tammy2.ShopBackEnd;

/**
 * Represents an item that can be purchased in the shop.
 */
public class Item {
    private String name;
    private int price;

    /**
     * Constructs a new Item with a name and price.
     *
     * @param name the name of the item.
     * @param price the price of the item in currency units.
     */
    public Item (String name, int price){
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the name of the item.
     *
     * @return the name of the item.
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the price of the item.
     *
     * @return the price of the item in currency units.
     */
    public int getPrice(){
        return price;
    }
}
