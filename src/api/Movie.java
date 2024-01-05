package api;

import java.io.*;
import java.util.ArrayList;

/**
 * Class that implements a movie. It inherits fields and functions from the class Video. As additional fields has
 * the year of its first appearance and its duration in minutes.
 */
public class Movie extends Video
{
    private int yearOfFirstAppearance;
    private int movieDuration;

    /**
     * Constructor of a Movie with a call to the constructor of the superclass Video
     * @param t The title of the Movie
     * @param d The description of the Movie
     * @param a The appropriateness level of the Movie
     * @param c The category of the Movie
     * @param p The protagonists of the Movie
     * @param y The year of first appearance of the Movie
     * @param m The duration in minutes of the Movie
     */
    public Movie(String t,String d,String a,String c,String p,int y, int m){
        super(t,d,a,c,p);
        this.yearOfFirstAppearance=y;
        this.movieDuration=m;
    };

    /**
     * Function that sets the year of first appearance of the Movie
     * @param x The year of first appearance of the Movie
     */
    public void setYearOfFirstAppearance(int x)
    {
        this.yearOfFirstAppearance=x;
    }

    /**
     * Function that sets the duration in minutes of the Movie
     * @param x The duration in minutes of the Movie
     */
    public void setMovieDuration(int x)
    {
        this.movieDuration=x;
    }

    /**
     * Function that gets the year of first appearance of the Movie
     * @return The year of first appearance of the Movie
     */
    public int getYearOfFirstAppearance()
    {
        return this.yearOfFirstAppearance;
    }

    /**
     * Function that gets the duration in minutes of the Movie
     * @return The duration in minutes of the Movie
     */
    public int getMovieDuration()
    {
        return this.movieDuration;
    }

    /**
     * Function that appends an object Movie to the binary file Movies.dat. It returns true if the appending was
     * successful and false if it was not, meaning that another object Movie with the same title already existed in the file.
     *
     * @return
     */
    public boolean addMovieToFile()
    {
        boolean result=true;  //theoro oti i tainia den iparxei

        ArrayList<Movie> movies = new ArrayList<>();

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Movies.dat"))) {

            //ta diabazo ola apo to binary file Series

            while (true) {  // repeat until end of file
                Movie temp = (Movie) oos.readObject();  //read obj

                movies.add(temp);
            }

        } catch (EOFException end) {
            // System.out.println("Reached the end of file");

        } catch (IOException | ClassNotFoundException ee) {
            ee.printStackTrace();
        }

        for (Movie movie : movies) {
            if((movie.getTitle()).toUpperCase().equals((this.getTitle()).toUpperCase()))  //an i tainia iparxei min kaneis tpt
                result=false;
        }

        if(result==true)  //an den iparxei balti
        {
            movies.add(this);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Movies.dat"))) {
                for (Movie movie : movies) {
                    oos.writeObject(movie);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
        /**
        //!!!!!!!!!!!!!!!!!!TEST
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Movies.dat"))) {

            while (true) {  // repeat until end of file
                Movie temp = (Movie) oos.readObject();  //read obj

                System.out.println(temp.getTitle());

            }
        } catch (EOFException end) {
            System.out.println("Reached the end of file");
        } catch (IOException | ClassNotFoundException ee) {
            ee.printStackTrace();
        }
         */

    }

}
