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
        JButton ok;
        JPanel panel,panel2,panel3,panel4,panel5;

        setTitle("Add a new serie");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(300, 350));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("    Give serie information:    ");
        this.add(label1);

        panel = new JPanel();
        JLabel label2 = new JLabel("Title:");
        title = new JTextField();
        title.setPreferredSize(new Dimension(100, title.getPreferredSize().height));
        panel.add(label2);
        panel.add(title);
        this.add(panel);

        panel2 = new JPanel();
        JLabel label3 = new JLabel("Description:");
        description = new JTextField();
        description.setPreferredSize(new Dimension(100, description.getPreferredSize().height));
        panel2.add(label3);
        panel2.add(description);
        this.add(panel2);

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
        JLabel label6 = new JLabel("Protagonists:");
        protagonists = new JTextField();
        protagonists.setPreferredSize(new Dimension(100, protagonists.getPreferredSize().height));
        panel5.add(label6);
        panel5.add(protagonists);
        this.add(panel5);


        ok = new JButton("Ok");
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


        setVisible(true);
    }
}
