package api;
import java.io.*;
import java.util.ArrayList;

/**
 * Class that implements a Favourite list of Movies and Series.
 */
public class Favourites {

    /**
     * Default constructor
     */
    public Favourites() {}

    /**
     * This Function adds a favourite movie/series to the list of favourites of a user . To perform the add we call function "findLineForUserAdd()"
     * @param tempSubscriber the name of the user
     * @param tempFavourite the name of the movie/series to be added
     */
    public static void addFavourite(String tempSubscriber, String tempFavourite) {
        findLineForUserAdd(tempSubscriber, tempFavourite);
    }

    /**
     * This Function deletes a favourite movie/series to the list of favourites of a user . To perform the delete we call function "findLineForUserDelete()"
     * @param tempSubscriber the name of the user
     * @param tempFavourite the name of the movie/series to be added
     */
    public static void deleteFavourite(String tempSubscriber, String tempFavourite) {
        findLineForUserDelete(tempSubscriber, tempFavourite);
    }

    /**
     * This Function finds user's username from the file "Favourites.txt" and adds the name of the movie/series we want to add to the specific line using variable String "tempLine".
     * To complete the rewriting of the file so that the new line is added we call "reWriteLines(allLines)" .
     * @param tempSubscriber the name of the user
     * @param tempFavourite the name of the movie/series to be deleted
     */
    public static void findLineForUserAdd(String tempSubscriber, String tempFavourite){
        ArrayList<String> allLines = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader("Favourites.txt"))) {
            String line = buffer.readLine();
            while (line != null) {
                String tempLine = "";
                // Split the line into words using whitespace as the delimiter
                String[] words = line.split(" , ");
                if(tempSubscriber.equals(words[0])){
                    tempLine = words[0];
                    for (int i=1; i < words.length; i++){
                        if(!words[i].equals(tempFavourite)){
                            tempLine = tempLine + " , " + words[i];
                        }
                    }
                    tempLine = tempLine + " , " + tempFavourite;
                }
                else {
                    tempLine = words[0];
                    for (int i=1; i < words.length; i++){
                        tempLine = tempLine + " , " + words[i];
                    }
                }
                allLines.add(tempLine);
                line = buffer.readLine();
            }
            reWriteLines(allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This Function finds user's username from the file "Favourites.txt" and deletes the name of the movie/series we want to delete from the specific line using variable String "tempLine".
     * To complete the rewriting of the file so that the new line is deleted we call "reWriteLines(allLines)" .
     * @param tempSubscriber the name of the user
     * @param tempFavourite the name of the movie/series to be deleted
     */
    public static void findLineForUserDelete(String tempSubscriber, String tempFavourite){
        ArrayList<String> allLines = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader("Favourites.txt"))) {
            String line = buffer.readLine();
            while (line != null) {
                String tempLine = "";
                // Split the line into words using whitespace as the delimiter
                String[] words = line.split(" , ");
                if(tempSubscriber.equals(words[0])){
                    tempLine = words[0];
                    for (int i=1; i < words.length; i++){
                        if(!words[i].equals(tempFavourite)){
                            tempLine = tempLine + " , " + words[i];
                        }
                    }
                }
                else {
                    tempLine = words[0];
                    for (int i=1; i < words.length; i++){
                        tempLine = tempLine + " , " + words[i];
                    }
                }
                allLines.add(tempLine);
                line = buffer.readLine();
            }
            reWriteLines(allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This Function rewrites the file "Favourites.txt" so that the movie/series is deleted from it
     * @param newLinesToWrite is an ArrayList<String> which stores the lines of the new file we want to write to "Favourites.txt"
     */
    public static void reWriteLines(ArrayList<String> newLinesToWrite){
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

    /**
     * This Function returns the list of favourites which is stored in file "Favourites.txt"
     * @param userName the name of the user
     * @return result which is a String that contains the favourite series/movie of the user
     */
    public static String getFavourites(String userName) {
        String lineOfFavourites = "";
        try (BufferedReader buffer = new BufferedReader(new FileReader("Favourites.txt"))) {
            String line = buffer.readLine();
            while (line != null) {
                // Split the line into words using whitespace as the delimiter
                String[] words = line.split(" , ");
                if(userName.equals(words[0])){
                    lineOfFavourites = words[0];
                    for (int i = 1; i < words.length; i++){
                        lineOfFavourites = lineOfFavourites + " , " + words[i];
                    }
                }
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = lineOfFavourites.toString().trim(); // Remove trailing space
        return result;
    }
}
//