package api;

public class Subscriber extends Person {

    private String name;
    private String surname;

    public Subscriber(String username, String password, String name, String surname){
        super(username, password);
        this.name = name;
        this.surname = surname;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String username){
        this.surname = surname;
    }

}
