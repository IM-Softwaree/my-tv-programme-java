/**
 * Το πρόγραμμά σας πρέπει να έχει μόνο μία main, η οποία πρέπει να είναι η παρακάτω.
 * <p>
 * <p>
 * ************* ΜΗ ΣΒΗΣΕΤΕ ΑΥΤΗ ΤΗΝ ΚΛΑΣΗ ************
 */

import api.*;

import api.FirstInitializationForAdminsSubscribers;

public class Main {
    public static void main(String[] args) {

        //Initialization of files Movies.dat and Series.dat
        InitializationOfFiles in= new InitializationOfFiles();

        FirstInitializationForAdminsSubscribers apiStart = new  FirstInitializationForAdminsSubscribers();

    }
}
