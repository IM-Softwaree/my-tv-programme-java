package gui;

import api.*;

import javax.swing.*;
import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

public class AddEpisode extends JFrame{

    private Episode neoep;

    public Episode addEpisode()
    {
        JTextField name, duration;
        JButton ok;

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

        duration = new JTextField("DURATION");
        duration.setPreferredSize(new Dimension(100, duration.getPreferredSize().height));

        ok = new JButton("Ok");

        this.add(name);
        this.add(duration);
        this.add(ok);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String n = name.getText();
                int d = Integer.parseInt(duration.getText());

                neoep = new Episode(n,d);

                dispose();
            }
        });

        setVisible(true);

        System.out.println(neoep.getName()+" "+neoep.getDuration());

        return this.neoep;

    }

}
