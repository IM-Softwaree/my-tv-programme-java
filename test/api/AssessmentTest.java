package api;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssessmentTest {

    @Test
    public void testConstructor() {
        String expectedUsername = "Name";
        String expectedText = "Text";
        int expectedRating = 1;
        String expectedDate = "8/1/2024";

        Assessment testAssessment = new Assessment(expectedUsername,expectedText,expectedRating,expectedDate);

        assertEquals(expectedUsername, testAssessment.getUsername());
        assertEquals(expectedText, testAssessment.getText());
        assertEquals(expectedRating, testAssessment.getRating());
        assertEquals(expectedDate, testAssessment.getDate());
    }

    @Test
    public void testSetUsername() {
        String expectedUsername = "Name";
        String expectedText = "Text";
        int expectedRating = 1;
        String expectedDate = "8/1/2024";

        Assessment testAssessment = new Assessment(expectedUsername,expectedText,expectedRating,expectedDate);

        testAssessment.setUsername("Name2");

        assertEquals("Name2", testAssessment.getUsername());

    }

    @Test
    public void testSetText() {
        String expectedUsername = "Name";
        String expectedText = "Text";
        int expectedRating = 1;
        String expectedDate = "8/1/2024";

        Assessment testAssessment = new Assessment(expectedUsername,expectedText,expectedRating,expectedDate);

        testAssessment.setText("Text2");

        assertEquals("Text2", testAssessment.getText());

    }

    @Test
    public void testSetRating() {
        String expectedUsername = "Name";
        String expectedText = "Text";
        int expectedRating = 1;
        String expectedDate = "8/1/2024";

        Assessment testAssessment = new Assessment(expectedUsername,expectedText,expectedRating,expectedDate);

        testAssessment.setRating(5);

        assertEquals(5, testAssessment.getRating());

    }

    @Test
    public void testSetDate() {
        String expectedUsername = "Name";
        String expectedText = "Text";
        int expectedRating = 1;
        String expectedDate = "8/1/2024";

        Assessment testAssessment = new Assessment(expectedUsername,expectedText,expectedRating,expectedDate);

        testAssessment.setDate("8/2/2024");

        assertEquals("8/2/2024", testAssessment.getDate());
    }

    @Test
    public void testGetUsername() {
        String expectedUsername = "Name";
        String expectedText = "Text";
        int expectedRating = 1;
        String expectedDate = "8/1/2024";

        Assessment testAssessment = new Assessment(expectedUsername,expectedText,expectedRating,expectedDate);

        assertEquals(expectedUsername, testAssessment.getUsername());

    }

    @Test
    public void testGetText() {
        String expectedUsername = "Name";
        String expectedText = "Text";
        int expectedRating = 1;
        String expectedDate = "8/1/2024";

        Assessment testAssessment = new Assessment(expectedUsername,expectedText,expectedRating,expectedDate);

        assertEquals(expectedText, testAssessment.getText());

    }

    @Test
    public void testGetRating() {
        String expectedUsername = "Name";
        String expectedText = "Text";
        int expectedRating = 1;
        String expectedDate = "8/1/2024";

        Assessment testAssessment = new Assessment(expectedUsername,expectedText,expectedRating,expectedDate);

        assertEquals(expectedRating, testAssessment.getRating());

    }

    @Test
    public void testGetDate() {
        String expectedUsername = "Name";
        String expectedText = "Text";
        int expectedRating = 1;
        String expectedDate = "8/1/2024";

        Assessment testAssessment = new Assessment(expectedUsername,expectedText,expectedRating,expectedDate);

        assertEquals(expectedDate, testAssessment.getDate());
    }

}
//