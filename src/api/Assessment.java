package api;

import java.io.Serializable;

public class Assessment implements Serializable {

    private String username;
    private String text;
    private int rating;
    private String date;

    public Assessment(String u,String t, int r, String d)
    {
        this.username = u;
        this.text = t;
        this.rating = r;
        this.date = d;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }

    public String getDate() {
        return date;
    }

}
