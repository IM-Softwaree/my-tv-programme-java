package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    public void start() {
        setTitle("NEXTFLIX");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(500, 300));
        setResizable(true);

        // Set layout manager to center the components vertically
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 75));

        // Create a blue button
        JButton loginButton = new JButton("Log In");
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE); // Set text color to white for better visibility

        // Set the preferred size of the button
        loginButton.setPreferredSize(new Dimension(200, 100));

        // Add ActionListener to the "Log In" button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when the "Log In" button is clicked
                openNewWindow();

                // Dispose of the current JFrame (make it disappear)
                dispose();
            }
        });

        // Add the button to the frame
        add(loginButton);

        // Make the frame visible
        setVisible(true);
    }

    private void openNewWindow() {
        // Create and configure a new JFrame for the new window
        JFrame newWindow = new JFrame("Nextflix Log-In");
        newWindow.setSize(new Dimension(400, 300));
        newWindow.setLocationRelativeTo(this);

        // Set default close operation to EXIT_ON_CLOSE
        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager for the new window
        newWindow.setLayout(new GridBagLayout());

        // Create labels
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        // Create two JTextFields on the left
        JTextField textField1 = new JTextField(15);
        JTextField textField2 = new JTextField(15);

        // Create a button on the right
        JButton actionButton = new JButton("LOGIN");
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when the button is clicked
                // You can access the contents of the text fields here
                String text1 = textField1.getText();
                String text2 = textField2.getText();
                System.out.println("Text 1: " + text1);
                System.out.println("Text 2: " + text2);
            }
        });

        // Set GridBagConstraints for the labels and text fields on the left
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5); // Add some spacing

        newWindow.add(usernameLabel, gbc);

        gbc.gridy = 1;
        newWindow.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        newWindow.add(textField1, gbc);

        gbc.gridy = 1;
        newWindow.add(textField2, gbc);

        // Set GridBagConstraints for the button on the right
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.EAST;
        newWindow.add(actionButton, gbc);

        // Make the new window visible
        newWindow.setVisible(true);
    }
}
