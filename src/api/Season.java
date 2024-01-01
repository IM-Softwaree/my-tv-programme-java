package api;

import java.io.Serializable;
import java.util.ArrayList;

public class Season implements Serializable {
    private int number;
    private int year;

    ArrayList<Episode> episodes = new ArrayList<>();

    public Season(int n, int y)
    {
        this.number=n;
        this.year=y;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setEpisodes(Episode ex) {
        episodes.add(ex);
    }

    public int getNumber() {
        return number;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<Episode> getEpisodes() {
        return this.episodes;
    }
}
