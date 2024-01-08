package api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class represents the 'log in' and is used to First initialize the files
 */
public class LoginAPI {

    /**
     * Constructor of LoginAPI
     * This function checks if it is the FIRST TIME we run the programme and if is it
     * calls function  FirstInitializationOfSeriesMovies() and the first initialization of files "Movies.dat", "Series.dat" and
     * also calls FirstInitializationForAdminsSubscribers() to initialize files "Subscribers.txt" and "Admins.txt".
     * If not it prints the message "File Movies/Series' exists." and does not reinitialize the files
     */
    public LoginAPI(){
        String fileName1 = "Movies.dat"; // VLEPW AN TO ARXEIO YPARXEI KAI AN DEN TOTE TO DHMIOYRGW ALLIWS TO ANOIGW GIA EGRAFH H ANAGNWSH

        // Convert the file name to a Path object
        Path filePath1 = Paths.get(fileName1);

        // Check if the file exists
        boolean fileExists1 = Files.exists(filePath1);

        if (fileExists1) {
            System.out.println("File Movies/Series' exists.");
        } else {
            // 1H ARXIKOPOIHSH TWN ARXEIWN GIA TOUS SUBSCRIBERS TOUS ADMINS KAI TWN FAVOURITES
            //Initialization of files Movies.dat and Series.dat
            FirstInitializationOfSeriesMovies in= new FirstInitializationOfSeriesMovies();
            System.out.println("File Movies/Series' does not exist.");
        }



        String fileName = "Subscribers.txt"; // VLEPW AN TO ARXEIO YPARXEI KAI AN DEN TOTE TO DHMIOYRGW ALLIWS TO ANOIGW GIA EGRAFH H ANAGNWSH

        // Convert the file name to a Path object
        Path filePath = Paths.get(fileName);

        // Check if the file exists
        boolean fileExists = Files.exists(filePath);

        if (fileExists) {
            System.out.println("File Subscribers/Admins' exists.");
        } else {
            // 1H ARXIKOPOIHSH TWN ARXEIWN GIA TOUS SUBSCRIBERS TOUS ADMINS KAI TWN FAVOURITES
            FirstInitializationForAdminsSubscribers apiStart = new  FirstInitializationForAdminsSubscribers();
            System.out.println("File Subscribers/Admins' does not exist.");
        }
    }

    /**
     * This Function has 2 arguments type String and calls functions isAdmin() and isUser to see what type of person this is
     * @param tempStr
     * @param tempPassword
     * @return a char that represents if he is a user 'U', an Admin ''
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
     * This Function checks if the person who tries to log in as admin gave correct username and password by reading the file "Admins.txt"
     * @param tempAdmin is the username of the person who tries to log in as admin
     * @param tempPassword is the password of the person who tries to log in as admin
     * @return true if his username and password are found in the file (he is an admin), false if not
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
     * This Function checks if the person who tries to log in as subscriber gave correct username and password by reading the file "Subscribers.txt"
     * @param tempUser is the username of the person who tries to log in as user
     * @param tempPassword is the password of the person who tries to log in as user
     * @return true if his username and password are found in the file (he is a user), false if not
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

