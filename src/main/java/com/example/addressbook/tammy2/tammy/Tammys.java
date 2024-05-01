package com.example.addressbook.tammy2.tammy;

public class Tammys implements ITammy {

    private String name;
    private int OwnerID;
    private int water;
    private int food;
    public String Characteristic;
    public String Species;

    public Tammys( int TamOwner, String TamName, String characteristic, String species){
        this.OwnerID = TamOwner;
        this.name = TamName;
        this.food = 100;
        this.water = 100;
        setCharacteristic(characteristic);
        setSpecies(species);
    }

    public Tammys( int TamOwner, String TamName, int food, int water, String characteristic, String species){
        this.OwnerID = TamOwner;
        this.name = TamName;
        this.food = 100;
        this.water = 100;
        this.Characteristic = characteristic;
        this.Species = species;
    }

    @Override
    public int getOwnerId() {
        return OwnerID;
    }

    public void setOwnerID(int id){this.OwnerID = id;}

    @Override
    public int getFoodVar() {
        return food;
    }

    public void setFoodVar(int food){this.food = food;}

    public void setADDFoodVar(int food){this.food += food;}

    public void setMINUSFoodVar(int food){this.food -= food;}

    @Override
    public int getWaterVar() {
        return water;
    }

    public void setWaterVar(int water){this.water = water;}

    public void setADDWaterVar(int water){this.water += water;}

    public void setMINUSWaterVar(int water){this.water -= water;}

    @Override
    public String getCharacteristic(){
        return this.Characteristic;
    }

    @Override
    public String getSpecies() {
        return this.Species;
    }

    public void setCharacteristic(String decider){
        if (decider.contains("Sleep")){
            this.Characteristic = TammyType.Sleep.GetCharacteristicName();
        }
        else if (decider.contains("Study")){
            this.Characteristic = TammyType.Study.GetCharacteristicName();
        }
        else{
            this.Characteristic = TammyType.Fitness.GetCharacteristicName();
        }
    }

    public void setSpecies(String decider){
        if(decider.contains("Fish")){
            this.Species = TammySpecies.Fish.GetSpeciesName();
        }
        else if(decider.contains("Rabbit")){
            this.Species = TammySpecies.Rabbit.GetSpeciesName();
        }
        else {
            this.Species = TammySpecies.Shell.GetSpeciesName();
        }
    }

    @Override
    public String getName(){
        return name;
    }

    public void setName(String name){this.name = name;}

    //public abstract String ShowMood();

}
