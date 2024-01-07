package gui;
import api.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMovie extends JFrame {

    public EditMovie(Video toedit,Video old)
    {
        JRadioButton title, des,ap,cat,prot, year,dur;
        JButton next;

        setTitle("Edit Movie");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(270, 230));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Select the element you want to edit:");
        this.add(label1);

        // radio buttons
        title = new JRadioButton("Title");
        des = new JRadioButton("Description");
        ap = new JRadioButton("Appropriateness");
        cat = new JRadioButton("Category");
        prot = new JRadioButton("Protagonists");
        year = new JRadioButton("Year of first appearance");
        dur = new JRadioButton("Duration");


        next = new JButton("Next");

        this.add(title);
        this.add(des);
        this.add(ap);
        this.add(cat);
        this.add(prot);
        this.add(year);
        this.add(dur);

        this.add(next);

        ButtonGroup group = new ButtonGroup();
        group.add(title);
        group.add(des);
        group.add(ap);
        group.add(cat);
        group.add(prot);
        group.add(year);
        group.add(dur);

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(title.isSelected())
                {
                   new EditTitle(toedit,old);
                   dispose();
                }
                else if(des.isSelected())
                {
                    new EditDescription(toedit,old);
                    dispose();
                }
                else if(ap.isSelected())
                {

                }
                else if(cat.isSelected())
                {

                }
                else if(prot.isSelected())
                {

                }
                else if(year.isSelected())
                {

                }
                else
                {
                  //  new AddSeason();
                }

            }
        });

        setVisible(true);
    }

}
