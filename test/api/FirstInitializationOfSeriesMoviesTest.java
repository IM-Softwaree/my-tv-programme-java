package api;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;


public class FirstInitializationOfSeriesMoviesTest {

    @Test
    public void testConstructor() {

        FirstInitializationOfSeriesMovies test = new FirstInitializationOfSeriesMovies();

        //check if the files were created

        assertEquals(true, new File("Movies.dat").exists());
        assertEquals(true, new File("Series.dat").exists());

    }

}
