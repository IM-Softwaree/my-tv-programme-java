package api;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoginAPI {

    public LoginAPI(){
        //Initialization of files Movies.dat and Series.dat
        //FirstInitializationOfSeriesMovies in= new FirstInitializationOfSeriesMovies();

        String fileName = "Subscribers.txt"; // VLEPW AN TO ARXEIO YPARXEI KAI AN DEN TOTE TO DHMIOYRGW ALLIWS TO ANOIGW GIA EGRAFH H ANAGNWSH

        // Convert the file name to a Path object
        Path filePath = Paths.get(fileName);

        // Check if the file exists
        boolean fileExists = Files.exists(filePath);

        if (fileExists) {
            // PROSTHIKI XRHSTWN STO FILE "Subscribers.txt"
            FirstInitializationForAdminsSubscribers.addSubscriberViaCommandLine();
            System.out.println("File '" + fileName + "' exists.\n");
        } else {
            // 1H ARXIKOPOIHSH TWN ARXEIWN GIA TOUS SUBSCRIBERS TOUS ADMINS KAI TWN FAVOURITES
            FirstInitializationForAdminsSubscribers apiStart = new  FirstInitializationForAdminsSubscribers();

            // PROSTHIKI XRHSTWN STO FILE "Subscribers.txt"
            PersonAdderToFile fileWriter = new PersonAdderToFile();
            System.out.println("File '" + fileName + "' does not exist.\n");
        }
    }
}
