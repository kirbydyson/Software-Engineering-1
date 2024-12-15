package org.example.Task5;

import javax.swing.*;
import java.awt.*;

public class SetLayout {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Set Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton jb1 = new JButton("NORTH");
        JButton jb2 = new JButton("SOUTH");
        JButton jb3 = new JButton("WEST");
        JButton jb4 = new JButton("EAST");
        JButton jb5 = new JButton("CENTER");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(jb1, BorderLayout.NORTH);
        panel.add(jb2, BorderLayout.SOUTH);
        panel.add(jb3, BorderLayout.WEST);
        panel.add(jb4, BorderLayout.EAST);
        panel.add(jb5, BorderLayout.CENTER);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
