package api;

import java.io.*;
import java.util.HashSet;

public class PersonAdderToFile {

    public PersonAdderToFile() {}

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

    // SYNARTHSH POU DEXETAI 2 ONOMATA ARXEIEWN 1 GIA ADMINS KAI 1 GIA SUBSCRIBERS TA DIAVAZEI KAI EPISTREFEI ENA HASHMAP ME OLA TA USERNAME(ADMIN KAI SUBSCRIBER)
    private static HashSet<String> getAdminSubscriberUsernames() {

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


