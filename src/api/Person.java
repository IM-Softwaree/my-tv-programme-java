package api;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.util.ArrayList;

public class Person {

    private String password;
    private String username;

    public Person(String username, String password){
        this.password = password;
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUserame(){
        return username;
    }

    public void setUserame(String username){
        this.username = username;
    }






    public int searchVideoHelper(Video obj,Video temp)
    {
        int check=0;

        if(obj.getTitle()!=null && temp.getTitle().contains(obj.getTitle()) )  //to exei epilexei o xristis gia search k einai paromoia
        {
            check++;
        }
        if(obj.getProtagonists()!=null && temp.getProtagonists().contains(obj.getProtagonists()) )
        {
            check++;
        }
        if(obj.getAppropriateness()!=null && temp.getAppropriateness().equals(obj.getAppropriateness()) )
        {
            check++;
        }
        if(obj.getCategory()!=null && temp.getCategory().equals(obj.getCategory()) )
        {
            check++;
        }
        if(obj.getAverageRatingForSearch()!=-1 && temp.findAverageRating() >= obj.getAverageRatingForSearch() )
        {
            check++;
        }

        return check;
    }


    public ArrayList<Video> searchVideo (Video obj)
    {
        ArrayList<Video> searchResults = new ArrayList<>();
        int criteria=0;
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

        //return evrything an criteria==0
        if (criteria==0)
        {
            ArrayList<Video> all = new ArrayList<>();

            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("MoviesTEST.dat"))) {
                while (true) {  // repeat until end of file
                    Movie temp = (Movie) oos.readObject();  //read obj
                    all.add(temp);
                }
            } catch (EOFException end) {
                // System.out.println("Reached the end of file");
            } catch (IOException | ClassNotFoundException ee) {
                ee.printStackTrace();
            }

            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("SeriesTEST.dat"))) {
                while (true) {  // repeat until end of file
                    Serie temp = (Serie) oos.readObject();  //read obj
                    all.add(temp);
                }
            } catch (EOFException end) {
                // System.out.println("Reached the end of file");
            } catch (IOException | ClassNotFoundException ee) {
                ee.printStackTrace();
            }

            return all;
        }

            if(!(obj instanceof Serie)) {  //diladi einai Video h Movie
                try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Movies.dat"))) {

                    //ta diabazo apo to binary file Movies

                    while (true) {  // repeat until end of file
                        Video temp = (Video) oos.readObject();  //read obj

                        check = searchVideoHelper(obj, temp);

                        if (check == criteria)
                            searchResults.add(temp);
                    }

                } catch (EOFException end) {
                    System.out.println("Reached the end of file");

                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            if(obj instanceof Movie)
            {
                return searchResults;
            }

            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Series.dat"))) {

                //ta diabazo apo to binary file Series

                while(true) {  // repeat until end of file
                    Serie temp = (Serie) oos.readObject();  //read obj

                    check = searchVideoHelper(obj,temp);

                    if(check==criteria)
                        searchResults.add(temp);
                }

            } catch (EOFException end) {
                System.out.println("Reached the end of file");

            }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            return searchResults;

    }

}
