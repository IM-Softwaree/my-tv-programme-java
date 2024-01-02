package gui;
import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AddMovie extends JFrame{

    public void addMovie()
    {
        JTextField title, description, appropriateness,category, protagonists, year, duration;
        JButton ok;

        setTitle("Add a new movie");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(300, 200));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Give movies information");
        this.add(label1);

        title = new JTextField("TITLE");
        title.setPreferredSize(new Dimension(100, title.getPreferredSize().height));

        description = new JTextField("DESCRIPTION");
        description.setPreferredSize(new Dimension(100, description.getPreferredSize().height));

        appropriateness = new JTextField("APPROPRIATENESS");
        appropriateness.setPreferredSize(new Dimension(150, appropriateness.getPreferredSize().height));

        category = new JTextField("CATEGORY");
        category.setPreferredSize(new Dimension(100, category.getPreferredSize().height));

        protagonists = new JTextField("PROTAGONISTS");
        protagonists.setPreferredSize(new Dimension(100, protagonists.getPreferredSize().height));

        year = new JTextField("YEAR OF FIRST APPEARANCE");
        year.setPreferredSize(new Dimension(200, year.getPreferredSize().height));

        duration = new JTextField("DURATION");
        duration.setPreferredSize(new Dimension(100, duration.getPreferredSize().height));

        ok = new JButton("Ok");

        this.add(title);
        this.add(description);
        this.add(appropriateness);
        this.add(category);
        this.add(protagonists);
        this.add(year);
        this.add(duration);

        this.add(ok);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String t = title.getText();
                String d = description.getText();
                String a = appropriateness.getText();
                String c = category.getText();
                String p = protagonists.getText();
                int y = Integer.parseInt(year.getText());
                int dur = Integer.parseInt(duration.getText());

                Movie neo = new Movie(t,d,a,c,p,y,dur);

                neo.addMovieToFile(neo);  //!!!APPEND TO BINARY FILE

                dispose();

                /**
                try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("MoviesTEST.dat"))) {

                    //ta diabazo apo to binary file Movies

                    while (true) {  // repeat until end of file
                        Video temp = (Video) oos.readObject();  //read obj

                        System.out.println(temp.getTitle());
                    }

                } catch (EOFException end) {
                    System.out.println("Reached the end of file");

                } catch (IOException | ClassNotFoundException ee) {
                    ee.printStackTrace();
                }
                 */

            }
        });



        setVisible(true);
    }


}
