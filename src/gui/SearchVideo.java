package gui;
import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchVideo extends JFrame{
    private Person person = new Person();
    public SearchVideo()
    {
        JTextField title, appropriateness,category, protagonists, rating;
        JButton movie,serie,all,back;
        JPanel panel,panel3,panel4,panel5,panel6;

        JFrame newWindow = new JFrame("Search result");
        newWindow.setSize(new Dimension(400, 300));
        newWindow.setLocationRelativeTo(null);

        // Set default close operation to EXIT_ON_CLOSE
        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager for the new window
        newWindow.setLayout(new FlowLayout());

        setTitle("Search");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(370, 330));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label = new JLabel("Fill in only(!) the information you want to search for (ex.title)");
        this.add(label);

        panel = new JPanel();
        JLabel label2 = new JLabel("Title:");
        title = new JTextField();
        title.setPreferredSize(new Dimension(100, title.getPreferredSize().height));
        panel.add(label2);
        panel.add(title);
        this.add(panel);

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
        JLabel label6 = new JLabel("Protagonist:");
        protagonists = new JTextField();
        protagonists.setPreferredSize(new Dimension(100, protagonists.getPreferredSize().height));
        panel5.add(label6);
        panel5.add(protagonists);
        this.add(panel5);

        panel6 = new JPanel();
        JLabel label7 = new JLabel("Minimum average rating (ex.>=4):");
        rating = new JTextField();
        rating.setPreferredSize(new Dimension(100, rating.getPreferredSize().height));
        panel6.add(label7);
        panel6.add(rating);
        this.add(panel6);

        JLabel label1 = new JLabel("                 What do you want to search for?                   ");
        this.add(label1);

        movie = new JButton("Movie");
        serie = new JButton("Serie");
        all = new JButton("All");

        this.add(movie);
        this.add(serie);
        this.add(all);

        movie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tit;
                String ap;
                String cat;
                String pro;
                float rat;

                if(title.getText().isEmpty())
                    tit=null;
                else
                    tit=title.getText();

                if(appropriateness.getText().isEmpty())
                    ap=null;
                else
                    ap=appropriateness.getText();

                if(category.getText().isEmpty())
                    cat=null;
                else
                    cat=category.getText();

                if(protagonists.getText().isEmpty())
                    pro=null;
                else
                    pro=protagonists.getText();

                if(rating.getText().isEmpty())
                    rat=-1;
                else
                    rat=Float.parseFloat(rating.getText());

                Movie send = new Movie(tit,null,ap,cat,pro,0,0);
                send.setAverageRatingForSearch(rat);
                ArrayList<Video> res =  person.searchVideo(send);
                if(res.size()==0)
                    JOptionPane.showMessageDialog(newWindow, "No matching result found", "Message", JOptionPane.INFORMATION_MESSAGE);
                else
                {
                    // Option 1: See list of movies and series
                    SwingUtilities.invokeLater(() -> {
                        WatchListGUI watchListGUI = new WatchListGUI(res);
                    });
                    dispose();
                }
            }
        });

        serie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tit;
                String ap;
                String cat;
                String pro;
                float rat;

                if(title.getText().isEmpty())
                    tit=null;
                else
                    tit=title.getText();

                if(appropriateness.getText().isEmpty())
                    ap=null;
                else
                    ap=appropriateness.getText();

                if(category.getText().isEmpty())
                    cat=null;
                else
                    cat=category.getText();

                if(protagonists.getText().isEmpty())
                    pro=null;
                else
                    pro=protagonists.getText();

                if(rating.getText().isEmpty())
                    rat=-1;
                else
                    rat=Float.parseFloat(rating.getText());

                Serie send = new Serie(tit,null,ap,cat,pro);
                send.setAverageRatingForSearch(rat);
                ArrayList<Video> res = person.searchVideo(send);
                if(res.size()==0)
                    JOptionPane.showMessageDialog(newWindow, "No matching result found", "Message", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        all.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tit;
                String ap;
                String cat;
                String pro;
                float rat;

                if(title.getText().isEmpty())
                    tit=null;
                else
                    tit=title.getText();

                if(appropriateness.getText().isEmpty())
                    ap=null;
                else
                    ap=appropriateness.getText();

                if(category.getText().isEmpty())
                    cat=null;
                else
                    cat=category.getText();

                if(protagonists.getText().isEmpty())
                    pro=null;
                else
                    pro=protagonists.getText();

                if(rating.getText().isEmpty())
                    rat=-1;
                else
                    rat=Float.parseFloat(rating.getText());

                Video send = new Video(tit,null,ap,cat,pro);
                send.setAverageRatingForSearch(rat);
                ArrayList<Video> res = person.searchVideo(send);
                if(res.size()==0)
                    JOptionPane.showMessageDialog(newWindow, "No matching result found", "Message", JOptionPane.INFORMATION_MESSAGE);

            }
        });


        back = new JButton("Back");
        this.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

}
