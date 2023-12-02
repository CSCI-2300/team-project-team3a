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
    private JLabel clearLabel;

    ScreenController controll;

    ImageIcon scorepng;
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
        JPanel rankPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        rankPanel.setOpaque(false);

        scorepng = new ImageIcon(getClass().getClassLoader().getResource("ddrscore.png"));
        Image image = scorepng.getImage().getScaledInstance(398, 253, Image.SCALE_DEFAULT);
        scorepng.setImage(image);
        JLabel noMore = new JLabel(scorepng);
        detailsPanel.setPreferredSize(new Dimension(400, 333));

        //overlay layout
        JPanel overPanel = new JPanel();
        overPanel.setLayout(new OverlayLayout(overPanel));
        overPanel.setOpaque(false);

        //adding number labels
        scoreLabel = new JLabel(Integer.toString(resultsGame.getScore()));
        scoreLabel.setForeground(Color.WHITE);
        comboLabel = new JLabel(Integer.toString(resultsGame.getHighestCombo()));
        comboLabel.setForeground(Color.BLACK);
        goodLabel = new JLabel(Integer.toString((int)resultsGame.getHits()));
        goodLabel.setForeground(Color.BLUE);
        missLabel = new JLabel(Integer.toString((int)resultsGame.getMisses()));
        missLabel.setForeground(Color.RED);
        clearLabel = new JLabel("CLEAR");
        clearLabel.setForeground(Color.WHITE);

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
        clearLabel.setBounds(250, 244, 200, 50);
        clearLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
        detailsPanel.add(clearLabel);

        overPanel.add(noMore);

        //scorePanel.add(deetsPane);
        //adding the images to a arraylist
        ranks = new ArrayList<String>();
        ranks.add("rankingS.png");
        ranks.add("rankingA.png");
        ranks.add("rankingB.png");
        ranks.add("rankingC.png");
        ranks.add("rankingD.png");
        ranks.add("rankingF.png");

//this is where we should change the ranks.get index to specific rank 
        rank = new ImageIcon(getClass().getClassLoader().getResource(ranks.get(0)));
        Image letter = rank.getImage().getScaledInstance(92, 96, Image.SCALE_DEFAULT);
        rank.setImage(letter);
        rankLabel = new JLabel(rank);
        rankPanel.setPreferredSize(new Dimension(92,96));
        rankPanel.add(rankLabel);

        scorePanel.add(rankPanel);
        scorePanel.add(overPanel);

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

    public void updateScoreLabel(int newScore) {
        scoreLabel.setText(Integer.toString(newScore));
    }

    public void updateComboLabel(int newCombo) {
        comboLabel.setText(Integer.toString(newCombo));
    }

    public void updateGoodLabel(float newHits) {
        goodLabel.setText(Integer.toString((int) newHits));
    }

    public void updateMissLabel(float newMisses) {
        missLabel.setText(Integer.toString((int) newMisses));
    }

    public void updateClearLabel(ClearType c) {
        if (c == ClearType.CLEAR){
            clearLabel.setText("CLEAR!");
        }
        if (c == ClearType.FAIL){
            clearLabel.setText("FAIL . . .");
        }
    }

    public void setRank() {
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
