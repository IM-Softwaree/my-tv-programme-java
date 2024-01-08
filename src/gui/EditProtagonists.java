package gui;
import api.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProtagonists extends JFrame{
    public EditProtagonists(Video toedit,Video old)
    {
        JTextField protagonists;
        JButton ok;

        JFrame newWindow = new JFrame("Edit");
        newWindow.setSize(new Dimension(400, 300));
        newWindow.setLocationRelativeTo(null);

        // Set default close operation to EXIT_ON_CLOSE
        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager for the new window
        newWindow.setLayout(new FlowLayout());

        setTitle("Edit Protagonists");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(270, 200));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Give the new protagonists:");
        this.add(label1);

        protagonists = new JTextField();
        protagonists.setPreferredSize(new Dimension(100, protagonists.getPreferredSize().height));
        this.add(protagonists);

        ok=new JButton("Ok");
        this.add(ok);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                toedit.setProtagonists(protagonists.getText());
                toedit.editingMovie(old);
                JOptionPane.showMessageDialog(newWindow, "Editing successful", "Message", JOptionPane.INFORMATION_MESSAGE);
                dispose();

            }
        });


        setVisible(true);
    }
}
