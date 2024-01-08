package api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class represents the 'log in'
 */
public class LoginAPI {

    /**
     * Constructor of LoginAPI
     * This function calls function  FirstInitializationOfSeriesMovies() and the first initialization of files "Movies.dat", "Series.dat" and
     * also calls FirstInitializationForAdminsSubscribers() to initialize files "Subscribers.txt" and "Admins.txt"
     */
    public LoginAPI(){
        String fileName1 = "Movies.dat"; // VLEPW AN TO ARXEIO YPARXEI KAI AN DEN TOTE TO DHMIOYRGW ALLIWS TO ANOIGW GIA EGRAFH H ANAGNWSH

        // Convert the file name to a Path object
        Path filePath1 = Paths.get(fileName1);

        // Check if the file exists
        boolean fileExists1 = Files.exists(filePath1);

        if (fileExists1) {
            System.out.println("File Movies/Series' exists.\n");
        } else {
            // 1H ARXIKOPOIHSH TWN ARXEIWN GIA TOUS SUBSCRIBERS TOUS ADMINS KAI TWN FAVOURITES
            //Initialization of files Movies.dat and Series.dat
            FirstInitializationOfSeriesMovies in= new FirstInitializationOfSeriesMovies();
            System.out.println("File Movies/Series' does not exist.\n");
        }



        String fileName = "Subscribers.txt"; // VLEPW AN TO ARXEIO YPARXEI KAI AN DEN TOTE TO DHMIOYRGW ALLIWS TO ANOIGW GIA EGRAFH H ANAGNWSH

        // Convert the file name to a Path object
        Path filePath = Paths.get(fileName);

        // Check if the file exists
        boolean fileExists = Files.exists(filePath);

        if (fileExists) {
            System.out.println("File Subscribers/Admins' exists.\n");
        } else {
            // 1H ARXIKOPOIHSH TWN ARXEIWN GIA TOUS SUBSCRIBERS TOUS ADMINS KAI TWN FAVOURITES
            FirstInitializationForAdminsSubscribers apiStart = new  FirstInitializationForAdminsSubscribers();
            System.out.println("File Subscribers/Admins' does not exist.\n");
        }
    }

    /**
     *
     * @param tempStr
     * @param tempPassword
     * @return
     */
    public static char isAdminUserNothing(String tempStr, String tempPassword){
        if(isAdmin(tempStr, tempPassword)){
            return 'A';
        } else if(isUser(tempStr, tempPassword)){
            return 'U';
        }
        return 'N';
    }

    /**
     *
     * @param tempAdmin
     * @param tempPassword
     * @return
     */
    private static boolean isAdmin(String tempAdmin, String tempPassword){
        try (BufferedReader buffer = new BufferedReader(new FileReader("Admins.txt"))) {
            String line = buffer.readLine();
            while (line != null) {
                // Split the line into words using whitespace as the delimiter
                String[] words = line.split("\\s+");
                if(words[0].equals(tempAdmin) && words[1].equals(tempPassword)){  // Onoma admin
                    return true;
                }
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param tempUser
     * @param tempPassword
     * @return
     */
    private static boolean isUser(String tempUser, String tempPassword){
        try (BufferedReader buffer = new BufferedReader(new FileReader("Subscribers.txt"))) {
            String line = buffer.readLine();
            while (line != null) {
                // Split the line into words using whitespace as the delimiter
                String[] words = line.split("\\s+");
                if(words[0].equals(tempUser) && words[1].equals(tempPassword)){  // Onoma Subscriber
                    return true;
                }
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

