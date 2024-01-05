package gui;
import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchVideo extends JFrame{
    public SearchVideo()
    {
        JTextField title, appropriateness,category, protagonists, rating;
        JButton movie,serie,all;
        JPanel panel,panel3,panel4,panel5,panel6;


        setTitle("Search");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(370, 330));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label = new JLabel("Fill in only(!) the information you want to search for (ex.title)");
        this.add(label);

        panel = new JPanel();
        JLabel label2 = new JLabel("Title:");
        title = new JTextField();
        title.setPreferredSize(new Dimension(100, title.getPreferredSize().height));
        panel.add(label2);
        panel.add(title);
        this.add(panel);

        panel3 = new JPanel();
        JLabel label4 = new JLabel("Appropriateness:");
        appropriateness = new JTextField();
        appropriateness.setPreferredSize(new Dimension(100, appropriateness.getPreferredSize().height));
        panel3.add(label4);
        panel3.add(appropriateness);
        this.add(panel3);

        panel4 = new JPanel();
        JLabel label5 = new JLabel("Category:");
        category = new JTextField();
        category.setPreferredSize(new Dimension(100, category.getPreferredSize().height));
        panel4.add(label5);
        panel4.add(category);
        this.add(panel4);

        panel5 = new JPanel();
        JLabel label6 = new JLabel("Protagonist:");
        protagonists = new JTextField();
        protagonists.setPreferredSize(new Dimension(100, protagonists.getPreferredSize().height));
        panel5.add(label6);
        panel5.add(protagonists);
        this.add(panel5);

        panel6 = new JPanel();
        JLabel label7 = new JLabel("Minimum average rating (ex.>=4):");
        rating = new JTextField();
        rating.setPreferredSize(new Dimension(100, rating.getPreferredSize().height));
        panel6.add(label7);
        panel6.add(rating);
        this.add(panel6);

        JLabel label1 = new JLabel("                 What do you want to search for?                   ");
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
