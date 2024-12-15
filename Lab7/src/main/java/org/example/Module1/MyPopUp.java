package org.example.Module1;

import java.awt.*;

class MyPopUp extends Frame {
    public MyPopUp () {
        super("MyWindow");
        setSize(300,300);
        Label newLabel = new Label("My Label");
        add(newLabel);
        setVisible(true);
    }
    public static void main (String args[]) {
        new MyPopUp();
    }
}
