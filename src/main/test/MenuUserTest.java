import com.example.addressbook.tammy2.AuthenLog.Main;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuUserTest{
    private UserAccountDAO userAccountDAO;

    @BeforeEach
    public void setUp() {
        userAccountDAO = new UserAccountDAO(); }

 //   @Test
    public void testUserChanges() {
        // Register a test user
        Main.registerUser(userAccountDAO);

        // Mock user update input
        String updateInput = "updatedName\n" +                   // Username
                "updatedEmail\n" +       // Email
                "upadtedPassword\n" ;             // Password

        //InputStream updateIn = new ByteArrayInputStream(input.getBytes());

        // Store original System.in to restore it later
        //InputStream originalIn = System.in;

        try{
            // Set the mock update stream
            //System.setIn(updateIn);

            // Call updateUser method
            //UserAccountDAO.update();

            // Retrieve details from updated user from database
            //String updatedUsername = userAccountDAO.getByUsername("updatedName").getUsername();

            // Check if update was successful
            //assertEquals("updatedName", username)
        }
        finally {
            // Restore original System.in
            //System.setIn(originalIn);
        }
    }

}