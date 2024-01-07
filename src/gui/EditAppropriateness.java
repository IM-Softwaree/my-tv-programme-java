package gui;
import api.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAppropriateness extends JFrame{
    public EditAppropriateness(Video toedit,Video old)
    {
        JTextField appropriateness;
        JButton ok;

        setTitle("Edit Appropriateness");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(270, 200));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Give the new appropriateness:");
        this.add(label1);

        appropriateness = new JTextField();
        appropriateness.setPreferredSize(new Dimension(100, appropriateness.getPreferredSize().height));
        this.add(appropriateness);

        ok=new JButton("Ok");
        this.add(ok);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                toedit.setAppropriateness(appropriateness.getText());
                toedit.editingMovie(old);
                dispose();

            }
        });


        setVisible(true);
    }
}
