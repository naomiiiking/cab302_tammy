import com.example.addressbook.tammy2.AuthenLog.Main;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginUserTest {
    private UserAccountDAO userAccountDAO;

    @BeforeEach
    public void setUp() {
        userAccountDAO = new UserAccountDAO();
    }

    @Test
    public void testLoginUser() {
        // Register a test user
        Main.registerUser(userAccountDAO);

        // Mock user input
        String input = "LauraG\nZeus&12\n";  // Provide username and password
        InputStream in = new ByteArrayInputStream(input.getBytes());

        // Store original System.in to restore it later
        InputStream originalIn = System.in;

        try {
            // Set the mock input stream
            System.setIn(in);

            // Call the loginUser method
            Main.loginUser();

            // Check if login was successful
            boolean isLoggedIn = userAccountDAO.getAll().stream()
                    .anyMatch(user -> user.getUsername().equals("testuser"));
            assertTrue(isLoggedIn);
        } finally {
            // Restore original System.in
            System.setIn(originalIn);
        }
    }
}
