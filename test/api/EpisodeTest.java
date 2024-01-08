package api;

import org.junit.Test;

import static org.junit.Assert.*;

public class EpisodeTest {

    @Test
    public void testConstructor() {
        String expectedName = "Test";
        int expectedDuration = 0;

        Episode testEpisode = new Episode(expectedName,expectedDuration);

        assertEquals(expectedName, testEpisode.getName());
        assertEquals(expectedDuration, testEpisode.getDuration());
    }

    @Test
    public void testgetName() {
        String expectedName = "Test";
        int expectedDuration = 0;

        Episode testEpisode = new Episode(expectedName,expectedDuration);

        assertEquals(expectedName, testEpisode.getName());
    }

    @Test
    public void testgetDuration() {
        String expectedName = "Test";
        int expectedDuration = 0;

        Episode testEpisode = new Episode(expectedName,expectedDuration);

        assertEquals(expectedDuration, testEpisode.getDuration());
    }

}