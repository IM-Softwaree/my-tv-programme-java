package api;

import java.io.Serializable;

/**
 * Class that implements an episode of a season. An Episode consists of a name and a duration in minutes.
 */
public class Episode implements Serializable {

    String name;
    int duration;

    /**
     * Constructor of an Episode
     * @param n The name of the Episode
     * @param d The duration of the Episode
     */
    public Episode(String n,int d)
    {
        this.name=n;
        this.duration=d;
    }

    /**
     * Function that gets the name of the Episode
     * @return The name of the Episode
     */
    public String getName() {
        return name;
    }

    /**
     * Function that gets the duration of the Episode
     * @return The duration of the Episode
     */
    public int getDuration() {
        return duration;
    }

}
