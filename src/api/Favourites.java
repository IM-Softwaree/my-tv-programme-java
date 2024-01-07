package api;
import java.io.*;
import java.util.ArrayList;

public class Favourites {
    public Favourites() {}

    public void addFavourite(String tempSubscriber, String tempFavourite) {
        findLineForUserAdd(tempSubscriber, tempFavourite);
    }

    public void deleteFavourite(String tempSubscriber, String tempFavourite) {
        findLineForUserDelete(tempSubscriber, tempFavourite);
    }

    public void findLineForUserAdd(String tempSubscriber, String tempFavourite){
        ArrayList<String> allLines = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader("Favourites.txt"))) {
            String line = buffer.readLine();
            while (line != null) {
                allLines.add(line);
                // Split the line into words using whitespace as the delimiter
                String[] words = line.split(",");
                if(tempSubscriber.equals(words[0])){
                    allLines.add(", " + tempFavourite);
                }
                line = buffer.readLine();
            }
            reWriteLines(allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findLineForUserDelete(String tempSubscriber, String tempFavourite){
        ArrayList<String> allLines = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader("Favourites.txt"))) {
            String line = buffer.readLine();
            while (line != null) {
                allLines.add(line);
                // Split the line into words using whitespace as the delimiter
                String[] words = line.split(",");
                if(tempSubscriber.equals(words[0])){
                    for (int i=1; i< words.length; i++){
                        if(!words[i].equals(tempFavourite)){
                            allLines.add(", " + tempFavourite);
                        }
                    }
                }
                line = buffer.readLine();
            }
            reWriteLines(allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void reWriteLines(ArrayList<String> newLinesToWrite){
        // New file for favourites
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Favourites.txt"))) {
            for(String newLine : newLinesToWrite){
                // Write each line to the file
                writer.write(newLine);
                writer.newLine(); // Add a new line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
