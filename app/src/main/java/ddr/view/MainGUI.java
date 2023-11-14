package ddr.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import ddr.screen_obvs;

public class MainGUI implements ActionListener {
    JFrame frame1;
    ImagePanel panel;
    ImageIcon logo;
    ImageIcon backs;
    JPanel highscores;
    JLabel [] highscores_a;
    screen_obvs controller;

    public MainGUI(screen_obvs control) {
        frame1 = new JFrame("Main Menu");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backs = new ImageIcon(getClass().getClassLoader().getResource("game_background.png"));
        panel = new ImagePanel(backs);
        controller = control;

        highscores = new JPanel(new GridLayout(3,1));
        highscores.setOpaque(false);
        highscores_a = new JLabel[3];
        for(int i = 0;i<3;i++){
        highscores_a[i] = new JLabel("highscore: ");
        highscores_a[i].setForeground(Color.WHITE);
        highscores_a[i].setOpaque(false);
    }

        for(int i = 0;i<3;i++){
          highscores.add(highscores_a[i]);}
        panel.add(highscores);


        panel.setPreferredSize(new Dimension(700,500));
        panel.setBackground(new Color(135, 206, 235));
        Dimension butoonsize = new Dimension(100,50);
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false);

        
        logo = new ImageIcon(getClass().getClassLoader().getResource("logo.png"));
        Image image = logo.getImage().getScaledInstance(300, 350, Image.SCALE_DEFAULT);
        logo.setImage(image);
        JLabel title = new JLabel(logo); 
        /////////ADD HIGH SCORE TOP LEFT
        titlePanel.setPreferredSize(new Dimension(400,400));
        titlePanel.add(title);
        //JLabel modes = new JLabel("Modes:");
        panel.add(titlePanel);
        //panel.add(modes);

        JPanel butoonpanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
        butoonpanel.setOpaque(false);

        JButton easy = new JButton("easy");
        easy.setForeground(Color.WHITE);
        butoonpanel.add(easy);
        easy.setPreferredSize(butoonsize);
        easy.setOpaque(false);
        easy.setContentAreaFilled(false);
        easy.addActionListener(this);

        //panel.add(easyPanel);

        JButton medium = new JButton("medium");
        medium.setForeground(Color.WHITE);
        medium.setPreferredSize(butoonsize);
        butoonpanel.add(medium);

        medium.setOpaque(false);
        medium.setContentAreaFilled(false);
        medium.addActionListener(this);

            //panel.add(mediumPanel);

        JButton hard = new JButton("hard");
        hard.setPreferredSize(butoonsize);
        hard.setForeground(Color.WHITE);
        butoonpanel.add(hard);

        hard.setOpaque(false);
        hard.setContentAreaFilled(false);
        hard.addActionListener(this);

        //panel.add(hardPanel);

        panel.add(butoonpanel);
        frame1.add(panel);
        frame1.pack();
        frame1.setVisible(true);
        frame1.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e){
       controller.transition();
    }

        public void disable(){
        frame1.setVisible(false);
        frame1.setEnabled(false);
        }

        public void enable(){
        panel.setVisible(true);
        panel.setEnabled(true);
        }
}