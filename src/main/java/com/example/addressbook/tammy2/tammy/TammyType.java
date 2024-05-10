package com.example.addressbook.tammy2.tammy;

/**
 * Class used to assign different Species to the Tammy Objects
 */
public enum TammyType {
    Fitness("Fitness"),
    Study("Study"),
    Sleep("Sleep");

    private final String characteristicName;

    /**
     * constructs the class to set the characteristicName to a certain enum type
     * @param characteristicName is the string characteristicName
     */
    TammyType(String characteristicName){
        this.characteristicName = characteristicName;
    }

    /**
     * returns the string characteristicName based off the enum type
     * @return characteristicName
     */
    public String GetCharacteristicName(){
        return characteristicName;
    }
}


