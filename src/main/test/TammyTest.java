import com.example.addressbook.tammy2.tammy.Tammys;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TammyTest {
    private Tammys tammys;

    @BeforeEach
    public void setUp(){
        tammys = new Tammys(1,"CaneJR", "Fitness", "Rabbit");
    }
    @Test
    public void testGetOwnerID(){
        assertEquals(1,tammys.getOwnerId());
    }
    @Test
    public void testSetOwnerID(){
        tammys.setOwnerID(5);
        assertEquals(5,tammys.getOwnerId());
    }
    @Test
    public void testGetName(){
        assertEquals("CaneJR",tammys.getName());
    }
    @Test
    public void testSetName(){
        tammys.setName("CaneSR");
        assertEquals("CaneSR",tammys.getName());
    }
    @Test
    public void testGetFoodVar(){
        assertEquals(100, tammys.getFoodVar());
    }
    @Test
    public void testSetFoodVar(){
        tammys.setFoodVar(80);
        assertEquals(80,tammys.getFoodVar());
    }
    @Test
    public void testSetADDFoodVar(){
        tammys.setFoodVar(80);
        tammys.setADDFoodVar(20);
        assertEquals(100,tammys.getFoodVar());
    }
    @Test
    public void testSetMINUSFoodVar(){
        tammys.setMINUSFoodVar(20);
        assertEquals(80,tammys.getFoodVar());
    }
    @Test
    public void testGetWaterVar(){
        assertEquals(100,tammys.getWaterVar());
    }
    @Test
    public void testSetWaterVar(){
        tammys.setWaterVar(80);
        assertEquals(80,tammys.getWaterVar());
    }
    @Test
    public void testSetADDWaterVar(){
        tammys.setWaterVar(80);
        tammys.setADDWaterVar(20);
        assertEquals(100,tammys.getWaterVar());
    }
    @Test
    public void testSetMINUSWaterVar(){
        tammys.setMINUSWaterVar(20);
        assertEquals(80,tammys.getWaterVar());
    }
    @Test
    public void testGetCharacteristic(){
        assertEquals("Fitness",tammys.getCharacteristic());
    }
    @Test
    public void testSetCharacteristic(){
        tammys.setCharacteristic("Sleep");
        assertEquals("Sleep",tammys.getCharacteristic());
        tammys.setCharacteristic("Study");
        assertEquals("Study",tammys.getCharacteristic());
    }
    @Test
    public void testGetSpecies(){
        assertEquals("Rabbit",tammys.getSpecies());
    }
    @Test
    public void testSetSpecies(){
        tammys.setCharacteristic("Fish");
        assertEquals("Fish",tammys.getSpecies());
        tammys.setCharacteristic("Shell");
        assertEquals("Shell",tammys.getSpecies());
    }
}
