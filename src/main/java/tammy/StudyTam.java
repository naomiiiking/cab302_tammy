package tammy;

public class StudyTam extends Tammys{

    public StudyTam(String name, int OwnerID){
        super(name,OwnerID);
        Characteristic = GetType();
    }

    @Override
    public String ShowMood() {
        return null;
    }

    @Override
    public String GetType() {
        return TammyType.Study.GetTypeName();
    }
}
