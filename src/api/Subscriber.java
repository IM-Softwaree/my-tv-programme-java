package api;

import java.util.ArrayList;

/**
 * Class "Subscriber" that represents a Subscriber/User and inherits fields class Person
 */
public class Subscriber extends Person {

    private String name;
    private String surname;
    private ArrayList<Video> favourites = new ArrayList<>();

    /**
     * Constructor that has 4 arguments. We use "super(username, password);" to call the constructor of Person.
     * @param username which is the username of subscriber
     * @param password which is the password of subscriber
     * @param name which is the name of subscriber
     * @param surname which is the surname of subscriber
     */
    public Subscriber(String username, String password, String name, String surname){
        super(username, password);
        this.name = name;
        this.surname = surname;
    }

    /**
     * Function that returns tha name of a subscriber
     * @return name which is a String
     */
    public String getName(){
        return name;
    }

    /**
     * Function that returns tha name of a subscriber
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Function that returns tha surname of a subscriber
     * @return "surname" which is a String
     */
    public String getSurname(){
        return surname;
    }

    /**
     * Function that changes the username of a Subscriber and has 1 argument "username"
     * @param username
     */
    public void setSurname(String username){
        this.surname = surname;
    }

    /**
     * Function that adds a favourite to the ArrayList<Video> of a Subscriber and has 1 argument "fav"
     * @param fav which is of type Video
     */
    public void addFavourite(Video fav)
    {
        this.favourites.add(fav);
    }

    /**
     * Function that returns tha favourites of a subscriber
     * @return "favourites" which is an ArrayList<Video> type
     */
    public ArrayList<Video> getFavourites()
    {
        return this.favourites;
    }
}
//