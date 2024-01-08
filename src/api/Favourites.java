package api;
import java.io.*;
import java.util.ArrayList;

/**
 *
 */
public class Favourites {

    /**
     *
     */
    public Favourites() {}

    /**
     *
     * @param tempSubscriber
     * @param tempFavourite
     */
    public static void addFavourite(String tempSubscriber, String tempFavourite) {
        findLineForUserAdd(tempSubscriber, tempFavourite);
    }

    /**
     *
     * @param tempSubscriber
     * @param tempFavourite
     */
    public static void deleteFavourite(String tempSubscriber, String tempFavourite) {
        findLineForUserDelete(tempSubscriber, tempFavourite);
    }

    /**
     *
     * @param tempSubscriber
     * @param tempFavourite
     */
    private static void findLineForUserAdd(String tempSubscriber, String tempFavourite){
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
     *
     * @param tempSubscriber
     * @param tempFavourite
     */
    private static void findLineForUserDelete(String tempSubscriber, String tempFavourite){
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
     *
     * @param newLinesToWrite
     */
    private static void reWriteLines(ArrayList<String> newLinesToWrite){
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
     *
     * @param userName
     * @return
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
