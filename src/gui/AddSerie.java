package gui;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSerie extends JFrame {

    public void addSerie()
    {
        JTextField title, description, appropriateness,category, protagonists;
        JButton ok,addseason,back;

        setTitle("Add a new serie");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(300, 200));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Give serie information");
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

        ok = new JButton("Ok");

        this.add(title);
        this.add(description);
        this.add(appropriateness);
        this.add(category);
        this.add(protagonists);

        this.add(ok);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String t = title.getText();
                String d = description.getText();
                String a = appropriateness.getText();
                String c = category.getText();
                String p = protagonists.getText();

                Serie neo = new Serie(t,d,a,c,p);

                neo.addSerieToFile();  //!!!APPEND TO BINARY FILE

                dispose();
            }
        });

        addseason = new JButton("Add a season");
        this.add(addseason);
        addseason.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String t = title.getText();
                String d = description.getText();
                String a = appropriateness.getText();
                String c = category.getText();
                String p = protagonists.getText();

                Serie neo = new Serie(t,d,a,c,p);

                new AddSeason().addSeason(neo);

            }
        });

        back = new JButton("Back");
        this.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
