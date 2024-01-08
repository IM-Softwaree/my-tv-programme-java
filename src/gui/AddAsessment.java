package gui;
import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAsessment extends JFrame{

    public AddAsessment(Video temp) {
        JTextField title, description, appropriateness,category;
        JButton save,back;
        JPanel panel,panel2,panel3,panel4;

        JFrame newWindow = new JFrame("Adding an assessment");
        newWindow.setSize(new Dimension(400, 300));
        newWindow.setLocationRelativeTo(null);

        // Set default close operation to EXIT_ON_CLOSE
        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager for the new window
        newWindow.setLayout(new FlowLayout());

        setTitle("Add a new assessment");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(330, 300));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        panel = new JPanel();
        JLabel label2 = new JLabel("Username:");
        title = new JTextField();
        title.setPreferredSize(new Dimension(100, title.getPreferredSize().height));
        panel.add(label2);
        panel.add(title);
        this.add(panel);

        panel2 = new JPanel();
        JLabel label3 = new JLabel("Comments:");
        description = new JTextField();
        description.setPreferredSize(new Dimension(100, description.getPreferredSize().height));
        panel2.add(label3);
        panel2.add(description);
        this.add(panel2);

        panel3 = new JPanel();
        JLabel label4 = new JLabel("Rating(1-5):");
        appropriateness = new JTextField();
        appropriateness.setPreferredSize(new Dimension(100, appropriateness.getPreferredSize().height));
        panel3.add(label4);
        panel3.add(appropriateness);
        this.add(panel3);

        panel4 = new JPanel();
        JLabel label5 = new JLabel("Date:");
        category = new JTextField();
        category.setPreferredSize(new Dimension(100, category.getPreferredSize().height));
        panel4.add(label5);
        panel4.add(category);
        this.add(panel4);

        back = new JButton("Back");
        this.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        save = new JButton("Save");

        this.add(save);

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String t = title.getText();
                String d = description.getText();
                int y = Integer.parseInt(appropriateness.getText());
                String c = category.getText();


                temp.addAssessment(t,d,y,c);

                JOptionPane.showMessageDialog(newWindow, "Adding an assessment successful", "Message", JOptionPane.INFORMATION_MESSAGE);

                dispose();
            }
        });

        setVisible(true);
    }

}
//