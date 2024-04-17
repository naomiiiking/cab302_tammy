package tammy;

public abstract class Tammys implements ITammy {

    private String name;
    private int OwnerID;
    public int health;

    public String Characteristic;

    public Tammys(String TamName, int TamOwner){
        name = TamName;
        OwnerID = TamOwner;
        health = 100;
    }

    public void Feed() {
        if(health < 100){
            health += 20;
        }
    }

    public int ShowVitals(){
        return health;
    }

    public abstract String ShowMood();

    public abstract String GetType();
}
