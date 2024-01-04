package api;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.*;

public class Serie extends Video {

    ArrayList<Season> seasons = new ArrayList<>();

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
    public void addSerieToFile(Serie ex) {
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

        boolean pass = true;
        for (Serie serie : series) {
            if (serie.getTitle().equals(ex.getTitle())) {
                pass = false;
                serie.setDescription(ex.getDescription());
                serie.setAppropriateness(ex.getAppropriateness());
                serie.setCategory(ex.getCategory());
                serie.setProtagonists(ex.getProtagonists());
            }
        }

        if (pass == true)
            series.add(this);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SeriesTEST.dat"))) {
            for (Serie serie : series) {
                oos.writeObject(serie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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


    public void addSeasonToFile(Serie ex,Season f)
    {
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

        boolean pass=true;
        for (Serie serie : series) {
            if(serie.getTitle().equals(ex.getTitle()))
            {
                pass=false;
                serie.setDescription(ex.getDescription());
                serie.setAppropriateness(ex.getAppropriateness());
                serie.setCategory(ex.getCategory());
                serie.setProtagonists(ex.getProtagonists());

                serie.setSeasons(f);

                //episodes
            }
        }

        if(pass==true)
            series.add(this);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SeriesTEST.dat"))) {
            for (Serie serie : series) {
                oos.writeObject(serie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


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

    public void addEpisodeToFile(Serie ex,int f,Episode m)
    {
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

        boolean pass=true;
        for (Serie serie : series) {
            if(serie.getTitle().equals(ex.getTitle()))
            {
                pass=false;
                serie.setDescription(ex.getDescription());
                serie.setAppropriateness(ex.getAppropriateness());
                serie.setCategory(ex.getCategory());
                serie.setProtagonists(ex.getProtagonists());

                for (Season season : serie.getSeasons()) {
                    if(season.getNumber()==f)
                        season.setEpisodes(m);
                }

            }
        }

        if(pass==true)
            series.add(this);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SeriesTEST.dat"))) {
            for (Serie serie : series) {
                oos.writeObject(serie);
            }
        } catch (IOException e) {
            e.printStackTrace();
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


    }



}