package gui;
import api.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTitle extends JFrame{
    public EditTitle(Video toedit,Video old)
    {
        JTextField title;
        JButton ok;

        setTitle("Edit Title");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(270, 200));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Give the new title:");
        this.add(label1);

        title = new JTextField();
        title.setPreferredSize(new Dimension(100, title.getPreferredSize().height));
        this.add(title);

        ok=new JButton("Ok");
        this.add(ok);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                toedit.setTitle(title.getText());
                toedit.editingMovie(old);
                dispose();

            }
        });


        setVisible(true);
    }

}
