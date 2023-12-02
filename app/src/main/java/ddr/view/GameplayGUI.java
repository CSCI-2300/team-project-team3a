package ddr.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;
import java.util.random.*;

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

    Arrow leftMove;
    Arrow downMove;
    Arrow upMove;
    Arrow rightMove;

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

    allArrows container;
    int position;

    int step;

    int notes;
    Random random;

    private Timer leftTimer, downTimer, upTimer, rightTimer;
    public GameplayGUI(ScreenObserver screen, Game game)
    { //javaswing constructor
        notes = 0;
        position = 0;
        step = 10;
        container = new allArrows(1); // one for now

        random = new Random();

        frame2 = new JFrame("Gameplay"); 
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backs = new ImageIcon(getClass().getClassLoader().getResource("receptorBackground.png"));
        mainPanel = new ImagePanel(backs);
        
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(700,500));
        frame2.addKeyListener(this);
        spawnpoint = new JPanel(); 
        spawnpoint.setLayout(new FlowLayout(FlowLayout.CENTER,30,0));
        spawnpoint.setPreferredSize(new Dimension(700,100));
        spawnpoint.setOpaque(false);


        //creating moving arrows and adding them to main panel
        boom = new ImageIcon(getClass().getClassLoader().getResource("explosion.gif"));
        booms = new JLabel(boom);
        leftIcon = new ImageIcon(getClass().getClassLoader().getResource("left.gif"));
        leftMove = new Arrow();
        leftMove.setIcon(leftIcon);
        downIcon = new ImageIcon(getClass().getClassLoader().getResource("down.gif"));
        downMove = new Arrow();
        downMove.setIcon(downIcon);
        upIcon = new ImageIcon(getClass().getClassLoader().getResource("up.gif"));
        upMove = new Arrow();
        upMove.setIcon(upIcon);
        rightIcon = new ImageIcon(getClass().getClassLoader().getResource("right.gif"));
        rightMove = new Arrow();
        rightMove.setIcon(rightIcon);

       // mainPanel.add(leftMove);
        //mainPanel.add(downMove);
        //mainPanel.add(upMove);
        //mainPanel.add(rightMove);
        
        score = new scores_panel();
        mainPanel.add(score);
        score.setBounds(250, 275,300,100);

        
      
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
                if (!container.left_col.isEmpty()) {
                    for (int i = 0; i < container.ArrLength(1); i++) {
                        container.left_col.get(i).setLocation(container.left_col.get(i).getX(), container.left_col.get(i).getY() + stepSize);
                    }
                    if (container.getArrow(1).getY() == 470 && container.getArrow(1).check_flag() == false) {
                        gamerGame.miss();
                    }
                    if (container.getArrow(1).getY() > 500) {
                        mainPanel.remove(container.getArrow(1));
                        container.removeArrow(1);
                    }
                }
            }
        });




        downTimer = new Timer(40, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!container.down_col.isEmpty()) {
                    for(int i = 0; i < container.ArrLength(2);i++){
                    container.down_col.get(i).setLocation(container.down_col.get(i).getX(), container.down_col.get(i).getY() + stepSize);
                    }
                    if (container.getArrow(2).getY() == 470 && container.getArrow(2).check_flag() == false){
                        gamerGame.miss();
                    }
                    if (container.getArrow(2).getY() > 500){
                    // gamerGame.miss();
                    mainPanel.remove(container.getArrow(2));
                    container.removeArrow(2);
                    }
                }
            }
        });

        upTimer = new Timer(60, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!container.up_col.isEmpty()) {
                for(int i = 0; i < container.ArrLength(3);i++){
                container.up_col.get(i).setLocation(container.up_col.get(i).getX(), container.up_col.get(i).getY() + stepSize);
                 }
                if (container.getArrow(3).getY() == 470 && container.getArrow(3).check_flag() == false){
                    gamerGame.miss();
                }
                if (container.getArrow(3).getY() > 500){
                 // gamerGame.miss();
                   mainPanel.remove(container.getArrow(3));
                   container.removeArrow(3);
                }
            }
            }
        });
        

        rightTimer = new Timer(80, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!container.right_col.isEmpty()) {
                for(int i = 0; i < container.ArrLength(4);i++){
                container.right_col.get(i).setLocation(container.right_col.get(i).getX(), container.right_col.get(i).getY() + stepSize);
                 }
                if (container.getArrow(4).getY() == 470 && container.getArrow(4).check_flag() == false){
                    gamerGame.miss();
                }
                if (container.getArrow(4).getY() > 500){
                 // gamerGame.miss();
                   mainPanel.remove(container.getArrow(4));
                   container.removeArrow(4);
                   
                }
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
        frame2.setTitle("Gameplay");
    }
    
    public void keyPressed(KeyEvent e) {
        SwingUtilities.invokeLater(() -> {
            int stepSize = 10;
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (!container.right_col.isEmpty()) {
                
                    //rightMove.setLocation(rightMove.getX(), rightMove.getY() + stepSize);
                    if (gamerGame.check_hit(1,container.getArrow(4).getY())) {
                        System.out.println("aahhhhh");
                        controller.press();
                        container.getArrow(4).set_flag();
                        container.getArrow(4).setIcon(boom);
                    // mainPanel.remove(rightMove);
                        //leftMove.revalidate();
                        //leftMove.repaint();
                    }
                    else {
                        controller.miss();
                    }
                } else {
                    controller.miss();
                }
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (!container.left_col.isEmpty()) {
                    // leftMove.setLocation(leftMove.getX(), leftMove.getY() + stepSize);
                    if (gamerGame.check_hit(1,container.getArrow(1).getY())) {
                        System.out.println("aahhhhh");
                        controller.press();
                        container.getArrow(1).set_flag();
                        container.getArrow(1).setIcon(boom);
                        //mainPanel.remove(leftMove);
                        //leftMove.revalidate();
                        //leftMove.repaint();
                    }
                    else{
                        controller.miss();
                    }
                } else {
                    controller.miss();
                }
               
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (!container.up_col.isEmpty()) {
                    // upMove.setLocation(upMove.getX(), upMove.getY() + stepSize);
                    if (gamerGame.check_hit(1,container.getArrow(3).getY())) {
                    System.out.println("aahhhhh");
                    controller.press();
                    container.getArrow(3).set_flag();
                    container.getArrow(3).setIcon(boom);
                   // mainPanel.remove(upMove);
                    //leftMove.revalidate();
                    //leftMove.repaint();
                    }
                    else{
                        controller.miss();
                    }
                } else {
                    controller.miss();
                }
               

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (!container.down_col.isEmpty()) {
                    // downMove.setLocation(downMove.getX(), downMove.getY() + stepSize);
                    if (gamerGame.check_hit(1,container.getArrow(2).getY())) {
                        System.out.println("aahhhhh");
                        controller.press();
                        container.getArrow(2).set_flag();;
                        container.getArrow(2).setIcon(boom);
                    // mainPanel.remove(downMove);
                        //leftMove.revalidate();
                        //leftMove.repaint();
                    }
                    else{
                        controller.miss();
                    }
                } else {
                    controller.miss();
                }
                
            } else if(e.getKeyCode() == KeyEvent.VK_SPACE){
                controller.endGame();
            }
        });
    }
    
    
    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void set_start(){
       // leftMove.setLocation(left.getX(),-50);
        //rightMove.setLocation(right.getX(),-50);
        //upMove.setLocation(up.getX(),-50);
        //downMove.setLocation(down.getX(),-50);


        
       // score.setLocation(400,200);
    }

    @Override
    public void update(){
       score.score_update(gamerGame.getScore());
        score.combo_update(gamerGame.getCurrentCombo());


        frame2.setTitle("Score "+ gamerGame.getScore() + " Combo "+ gamerGame.getCurrentCombo());
        if (gamerGame.gameOver()){
            controller.endGame();
        }


    }

    public void game_start(){
        //     container.addArrow(1);
        //     container.addArrow(2);
        //     container.addArrow(3);
        //     container.addArrow(4);
        //     container.addArrow(1);
        
        //     container.getArrow(1).setBounds(175, -125, 80, 80);
        //     container.getArrow(2).setBounds(275, -125, 80, 90);
        //     container.getArrow(3).setBounds(365, -125, 80, 80);
        //      container.getArrow(4).setBounds(450, -125, 80, 80);

        //     // container.getArrow(2).setLocation(400, 300);
        //     // container.getArrow(3).setLocation(500, 300);
        //     // container.getArrow(4).setLocation(600, 300);
        
        //     mainPanel.add(container.getArrow(1));
        //     mainPanel.add(container.getArrow(2));
        //     mainPanel.add(container.getArrow(3));
        //     mainPanel.add(container.getArrow(4));
        // //     mainPanel.add(container.left_col.get(1));

        //     mainPanel.setComponentZOrder(container.getArrow(1), 0);
        //     mainPanel.setComponentZOrder(container.getArrow(2), 1);
        //     mainPanel.setComponentZOrder(container.getArrow(3), 2);
        //     mainPanel.setComponentZOrder(container.getArrow(4), 3);
        //   //   mainPanel.setComponentZOrder(container.left_col.get(container.left_col.size()-1), 0);
        //     mainPanel.revalidate();
        //     mainPanel.repaint();
            Timer GameTimer = new Timer(2000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int choice = random.nextInt(4)+1;



                    // make for loop that goes through each allArrows array to store location and then try to use set location to repaint it there. If set location no work, remove everything from pain panel, readd it then use set location with store location
                    if (choice ==1){
                    container.addArrow(1);

                    int lastIndex = container.left_col.size() - 1;
                    if (lastIndex > 0) {
                        container.left_col.get(lastIndex).setBounds(175, -100, 100, 100);
                        step += 100;
                        mainPanel.add(container.left_col.get(lastIndex));
                        mainPanel.setComponentZOrder(container.left_col.get(lastIndex), 0);
                        container.left_col.get(lastIndex).setVisible(true);
                        mainPanel.revalidate();
                        mainPanel.repaint();

                    }}
                    if (choice ==2){
                        container.addArrow(2);

                    int lastIndex2 = container.down_col.size() - 1;
                    if (lastIndex2 > 0) {
                        container.down_col.get(lastIndex2).setBounds(275, -100, 80, 90);
                        step += 100;
                        mainPanel.add(container.down_col.get(lastIndex2));
                        mainPanel.setComponentZOrder(container.down_col.get(lastIndex2), 0);
                        container.down_col.get(lastIndex2).setVisible(true);
                        mainPanel.revalidate();
                        mainPanel.repaint();

                    }}
                    if (choice ==3){
                            container.addArrow(3);
                   
                    int lastIndex3 = container.up_col.size() - 1;
                    if (lastIndex3 > 0) {
                        container.up_col.get(lastIndex3).setBounds(365, -100, 80, 80);
                        step += 100;
                        mainPanel.add(container.up_col.get(lastIndex3));
                        mainPanel.setComponentZOrder(container.up_col.get(lastIndex3), 0);
                        container.up_col.get(lastIndex3).setVisible(true);
                        mainPanel.revalidate();
                        mainPanel.repaint();

                    }}

                    if (choice ==4){
                         container.addArrow(4);
                    int lastIndex4 = container.right_col.size() - 1;
                    if (lastIndex4 > 0) {
                        container.right_col.get(lastIndex4).setBounds(450, -100, 80, 80);
                        step += 100;
                        mainPanel.add(container.right_col.get(lastIndex4));
                        mainPanel.setComponentZOrder(container.right_col.get(lastIndex4), 0);
                        container.right_col.get(lastIndex4).setVisible(true);
                        mainPanel.revalidate();
                        mainPanel.repaint();

                    }}
                }
            });
            GameTimer.start();
                                
                                
        }
        

    
}
    
