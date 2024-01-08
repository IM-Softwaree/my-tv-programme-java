package api;

import org.junit.Test;
import static org.junit.Assert.*;

public class SubscriberTest {

    @Test
    public void testSubscriberConstructor() {
        Subscriber subscriber = new Subscriber("user123", "pass123", "John", "Doe");
        assertEquals("user123", subscriber.getUserame());
        assertEquals("pass123", subscriber.getPassword());
        assertEquals("John", subscriber.getName());
        assertEquals("Doe", subscriber.getSurname());
    }

    @Test
    public void testFavourites() {
        Subscriber subscriber = new Subscriber("user456", "pass456", "Alice", "Smith");

        Video video1 = new Video();
        Video video2 = new Video("Dora the adventurer", "Dora is a highschool girl", "0+", "comedy", "Dora");

        subscriber.addFavourite(video1);
        subscriber.addFavourite(video2);

        assertEquals(2, subscriber.getFavourites().size());
        assertTrue(subscriber.getFavourites().contains(video1));
        assertTrue(subscriber.getFavourites().contains(video2));
    }

    // Add more test cases based on the functionality of your class
}

