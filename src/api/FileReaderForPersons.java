package api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class FileReaderForPersons {

    public FileReaderForPersons(){

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


        try (BufferedReader buffer = new BufferedReader(new FileReader("Admins.txt"))) {
            String line = buffer.readLine();
            int i = 0;
            while (line != null) {
                // Split the line into words using whitespace as the delimiter
                String[] words = line.split("\\s+");
                if(i < 2){
                    new Admin(words[0], words[1]);
                }
                else {
                    new Subscriber(words[0], words[1], words[2], words[3]);
                }
                i++;
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader buffer = new BufferedReader(new FileReader("Subscribers.txt"))) {
            String line = buffer.readLine();
            int i = 0;
            while (line != null) {
                // Split the line into words using whitespace as the delimiter
                String[] words = line.split("\\s+");
                if(i < 2){
                    new Admin(words[0], words[1]);
                }
                else {
                    new Subscriber(words[0], words[1], words[2], words[3]);
                }
                i++;
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
