package ddr.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameplayGUI implements KeyListener { //UI during gameplay
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
    JPanel spawnpoint;



    ImageIcon test;
    JLabel tester;
    ImageIcon test1;
    JLabel tester1;
    JLabel tester2;
    JLabel tester3;
    public GameplayGUI()
    { //javaswing constructor
        frame2 = new JFrame("Gameplay"); 
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backs = new ImageIcon(getClass().getClassLoader().getResource("game_background.png"));
        mainPanel = new ImagePanel(backs);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,0));
        mainPanel.setPreferredSize(new Dimension(700,500));
        frame2.addKeyListener(this);
        spawnpoint = new JPanel(new FlowLayout(FlowLayout.CENTER,30,0)); 
        spawnpoint.setOpaque(false);
        test = new ImageIcon(getClass().getClassLoader().getResource("left.gif"));
        tester = new JLabel(test);
       test1 = new ImageIcon(getClass().getClassLoader().getResource("down.gif"));
        tester1 = new JLabel(test1);
        ImageIcon test2 = new ImageIcon(getClass().getClassLoader().getResource("up.gif"));
        tester2 = new JLabel(test2);
        ImageIcon test3 = new ImageIcon(getClass().getClassLoader().getResource("right.gif"));
        tester3 = new JLabel(test3);

        mainPanel.add(tester);
        mainPanel.add(tester1);
         mainPanel.add(tester2);
        mainPanel.add(tester3);
        


        arrowsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,30,0));
        arrowsPanel.setPreferredSize(new Dimension(700,100));
        arrowsPanel.setBackground(Color.gray);
        arrowsPanel.setOpaque(false);
        space1 = new JPanel();
        space2 = new JPanel();
        space3 = new JPanel();
        space4 = new JPanel();
        space1.setPreferredSize(new Dimension(233,120));
        space2.setPreferredSize(new Dimension(233,120));
        space3.setPreferredSize(new Dimension(233,120));
        space1.setOpaque(false);
        space2.setOpaque(false);
        space3.setOpaque(false);


        gridArrows = new JPanel(new GridLayout(5, 1));
        gridArrows.setOpaque(false);

        gridArrows.add(space1);
        gridArrows.add(space2);
        gridArrows.add(space3);
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
    
    public void disable()
    {
        frame2.setVisible(false);
        frame2.setEnabled(false);
    }

    public void enable()
    {
        frame2.setVisible(true);
        frame2.setEnabled(true);
    }
    
    public void keyPressed(KeyEvent e) 
    {
        int stepSize = 10;
        System.out.println("here");
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            System.out.println("right");
             tester3.setLocation(tester3.getX(), tester3.getY() + stepSize);}
        else if(e.getKeyCode()== KeyEvent.VK_LEFT){
            System.out.println("left");
            tester.setLocation(tester.getX(), tester.getY() + stepSize);}
        else if(e.getKeyCode()== KeyEvent.VK_UP){
            System.out.println("up");
            
           tester2.setLocation(tester2.getX(), tester2.getY() + stepSize);}

        else if(e.getKeyCode()== KeyEvent.VK_DOWN){
            System.out.println("down");
            tester1.setLocation(tester1.getX(), tester1.getY() + stepSize);}
    }
    
    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
    
