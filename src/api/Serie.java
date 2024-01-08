package api;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.*;

/**
 * Class that implements a serie. It inherits fields and functions from the class Video. As additional fields has
 * a list of its seasons.
 */
public class Serie extends Video {

    ArrayList<Season> seasons = new ArrayList<>();

    /**
     * Empty constructor
     */
    public Serie(){}

    /**
     * Constructor of a Serie with a call to the constructor of the superclass Video
     * @param t The title of the Serie
     * @param d The description of the Serie
     * @param a The appropriateness level of the Serie
     * @param c The category of the Serie
     * @param p The protagonists of the Serie
     */
    public Serie(String t, String d, String a, String c, String p) {
        super(t, d, a, c, p);
    }

    /**
     * Function that adds a new season to the list of seasons of the serie
     * @param ex The new season we want to add
     */
    public void setSeasons(Season ex) {
        seasons.add(ex);
    }

    /**
     * Function that returns the list of seasons of the serie
     * @return The list of seasons of the serie
     */
    public ArrayList<Season> getSeasons() {
        return this.seasons;
    }

    /**
     * Function that appends an object Serie to the binary file Serie.dat. It returns true if the appending was
     * successful and false if it was not, meaning that another object Serie with the same title already existed in the file.
     * In order to append, it firstly reads all the objects from the file and saves them in an Arraylist<Serie> called
     * series. Then it checks each serie title, to see if it is equal to the new serie we want to add. If the serie does
     * not exist, we can add it to the list of series and then write the list to our file.
     * @param ex The new serie we want to add
     * @return True if the serie did not already exist and was added to the file and false otherwise
     */
    public boolean addSerieToFile(Serie ex) {

        boolean pass = true; //first assumption is that the serie does not already exist

        ArrayList<Serie> series = new ArrayList<>();

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Series.dat"))) {

            while (true) {  // repeat until end of file
                Serie temp = (Serie) oos.readObject();  //read object

                series.add(temp);
            }
        } catch (EOFException end) {
            //Reached the end of file

        } catch (IOException | ClassNotFoundException ee) {
            ee.printStackTrace();
        }

        //Check all the series to see if the new serie already exists
        for (Serie serie : series) {
            if ((serie.getTitle().toUpperCase()).equals(ex.getTitle().toUpperCase())) {
                pass = false;
            }
        }

        //If the serie did not exist, then add it
        if (pass) {
            series.add(this);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Series.dat"))) {
                for (Serie serie : series) {
                    oos.writeObject(serie);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return pass;

    }

    /**
     * Function that adds a new season to an existing serie and then writes the altered object Serie back to the binary file Serie.dat.
     * It returns true if the appending was successful and false if it was not, meaning that no object Serie with the same title existed in the file.
     * It firstly reads all the objects from the file and saves them in an Arraylist<Serie> called series.
     * Then it checks each serie title, to see if it is equal to the serie title we want to add the new season.
     * If the serie existed, and we added the new season, then write the list of series back to our file.
     * @param ex The name of the serie we want to add a new season
     * @param f The new object Season we want to add
     * @return True if the serie existed, and we added the season and false otherwise
     */
    public boolean addSeasonToFile(String ex,Season f)
    {
        boolean pass = false;  //first assumption is that the serie does not already exist

        ArrayList<Serie> series = new ArrayList<>();

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Series.dat"))) {

            while (true) {  // repeat until end of file
                Serie temp = (Serie) oos.readObject();  //read object

                series.add(temp);
            }
        } catch (EOFException end) {
            //Reached the end of file

        } catch (IOException | ClassNotFoundException ee) {
            ee.printStackTrace();
        }

        //Check all the series to see if the serie already exists, and if it does add the new season
        for (Serie serie : series) {

            if(((serie.getTitle()).toUpperCase()).equals(ex.toUpperCase()))
            {
                serie.setSeasons(f);
                pass=true;
            }
        }

        //If the serie existed, and we added the new season then write all the series back to the file
        if(pass) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Series.dat"))) {
                for (Serie serie : series) {
                    oos.writeObject(serie);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return pass;

    }

    /**
     * Function that adds a new episode to a season of an existing serie and then writes the altered object Serie back to the binary file Serie.dat.
     * It returns true if the appending was successful and false if it was not, meaning that no object
     * Serie with the same title or Season with the same number existed in the file.
     * It firstly reads all the objects from the file and saves them in an Arraylist<Serie> called series.
     * Then it checks each serie title and each season number, to see if it is equal to the serie title and the
     * season number we want to add the new episode.
     * If the serie existed, and we added the new episode, then write the list of series back to our file.
     * @param ex The name of the serie we want to add a new episode
     * @param f The number of the season we want to add a new episode
     * @param m The new object Episode we want to add
     * @return True if the serie existed, and we added the episode and false otherwise
     */
    public boolean addEpisodeToFile(String ex,int f,Episode m)
    {
        boolean pass = false;   //first assumption is that the serie does not already exist

        ArrayList<Serie> series = new ArrayList<>();

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Series.dat"))) {

            while (true) {  // repeat until end of file
                Serie temp = (Serie) oos.readObject();  //read object

                series.add(temp);
            }

        } catch (EOFException end) {
            //Reached the end of file

        } catch (IOException | ClassNotFoundException ee) {
            ee.printStackTrace();
        }

        //Check all the series to see if the serie and the season number already exists, and if it does add the new season
        for (Serie serie : series) {

            if((serie.getTitle().toUpperCase()).equals(ex.toUpperCase()))
            {
                for (Season season : serie.getSeasons()) {
                    if(season.getNumber()==f) {
                        season.setEpisodes(m);
                        pass=true;
                    }
                }
            }
        }

        //If the serie existed, and we added the new episode then write all the series back to the file
        if(pass) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Series.dat"))) {
                for (Serie serie : series) {
                    oos.writeObject(serie);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

       return pass;
    }

}
//