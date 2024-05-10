package com.example.addressbook.tammy2.tammy;

/**
 * Class used to assign different Species to the Tammy Objects
 */
public enum TammySpecies{
    Rabbit("Rabbit"),
    Shell("Shell"),
    Fish("Fish");


    private final String speciesName;

    /**
     * constructs the class to set the speciesName to a certain enum type
     * @param speciesName is the String speciesName
     */
    TammySpecies(String speciesName){
        this.speciesName = speciesName;
    }

    /**
     * returns the string speciesName based off the enum type
     * @return speciesName
     */
    public String GetSpeciesName(){
        return  speciesName;
    }
}
