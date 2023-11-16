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

    ImageIcon leftIcon;
    ImageIcon downIcon;
    ImageIcon upIcon;
    ImageIcon rightIcon;

    JLabel leftMove;
    JLabel downMove;
    JLabel upMove;
    JLabel rightMove;

    int bottom_row = 450;
    scores_panel score;
    
    private Timer leftTimer, downTimer, upTimer, rightTimer;
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
        int stepSize =10;
        //creating moving arrows and adding them to main panel
        leftIcon = new ImageIcon(getClass().getClassLoader().getResource("left.gif"));
        leftMove = new JLabel(leftIcon);
        downIcon = new ImageIcon(getClass().getClassLoader().getResource("down.gif"));
        downMove = new JLabel(downIcon);
        upIcon = new ImageIcon(getClass().getClassLoader().getResource("up.gif"));
        upMove = new JLabel(upIcon);
        rightIcon = new ImageIcon(getClass().getClassLoader().getResource("right.gif"));
        rightMove = new JLabel(rightIcon);

        mainPanel.add(leftMove);
        mainPanel.add(downMove);
        mainPanel.add(upMove);
        mainPanel.add(rightMove);
        
        score = new scores_panel();
        mainPanel.add(score);
        
        //making the arrow receptors panel and adding it to a grid
        arrowsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,30,0));
        arrowsPanel.setPreferredSize(new Dimension(700,100));
        arrowsPanel.setBackground(Color.gray);
        arrowsPanel.setOpaque(false);
        space1 = new JPanel();
        space2 = new JPanel();
        space3 = new JPanel();
        space4 = new JPanel();
        space1.setPreferredSize(new Dimension(233,135));
        space2.setPreferredSize(new Dimension(233,135));
        space1.setOpaque(false);
        space2.setOpaque(false);

        gridArrows = new JPanel(new GridLayout(5, 1));
        gridArrows.setOpaque(false);
        gridArrows.add(space1);
        gridArrows.add(space2);
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

        leftTimer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftMove.setLocation(leftMove.getX(), leftMove.getY() + stepSize);
                if (leftMove.getY() > 460){
                    System.out.println("booo");
                }

            }
        });

        downTimer = new Timer(150, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                downMove.setLocation(downMove.getX(), downMove.getY() + stepSize);
            }
        });

        upTimer = new Timer(200, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                upMove.setLocation(upMove.getX(), upMove.getY() + stepSize);
            }
        });

        rightTimer = new Timer(250, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightMove.setLocation(rightMove.getX(), rightMove.getY() + stepSize);
            }});
            rightTimer.start();
            leftTimer.start();
            upTimer.start();
            downTimer.start();
    }
    
    public void disable()
    {
        frame2.setVisible(false);
        frame2.setEnabled(false);
        leftTimer.stop();
        downTimer.stop();
        upTimer.stop();
        rightTimer.stop();
    }

    public void enable()
    {
        frame2.setVisible(true);
        frame2.setEnabled(true);
            rightTimer.start();
            leftTimer.start();
            upTimer.start();
            downTimer.start();
    }
    
    public void keyPressed(KeyEvent e) 
    {   // +420 immediatly goes to bottom arrows
        int stepSize = 10;
        //System.out.println("here");
        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
        {
            //System.out.println("right");
            rightMove.setLocation(rightMove.getX(), rightMove.getY() + stepSize);
        }
        else if(e.getKeyCode()== KeyEvent.VK_LEFT)
        {
            //System.out.println("left");
            leftMove.setLocation(leftMove.getX(), leftMove.getY() + stepSize);
            if (leftMove.getY() > 400 && leftMove.getY() < 450) {
                System.out.println("aahhhhh");

            }
            
        }
        else if(e.getKeyCode()== KeyEvent.VK_UP)
        {
            //System.out.println("up");
            upMove.setLocation(upMove.getX(), upMove.getY() + stepSize);
        }
        else if(e.getKeyCode()== KeyEvent.VK_DOWN)
        {
            //System.out.println("down");
            downMove.setLocation(downMove.getX(), downMove.getY() + stepSize);
        }
    }
    
    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void set_start(){
        leftMove.setLocation(left.getX(),-50);
        rightMove.setLocation(right.getX(),-50);
        upMove.setLocation(up.getX(),-50);
        downMove.setLocation(down.getX(),-50);
        score.setLocation(down.getX(),200);
    }
}
    
