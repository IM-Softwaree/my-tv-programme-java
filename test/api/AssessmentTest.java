package api;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssessmentTest {

    @Test
    public void testConstructor() {
        String expectedUsername = "Name";
        String expectedText = "Text";
        int expectedRating = 1;
        String expectedDate = "8/1/20229";

        Assessment testAssessment = new Assessment(expectedUsername,expectedText,expectedRating,expectedDate);

        assertEquals(expectedUsername, testAssessment.getUsername());
        assertEquals(expectedText, testAssessment.getText());
        assertEquals(expectedRating, testAssessment.getRating());
        assertEquals(expectedDate, testAssessment.getDate());
    }



}