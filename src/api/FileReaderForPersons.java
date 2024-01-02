package api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashSet;
public class FileReaderForPersons {

    // KENOS CONSTRUCTOR POU KALEITE THN 1H FORA GIA ARXIKOPOIHSH
    public FileReaderForPersons() {

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
    }

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
}
