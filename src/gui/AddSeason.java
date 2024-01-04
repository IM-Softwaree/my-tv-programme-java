package gui;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSeason extends JFrame {

    public void addSeason(Serie s)
    {
        JTextField number, year;
        JButton ok,addepisode;

        setTitle("Add a new season");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(300, 200));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Give season information");
        this.add(label1);

        number = new JTextField("NUMBER");
        number.setPreferredSize(new Dimension(100, number.getPreferredSize().height));

        year = new JTextField("YEAR");
        year.setPreferredSize(new Dimension(100, year.getPreferredSize().height));

        ok = new JButton("Ok");

        this.add(number);
        this.add(year);
        this.add(ok);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(number.getText());
                int y = Integer.parseInt(year.getText());

                Season neo = new Season(n,y);

                s.setSeasons(neo);

                dispose();
            }
        });

        addepisode = new JButton("Add an episode");
        this.add(addepisode);
        addepisode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(number.getText());
                int y = Integer.parseInt(year.getText());

                Season neo = new Season(n,y);

                Episode fak =  new AddEpisode().addEpisode();

                System.out.println(fak.getName()+" "+fak.getDuration());
            }
        });

        setVisible(true);
    }

}
