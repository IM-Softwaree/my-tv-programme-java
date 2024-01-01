package api;

import java.util.ArrayList;

public class Serie extends Video {

    ArrayList<Season> seasons = new ArrayList<>();

    public Serie(String t,String d,String a,String c,String p){
        super(t,d,a,c,p);
    };

    public ArrayList<Video> similarVideos(){
        ArrayList<Video> similarSeries = new ArrayList<>();
        return similarSeries;
    }

    public void setSeasons(Season ex){
        seasons.add(ex);
    }

    public ArrayList<Season> getSeasons(){
        return this.seasons;
    }

}