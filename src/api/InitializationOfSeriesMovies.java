package api;

import java.io.*;

public class InitializationOfSeriesMovies {
    public InitializationOfSeriesMovies()
    {
        Subscriber subscriber1 = new Subscriber("user1", "password1", "name1", "surname1");
        Subscriber subscriber2 = new Subscriber("user2", "password2", "name2", "surname2");

        //ARXIKOPOISI ARXEIOU MOVIES
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MoviesTEST.dat"))) {

            //ftiaxno antikeimena Movie
            Movie a = new Movie("Barbie","Barbie suffers a crisis that leads her to question her world and her existence.","PG-13","Comedy","Margot Robbie,Ryan Gosling",2023,114);
            a.addAssessment("name1","Amazing!",5,"3/10/2023");
            a.addAssessment("name2","Boring...",2,"15/11/2023");

            Movie b = new Movie("The Godfather","Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael, unintentionally putting the lives of his loved ones in great danger.","R","Drama","Marlon Brando,Al Pacino",1972,175);
            b.addAssessment("name1","Love it",5,"1/4/1973");
            b.addAssessment("name2","Fantastic",5,"5/8/1973");

            Movie c = new Movie("Inception","A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.","PG-13","Sci-Fi","Leonardo DiCaprio,Elliot Page",2010,148);
            c.addAssessment("name1","Beautiful!!!",4,"20/12/2010");
            c.addAssessment("name2","Mind-blowing!LOVE IT",5,"10/1/2012");

            Movie d = new Movie("The Silence of the Lambs","A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.","R","Thriller","Jodie Foster,Anthony Hopkins",1991,118);
            d.addAssessment("name1","Would not recommend it",2,"4/5/1995");
            d.addAssessment("name2","Very bad.. did not like it",1,"18/7/1999");

            Movie e = new Movie("Gladiator","A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.","R","Action","Russell Crowe,Joaquin Phoenix",2000,155);
            e.addAssessment("name1","Mediocre",3,"2/10/2000");
            e.addAssessment("name2","Okay...",2,"7/9/2001");

            subscriber1.addFavourite(a);
            subscriber2.addFavourite(b);

            //ta grafo sto binary file Movies
            oos.writeObject(a);
            oos.writeObject(b);
            oos.writeObject(c);
            oos.writeObject(d);
            oos.writeObject(e);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //ARXIKOPOISI ARXEIOU SERIES
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SeriesTEST.dat"))) {

            //ftiaxno antikeimena Serie Season k Episode
            Serie a = new Serie("Mindhunter","In the late 1970s, two FBI agents broaden the realm of criminal science by investigating the psychology behind murder and end up getting too close to real-life monsters.","TV-MA","Drama","Jonathan Groff,Anna Torv");
            a.addAssessment("name1","I AM IN LOVE!! KEEP GOING",5,"15/10/2023");
            a.addAssessment("name2","Nice job",5,"27/12/2023");

            Season a_1 = new Season(1,2017);
            Episode one = new Episode("Episode 1",60);
            a_1.setEpisodes(one);
            Episode two = new Episode("Episode 2",56);
            a_1.setEpisodes(two);
            Episode three = new Episode("Episode 3",45);
            a_1.setEpisodes(three);
            Episode four = new Episode("Episode 4",54);
            a_1.setEpisodes(four);
            Episode five = new Episode("Episode 5",42);
            a_1.setEpisodes(five);
            Episode six = new Episode("Episode 6",34);
            a_1.setEpisodes(six);
            Episode seven = new Episode("Episode 7",53);
            a_1.setEpisodes(seven);
            Episode eight = new Episode("Episode 8",54);
            a_1.setEpisodes(eight);
            Episode nine = new Episode("Episode 9",48);
            a_1.setEpisodes(nine);
            Episode ten = new Episode("Episode 10",53);
            a_1.setEpisodes(ten);
            a.setSeasons(a_1);

            Season a_2 = new Season(2,2019);
            Episode one2 = new Episode("Episode 1",48);
            a_2.setEpisodes(one2);
            Episode two2 = new Episode("Episode 2",47);
            a_2.setEpisodes(two2);
            Episode three2 = new Episode("Episode 3",60);
            a_2.setEpisodes(three2);
            Episode four2 = new Episode("Episode 4",51);
            a_2.setEpisodes(four2);
            Episode five2 = new Episode("Episode 5",72);
            a_2.setEpisodes(five2);
            Episode six2 = new Episode("Episode 6",59);
            a_2.setEpisodes(six2);
            Episode seven2 = new Episode("Episode 7",58);
            a_2.setEpisodes(seven2);
            Episode eight2 = new Episode("Episode 8",53);
            a_2.setEpisodes(eight2);
            Episode nine2 = new Episode("Episode 9",74);
            a_2.setEpisodes(nine2);
            a.setSeasons(a_2);

            Serie b = new Serie("Alice in Borderland","Obsessed gamer Arisu suddenly finds himself in a strange, emptied-out version of Tokyo in which he and his friends must compete in dangerous games in order to survive.","TV-MA","Action","Kento Yamazaki,Tao Tsuchiya");
            b.addAssessment("name1","Great quality, great actors",5,"29/3/2022");
            b.addAssessment("name2","Good",4,"4/6/2023");

            Season b_1 = new Season(1,2020);
            Episode one3 = new Episode("Episode 1",49);
            b_1.setEpisodes(one3);
            Episode two3 = new Episode("Episode 2",51);
            b_1.setEpisodes(two3);
            Episode three3 = new Episode("Episode 3",43);
            b_1.setEpisodes(three3);
            Episode four3 = new Episode("Episode 4",47);
            b_1.setEpisodes(four3);
            Episode five3 = new Episode("Episode 5",52);
            b_1.setEpisodes(five3);
            Episode six3 = new Episode("Episode 6",42);
            b_1.setEpisodes(six3);
            Episode seven3 = new Episode("Episode 7",49);
            b_1.setEpisodes(seven3);
            Episode eight3 = new Episode("Episode 8",53);
            b_1.setEpisodes(eight3);
            b.setSeasons(b_1);

            Season b_2 = new Season(2,2022);
            Episode one4 = new Episode("Episode 1",48);
            b_2.setEpisodes(one4);
            Episode two4 = new Episode("Episode 2",60);
            b_2.setEpisodes(two4);
            Episode three4 = new Episode("Episode 3",66);
            b_2.setEpisodes(three4);
            Episode four4 = new Episode("Episode 4",52);
            b_2.setEpisodes(four4);
            Episode five4 = new Episode("Episode 5",67);
            b_2.setEpisodes(five4);
            Episode six4 = new Episode("Episode 6",75);
            b_2.setEpisodes(six4);
            Episode seven4 = new Episode("Episode 7",59);
            b_2.setEpisodes(seven4);
            Episode eight4 = new Episode("Episode 8",80);
            b_2.setEpisodes(eight4);
            b.setSeasons(b_2);

            Serie c = new Serie("The Alienist","Newspaper illustrator John Moore meets with criminal psychologist (alienist) Dr. Laszlo Kreizler to investigate a serial killer in New York during the late 19th century.","TV-MA","Thriller","Daniel Brühl,Luke Evans");
            c.addAssessment("name1","Great story!",5,"10/7/2023");
            c.addAssessment("name2","It was fine...not anything special",3,"30/8/2023");

            Season c_1 = new Season(1,2018);
            Episode one5 = new Episode("The Boy on the Bridge",49);
            c_1.setEpisodes(one5);
            Episode two5 = new Episode("A Fruitful Partnership",48);
            c_1.setEpisodes(two5);
            Episode three5 = new Episode("Silver Smile",45);
            c_1.setEpisodes(three5);
            Episode four5 = new Episode("These Bloody Thoughts",48);
            c_1.setEpisodes(four5);
            Episode five5 = new Episode("Hildebrandt's Starling",48);
            c_1.setEpisodes(five5);
            Episode six5 = new Episode("Ascension",46);
            c_1.setEpisodes(six5);
            Episode seven5 = new Episode("Many Sainted Men",49);
            c_1.setEpisodes(seven5);
            Episode eight5 = new Episode("Psychopathia Sexualis",43);
            c_1.setEpisodes(eight5);
            Episode nine5 = new Episode("Requiem",49);
            c_1.setEpisodes(nine5);
            Episode ten5 = new Episode("Castle in the Sky",54);
            c_1.setEpisodes(ten5);
            c.setSeasons(c_1);

            Season c_2 = new Season(2,2020);
            Episode one6 = new Episode("Ex Ore Infantium",48);
            c_2.setEpisodes(one6);
            Episode two6 = new Episode("Something Wicked",51);
            c_2.setEpisodes(two6);
            Episode three6 = new Episode("Labyrinth",49);
            c_2.setEpisodes(three6);
            Episode four6 = new Episode("Gilded Cage",51);
            c_2.setEpisodes(four6);
            Episode five6 = new Episode("Belly of the Beast",49);
            c_2.setEpisodes(five6);
            Episode six6 = new Episode("Memento Mori",48);
            c_2.setEpisodes(six6);
            Episode seven6 = new Episode("Last Exit to Brooklyn",46);
            c_2.setEpisodes(seven6);
            Episode eight6 = new Episode("Better Angels",55);
            c_2.setEpisodes(eight6);
            c.setSeasons(c_2);

            Serie d = new Serie("Monk","The series follows Adrian Monk, a brilliant former San Francisco detective, who now consults the police as a private consultant whilst battling with an obsessive-compulsive disorder.","TV-PG","Comedy","Tony Shalhoub,Stanley Kamel");
            d.addAssessment("name1","Not very fond of it",2,"22/4/2015");
            d.addAssessment("name2","Did not like the actors, but the story was fine",2,"1/6/2017");

            Season d_1 = new Season(1,2002);
            Episode one7 = new Episode("Mr. Monk and the Candidate",78);
            d_1.setEpisodes(one7);
            Episode two7 = new Episode("Mr. Monk and the Psychic",44);
            d_1.setEpisodes(two7);
            Episode three7 = new Episode("Mr. Monk Meets Dale the Whale",44);
            d_1.setEpisodes(three7);
            d.setSeasons(d_1);

            Season d_2 = new Season(2,2003);
            Episode one8 = new Episode("Mr. Monk Goes Back to School",44);
            d_2.setEpisodes(one8);
            Episode two8 = new Episode("Mr. Monk Goes to Mexico",43);
            d_2.setEpisodes(two8);
            Episode three8 = new Episode("Mr. Monk Goes to the Ballgame",43);
            d_2.setEpisodes(three8);
            d.setSeasons(d_2);

            Season d_3 = new Season(3,2004);
            Episode one9 = new Episode("Mr. Monk Takes Manhattan",43);
            d_3.setEpisodes(one9);
            Episode two9 = new Episode("Mr. Monk and the Panic Room",43);
            d_3.setEpisodes(two9);
            Episode three9 = new Episode("Mr. Monk and the Blackout",44);
            d_3.setEpisodes(three9);
            d.setSeasons(d_3);

            Serie e = new Serie("Stranger Things","When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces and one strange little girl.","TV-14","Sci-Fi","Winona Ryder,David Harbour");
            e.addAssessment("name1","Not a fan, a bit boring",2,"3/11/2021");
            e.addAssessment("name2","First seasons were good, now the story is repeating itself",3,"23/5/2023");

            Season e_1 = new Season(1,2016);
            Episode one10 = new Episode("Chapter One: The Vanishing of Will Byers",49);
            e_1.setEpisodes(one10);
            Episode two10 = new Episode("Chapter Two: The Weirdo on Maple Street",56);
            e_1.setEpisodes(two10);
            Episode three10 = new Episode("Chapter Three: Holly, Jolly",52);
            e_1.setEpisodes(three10);
            Episode four10 = new Episode("Chapter Four: The Body",51);
            e_1.setEpisodes(four10);
            e.setSeasons(e_1);

            Season e_2 = new Season(2,2017);
            Episode one11 = new Episode("Chapter One: MADMAX",48);
            e_2.setEpisodes(one11);
            Episode two11 = new Episode("Chapter Two: Trick or Treat, Freak",56);
            e_2.setEpisodes(two11);
            Episode three11 = new Episode("Chapter Three: The Pollywog",51);
            e_2.setEpisodes(three11);
            Episode four11 = new Episode("Chapter Four: Will the Wise",46);
            e_2.setEpisodes(four11);
            e.setSeasons(e_2);

            Season e_3 = new Season(3,2019);
            Episode one12 = new Episode("Chapter One: Suzie, Do You Copy?",51);
            e_3.setEpisodes(one12);
            Episode two12 = new Episode("Chapter Two: The Mall Rats",50);
            e_3.setEpisodes(two12);
            Episode three12 = new Episode("Chapter Three: The Case of the Missing Lifeguard",50);
            e_3.setEpisodes(three12);
            Episode four12 = new Episode("Chapter Four: The Sauna Test",53);
            e_3.setEpisodes(four12);
            e.setSeasons(e_3);

            Season e_4 = new Season(4,2022);
            Episode one13 = new Episode("Chapter One: The Hellfire Club",78);
            e_4.setEpisodes(one13);
            Episode two13 = new Episode("Chapter Two: Vecna's Curse",78);
            e_4.setEpisodes(two13);
            Episode three13 = new Episode("Chapter Three: The Monster and the Superhero",64);
            e_4.setEpisodes(three13);
            Episode four13 = new Episode("Chapter Four: Dear Billy",79);
            e_4.setEpisodes(four13);
            e.setSeasons(e_4);

            subscriber1.addFavourite(c);
            subscriber2.addFavourite(a);

            //ta grafo sto binary file Series
            oos.writeObject(a);
            oos.writeObject(b);
            oos.writeObject(c);
            oos.writeObject(d);
            oos.writeObject(e);

        } catch (IOException e) {
            e.printStackTrace();
        }


        /**
         try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Movies.dat"))) {

         //ta diabazo apo to binary file Movies kai ta emfanizo stin othoni

         Movie temp= (Movie) oos.readObject();
         System.out.println(temp.getTitle() +" "+ temp.getDescription() +" "+ temp.getYearOfFirstAppearance());


         Movie temp2= (Movie) oos.readObject();
         System.out.println(temp2.getAppropriateness() +" "+ temp2.getCategory() +" "+ temp2.getProtagonists() +" "+ temp2.getMovieDuration());

         } catch (IOException | ClassNotFoundException e) {
         e.printStackTrace();
         }
         */


        /**
         try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Series.dat"))) {

         //ta diabazo apo to binary file Series kai ta emfanizo stin othoni

         Serie temp= (Serie) oos.readObject();
         System.out.println(temp.getTitle() +" "+ temp.getDescription());

         for (Season season : temp.getSeasons()) {
         System.out.println(season.getNumber() +" "+ season.getYear());
         for(Episode episode: season.getEpisodes())
         System.out.println(episode.getName() +" "+ episode.getDuration() );
         }

         Serie temp2= (Serie) oos.readObject();
         System.out.println(temp2.getAppropriateness() +" "+ temp2.getCategory() +" "+ temp2.getProtagonists());

         for (Season season : temp2.getSeasons()) {
         System.out.println(season.getNumber() +" "+ season.getYear());
         }

         } catch (IOException | ClassNotFoundException e) {
         e.printStackTrace();
         }
         */


        /**
        for (Video favourite : subscriber1.getFavourites()) {
            System.out.println("Favourite1 " + favourite.getTitle());
        }
        for (Video favourite : subscriber2.getFavourites()) {
            System.out.println("Favourite2 " + favourite.getTitle());
        }
         */


    }

}

