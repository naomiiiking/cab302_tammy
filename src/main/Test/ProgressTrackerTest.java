
import com.example.addressbook.tammy2.ProgressTracking.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ProgressTrackerTest {

    private ProgressTracker tracker;

    @BeforeEach
    public void setUp() {
        // Initialize ProgressTracker with 100 currency
        tracker = new ProgressTracker(100);
    }

    @Test
    public void testInitialCurrency() {
        // Assert that the initial currency is correctly set
        assertEquals(100, tracker.getCurrency());
    }

    @Test
    public void testCurrencyUpdate() {
        // Update currency by adding 50
        tracker.updateCurrency(50);
        // Assert the currency was updated correctly
        assertEquals(150, tracker.getCurrency());
    }

    @Test
    public void testLogProgress() {
        // Log progress and update currency
        tracker.logProgress("Studied 2 hours", 20);
        // Assert the currency is updated correctly
        assertEquals(120, tracker.getCurrency());
        // Assert the log is added correctly
        assertTrue(tracker.getLogs().contains("Studied 2 hours"));
    }
}

