package api;

import java.io.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class PersonAdderToFileTest {

    @Test
    public void testFindUsername() {
        FirstInitializationForAdminsSubscribers fi = new FirstInitializationForAdminsSubscribers();

        // Create an instance of the PersonAdderToFile class
        PersonAdderToFile personAdder = new PersonAdderToFile();

        // Assuming "Admins.txt" and "Subscribers.txt" files are initialized correctly
        // with test data in the FirstInitializationForAdminsSubscribers constructor.

        // Test for an existing username
        assertEquals(false, personAdder.findUsername("admin1"));

        // Test for a non-existing username
        assertEquals(true, personAdder.findUsername("newUser"));

        // Test for an existing username among subscribers
        assertEquals(false, personAdder.findUsername("user1"));

        // Test for a non-existing username among subscribers
        assertEquals(true, personAdder.findUsername("newSubscriber"));
    }

    @Test
    public void testAddSubscriberViaForm() {
        // Create an instance of the PersonAdderToFile class
        PersonAdderToFile personAdder = new PersonAdderToFile();

        // Assuming "Subscribers.txt" file is initialized correctly
        // with test data in the FirstInitializationForAdminsSubscribers constructor.

        // Add a new subscriber
        personAdder.addSubscriberViaForm("newUser", "newPassword", "New", "User");

        // Check if the new subscriber is added to the file
        assertTrue(fileContains("Subscribers.txt", "newUser newPassword New User"));
    }

    // Helper method to check if a file contains a specific line
    private boolean fileContains(String filePath, String expectedLine) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(expectedLine)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

