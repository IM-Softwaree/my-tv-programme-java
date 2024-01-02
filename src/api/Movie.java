package api;

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

}
