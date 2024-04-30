package com.example.addressbook.tammy2.tammy;
/**
    used to define the type of tammy and
 **/
public enum TammyType {
    Fitness("Fitness"),
    Study("Study"),
    Sleep("Sleep");

    private final String characteristicName;

    TammyType(String characteristicName){
        this.characteristicName = characteristicName;
    }

    public String GetCharacteristicName(){
        return characteristicName;
    }
}


