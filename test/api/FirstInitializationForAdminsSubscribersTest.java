package api;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class FirstInitializationForAdminsSubscribersTest {

    @Test
    public void testInitialization() {
        // Create an instance of the initialization class
        FirstInitializationForAdminsSubscribers initializer = new FirstInitializationForAdminsSubscribers();

        // Test if the files are created and contain the expected data

        // Test Admins.txt
        assertTrue(fileContains("Admins.txt", "admin1 password1"));
        assertTrue(fileContains("Admins.txt", "admin2 password2"));

        // Test Subscribers.txt
        assertTrue(fileContains("Subscribers.txt", "user1 password1 name1 surname1"));
        assertTrue(fileContains("Subscribers.txt", "user2 password2 name2 surname2"));

        // Test Favourites.txt
        assertTrue(fileContains("Favourites.txt", "user1 , Barbie , Alice in Borderland"));
        assertTrue(fileContains("Favourites.txt", "user2 , Inception , Monk"));
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

