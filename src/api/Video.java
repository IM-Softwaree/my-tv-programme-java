package api;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

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

    public ArrayList<Assessment> getAssessments()
    {
        return this.assessments;
    }

    /**
     * Function that adds a new assessment to the list of the assessments of the Video
     * @param username The name of the subscriber making the assessment
     * @param text The comments of the subscriber making the assessment
     * @param rating The rating given by the subscriber making the assessment
     * @param date The date when the subscriber made the assessment
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


    /**
     * Function that returns a list of all the movies and series from the files Movies.dat and Series.dat
     * @return the list of all the movies and series
     */
    public static ArrayList<Video> returnAllVideos()
    {
        ArrayList<Video> all = new ArrayList<>();

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Movies.dat"))) {
            while (true) {  // repeat until end of file
                Movie temp = (Movie) oos.readObject();  //read object
                all.add(temp);
            }
        } catch (EOFException end) {
            //Reached the end of file
        } catch (IOException | ClassNotFoundException ee) {
            ee.printStackTrace();
        }

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Series.dat"))) {
            while (true) {  // repeat until end of file
                Serie temp = (Serie) oos.readObject();  //read object
                all.add(temp);
            }
        } catch (EOFException end) {
            //Reached the end of file
        } catch (IOException | ClassNotFoundException ee) {
            ee.printStackTrace();
        }

        return all;
    }


    /**
     *Function used in the method searchVideo that compares two objects and returns the number of the criteria fulfilled
     * If the obj's fields for the title/protagonists/appropriateness/category are null or minimum average rating is -1,
     * means that they are not criteria for the search, and we do not take then into consideration. Othewise,
     * we make each string with capital letters for better results, and compare the counterpart fields of the two objects.
     * @param obj first object we want to compare
     * @param temp second object we want to compare
     * @return the number of the criteria fulfilled
     */
    public int searchVideoHelper(Video obj,Video temp)
    {
        int check=0;  //first assumption is that no criteria are fulfilled


        if(obj.getTitle()!=null && ((temp.getTitle()).toUpperCase()).contains((obj.getTitle()).toUpperCase()) )
        {
            check++;
        }
        if(obj.getProtagonists()!=null && ((temp.getProtagonists()).toUpperCase()).contains((obj.getProtagonists()).toUpperCase()) )
        {
            check++;
        }
        if(obj.getAppropriateness()!=null && ((temp.getAppropriateness()).toUpperCase()).contains((obj.getAppropriateness()).toUpperCase()) )
        {
            check++;
        }
        if(obj.getCategory()!=null && ((temp.getCategory()).toUpperCase()).contains((obj.getCategory()).toUpperCase()) )
        {
            check++;
        }
        if(obj.getAverageRatingForSearch()!=-1 && temp.findAverageRating() >= obj.getAverageRatingForSearch() )
        {
            check++;
        }

        return check;
    }


    /**
     *Function that searches for a Video. It uses a variable "criteria" to hold the number of the criteria used in the search
     * (title/protagonists/appropriateness/category/minimum average rating).
     * "check" is a variable that holds how many criteria are fulfilled each time, as we compare objects from the files with the given one.
     * If no criteria was defined, it returns all the movies and series we have at the binary files Movies.dat and Series.dat.
     * The function has a parameter Video obj. If we want to search for a movie, then we check if obj is an object of the class Movie,
     * if we want to search for a serie, we check if obj is an object from the class Serie. Otherwise, if obj is an object from class Video
     * that means we want to search for both movies and series.
     * @param obj the video we want to find
     * @return the list of the search results(all the movies/series that the function found)
     */
    public ArrayList<Video> searchVideo (Video obj)
    {
        ArrayList<Video> searchResults = new ArrayList<>();

        int criteria=0; //variable that keeps the number of the criteria used for the search
        int check=0;

        if(obj.getTitle()!=null)
            criteria++;
        if(obj.getProtagonists()!=null)
            criteria++;
        if(obj.getAppropriateness()!=null)
            criteria++;
        if(obj.getCategory()!=null)
            criteria++;
        if(obj.getAverageRatingForSearch()!=-1)
            criteria++;

        //return everything if criteria==0
        if (criteria==0)
        {
            ArrayList<Video> all = new ArrayList<>();

            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Movies.dat"))) {
                while (true) {  // repeat until end of file
                    Movie temp = (Movie) oos.readObject();  //read object
                    all.add(temp);
                }
            } catch (EOFException end) {
                //Reached the end of file
            } catch (IOException | ClassNotFoundException ee) {
                ee.printStackTrace();
            }

            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Series.dat"))) {
                while (true) {  // repeat until end of file
                    Serie temp = (Serie) oos.readObject();  //read object
                    all.add(temp);
                }
            } catch (EOFException end) {
                //Reached the end of file
            } catch (IOException | ClassNotFoundException ee) {
                ee.printStackTrace();
            }

            return all;
        }

        //if obj is a Video or a Movie
        if(!(obj instanceof Serie)) {
            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Movies.dat"))) {

                //read everything from the file Movies.dat

                while (true) {  // repeat until end of file
                    Movie temp = (Movie) oos.readObject();  //read obj

                    //compare the 2 objects
                    check = searchVideoHelper(obj, temp);

                    //if it is what we are looking for add it to the list of search results
                    if (check == criteria)
                        searchResults.add(temp);
                }

            } catch (EOFException end) {
                // Reached the end of file

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        //If the obj was a movie return the list of search results and do not continue below
        if(obj instanceof Movie)
        {
            return searchResults;
        }

        //if obj is a Video or a Serie, we must search and the binary file Series.dat
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Series.dat"))) {

            //read everything from the file Series.dat

            while(true) {  // repeat until end of file
                Serie temp = (Serie) oos.readObject();  //read object

                //compare the 2 objects
                check = searchVideoHelper(obj,temp);

                //if it is what we are looking for add it to the list of search results
                if(check==criteria)
                    searchResults.add(temp);
            }

        } catch (EOFException end) {
            //Reached the end of file

        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //If the obj was a Video or a serie return the list of search results
        return searchResults;

    }


    /**
     * Function that replaces an old video (movie/serie) from the files, with a new edited one
     * @param old the video (movie or serie) we edited and want to replace
     */
    public void editingMovie(Video old)
    {
        ArrayList<Video> all = new ArrayList<>();

        //read all the objects from the file Movies.dat or Series.dat
        if(old instanceof Movie) {
            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Movies.dat"))) {
                while (true) {  // repeat until end of file
                    Movie temp = (Movie) oos.readObject();  //read obj
                    all.add(temp);
                }
            } catch (EOFException end) {
                // Reached the end of file
            } catch (IOException | ClassNotFoundException ee) {
                ee.printStackTrace();
            }

        }
        else {
            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Series.dat"))) {
                while (true) {  // repeat until end of file
                    Serie temp = (Serie) oos.readObject();  //read obj
                    all.add(temp);
                }
            } catch (EOFException end) {
                //"Reached the end of file
            } catch (IOException | ClassNotFoundException ee) {
                ee.printStackTrace();
            }
        }

        //find the old video
        Iterator<Video> iterator = all.iterator();
        int i=0;
        while (iterator.hasNext()) {
            Video video = iterator.next();
            if (video.getTitle().equals(old.getTitle())) {
                iterator.remove(); //remove the old video
                all.add(i,this);     //add the new video
                break;             //end the loop
            }
            i++;
        }

        //write again all the objects to the file
        if(old instanceof Movie) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Movies.dat"))) {
                for (Video video : all) {
                    oos.writeObject(video);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Series.dat"))) {
                for (Video video : all) {
                    oos.writeObject(video);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}