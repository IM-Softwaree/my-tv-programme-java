package api;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void testConstructor() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";
        int expectedYear = 2000;
        int expectedDur = 60;

        Movie testMovie = new Movie(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro,expectedYear,expectedDur);

        assertEquals(expectedTitle, testMovie.getTitle());
        assertEquals(expectedDes, testMovie.getDescription());
        assertEquals(expectedAp, testMovie.getAppropriateness());
        assertEquals(expectedCat, testMovie.getCategory());
        assertEquals(expectedPro, testMovie.getProtagonists());
        assertEquals(expectedYear, testMovie.getYearOfFirstAppearance());
        assertEquals(expectedDur, testMovie.getMovieDuration());
    }

    @Test
    public void testSetYear() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";
        int expectedYear = 2000;
        int expectedDur = 60;

        Movie testMovie = new Movie(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro,expectedYear,expectedDur);

        testMovie.setYearOfFirstAppearance(2001);

        assertEquals(2001, testMovie.getYearOfFirstAppearance());

    }

    @Test
    public void testSetDur() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";
        int expectedYear = 2000;
        int expectedDur = 60;

        Movie testMovie = new Movie(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro,expectedYear,expectedDur);

        testMovie.setMovieDuration(120);

        assertEquals(120, testMovie.getMovieDuration());

    }

    @Test
    public void testGetYear() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";
        int expectedYear = 2000;
        int expectedDur = 60;

        Movie testMovie = new Movie(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro,expectedYear,expectedDur);

        assertEquals(2000, testMovie.getYearOfFirstAppearance());

    }

    @Test
    public void testGetDur() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";
        int expectedYear = 2000;
        int expectedDur = 60;

        Movie testMovie = new Movie(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro,expectedYear,expectedDur);

        assertEquals(60, testMovie.getMovieDuration());

    }

    @Test
    public void testAddMovieToFile() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";
        int expectedYear = 2000;
        int expectedDur = 60;

        Movie testMovie = new Movie(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro,expectedYear,expectedDur);

        FirstInitializationOfSeriesMovies test = new FirstInitializationOfSeriesMovies();

        //check if the movie did not already exist and was added to the file
        assertEquals(true, testMovie.addMovieToFile());

        //check if the movie was not added to the file because it already existed
        assertEquals(false, testMovie.addMovieToFile());

    }

}
