package api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SerieTest {

    @Test
    public void testConstructor() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Serie testSerie = new Serie(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        assertEquals(expectedTitle, testSerie.getTitle());
        assertEquals(expectedDes, testSerie.getDescription());
        assertEquals(expectedAp, testSerie.getAppropriateness());
        assertEquals(expectedCat, testSerie.getCategory());
        assertEquals(expectedPro, testSerie.getProtagonists());

    }

    @Test
    public void testSetSeasons() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Serie testSerie = new Serie(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        int expectedNumber = 1;
        int expectedYear = 2000;
        Season testSeason = new Season(expectedNumber,expectedYear);

        testSerie.setSeasons(testSeason);

        assertEquals(1, testSerie.getSeasons().size());
    }

    @Test
    public void testGetSeasons() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Serie testSerie = new Serie(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        int expectedNumber = 1;
        int expectedYear = 2000;
        Season testSeason = new Season(expectedNumber,expectedYear);
        testSerie.setSeasons(testSeason);

        int expectedNumber2 = 2;
        int expectedYear2 = 2001;
        Season testSeason2 = new Season(expectedNumber2,expectedYear2);
        testSerie.setSeasons(testSeason2);

        assertEquals(2, testSerie.getSeasons().size());
    }

    @Test
    public void testAddSerieToFile() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Serie testSerie = new Serie(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        FirstInitializationOfSeriesMovies test = new FirstInitializationOfSeriesMovies();

        //check if the serie did not already exist and was added to the file
        assertEquals(true, testSerie.addSerieToFile(testSerie));

        //check if the serie was not added to the file because it already existed
        assertEquals(false, testSerie.addSerieToFile(testSerie));

    }

    @Test
    public void testAddSeasonToFile() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Serie testSerie = new Serie(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        int expectedNumber = 1;
        int expectedYear = 2000;
        Season testSeason = new Season(expectedNumber,expectedYear);

        FirstInitializationOfSeriesMovies test = new FirstInitializationOfSeriesMovies();

        //check if the serie did not exist, and we did not add the season
        assertEquals(false, testSerie.addSeasonToFile(expectedTitle,testSeason));

        //we add the serie to the file
        testSerie.addSerieToFile(testSerie);

        //check if the serie exists, and we added the season
        assertEquals(true, testSerie.addSeasonToFile(expectedTitle,testSeason));

    }

    @Test
    public void testAddEpisodeToFile() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";
        Serie testSerie = new Serie(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        int expectedNumber = 1;
        int expectedYear = 2000;
        Season testSeason = new Season(expectedNumber,expectedYear);

        String expectedName = "Test";
        int expectedDuration = 0;
        Episode testEpisode = new Episode(expectedName,expectedDuration);

        FirstInitializationOfSeriesMovies test = new FirstInitializationOfSeriesMovies();

        //check if the serie/season did not exist, and we did not add the episode
        assertEquals(false, testSerie.addEpisodeToFile(expectedTitle,1,testEpisode));

        //we add the serie to the file
        testSerie.addSerieToFile(testSerie);

        //check if the season did not exist, and we did not add the episode
        assertEquals(false, testSerie.addEpisodeToFile(expectedTitle,1,testEpisode));

        //we add the season to the serie, and all to the file
        testSerie.addSeasonToFile(expectedTitle,testSeason);

        //check if the serie/season exist, and we added the episode
        assertEquals(true, testSerie.addEpisodeToFile(expectedTitle,1,testEpisode));

    }

}
