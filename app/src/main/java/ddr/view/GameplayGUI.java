package ddr.view;

import java.awt.*;
import javax.swing.*;

public class GameplayGUI  { //UI during gameplay
    JFrame frame2;
    JPanel panel;
    JLabel right;
    ImageIcon rights;
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


        frame2.pack();
        frame2.setVisible(true);
    }
}
    
