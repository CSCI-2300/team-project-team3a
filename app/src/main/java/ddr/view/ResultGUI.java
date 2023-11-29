package ddr.view;

import ddr.ClearType;
import ddr.controller.ScreenController;
import ddr.model.Game;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class ResultGUI implements ActionListener{ //result screen after failing/finishing song
    private JPanel scorePanel; // display results
    private JLabel clearType; //did player fail or clear?
    private JLabel labels;
    private JPanel buttonPanel; // display navigational buttons
    private JButton buttonRetry;
    private JButton buttonMain;
    private ImageIcon backs;
    private JFrame frame3;
    private Game resultsGame;

    private ImageIcon rank;
    private JLabel scoreLabel;
    private JLabel comboLabel;
    private JLabel goodLabel;
    private JLabel missLabel;

    ScreenController controll;

    ImageIcon deets;
    ImageIcon letter;
    ArrayList<String> ranks;

    private JLabel rankLabel;

    public ResultGUI(Game gamer, ScreenController controll){ //javaswing constructor
        frame3 = new JFrame("Results Screen");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backs = new ImageIcon(getClass().getClassLoader().getResource("game_background.png"));
        scorePanel = new ImagePanel(backs);
        resultsGame = gamer;
        this.controll = controll;

        //center the details png
        scorePanel.setPreferredSize(new Dimension(700,500));
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setOpaque(false);
        JPanel rankPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        rankPane.setOpaque(false);

        deets = new ImageIcon(getClass().getClassLoader().getResource("ddrscore.png"));
        Image image = deets.getImage().getScaledInstance(398, 253, Image.SCALE_DEFAULT);
        deets.setImage(image);
        JLabel noMore = new JLabel(deets);
        detailsPanel.setPreferredSize(new Dimension(400, 333));

        //overlay layout
        JPanel overPanel = new JPanel();
        overPanel.setLayout(new OverlayLayout(overPanel));
        overPanel.setOpaque(false);

        //adding number labels
        scoreLabel = new JLabel(Integer.toString(gamer.getScore()));
        scoreLabel.setForeground(Color.RED);
        comboLabel = new JLabel(Integer.toString(gamer.getHighestCombo()));
        goodLabel = new JLabel(Integer.toString((int)gamer.getHits()));
        missLabel = new JLabel(Integer.toString((int)gamer.getMisses()));

        overPanel.add(detailsPanel);

        detailsPanel.setLayout(null);
    
        //numb label moving
        scoreLabel.setBounds(250, 60, 50, 50);
        scoreLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
        detailsPanel.add(scoreLabel);
        comboLabel.setBounds(250, 105, 50, 50);
        comboLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
        detailsPanel.add(comboLabel);
        goodLabel.setBounds(250, 153, 50, 50);
        goodLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
        detailsPanel.add(goodLabel);
        missLabel.setBounds(250, 200, 50, 50);
        missLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
        detailsPanel.add(missLabel);

        overPanel.add(noMore);

        //scorePanel.add(deetsPane);
        //adding the images to a arraylist
        ranks = new ArrayList<String>();
        ranks.add("rankingS.png");
        ranks.add("rankingA.png");
        ranks.add("rankingB.png");
        ranks.add("rankingC.png");
        ranks.add("rankingD.png");

//this is where we should change the ranks.get index to specific rank 
        rank = new ImageIcon(getClass().getClassLoader().getResource(ranks.get(0)));
        Image letter = rank.getImage().getScaledInstance(92, 96, Image.SCALE_DEFAULT);
        rank.setImage(letter);
        rankLabel = new JLabel(rank);
        rankPane.setPreferredSize(new Dimension(92,96));
        rankPane.add(rankLabel);

        scorePanel.add(rankPane);
        scorePanel.add(overPanel);

        // scorePanel.setOpaque(false);

        // scoreIcon = new ImageIcon(getClass().getClassLoader().getResource("ddrscore.png"));
        // detailsPanel = new ImagePanel(scoreIcon);
        // detailsPanel.setOpaque(false);
        // scorePanel.add(detailsPanel);

        //make top header of player clear result
 /*        clearType = new JLabel("RESULT (SONG FAILED/SONG CLEARED)");
        clearType.setForeground(Color.WHITE);
        clearType.setAlignmentX(Component.CENTER_ALIGNMENT);
        scorePanel.add(clearType);

        //make score, good, miss counters
        String[] counts = {"Score: " + resultsGame.getScore(), "Good: " + resultsGame.getHits(), "Miss:" + resultsGame.getMisses()}; //hardcoded
        for(int i = 0; i < counts.length; i++){
            labels = new JLabel(counts[i]);
            labels.setAlignmentX(Component.CENTER_ALIGNMENT);
            labels.setForeground(Color.WHITE);
            scorePanel.add(labels);
        } 
        */

        //adding buttons now
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,40,50)); //make navigational buttons panel
        buttonPanel.setOpaque(false);

        buttonRetry = new JButton("Play Again");
        buttonRetry.setPreferredSize(new Dimension(100,50));
        buttonRetry.setForeground(Color.WHITE);
        buttonRetry.setOpaque(false);
        buttonRetry.setContentAreaFilled(false);
        buttonRetry.addActionListener(this);
        buttonPanel.add(buttonRetry);

        buttonMain = new JButton("Main Menu");
        buttonPanel.add(buttonMain);
        buttonMain.setForeground(Color.white);
        buttonMain.setOpaque(false);
        buttonMain.setContentAreaFilled(false);
        buttonMain.addActionListener(this);

        buttonMain.setPreferredSize(new Dimension(100,50));

        //final adding stuff
        scorePanel.add(buttonPanel);
        frame3.add(scorePanel);
        frame3.pack();
        frame3.setResizable(false);
        frame3.setVisible(true);
    }

    public void setRank()
    {
        rank = new ImageIcon(getClass().getClassLoader().getResource(ranks.get(controll.rank())));
        rankLabel.setIcon(rank);
    }


    public void disable(){
        frame3.setVisible(false);
        frame3.setEnabled(false);
    }

    public void enable(){
        frame3.setVisible(true);
        frame3.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == buttonMain){
            controll.to_main();
        }
        if(e.getSource() == buttonRetry){
            controll.retry();
        }
    }
}
