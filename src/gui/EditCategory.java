package gui;
import api.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCategory extends JFrame{
    public EditCategory(Video toedit,Video old)
    {
        JTextField category;
        JButton ok;

        JFrame newWindow = new JFrame("Edit");
        newWindow.setSize(new Dimension(400, 300));
        newWindow.setLocationRelativeTo(null);

        // Set default close operation to EXIT_ON_CLOSE
        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager for the new window
        newWindow.setLayout(new FlowLayout());

        setTitle("Edit Category");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(270, 200));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Give the new category:");
        this.add(label1);

        category = new JTextField();
        category.setPreferredSize(new Dimension(100, category.getPreferredSize().height));
        this.add(category);

        ok=new JButton("Ok");
        this.add(ok);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                toedit.setCategory(category.getText());
                toedit.editingMovie(old);
                JOptionPane.showMessageDialog(newWindow, "Editing successful", "Message", JOptionPane.INFORMATION_MESSAGE);
                dispose();

            }
        });


        setVisible(true);
    }
}
//