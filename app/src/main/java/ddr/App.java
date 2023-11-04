package ddr;

import java.awt.*;
import javax.swing.*;

public class App {
    public static void main (String args[]){
        JFrame frame1 = new JFrame("Main Menu"); //window label
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame1.setVisible(true);


        JFrame frame2 = new JFrame("Gameplay"); 
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame2.setVisible(true);


        JFrame frame3 = new JFrame("Results Screen");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame3.setVisible(true);
    }
}