package api;

public class FirstInitializationForAdminsSubscribers {

    public FirstInitializationForAdminsSubscribers(){
        //Initialization of files Admins.txt and Subscribers.txt
        FileReaderForPersons fileReader = new FileReaderForPersons();

        //Send as a parameter the name of the file where you want to write
        PersonAdderToFile fileWriter = new PersonAdderToFile("Subscribers.txt");
    }
}
