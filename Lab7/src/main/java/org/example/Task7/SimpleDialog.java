package org.example.Task7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleDialog extends JFrame {

    public static void main(String[] args) {
        createWindow();
    }

    private static void createWindow() {
        JFrame frame = new JFrame("Swing Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createUI(final JFrame frame) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel txtPanel = new JPanel(new FlowLayout());
        JTextField txtField = new JTextField(15);
        JButton txtBttn = new JButton("Submit Text");
        final JLabel txtLabel = new JLabel();
        txtBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtField.getText();
                if (input != null && !input.isEmpty()) {
                    txtLabel.setText("Text Input: " + input);
                } else {
                    txtLabel.setText("No input provided");
                }
            }
        });

        txtPanel.add(new JLabel("Enter text:"));
        txtPanel.add(txtField);
        txtPanel.add(txtBttn);
        txtPanel.add(txtLabel);

        JPanel diaPanel = new JPanel(new FlowLayout());
        JButton diaBttn = new JButton("Click Me!");
        final JLabel diaLabel = new JLabel();
        diaBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String result = (String) JOptionPane.showInputDialog(
                        frame,
                        "Give me a color",
                        "Swing Tester",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "Red"
                );
                if (result != null && result.length() > 0) {
                    diaLabel.setText("You selected: " + result);
                } else {
                    diaLabel.setText("None selected");
                }
            }
        });

        diaPanel.add(diaBttn);
        diaPanel.add(diaLabel);
        panel.add(txtPanel);
        panel.add(diaPanel);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
}
