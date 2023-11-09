package ddr.view;

import java.awt.*;
import javax.swing.*;

public class GameplayGUI  { //UI during gameplay
    JFrame frame2;
    JPanel panel;
    JLabel right;
    ImageIcon rights;
    JLabel left;
    ImageIcon lefts;
    JLabel up;
    ImageIcon ups;
    JLabel down;
    ImageIcon downs;
    public GameplayGUI(){ //javaswing constructor
        frame2 = new JFrame("Gameplay"); 
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(700,500));
        panel.setBackground(Color.gray);
        frame2.add(panel);

        rights = new ImageIcon(getClass().getClassLoader().getResource("rightarrow.png"));
        right = new JLabel(rights);
        panel.add(right);

        lefts = new ImageIcon(getClass().getClassLoader().getResource("leftarrow.png"));
        left = new JLabel(lefts);
        panel.add(left);

        ups = new ImageIcon(getClass().getClassLoader().getResource("uparrow.png"));
        up = new JLabel(ups);
        panel.add(up);

        downs = new ImageIcon(getClass().getClassLoader().getResource("downarrow.png"));
        down = new JLabel(downs);
        panel.add(down);


        frame2.pack();
        frame2.setVisible(true);
    }
}
    
