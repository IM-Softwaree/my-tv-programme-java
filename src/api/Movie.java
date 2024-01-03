package api;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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


    //NA ALLAXO TO ARXEIO STO KANONIKO STO TELOS!!!!!!!!!!!
    public void addMovieToFile(Movie neo)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MoviesTEST.dat"))) {
            oos.writeObject(neo);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
