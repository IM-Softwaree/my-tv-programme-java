package api;

import java.io.Serializable;

/**
 * Class that implements an assessment of a Video. An Assessment consists of the name of the subscriber, his comments
 * and rating of the movie/serie and also the date when he made the assessment.
 */
public class Assessment implements Serializable {

    private String username;
    private String text;
    private int rating;
    private String date;

    /**
     * Constructor of an Assessment
     * @param u The name of the subscriber making the assessment
     * @param t The comments of the subscriber making the assessment
     * @param r The rating given by the subscriber making the assessment
     * @param d The date when the subscriber made the assessment
     */
    public Assessment(String u,String t, int r, String d)
    {
        this.username = u;
        this.text = t;
        this.rating = r;
        this.date = d;
    }

    /**
     * Function that sets the name of the subscriber making the assessment
     * @param username The name of the subscriber making the assessment
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Function that sets the comments of the subscriber making the assessment
     * @param text The comments of the subscriber making the assessment
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Function that sets the rating given by the subscriber making the assessment
     * @param rating The rating given by the subscriber making the assessment
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Function that sets the date when the subscriber made the assessment
     * @param date The date when the subscriber made the assessment
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Function that gets the name of the subscriber making the assessment
     * @return The name of the subscriber making the assessment
     */
    public String getUsername() {
        return username;
    }

    /**
     * Function that gets the comments of the subscriber making the assessment
     * @return The comments of the subscriber making the assessment
     */
    public String getText() {
        return text;
    }

    /**
     * Function that gets the rating given by the subscriber making the assessment
     * @return The rating given by the subscriber making the assessment
     */
    public int getRating() {
        return rating;
    }

    /**
     * Function that sets the date when the subscriber made the assessment
     * @return The date when the subscriber made the assessment
     */
    public String getDate() {
        return date;
    }
}
//