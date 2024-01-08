package api;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that implements a season of a serie. A Season consists of a number, a year and a list of its episodes.
 */
public class Season implements Serializable {
    private int number;
    private int year;

    ArrayList<Episode> episodes = new ArrayList<>();

    /**
     * Constructor of a Season
     * @param n The number of the season
     * @param y The year of the season
     */
    public Season(int n, int y)
    {
        this.number=n;
        this.year=y;
    }

    /**
     * Function that sets the number of the Season
     * @param number The number of the season
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Function that sets the year of the Season
     * @param year The year of the season
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Function that adds a new episode to the list of the episodes of the Season
     * @param ex The new episode
     */
    public void setEpisodes(Episode ex) {
        episodes.add(ex);
    }

    /**
     * Function that gets the number of the Season
     * @return The number of the season
     */
    public int getNumber() {
        return number;
    }

    /**
     * Function that gets the year of the Season
     * @return The year of the season
     */
    public int getYear() {
        return year;
    }

    /**
     * Function that returns the list of episodes of the season
     * @return The list of episodes of the season
     */
    public ArrayList<Episode> getEpisodes() {
        return this.episodes;
    }
}
