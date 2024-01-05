package api;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.*;

public class Serie extends Video {

    ArrayList<Season> seasons = new ArrayList<>();

    public Serie(){}

    public Serie(String t, String d, String a, String c, String p) {
        super(t, d, a, c, p);
    }

    public void setSeasons(Season ex) {
        seasons.add(ex);
    }

    public ArrayList<Season> getSeasons() {
        return this.seasons;
    }


    //NA ALLAXO TO ARXEIO STO KANONIKO STO TELOS!!!!!!!!!!!
    public boolean addSerieToFile(Serie ex) {
        boolean pass = true;

        ArrayList<Serie> series = new ArrayList<>();

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("SeriesTEST.dat"))) {

            //ta diabazo ola apo to binary file Series

            while (true) {  // repeat until end of file
                Serie temp = (Serie) oos.readObject();  //read obj

                series.add(temp);
            }

        } catch (EOFException end) {
            // System.out.println("Reached the end of file");

        } catch (IOException | ClassNotFoundException ee) {
            ee.printStackTrace();
        }

        for (Serie serie : series) {
            if (serie.getTitle().equals(ex.getTitle())) {
                pass = false;
            //    serie.setDescription(ex.getDescription());
            //    serie.setAppropriateness(ex.getAppropriateness());
            //    serie.setCategory(ex.getCategory());
            //    serie.setProtagonists(ex.getProtagonists());
            }
        }

        if (pass) {
            series.add(this);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SeriesTEST.dat"))) {
                for (Serie serie : series) {
                    oos.writeObject(serie);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return pass;
/**
         //!!!!!!!!!!!!!!!!!!
         try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("SeriesTEST.dat"))) {

         while (true) {  // repeat until end of file
         Serie temp = (Serie) oos.readObject();  //read obj

         System.out.println(temp.getTitle());

         for (Season season : temp.getSeasons()) {
         System.out.println(season.getNumber());
         for (Episode episode : season.getEpisodes()) {
         System.out.println(episode.getName());
         }
         }

         }
         } catch (EOFException end) {
         System.out.println("Reached the end of file");
         } catch (IOException | ClassNotFoundException ee) {
         ee.printStackTrace();
         }
*/
    }


    public boolean addSeasonToFile(String ex,Season f)
    {
        boolean pass = false;  //ipotheto oti i seira den iparxei

        ArrayList<Serie> series = new ArrayList<>();

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("SeriesTEST.dat"))) {

            //ta diabazo ola apo to binary file Series

            while (true) {  // repeat until end of file
                Serie temp = (Serie) oos.readObject();  //read obj

                series.add(temp);
            }

        } catch (EOFException end) {
            // System.out.println("Reached the end of file");

        } catch (IOException | ClassNotFoundException ee) {
            ee.printStackTrace();
        }


        for (Serie serie : series) {

            if(serie.getTitle().equals(ex))  //an i seira iparxei bale season k graxtin sto file
            {
                serie.setSeasons(f);
                pass=true;
            }
        }

        if(pass) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SeriesTEST.dat"))) {
                for (Serie serie : series) {
                    oos.writeObject(serie);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return pass;

/**
         //!!!!!!!!!!!!!!!!!!
         try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("SeriesTEST.dat"))) {

         while (true) {  // repeat until end of file
         Serie temp = (Serie) oos.readObject();  //read obj

         System.out.println(temp.getTitle());

         for (Season season : temp.getSeasons()) {
         System.out.println(season.getNumber());
         for (Episode episode : season.getEpisodes()) {
         System.out.println(episode.getName());
         }
         }

         }
         } catch (EOFException end) {
         System.out.println("Reached the end of file");
         } catch (IOException | ClassNotFoundException ee) {
         ee.printStackTrace();
         }
*/
    }

    public boolean addEpisodeToFile(String ex,int f,Episode m)
    {
        boolean pass = false;  //ipotheto oti i seira den iparxei

        ArrayList<Serie> series = new ArrayList<>();

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("SeriesTEST.dat"))) {

            //ta diabazo ola apo to binary file Series

            while (true) {  // repeat until end of file
                Serie temp = (Serie) oos.readObject();  //read obj

                series.add(temp);
            }

        } catch (EOFException end) {
            // System.out.println("Reached the end of file");

        } catch (IOException | ClassNotFoundException ee) {
            ee.printStackTrace();
        }

        for (Serie serie : series) {

            if(serie.getTitle().equals(ex))
            {
                for (Season season : serie.getSeasons()) {
                    if(season.getNumber()==f) {
                        season.setEpisodes(m);
                        pass=true;
                    }
                }
            }
        }

        if(pass) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SeriesTEST.dat"))) {
                for (Serie serie : series) {
                    oos.writeObject(serie);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


 //!!!!!!!!!!!!!!!!!!
 try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("SeriesTEST.dat"))) {

 while (true) {  // repeat until end of file
 Serie temp = (Serie) oos.readObject();  //read obj

 System.out.println(temp.getTitle());

 for (Season season : temp.getSeasons()) {
 System.out.println(season.getNumber());
 for (Episode episode : season.getEpisodes()) {
 System.out.println(episode.getName());
 }
 }

 }
 } catch (EOFException end) {
 System.out.println("Reached the end of file");
 } catch (IOException | ClassNotFoundException ee) {
 ee.printStackTrace();
 }


       return pass;
    }


}