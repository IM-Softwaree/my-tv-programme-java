package api;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that implements a video. A Video consists of a title, a description, an appropriateness level, a category,
 * the protagonists and a list of its assessments.
 */
public class Video implements Serializable {

    private String title;
    private String description;
    private String appropriateness;
    private String category;
    private String protagonists;

    private ArrayList<Assessment> assessments = new ArrayList<>();
    private float averageRatingForSearch; //Field used only for search purposes

    /**
     * Empty constructor
     */
    public Video(){}

    /**
     *Constructor of a Video
     * @param t The title of the Video
     * @param d The description of the Video
     * @param a The appropriateness level of the Video
     * @param c The category of the Video
     * @param p The protagonists of the Video
     */
    public Video(String t,String d,String a,String c,String p){
        this.title=t;
        this.description=d;
        this.appropriateness=a;
        this.category=c;
        this.protagonists =p;
    }

    /**
     * Function that sets the title of the Video
     * @param x The title of the Video
     */
    public void setTitle(String x)
    {
        this.title=x;
    }

    /**
     * Function that sets the description of the Video
     * @param x The description of the Video
     */
    public void setDescription(String x)
    {
        this.description=x;
    }

    /**
     * Function that sets the appropriateness of the Video
     * @param x The appropriateness of the Video
     */
    public void setAppropriateness(String x)
    {
        this.appropriateness=x;
    }

    /**
     * Function that sets the category of the Video
     * @param x The category of the Video
     */
    public void setCategory(String x)
    {
        this.category=x;
    }

    /**
     * Function that sets the protagonists of the Video
     * @param x The protagonists of the Video
     */
    public void setProtagonists(String x)
    {
        this.protagonists=x;
    }

    /**
     * Function that sets the average rating for search purposes of the Video
     * @param x The average rating for search of the Video
     */
    public void setAverageRatingForSearch(float x)
    {
        this.averageRatingForSearch=x;
    }

    /**
     * Function that finds the true average rating of the Video
     * @return the average rating of the Video
     */
    public float findAverageRating()
    {
        int sum=0;
        for (Assessment assessment : assessments) {
            sum += assessment.getRating();
        }
        return (float) sum/ assessments.size();
    }

    /**
     * Function that gets the title of the Video
     * @return the title of the Video
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Function that gets the description of the Video
     * @return the description of the Video
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Function that gets the appropriateness of the Video
     * @return the appropriateness of the Video
     */
    public String getAppropriateness(){
        return this.appropriateness;
    }

    /**
     * Function that gets the category of the Video
     * @return the category of the Video
     */
    public String getCategory(){
        return this.category;
    }

    /**
     * Function that gets the protagonists of the Video
     * @return the protagonists of the Video
     */
    public String getProtagonists(){
        return this.protagonists;
    }

    /**
     * Function that gets the average rating for search purposes of the Video
     * @return the protagonists of the Video
     */
    public float getAverageRatingForSearch()
    {
        return this.averageRatingForSearch;
    }

    /**
     * Function that adds a new assessment to the list of the assessments of the Video
     * @param username The name of the subscriber making the assessment
     * @param text The comments of the subscriber making the assessment
     * @param rating The rating given by the subscriber making the assessment
     * @param date The date when the subscriber makde the assessment
     */
    public void addAssessment(String username,String text, int rating, String date)
    {
        Assessment temp = new Assessment(username,text,rating,date);
        this.assessments.add(temp);
    }

    /**
     * Function that returns a list of similar Videos
     * @return a list of similar Videos
     */
    public ArrayList<Video> similarVideos()
    {
        ArrayList<Video> similar = new ArrayList<>();
        return similar;
    }

}