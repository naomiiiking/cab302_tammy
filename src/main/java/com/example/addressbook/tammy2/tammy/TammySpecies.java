package com.example.addressbook.tammy2.tammy;

public enum TammySpecies{
    Bean("Bean"),
    Popcorn("Popcorn"),
    Dorito("Dorito");


    private final String speciesName;

    TammySpecies(String speciesName){
        this.speciesName = speciesName;
    }

    public String GetSpeciesName(){
        return  speciesName;
    }
}
