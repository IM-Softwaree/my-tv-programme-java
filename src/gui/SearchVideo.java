package gui;
import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchVideo extends JFrame{
    public SearchVideo()
    {
        JButton movie,serie,all;

        setTitle("Search");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(270, 200));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("What do you want to search for?");
        this.add(label1);

        movie = new JButton("Movie");
        serie = new JButton("Serie");
        all = new JButton("All");

        this.add(movie);
        this.add(serie);
        this.add(all);

        movie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });

        serie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });

        all.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });


        setVisible(true);
    }
}
