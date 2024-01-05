package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddObject extends JFrame {

    public void add()
    {
        JRadioButton movie, serie, season, episode;
        JButton next,back;

        setTitle("Add a new object");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(280, 200));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("What object do you want to add?");
        this.add(label1);

        movie = new JRadioButton("Movie");
        serie = new JRadioButton("Serie");
        season = new JRadioButton("Season");
        episode = new JRadioButton("Episode");


        next = new JButton("Next");

        this.add(movie);
        this.add(serie);
        this.add(season);
        this.add(episode);


        back = new JButton("Back");
        this.add(back);

        JLabel labelB = new JLabel("                                         ");
        this.add(labelB);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        this.add(next);

        ButtonGroup group = new ButtonGroup();
        group.add(movie);
        group.add(serie);
        group.add(season);
        group.add(episode);

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(movie.isSelected())
                {
                    new AddMovie().addMovie();
                }

                 else if(serie.isSelected())
                 {
                     new AddSerie();
                 }

                 else if(season.isSelected())
                 {

                 }
                 /**
                 else
                 {

                 }
                 */

            }
        });


        setVisible(true);
    }


}
