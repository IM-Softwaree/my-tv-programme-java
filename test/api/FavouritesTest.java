package api;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FavouritesTest {

    @Test
    public void testDeleteFavourite() {
        // Create a temporary file for testing
        Path tempFile = Paths.get("tempFavourites.txt");

        try {
            // Write initial content to the temporary file
            Files.write(tempFile, "user123 , movie1 , movie2 , movie3".getBytes());

            // Perform the delete operation
            Favourites.deleteFavourite("user123", "movie2");

            // Read the content from the file
            String content = Files.readString(tempFile);

            // Check if the specified movie is deleted
            assertFalse(content.contains("user123 , movie2"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Clean up: delete the temporary file
            try {
                Files.deleteIfExists(tempFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void testFindLineForUserAdd() {
        // Create a temporary file for testing
        Path tempFile = Paths.get("tempFavourites.txt");

        try {
            // Write initial content to the temporary file
            Files.write(tempFile, "user123 , movie1 , movie2".getBytes());

            // Perform the findLineForUserAdd operation
            Favourites.findLineForUserAdd("user123", "movie3");

            // Read the content from the file
            String content = Files.readString(tempFile);

            // Check if the new movie is added to the specific line
            assertTrue(content.contains("user123 , movie1 , movie2 , movie3"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Clean up: delete the temporary file
            try {
                Files.deleteIfExists(tempFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFindLineForUserDelete() {
        // Create a temporary file for testing
        Path tempFile = Paths.get("tempFavourites.txt");

        try {
            // Write initial content to the temporary file
            Files.write(tempFile, "user123 , movie1 , movie2 , movie3".getBytes());

            // Perform the findLineForUserDelete operation
            Favourites.findLineForUserDelete("user123", "movie2");

            // Read the content from the file
            String content = Files.readString(tempFile);

            // Check if the specified movie is deleted from the specific line
            assertFalse(content.contains("user123 , movie2"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Clean up: delete the temporary file
            try {
                Files.deleteIfExists(tempFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
//
