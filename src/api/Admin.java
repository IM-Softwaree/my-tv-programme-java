package api;

/**
 * Class "Admin" that represents an Admin that extends class Person
 */
public class Admin extends Person {
    /**
     * Constructor that has two arguments
     * @param username which is the username of admin
     * @param password which is the password of admin
     * We use "super(username, password);" to call the constructor of Person
     */
    public Admin(String username, String password)
    {
        super(username, password);
    }

}