package tammy;



public class FitnessTam extends Tammys{

    public FitnessTam(String name, int OwnerID){
        super(name,OwnerID);
        //Characteristic = GetType();
    }
    @Override
    public String ShowMood() {
        return null;
    }

    @Override
    public String GetType() {
        return TammyType.Fitness.GetTypeName();
    }

    public void takeDmg(){
        setHealth(-20);
    }


}
