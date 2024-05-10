package com.example.addressbook.tammy2.tammy;

/**
 * A class used to create objects for our Tammys representing its name, OwnerID, water, food, Characteristic
 * and Species
 */
public class Tammys implements ITammy{

    private String name;
    private int OwnerID;
    private int water;
    private int food;
    public String Characteristic;
    public String Species;

    /**
     * Constructs a new Tammy with the specified TamOwner id, TamName, characteristic, species
     * is used when first creating the Tammy and to be put into the database
     * @param TamOwner the OwnerID of the Tammys
     * @param TamName the name of the Tammys
     * @param characteristic the Characteristic of the Tammys
     * @param species the Species of the Tammys
     */
    public Tammys( int TamOwner, String TamName, String characteristic, String species){
        this.OwnerID = TamOwner;
        this.name = TamName;
        this.food = 100;
        this.water = 100;
        setCharacteristic(characteristic);
        setSpecies(species);
    }

    /**
     * Constructs a new Tammy with the specified TamOwner id, TamName, food, water, characteristic, species
     * this is used when SELECT is used to get the tammy from the database
     * @param TamOwner the OwnerID of the Tammys
     * @param TamName the name of the Tammys
     * @param food the food of the Tammys
     * @param water the water of the Tammys
     * @param characteristic the Characteristic of the Tammys
     * @param species the Species of the Tammys
     */
    public Tammys( int TamOwner, String TamName, int food, int water, String characteristic, String species){
        this.OwnerID = TamOwner;
        this.name = TamName;
        this.food = food;
        this.water = water;
        this.Characteristic = characteristic;
        this.Species = species;
    }

    /**
     * Override from the Interface
     * used to get the private OwnerID variable
     * @return OwnerID
     */
    @Override
    public int getOwnerId() {
        return OwnerID;
    }

    /**
     * Sets the OwnerID variable to the param id
     * @param id the new OwnerID
     */
    public void setOwnerID(int id){this.OwnerID = id;}

    /**
     * Override of the method in the Interface
     * Gets the private variable food
     * @return food
     */
    @Override
    public int getFoodVar() {
        return food;
    }

    /**
     * Sets the variable food 
     * @param food the food variable of the Tammy Object
     */
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
