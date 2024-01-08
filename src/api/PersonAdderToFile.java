package api;

import java.io.*;
import java.util.HashSet;

/**
 * This class is used to add Subscribers/Users to the file "Subscribers.txt" and also finds usernames so that there
 * are not used the usernames twice
 */
public class PersonAdderToFile {

    /**
     * Default constructor of class PersonAdderToFile
     */
    public PersonAdderToFile() {}

    /**
     * This function searches if a username already exists among admins and users/subscribers
     * Function getAdminSubscriberUsernames() is called to help us search among the already used usernames
     * @param username is the username that the user wants to put
     * @return false if the given username already exists and true if it does not
     */
    public static boolean findUsername(String username){
        HashSet<String> allUsernames = getAdminSubscriberUsernames(); // Static Method
        for (String tempUsername : allUsernames) {
            if (tempUsername.equals(username)){
                System.out.println("Username already exists");
                return false;
            }
        }
        return true;
    }

    /**
     * This function stores all the usernames of admins and users in a variable HashSet<String> "allUsernames" and returns them
     * The usernames are read from files "Admins.txt" and "Subscribers.txt"
     * @return allUsernames HashSet<String> in which are stored all the usernames
     */
    // SYNARTHSH POU DEXETAI 2 ONOMATA ARXEIEWN 1 GIA ADMINS KAI 1 GIA SUBSCRIBERS TA DIAVAZEI KAI EPISTREFEI ENA HASHMAP ME OLA TA USERNAME(ADMIN KAI SUBSCRIBER)
    public static HashSet<String> getAdminSubscriberUsernames() {

        HashSet<String> allUsernames = new HashSet<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader("Admins.txt"))) {
            String line = buffer.readLine();
            while (line != null) {
                // Split the line into words using whitespace as the delimiter
                String[] words = line.split("\\s+");
                allUsernames.add(words[0]);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader buffer = new BufferedReader(new FileReader("Subscribers.txt"))) {
            String line = buffer.readLine();
            while (line != null) {
                // Split the line into words using whitespace as the delimiter
                String[] words = line.split("\\s+");
                allUsernames.add(words[0]);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allUsernames;
    }

    /**
     * This function adds a user/subscribers to the file "Subscribers.txt"
     * @param userName the username of the user/subscribers
     * @param password the password of the user/subscribers
     * @param name the name of the user/subscribers
     * @param surName the surnaem of the user/subscribers
     */
    public static void addSubscriberViaForm(String userName,String password, String name, String surName){

        //File for Subscribers
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Subscribers.txt", true))) {

            // Write each line to the file
            writer.write(userName + " " + password + " " + name + " " + surName);
            writer.newLine(); // Add a new line

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
//

