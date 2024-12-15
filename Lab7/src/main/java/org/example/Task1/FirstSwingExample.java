package org.example.Task1;

import javax.swing.*;
import java.awt.event.*;

public class FirstSwingExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();// creating instance of JFrame
        frame.setSize(300, 200);// 300 width and 200 height
        frame.setLayout(null);// using no layout managers
        frame.setVisible(true);// making the frame visible

        JButton button = new JButton("click");// creating instance of JButton
        button.setBounds(100, 70, 100, 40);// x axis, y axis, width, height

        frame.add(button);// adding button in JFrame

        JLabel label = new JLabel("Clicks: 0");
        label.setBounds(100, 100, 100, 40);
        frame.add(label);

        final int[] clicks = {0};
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clicks[0]++;
                label.setText("Clicks: " + clicks[0]);
            }
        });
    }
}
