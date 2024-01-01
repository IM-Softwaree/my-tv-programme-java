/**
 * Το πρόγραμμά σας πρέπει να έχει μόνο μία main, η οποία πρέπει να είναι η παρακάτω.
 * <p>
 * <p>
 * ************* ΜΗ ΣΒΗΣΕΤΕ ΑΥΤΗ ΤΗΝ ΚΛΑΣΗ ************
 */

import api.*;

public class Main {
    public static void main(String[] args) {

        // ADD YOUR CODE HERE

        //Initialization of files Admins.txt and Subscribers.txt
        FileReaderForPersons fileReader = new FileReaderForPersons();

        /**
         //Send as a parameter the name of the file where you want to write
         PersonAdderToFile fileWriter = new PersonAdderToFile("Admins.txt", "Subscribers.txt");
         */

        //Initialization of files Movies.dat and Series.dat
        InitializationOfFiles in= new InitializationOfFiles();

    }
}
