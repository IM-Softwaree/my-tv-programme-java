package api;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstInitializationForAdminsSubscribers {


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

