package api;

import java.io.Serializable;

public class Episode implements Serializable {

    String name;
    int duration;
    public Episode(String n,int d)
    {
        this.name=n;
        this.duration=d;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

}
