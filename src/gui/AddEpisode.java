package gui;

import api.*;

import javax.swing.*;
import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

public class AddEpisode extends JFrame{

    public Episode addEpisode()
    {
        JTextField name, duration;
        JButton ok;
        String n;
        int d;

        setTitle("Add a new episode");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(300, 200));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Give episode information");
        this.add(label1);

        name = new JTextField("Name of episode");
        name.setPreferredSize(new Dimension(100, name.getPreferredSize().height));

        duration = new JTextField("0");
        duration.setPreferredSize(new Dimension(100, duration.getPreferredSize().height));

        ok = new JButton("Ok");

        this.add(name);
        this.add(duration);
        this.add(ok);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                dispose();
            }
        });

        n = name.getText();
        d = Integer.parseInt(duration.getText());

        Episode neoep = new Episode(n,d);

        setVisible(true);

        System.out.println("FFAAAAAAAAAK");

        return neoep;

    }



}
