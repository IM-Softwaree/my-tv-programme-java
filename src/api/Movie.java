package api;


import java.io.*;
import java.util.ArrayList;

public class Movie extends Video
{
    private int yearOfFirstAppearance;
    private int movieDuration;

    public Movie(String t,String d,String a,String c,String p,int y, int m){
        super(t,d,a,c,p);
        this.yearOfFirstAppearance=y;
        this.movieDuration=m;
    };

    public void setYearOfFirstAppearance(int x)
    {
        this.yearOfFirstAppearance=x;
    }
    public void setMovieDuration(int x)
    {
        this.movieDuration=x;
    }

    public int getYearOfFirstAppearance()
    {
        return this.yearOfFirstAppearance;
    }
    public int getMovieDuration()
    {
        return this.movieDuration;
    }

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
