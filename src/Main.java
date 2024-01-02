/**
 * Το πρόγραμμά σας πρέπει να έχει μόνο μία main, η οποία πρέπει να είναι η παρακάτω.
 * <p>
 * <p>
 * ************* ΜΗ ΣΒΗΣΕΤΕ ΑΥΤΗ ΤΗΝ ΚΛΑΣΗ ************
 */

import api.*;

public class Main {
    public static void main(String[] args) {

        //Initialization of files Movies.dat and Series.dat
        InitializationOfSeriesMovies in= new InitializationOfSeriesMovies();

        FirstInitializationForAdminsSubscribers apiStart = new  FirstInitializationForAdminsSubscribers();

        /**
        Video MovieForSearch = new Video(null,null,null,null,null);
        MovieForSearch.setAverageRatingForSearch(5);

        Admin aaa =  new Admin("aaaa","eee");
        for (Video video : aaa.searchVideo(MovieForSearch)) {
            System.out.println(video.getTitle()+" "+video.getCategory());
        }
         */

    }
}
