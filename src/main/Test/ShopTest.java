import com.example.addressbook.tammy2.ShopBackEnd.*;
import com.example.addressbook.tammy2.ProgressTracking.ProgressTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {
    private Shop shop;
    private ProgressTracker tracker;

    @BeforeEach
    public void setUp() {
        shop = new Shop();
        tracker = new ProgressTracker(50); // Initialize with 50 currency units
    }

    @Test
    public void testPurchaseItemSuccess() {
        // Test successful purchase
        assertTrue(shop.purchaseItem("Food", tracker));
        assertEquals(30, tracker.getCurrency(), "Currency should be reduced by the price of Food.");
    }

    @Test
    public void testPurchaseItemInsufficientCurrency() {
        // Test purchase failure due to insufficient currency
        assertFalse(shop.purchaseItem("Food", new ProgressTracker(10))); // New tracker with only 10 currency
        assertEquals(10, tracker.getCurrency(), "Currency should not change.");
    }

    @Test
    public void testPurchaseItemNonExistent() {
        // Test purchase failure due to non-existent item
        assertFalse(shop.purchaseItem("Toy", tracker));
        assertEquals(50, tracker.getCurrency(), "Currency should not change.");
    }

    @Test
    public void testShopInitialInventory() {
        // Test the initial setup of the Shop's inventory
        assertEquals(2, shop.getItems().size(), "Shop should start with 2 types of items.");
        assertEquals("Food", shop.getItems().get(0).getName(), "First item should be Food.");
        assertEquals(20, shop.getItems().get(0).getPrice(), "Price of Food should be 20.");
        assertEquals("Water", shop.getItems().get(1).getName(), "Second item should be Water.");
        assertEquals(10, shop.getItems().get(1).getPrice(), "Price of Water should be 10.");
    }
}
