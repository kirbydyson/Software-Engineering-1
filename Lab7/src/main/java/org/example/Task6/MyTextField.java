package org.example.Task6;

import javax.swing.*;
import java.awt.event.*;


class MyTextField extends JFrame implements ActionListener {
    // JTextField
    static JTextField textField;

    // JFrame
    static JFrame frame;

    // JButton
    static JButton button;

    // label to display text
    static JLabel label;

    // default constructor
    MyTextField() {}

    // main class
    public static void main(String[] args) {
        frame = new JFrame("textfield");
        label = new JLabel("nothing entered");
        button = new JButton("submit");
        MyTextField te = new MyTextField();

        button.addActionListener(te);

        // create a object of JTextField with 16 columns
        textField = new JTextField(16);

        // create a panel to add buttons and textfield
        JPanel p = new JPanel();

        p.add(textField);
        p.add(button);
        p.add(label);

        frame.add(p);

        // set the size of frame
        frame.setSize(300, 300);

        frame.setVisible(true);
    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            // set the text of the label to the text of the field
            label.setText(textField.getText());

            // set the text of field to blank
            textField.setText("  ");
        }
    }
}
