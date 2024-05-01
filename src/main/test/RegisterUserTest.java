import com.example.addressbook.tammy2.AuthenLog.Main;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterUserTest {
    private UserAccountDAO userAccountDAO;

    @BeforeEach
    public void setUp() {
        userAccountDAO = new UserAccountDAO();
    }

    @Test
    public void testRegisterUser() {
        // Mock user input
        String input = "newuser\n" +                   // Username
                "newuser@example.com\n" +       // Email
                "newpassword\n" +               // Password
                "New Tammy\n" +                 // Tammy's name
                "sleep\n" +                     // Tammy's type
                "rabbit";                       // Tammy's species
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the registerUser method
        Main.registerUser(userAccountDAO);

        // Retrieve the registered user from the database
        String registeredUsername = userAccountDAO.getByUsername("newuser").getUsername();

        // Assert that the user is registered correctly
        assertEquals("newuser", registeredUsername);
    }
}
