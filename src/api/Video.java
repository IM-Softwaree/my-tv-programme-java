package api;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Video implements Serializable {

    private String title;
    private String description;
    private String appropriateness;
    private String category;
    private String protagonists;

    private ArrayList<Assessment> assessments = new ArrayList<>();

    public Video(){}
    public Video(String t,String d,String a,String c,String p){
        this.title=t;
        this.description=d;
        this.appropriateness=a;
        this.category=c;
        this.protagonists =p;
    }

    public void setTitle(String x)
    {
        this.title=x;
    }
    public void setDescription(String x)
    {
        this.description=x;
    }
    public void setAppropriateness(String x)
    {
        this.appropriateness=x;
    }
    public void setCategory(String x)
    {
        this.category=x;
    }
    public void setProtagonists(String x)
    {
        this.protagonists=x;
    }


    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public String getAppropriateness(){
        return this.appropriateness;
    }

    public String getCategory(){
        return this.category;
    }

    public String getProtagonists(){
        return this.protagonists;
    }

    public void addAssessment(String username,String text, int rating, String date)
    {
        Assessment temp = new Assessment(username,text,rating,date);
        this.assessments.add(temp);
    }

    public abstract ArrayList<Video> similarVideos();

}