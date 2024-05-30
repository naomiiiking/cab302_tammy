package com.example.addressbook.tammy2.tammy;

public class Tammys implements ITammy {
    private String name;
    private int OwnerID;
    private int water;
    private int food;
    private String Characteristic;
    private String Species;
    private String Image;
    private int happiness;

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
        this.happiness = 100;
        setCharacteristic(characteristic);
        setSpecies(species);
        setImage(species);
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
    public Tammys( int TamOwner, String TamName, int food, int water, String characteristic, String species, int happiness){
        this.OwnerID = TamOwner;
        this.name = TamName;
        this.food = food;
        this.water = water;
        this.Characteristic = characteristic;
        this.Species = species;
        setImage(species);
        this.happiness = happiness;
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

    /**
     * Sets the food variable by adding the param to the variable
     * @param food the food variable of the TammyObject
     */
    public void setADDFoodVar(int food){
        int Food = this.food + food;
        this.food = (Food > 100) ? 100 : Food;}

    /**
     * Sets the food variable by minusing the param to the variable
     * @param food the food variable of the TammyObject
     */
    public void setMINUSFoodVar(int food){
        //this.food -= food;
        int Food = this.food - (int)(food * 1.2);
        this.food = (Food < 0) ? 0 : Food;
    }

    /**
     * Returns the variable water of the tammy object
     * @return water is the variable water
     */
    @Override
    public int getWaterVar() {
        return water;
    }

    /**
     * sets the variable water
     * @param water is the variable water
     */
    public void setWaterVar(int water){this.water = water;}

    /**
     * Sets the water variable by adding the param to the variable
     * @param water is the variable water
     */
    public void setADDWaterVar(int water){
        int Water = this.water + water;
        this.water = (Water > 100) ? 100 : Water;
    }

    /**
     *  Sets the water variable by minusing the param to the variable
     * @param water is the water variable
     */
    public void setMINUSWaterVar(int water){
        //this.water -= water;
        int Water = this.water - (int)(water * 1.5);
        this.water = (Water < 0) ? 0 : Water;
    }

    /**
     * returns the variable Characteristic of the object
     * @return Characteristic
     */
    @Override
    public String getCharacteristic(){
        return this.Characteristic;
    }

    /**
     * returns the variable Species of the object
     * @return Species
     */
    @Override
    public String getSpecies() {
        return this.Species;
    }

    /**
     * Sets the variable Characteristic dependent on the param, it then sets Characteristic
     * variable getting the enum from TammyType
     * @param decider is a String which is gotten through radiobuttons in the register method
     */
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

    /**
     * Sets the variable Species dependent on the param, it then sets Species variable
     * getting the enum from TammySpecies
     * @param decider is a String which is gotten through radiobutton in the register method
     */
    public void setSpecies(String decider){
        if(decider.contains("Bean")){
            this.Species = TammySpecies.Bean.GetSpeciesName();
        }
        else if(decider.contains("Popcorn")){
            this.Species = TammySpecies.Popcorn.GetSpeciesName();
        }
        else {
            this.Species = TammySpecies.Dorito.GetSpeciesName();
        }
    }

    /**
     * Sets the image that will be displayed for this TammyObject in the home screen
     * @param Species is the Species variable
     */
    private void setImage(String Species){
        if(Species.contains(TammySpecies.Bean.GetSpeciesName())){
            Image = "/assets/1.png";
        } else if (Species.contains(TammySpecies.Popcorn.GetSpeciesName())) {
            Image = "/assets/2.png";
        }
        else {
            Image = "/assets/3.png";
        }
    }

    /**
     * returns the Tammy objects image filepath
     * @return Image
     */
    public String getImage(){
        return Image;
    }

    /**
     * returns the Tammy objects happiness value
     * @return happiness
     */
    public int getHappiness(){ return this.happiness; }

    /**
     * sets the tammys objects happiness value whether it be adding or subtracting, also
     * limits it to the bounds of 100 and 0
     * @param addHappy the integer value to be added to happiness
     */
    public void updateHappiness(int addHappy){
        int Happiness = this.happiness + addHappy;
        if (Happiness > 100){Happiness = 100;}
        else if (Happiness < 0) {Happiness = 0;}
        this.happiness = Happiness;
    }

        /**
         * returns the objects variable name
         * @return name
         */
    @Override
    public String getName(){
        return name;
    }

    /**
     * Sets the objects name
     * @param name is the variable name
     */
    public void setName(String name){this.name = name;}

    //public abstract String ShowMood();

}
