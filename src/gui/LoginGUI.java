package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import api.LoginAPI;
import api.PersonAdderToFile;


public class LoginGUI extends JFrame {

    public void start() {

        LoginAPI loginAPI = new LoginAPI();

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
                openNewWindow1();

                // Dispose of the current JFrame (make it disappear)
                SwingUtilities.invokeLater(() -> {
                    dispose(); // Make sure this is inside invokeLater
                });
            }
        });

        // Add the button to the frame
        add(loginButton);

        // Make the frame visible
        setVisible(true);
    }

    //-----------------------------------------------------------------------
    private void openNewWindow1() {
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
        JButton actionButton1 = new JButton("LOGIN");
        actionButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when the "Log In" button is clicked
                String text1 = textField1.getText();
                String text2 = textField2.getText();

                if (LoginAPI.isAdminUserNothing(text1, text2) == 'A'){
                    // Action to perform when the "Log In" button is clicked
                    openNewWindowAdmin();
                } else if (LoginAPI.isAdminUserNothing(text1, text2) == 'U'){
                    // Action to perform when the "Log In" button is clicked
                    openNewWindowUser(text1);
                } else {
                    // Show the message dialog
                    JOptionPane.showMessageDialog(newWindow, "WRONG USERNAME OR PASSWORD", "Message", JOptionPane.INFORMATION_MESSAGE);
                    openNewWindow1();
                }

                // Dispose of the current JFrame (make it disappear)
                newWindow.dispose();
            }
        });

        // Create a button on the bottom
        JButton actionButton2 = new JButton("New Member? Press Here");
        actionButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when the "Log In" button is clicked
                openNewWindow2();

                // Dispose of the current JFrame (make it disappear)
                newWindow.dispose();
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
        newWindow.add(actionButton1, gbc);

        // Set GridBagConstraints for the button on the right
        gbc.gridx = -2;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.EAST;
        newWindow.add(actionButton2, gbc);

        // Make the new window visible
        newWindow.setVisible(true);

        // Dispose of the original frame (make it disappear)
        SwingUtilities.invokeLater(() -> {
            dispose(); // Make sure this is inside invokeLater
        });
    }

    //-----------------------------------------------------------------------
    private void openNewWindow2() {

        // Create and configure a new JFrame for the new window
        JFrame newWindow = new JFrame("Subscribe to Nextflix");
        newWindow.setSize(new Dimension(400, 300));
        newWindow.setLocationRelativeTo(this);

        // Set default close operation to EXIT_ON_CLOSE
        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager for the new window
        newWindow.setLayout(new GridBagLayout());

        // Create labels
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel surnameLabel = new JLabel("Surname:");

        // Create two JTextFields on the left
        JTextField textField1 = new JTextField(15);
        JTextField textField2 = new JTextField(15);
        JTextField textField3 = new JTextField(15);
        JTextField textField4 = new JTextField(15);

        // Create a button on the right
        JButton actionButton1 = new JButton("SUBSCRIBE");
        actionButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when the "Log In" button is clicked
                String text1 = textField1.getText();
                String text2 = textField2.getText();
                String text3 = textField3.getText();
                String text4 = textField4.getText();

                if(!PersonAdderToFile.findUsername(text1)) {
                    // Show the message dialog
                    JOptionPane.showMessageDialog(newWindow, "USERNAME ALREADY EXISTS", "Message", JOptionPane.INFORMATION_MESSAGE);
                    openNewWindow2();
                } else {
                    PersonAdderToFile.addSubscriberViaForm(text1, text2, text3, text4);
                    // Show the message dialog
                    JOptionPane.showMessageDialog(newWindow, "SUBSCRIPTION SUCCESSFUL!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    openNewWindow1();
                }

                // Dispose of the current JFrame (make it disappear)
                newWindow.dispose();
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

        gbc.gridy = 2;
        newWindow.add(nameLabel, gbc);

        gbc.gridy = 3;
        newWindow.add(surnameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        newWindow.add(textField1, gbc);

        gbc.gridy = 1;
        newWindow.add(textField2, gbc);

        gbc.gridy = 2;
        newWindow.add(textField3, gbc);

        gbc.gridy = 3;
        newWindow.add(textField4, gbc);

        // Set GridBagConstraints for the button on the right
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.EAST;
        newWindow.add(actionButton1, gbc);

        // Make the new window visible
        newWindow.setVisible(true);
    }

    //-----------------------------------------------------------------------
    private void openNewWindowAdmin() {

        // Create and configure a new JFrame for the new window
        JFrame newWindow = new JFrame("Nextflix Admin");
        newWindow.setSize(new Dimension(300, 200));
        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newWindow.setLocationRelativeTo(null);

        // Create a button on the bottom
        JButton actionButton1 = new JButton("PRESS HERE TO CONTINUE");
        actionButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when the "PRESS HERE TO CONTINUE" button is clicked
                SwingUtilities.invokeLater(() -> {
                    new AdminGUI().admin();
                });

                // Dispose of the current JFrame (make it disappear)
                newWindow.dispose();
            }
        });

        // Show the message dialog
        JOptionPane.showMessageDialog(newWindow, "YOU HAVE SUCCESSFULLY LOGGED IN AS AN ADMIN", "Message", JOptionPane.INFORMATION_MESSAGE);

        JLabel welcomeLabel = new JLabel("WELCOME DEAR ADMIN");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add the button and label to the frame
        newWindow.setLayout(new BorderLayout());
        newWindow.add(actionButton1, BorderLayout.SOUTH);
        newWindow.add(welcomeLabel, BorderLayout.CENTER);

        // Make the new window visible
        newWindow.setVisible(true);
    }

    //-----------------------------------------------------------------------
    private void openNewWindowUser(String userName) {

        // Create and configure a new JFrame for the new window
        JFrame newWindow = new JFrame("Nextflix Subscriber");
        newWindow.setSize(new Dimension(300, 200));
        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newWindow.setLocationRelativeTo(null);

        // Create a button on the bottom
        JButton actionButton2 = new JButton("PRESS HERE TO CONTINUE");
        actionButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when the "PRESS HERE TO CONTINUE" button is clicked
                SwingUtilities.invokeLater(() -> {
                    new SubscriberGUI().subscriber(userName);
                });

                // Dispose of the current JFrame (make it disappear)
                newWindow.dispose();
            }
        });

        // Show the message dialog
        JOptionPane.showMessageDialog(newWindow, "YOU HAVE SUCCESSFULLY LOGGED IN AS A SUBSCRIBER", "Message", JOptionPane.INFORMATION_MESSAGE);

        JLabel welcomeLabel = new JLabel("WELCOME DEAR SUBSCRIBER");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add the button and label to the frame
        newWindow.setLayout(new BorderLayout());
        newWindow.add(actionButton2, BorderLayout.SOUTH);
        newWindow.add(welcomeLabel, BorderLayout.CENTER);

        // Make the new window visible
        newWindow.setVisible(true);
    }

}

/**
 *
 */