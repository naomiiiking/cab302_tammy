package tammy;

public abstract class Tammys implements ITammy {

    private String name;
    private int OwnerID;
    private int health;
    public String Characteristic;
    public int CharacteristicVariable;

    public Tammys(String TamName, int TamOwner){
        name = TamName;
        OwnerID = TamOwner;
        health = 100;
    }
    @Override
    public void Feed() {
        if(health < 100){
            health += 20;
        }
    }
    @Override
    public int getOwnerId() {
        return OwnerID;
    }

    public void setOwnerID(int id){
        this.OwnerID = id;
    }

    public int getCharacteristicVariable(){
        return CharacteristicVariable;
    }

    public void SetCharacteristicVariable(int value){
        this.CharacteristicVariable = value;
    }

    @Override
    public String getCharacteristic(){
        return Characteristic;
    }

    public void setCharacteristic(int decider){
        if(decider == 1){
            Characteristic = TammyType.Sleep.GetTypeName();
        }
        else if (decider == 2){
            Characteristic = TammyType.Study.GetTypeName();
        } else if (decider == 3) {
            Characteristic = TammyType.Fitness.GetTypeName();
        }
        else{
            return;
        }
    }



    @Override
    public String GetName(){
        return name;
    }

    @Override
    public int getHealth(){
        return health;
    }

    public void setHealth(int healthChangeVal){
        if (healthChangeVal > 0){
            this.health += healthChangeVal;
        }
        else{
            this.health -= healthChangeVal;
        }
    }





    public int ShowVitals(){
        return health;
    }

    public abstract String ShowMood();

    public abstract String GetType();
}
