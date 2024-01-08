package api;

/**
 * Class "Admin" that represents an Admin and inherits fields class Person
 */
public class Admin extends Person {
    /**
     * Constructor that has two arguments. We use "super(username, password);" to call the constructor of Person.
     * @param username which is the username of admin
     * @param password which is the password of admin
     */
    public Admin(String username, String password)
    {
        super(username, password);
    }

}