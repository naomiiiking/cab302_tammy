package tammy;
/**
    used to define the type of tammy and
 **/
public enum TammyType {
    Fitness("Fitness"),
    Study("Study"),
    Sleep("Sleep");

    public final String typeName;

    TammyType(String TypeName){
        typeName = TypeName;
    }

    public String GetTypeName(){
        return typeName;
    }
}
