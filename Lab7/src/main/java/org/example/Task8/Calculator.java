package org.example.Task8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    static JFrame frame;
    static JTextField text;
    String s0, s1, s2;

    Calculator() {
        s0 = s1 = s2 = "";
    }

    public static void main(String args[]) {
        frame = new JFrame("Calculator");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        Calculator calc = new Calculator();

        text = new JTextField(16);
        text.setEditable(false);
        text.setHorizontalAlignment(SwingConstants.RIGHT);
        text.setFont(new Font("Arial", Font.PLAIN, 24));

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "%", "0", ".", "+",
                "C", "="
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    calc.actionPerformed(e);
                }
            });
            buttonPanel.add(button);
        }

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(text, BorderLayout.NORTH);
        p.add(buttonPanel, BorderLayout.CENTER);

        frame.add(p);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!s1.equals("")) {
                s2 = s2 + s;
            } else {
                s0 = s0 + s;
            }
            text.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {
            s0 = s1 = s2 = "";
            text.setText("");
        }
        else if (s.charAt(0) == '=') {
            double result;

            if (s1.equals("+")) {
                result = (Double.parseDouble(s0) + Double.parseDouble(s2));
            } else if (s1.equals("-")) {
                result = (Double.parseDouble(s0) - Double.parseDouble(s2));
            } else if (s1.equals("/")) {
                result = (Double.parseDouble(s0) / Double.parseDouble(s2));
            } else if (s1.equals("%")) {
                result = (Double.parseDouble(s0) % Double.parseDouble(s2));
            } else {
                result = (Double.parseDouble(s0) * Double.parseDouble(s2));
            }

            text.setText(s0 + s1 + s2 + " = " + result);
            s0 = Double.toString(result);
            s1 = s2 = "";
        }
        else {
            if (s1.equals("") || s2.equals("")) {
                s1 = s;
            } else {
                double result;

                if (s1.equals("+")) {
                    result = (Double.parseDouble(s0) + Double.parseDouble(s2));
                } else if (s1.equals("-")) {
                    result = (Double.parseDouble(s0) - Double.parseDouble(s2));
                } else if (s1.equals("/")) {
                    result = (Double.parseDouble(s0) / Double.parseDouble(s2));
                } else if (s1.equals("%")) {
                    result = (Double.parseDouble(s0) % Double.parseDouble(s2));
                } else {
                    result = (Double.parseDouble(s0) * Double.parseDouble(s2));
                }

                s0 = Double.toString(result);
                s1 = s;
                s2 = "";
            }
            text.setText(s0 + s1 + s2);
        }
    }
}
