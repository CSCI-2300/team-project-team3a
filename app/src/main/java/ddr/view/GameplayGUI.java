package ddr.view;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.*;

import java.util.Random;

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

    int step;

    int speed;
    Random random;

    private Timer leftTimer, downTimer, upTimer, rightTimer;
    public GameplayGUI(ScreenObserver screen, Game game)
    { //javaswing constructor

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

        int delay = 30; // should work but MIGHT be different number for different devices
        int stepSize =8;
        leftTimer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!container.left_col.isEmpty()) {
                    for (int i = 0; i < container.ArrLength(1); i++) {
                        container.left_col.get(i).setLocation(container.left_col.get(i).getX(), container.left_col.get(i).getY() + stepSize);
                    }
                     
                     if (container.getArrow(1).getY() > 500){
                        if (container.getArrow(1).check_flag() == false){
                            gamerGame.miss();
                        }
                        mainPanel.remove(container.getArrow(1));
                        container.removeArrow(1);
                    } 
                    
                }
            }
        });


        downTimer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!container.down_col.isEmpty()) {
                    for(int i = 0; i < container.ArrLength(2);i++){
                        container.down_col.get(i).setLocation(container.down_col.get(i).getX(), container.down_col.get(i).getY() + stepSize);
                    }
                    if (container.getArrow(2).getY() > 500){
                        if (container.getArrow(2).check_flag() == false){
                            gamerGame.miss();
                        }
                        mainPanel.remove(container.getArrow(2));
                        container.removeArrow(2);
                    } 
                }
            }
        });
 
        upTimer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!container.up_col.isEmpty()) {
                for(int i = 0; i < container.ArrLength(3);i++){
                container.up_col.get(i).setLocation(container.up_col.get(i).getX(), container.up_col.get(i).getY() + stepSize);
                 }
                 if (container.getArrow(3).getY() > 500){
                        if (container.getArrow(3).check_flag() == false){
                            gamerGame.miss();
                        }
                        mainPanel.remove(container.getArrow(3));
                        container.removeArrow(3);
                    } 
            }
            }
        });
        

        rightTimer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!container.right_col.isEmpty()) {
                for(int i = 0; i < container.ArrLength(4);i++){
                container.right_col.get(i).setLocation(container.right_col.get(i).getX(), container.right_col.get(i).getY() + stepSize);
                 }
                 if (container.getArrow(4).getY() > 500){
                        if (container.getArrow(4).check_flag() == false){
                            gamerGame.miss();
                        }
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
                
                    if (gamerGame.check_hit(1,container.getArrow(4).getY()) && container.getArrow(4).check_flag() == false) {
                        controller.press();
                        container.getArrow(4).set_flag();
                        container.getArrow(4).setIcon(boom);
                    }
                    else {
                        controller.miss();
                    }
                } else {
                    controller.miss(); 
                }

            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (!container.left_col.isEmpty()) {
                    if (gamerGame.check_hit(1,container.getArrow(1).getY()) && container.getArrow(1).check_flag() == false) {
                        controller.press();
                        container.getArrow(1).set_flag();
                        container.getArrow(1).setIcon(boom);
                    }
                    else{
                        controller.miss();
                    }
                } else {
                    controller.miss();
                    
                }

            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (!container.up_col.isEmpty()) {
                    if (gamerGame.check_hit(1,container.getArrow(3).getY()) && container.getArrow(3).check_flag() == false) {
                    controller.press();
                    container.getArrow(3).set_flag();
                    container.getArrow(3).setIcon(boom);
                    }
                    else{
                        controller.miss();
                    }
                } else {
                   controller.miss(); 
                }
                

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (!container.down_col.isEmpty()) {
                    if (gamerGame.check_hit(1,container.getArrow(2).getY()) && container.getArrow(2).check_flag() == false) {
                        controller.press();
                        container.getArrow(2).set_flag();;
                        container.getArrow(2).setIcon(boom);
                    }
                    else{
                        controller.miss();
                    }
                } else {
                    controller.miss();
                }

                
            } 
        });
    }
    
    
    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void update(){
        score.score_update(gamerGame.getScore());
        score.combo_update(gamerGame.getCurrentCombo());

        if(controller.gameLost()){
            System.out.println("end");
            stopBackgroundMusic();
            controller.endGame();
            GameTimer.stop();
            elapsedTimeTimer.stop();
        }
    }

    //timer for game (49 seconds)
    private Timer GameTimer;
    private Timer elapsedTimeTimer;
    private int elapsedTime = 0;

    public void game_start(){
        playBackgroundMusic();

        elapsedTimeTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime++; // Increase elapsed time every second
                if (elapsedTime == 49) {
                    stopBackgroundMusic();
                    controller.endGame();
                    controller.clear();
                    GameTimer.stop();
                    elapsedTimeTimer.stop();
                }
            }
        });

        GameTimer = new Timer(gamerGame.diff, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = random.nextInt(4)+1;
                // make for loop that goes through each allArrows array to store location and then try to use set location to repaint it there. If set location no work, remove everything from pain panel, readd it then use set location with store location
                if (choice ==1){
                    container.addArrow(1);

                    int lastIndex = container.left_col.size() - 1;
                    if (lastIndex >= 0) {
                        container.left_col.get(lastIndex).setBounds(180, -100, 100, 100);
                        step += 100;
                        mainPanel.add(container.left_col.get(lastIndex));
                        mainPanel.setComponentZOrder(container.left_col.get(lastIndex), 0);
                        container.left_col.get(lastIndex).setVisible(true);
                        
                        mainPanel.revalidate();
                        mainPanel.repaint();

                    }
                }
                if (choice == 2){
                    container.addArrow(2);

                    int lastIndex2 = container.down_col.size() - 1;
                    if (lastIndex2 >= 0) {
                        container.down_col.get(lastIndex2).setBounds(275, -100, 80, 90);
                        step += 100;
                        mainPanel.add(container.down_col.get(lastIndex2));
                        mainPanel.setComponentZOrder(container.down_col.get(lastIndex2), 0);
                        container.down_col.get(lastIndex2).setVisible(true);
                        mainPanel.revalidate();
                        mainPanel.repaint();

                    }
                }
                if (choice ==3){
                        container.addArrow(3);
                
                    int lastIndex3 = container.up_col.size() - 1;
                    if (lastIndex3 >= 0) {
                        container.up_col.get(lastIndex3).setBounds(365, -100, 80, 80);
                        step += 100;
                        mainPanel.add(container.up_col.get(lastIndex3));
                        mainPanel.setComponentZOrder(container.up_col.get(lastIndex3), 0);
                        container.up_col.get(lastIndex3).setVisible(true);
                        mainPanel.revalidate();
                        mainPanel.repaint();

                    }
                }

                if (choice ==4){
                    container.addArrow(4);
                    int lastIndex4 = container.right_col.size() - 1;
                    if (lastIndex4 >= 0) {
                        container.right_col.get(lastIndex4).setBounds(455, -100, 80, 80);
                        step += 100;
                        mainPanel.add(container.right_col.get(lastIndex4));
                        mainPanel.setComponentZOrder(container.right_col.get(lastIndex4), 0);
                        container.right_col.get(lastIndex4).setVisible(true);
                        mainPanel.revalidate();
                        mainPanel.repaint();

                    }
                }
            }
        });
        elapsedTimeTimer.start(); // Start the elapsed time timer
        GameTimer.start();                  
                            
    }

        
    //music 
    private Clip backgroundMusicClip;
    private void playBackgroundMusic() 
    {
        try 
        {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("banger.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
            DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
            backgroundMusicClip = (Clip) AudioSystem.getLine(info);
            backgroundMusicClip.open(audioInputStream);
            backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }    
    
    public void stopBackgroundMusic() 
    {
        if (backgroundMusicClip != null) 
        {
            backgroundMusicClip.stop();
        }
    } 
    
}
    
