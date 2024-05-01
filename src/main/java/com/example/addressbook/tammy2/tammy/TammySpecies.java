package com.example.addressbook.tammy2.tammy;

public enum TammySpecies{
    Rabbit("Rabbit"),
    Shell("Shell"),
    Fish("Fish");


    private final String speciesName;

    TammySpecies(String speciesName){
        this.speciesName = speciesName;
    }

    public String GetSpeciesName(){
        return  speciesName;
    }
}
