package api;

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



}
