package api;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.util.ArrayList;

public class Person {

    private String password;
    private String username;

    public Person(){}

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
