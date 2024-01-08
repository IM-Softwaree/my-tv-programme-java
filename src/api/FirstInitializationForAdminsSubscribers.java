package api;

import java.io.*;

/**
 * This class is used only once at the start to Initialize for First time and create the files  "Admins.txt" (will have 2 admins and 2 passwords for them),
 * "Subscribers.txt" (will have 2 subscribers and 2 passwords for them) and "Favourites.txt" (will have 2 usernames of subscribers and 2 favourite movies/series for each one of them)
 */

public class FirstInitializationForAdminsSubscribers {

    /**
     * This function is used for creation of three files "Subscribers.txt", "Admins.txt" and "Favourites.txt" and writes to them initial data (2 admins, 2 users and 2 favourites for each user)
     */

    // KENOS CONSTRUCTOR POU KALEITE THN 1H FORA GIA ARXIKOPOIHSH
    public FirstInitializationForAdminsSubscribers() {

        //Initialization of files Admins.txt and Subscribers.txt

        //File for Admins
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Admins.txt"))) {
            // Write each line to the file
            writer.write("admin1 password1");
            writer.newLine(); // Add a new line

            writer.write("admin2 password2");
            writer.newLine(); // Add a new line
        } catch (IOException e) {
            e.printStackTrace();
        }

        //File for Subscribers
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Subscribers.txt"))) {

            // Write each line to the file
            writer.write("user1 password1 name1 surname1");
            writer.newLine(); // Add a new line

            writer.write("user2 password2 name2 surname2");
            writer.newLine(); // Add a new line

        } catch (IOException e) {
            e.printStackTrace();
        }

        // EDW DHMIOYRGW ENA FILE "Favourites.txt" KAI VAZW MESA TYXAIA FAVOURITE GIA TOUS 2 USERS (OI GRAMMES TOU FILE "Subscribers.txt" ANTISTOIXOUN ME TIS GRAMMES TOU FILE "Favourites.txt")
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Favourites.txt"))) {

            // Write each line to the file
            writer.write("user1 , Barbie , Alice in Borderland");
            writer.newLine(); // Add a new line

            writer.write("user2 , Inception , Monk");
            writer.newLine(); // Add a new line

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
//