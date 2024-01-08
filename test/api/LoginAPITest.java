package api;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LoginAPITest {

    private ByteArrayOutputStream outContent;  // To capture system output

    @Before
    public void setUpStreams() {
        // Redirect the system output to capture it
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        // Reset the system output
        System.setOut(System.out);
        outContent = null;
    }

    @Test
    public void testInitialization() {
        // Create an instance of the LoginAPI class
        LoginAPI loginAPI = new LoginAPI();

        // Test if the initialization logic works as expected

        // Assert that the initialization logic printed the expected messages to the console
        assertTrue(outContent.toString().toLowerCase().contains("file movies/series' exists.") || outContent.toString().toLowerCase().contains("file movies/series' does not exist."));
        assertTrue(outContent.toString().toLowerCase().contains("file subscribers/admins' exists.") || outContent.toString().toLowerCase().contains("file subscribers/admins' does not exist."));
    }

    @Test
    public void testIsAdminUserNothing() {
        // Create an instance of the LoginAPI class
        LoginAPI loginAPI = new LoginAPI();

        // Test the isAdminUserNothing function

        // Assuming that "Admins.txt" and "Subscribers.txt" files are initialized correctly
        // with test data in the LoginAPI constructor.

        // Test for admin credentials
        assertEquals('A', loginAPI.isAdminUserNothing("admin1", "password1"));

        // Test for user credentials
        assertEquals('U', loginAPI.isAdminUserNothing("user1", "password1"));

        // Test for invalid credentials
        assertEquals('N', loginAPI.isAdminUserNothing("invalidUser", "invalidPassword"));
    }

    // Helper method to capture system out for testing console output
    private String systemOut() {
        return System.out.toString().toLowerCase(); // You may need to customize this based on your actual console output
    }
}

//