package ddr.view;

import java.awt.*;
import javax.swing.*;

public class GameplayGUI  { //UI during gameplay
    JFrame frame2;
    ImagePanel mainPanel;

    JPanel arrowsPanel;
    JPanel space1;
    JPanel space2;
    JPanel space3;
    JPanel space4;

    JLabel right;
    ImageIcon rights;
    JLabel left;
    ImageIcon lefts;
    JLabel up;
    ImageIcon ups;
    JLabel down;
    ImageIcon downs;

    JLabel back;
    ImageIcon backs;

    JPanel gridArrows;
    public GameplayGUI(){ //javaswing constructor
        frame2 = new JFrame("Gameplay"); 
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backs = new ImageIcon(getClass().getClassLoader().getResource("game_background.png"));
        mainPanel = new ImagePanel(backs);
        mainPanel.setPreferredSize(new Dimension(700,500));




        arrowsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,30,0));
        arrowsPanel.setPreferredSize(new Dimension(700,100));
        arrowsPanel.setBackground(Color.gray);
        arrowsPanel.setOpaque(false);
        space1 = new JPanel();
        space2 = new JPanel();
        space3 = new JPanel();
        space4 = new JPanel();
        space1.setPreferredSize(new Dimension(233,100));
        space2.setPreferredSize(new Dimension(233,100));
        space3.setPreferredSize(new Dimension(233,100));
        space4.setPreferredSize(new Dimension(233,100));
        space1.setOpaque(false);
        space2.setOpaque(false);
        space3.setOpaque(false);
        space4.setOpaque(false);

        gridArrows = new JPanel(new GridLayout(5, 1));
        gridArrows.setOpaque(false);

        gridArrows.add(space1);
        gridArrows.add(space2);
        gridArrows.add(space3);
        gridArrows.add(space4);
        gridArrows.add(arrowsPanel);

        mainPanel.add(gridArrows);
        frame2.add(mainPanel);

        lefts = new ImageIcon(getClass().getClassLoader().getResource("leftarrow.png"));
        left = new JLabel(lefts);
        arrowsPanel.add(left);

        downs = new ImageIcon(getClass().getClassLoader().getResource("downarrow.png"));
        down = new JLabel(downs);
        arrowsPanel.add(down);

        ups = new ImageIcon(getClass().getClassLoader().getResource("uparrow.png"));
        up = new JLabel(ups);
        arrowsPanel.add(up);

        rights = new ImageIcon(getClass().getClassLoader().getResource("rightarrow.png"));
        right = new JLabel(rights);
        arrowsPanel.add(right);

        frame2.pack();
        frame2.setVisible(true);
        frame2.setResizable(false);
    }
}
    
