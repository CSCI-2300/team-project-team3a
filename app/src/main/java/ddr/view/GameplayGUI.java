package ddr.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import ddr.ScreenObserver;
import ddr.gameObserver;
import ddr.model.Game;

public class GameplayGUI implements KeyListener, gameObserver { //UI during gameplay
    JFrame frame2;
    JPanel mainPanel;

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

    Game gamerGame;
    ScreenObserver controller;

    int scorex;
    int scorey;

    JLabel test;
    int tester;
    String ahh;

    ImageIcon boom;
    JLabel booms;

    private Timer leftTimer, downTimer, upTimer, rightTimer;
    public GameplayGUI(ScreenObserver screen, Game game)
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

        //creating moving arrows and adding them to main panel
        boom = new ImageIcon(getClass().getClassLoader().getResource("explosion.gif"));
        booms = new JLabel(boom);
        leftIcon = new ImageIcon(getClass().getClassLoader().getResource("left.gif"));
        leftMove = new JLabel();
        leftMove.setIcon(leftIcon);
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
        
       // score = new scores_panel();
       // mainPanel.add(score);
      //  score.setLocation(200,200);
        
        //making the arrow receptors panel and adding it to a grid
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

        gamerGame = game;
        controller = screen;

        frame2.add(mainPanel);
        frame2.pack();
        frame2.setVisible(true);
        frame2.setResizable(false);

                        int stepSize =2;
                leftTimer = new Timer(20, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftMove.setLocation(leftMove.getX(), leftMove.getY() + stepSize);
                if (leftMove.getY() == 470){
                    gamerGame.miss();
                }
                if (leftMove.getY() > 500){
                 // gamerGame.miss();
                   mainPanel.remove(leftMove);
                }

            }
        });

        downTimer = new Timer(40, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                downMove.setLocation(downMove.getX(), downMove.getY() + stepSize);
                if (downMove.getY() == 470){
                    gamerGame.miss();
                }
                if (downMove.getY() > 500){
                   //gamerGame.miss();
                   mainPanel.remove(downMove);
                }
            }
        });

        upTimer = new Timer(60, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    upMove.setLocation(upMove.getX(), upMove.getY() + stepSize);
                if (upMove.getY() == 470){
                    gamerGame.miss();
                }
                if (upMove.getY() > 500){
                   mainPanel.remove(upMove);

                }
                });
            }
        });
        

        rightTimer = new Timer(80, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rightMove.setLocation(rightMove.getX(), rightMove.getY() + stepSize);
                if (rightMove.getY() == 470){
                    gamerGame.miss();
                }
                    if (rightMove.getY() > 500){
                  // gamerGame.miss();
                   mainPanel.remove(rightMove);
                }
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
        frame2.setTitle("score "+ gamerGame.getScore() + " combo "+gamerGame.getCurrentCombo());
    }
    
    public void keyPressed(KeyEvent e) {
        SwingUtilities.invokeLater(() -> {
            int stepSize = 10;
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rightMove.setLocation(rightMove.getX(), rightMove.getY() + stepSize);
                if (gamerGame.check_hit(1,rightMove.getY())) {
                    System.out.println("aahhhhh");
                    controller.press(1);
                    rightMove.setIcon(boom);
                    mainPanel.remove(rightMove);
                    //leftMove.revalidate();
                    //leftMove.repaint();
                }
                gamerGame.miss();
                //controller.press(3);
                //rightMove.revalidate();
                //rightMove.repaint();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                leftMove.setLocation(leftMove.getX(), leftMove.getY() + stepSize);
                if (gamerGame.check_hit(1,leftMove.getY())) {
                    System.out.println("aahhhhh");
                    controller.press(1);
                    leftMove.setIcon(boom);
                    mainPanel.remove(leftMove);
                    //leftMove.revalidate();
                    //leftMove.repaint();
                }
                gamerGame.miss();
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                upMove.setLocation(upMove.getX(), upMove.getY() + stepSize);
                    if (gamerGame.check_hit(1,upMove.getY())) {
                    System.out.println("aahhhhh");
                    controller.press(1);
                    upMove.setIcon(boom);
                    mainPanel.remove(upMove);
                    //leftMove.revalidate();
                    //leftMove.repaint();
                }
                gamerGame.miss();

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downMove.setLocation(downMove.getX(), downMove.getY() + stepSize);
                if (gamerGame.check_hit(1,downMove.getY())) {
                    System.out.println("aahhhhh");
                    controller.press(1);
                    downMove.setIcon(boom);
                    mainPanel.remove(downMove);
                    //leftMove.revalidate();
                    //leftMove.repaint();
                }
                gamerGame.miss();
            }
        });
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
       // score.setLocation(400,200);
    }

    @Override
    public void update(){
       // score.score_update(gamerGame.getScore());
        //score.combo_update(gamerGame.getCurrentCombo());
        //score.setLocation(scorex, scorey);
        //score.setLocation(scorex, scorey);
        frame2.setTitle("score "+ gamerGame.getScore() + " Combo "+ gamerGame.getCurrentCombo());
        if (gamerGame.gameOver()){
            controller.move();
        }


    }

}
    
