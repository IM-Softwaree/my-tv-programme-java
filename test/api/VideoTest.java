package api;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VideoTest {

    @Test
    public void testConstructor() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        assertEquals(expectedTitle, testVideo.getTitle());
        assertEquals(expectedDes, testVideo.getDescription());
        assertEquals(expectedAp, testVideo.getAppropriateness());
        assertEquals(expectedCat, testVideo.getCategory());
        assertEquals(expectedPro, testVideo.getProtagonists());

    }

    @Test
    public void testSetTitle() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        testVideo.setTitle("Title2");

        assertEquals("Title2", testVideo.getTitle());

    }

    @Test
    public void testSetDescription() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        testVideo.setDescription("Description2");

        assertEquals("Description2", testVideo.getDescription());

    }

    @Test
    public void testSetAppropriateness() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        testVideo.setAppropriateness("Appropriateness2");

        assertEquals("Appropriateness2", testVideo.getAppropriateness());

    }

    @Test
    public void testSetCategory() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        testVideo.setCategory("Category2");

        assertEquals("Category2", testVideo.getCategory());

    }

    @Test
    public void testSetProtagonists() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        testVideo.setProtagonists("Protagonists2");

        assertEquals("Protagonists2", testVideo.getProtagonists());

    }

    @Test
    public void testSetAverageRatingForSearch() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        testVideo.setAverageRatingForSearch(1.2f);

        assertEquals(1.2f, testVideo.getAverageRatingForSearch(), 0.0001);

    }

    @Test
    public void testFindAverageRating() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        testVideo.addAssessment("Name1","Text1",5,"1/1/2024");
        testVideo.addAssessment("Name2","Text2",4,"2/1/2024");

        assertEquals(4.5f, testVideo.findAverageRating(), 0.0001);

    }

    @Test
    public void testGetTitle() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        assertEquals(expectedTitle, testVideo.getTitle());

    }

    @Test
    public void testGetDescription() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        assertEquals(expectedDes, testVideo.getDescription());

    }

    @Test
    public void testGetAppropriateness() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        assertEquals(expectedAp, testVideo.getAppropriateness());

    }

    @Test
    public void testGetCategory() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        assertEquals(expectedCat, testVideo.getCategory());

    }

    @Test
    public void testGetProtagonists() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        assertEquals(expectedPro, testVideo.getProtagonists());

    }

    @Test
    public void testGetAverageRatingForSearch() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        testVideo.setAverageRatingForSearch(3.5f);

        assertEquals(3.5f, testVideo.getAverageRatingForSearch(), 0.0001);

    }

    @Test
    public void testGetAssessments() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        testVideo.addAssessment("Name1","Text1",5,"1/1/2024");
        testVideo.addAssessment("Name2","Text2",4,"2/1/2024");
        testVideo.addAssessment("Name3","Text3",3,"3/1/2024");

        assertEquals(3, testVideo.getAssessments().size());

    }

    @Test
    public void testAddAssessments() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        testVideo.addAssessment("Name1","Text1",5,"1/1/2024");

        assertEquals(1, testVideo.getAssessments().size());

    }

    @Test
    public void testSimilarVideos() {
        String expectedTitle = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,expectedDes,expectedAp,expectedCat,expectedPro);

        ArrayList<Video> test = testVideo.similarVideos();

        assertEquals(0, test.size());

    }

    @Test
    public void testReturnAllVideos() {

        FirstInitializationOfSeriesMovies test = new FirstInitializationOfSeriesMovies();

        ArrayList<Video> all = Video.returnAllVideos();

        assertEquals(10, all.size());

    }

    @Test
    public void testSearchVideoHelper() {
        String expectedTitle = "Title";
        String expectedPro = "Protagonists";

        Video testVideo = new Video(expectedTitle,null,null,null,expectedPro);

        String expectedTitle2 = "Title";
        String expectedDes = "Description";
        String expectedAp = "Appropriateness";
        String expectedCat = "Category";
        String expectedPro2 = "Protagonists";

        Video testVideo2 = new Video(expectedTitle2,expectedDes,expectedAp,expectedCat,expectedPro2);

        assertEquals(2, testVideo2.searchVideoHelper(testVideo,testVideo2));

    }

    @Test
    public void testSearchVideo() {

        //the objects we want to search for
        Video testVideo = new Video(null,null,null,"Comedy",null);

        Video testVideo2 = new Video("Barbie",null,null,null,null);

        FirstInitializationOfSeriesMovies temp = new FirstInitializationOfSeriesMovies();

        assertEquals(2, testVideo.searchVideo(testVideo).size());

        assertEquals(1, testVideo2.searchVideo(testVideo2).size());

    }

    @Test
    public void testEditingMovie() {

        //the objects we want to search for
        Video testVideo = new Video(null,null,null,"Comedy",null);

        Video testVideo2 = new Video("Barbie",null,null,null,null);

        FirstInitializationOfSeriesMovies temp = new FirstInitializationOfSeriesMovies();

        assertEquals(2, testVideo.searchVideo(testVideo).size());

        assertEquals(1, testVideo2.searchVideo(testVideo2).size());

    }

}
