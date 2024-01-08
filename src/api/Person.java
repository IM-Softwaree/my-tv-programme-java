package api;

/**
 * Class "Person" that represents a Person
 */

public class Person {
    private String password;
    private String username;

    /**
     * Default Constructor
     */
    public Person(){}

    /**
     * Constructor that takes has 2 arguments "username" and "password".
     * @param username which is the username of a Person
     * @param password which is the password of a Person
     */
    public Person(String username, String password){
        this.password = password;
        this.username = username;
    }

    /**
     * Function that returns the password of a Person.
     * @return "password" which is a String
     */
    public String getPassword(){
        return password;
    }

    /**
     * Function that changes the password of a Person and has 1 argument "password".
     * @param password which is a String
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * Function that returns the username of a Person.
     * @return username which is a String
     */
    public String getUserame(){
        return username;
    }

    /**
     * Function that changes the username of a Person and has 1 argument "username".
     * @param username which is a String
     */
    public void setUserame(String username){
        this.username = username;
    }

}
//