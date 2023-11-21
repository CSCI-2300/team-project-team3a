package ddr.view;

import ddr.model.Game;
import java.awt.*;
import javax.swing.*;


public class ResultGUI { //result screen after failing/finishing song
    private JPanel scorePanel; // display results
    private JLabel clearType; //did player fail or clear?
    private JLabel labels;
    private JPanel buttonPanel; // display navigational buttons
    private JButton buttonRetry;
    private JButton buttonMain;
    private ImageIcon backs;
    private JFrame frame3;
    private Game resultsGame;

    public ResultGUI(Game gamer){ //javaswing constructor
        frame3 = new JFrame("Results Screen");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultsGame = gamer;
        
        backs = new ImageIcon(getClass().getClassLoader().getResource("game_background.png"));
        scorePanel = new ImagePanel(backs);
        scorePanel.setPreferredSize(new Dimension(700,500));
        scorePanel.setOpaque(false);
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));

        //make top header of player clear result
        clearType = new JLabel("RESULT (SONG FAILED/SONG CLEARED)");
        clearType.setForeground(Color.WHITE);
        clearType.setAlignmentX(Component.CENTER_ALIGNMENT);
        scorePanel.add(clearType);

        //make score, good, miss counters
        String[] counts = {"Score: 327928", "Good: 7398", "Miss:" + resultsGame.getMisses()}; //hardcoded
        for(int i = 0; i < counts.length; i++){
            labels = new JLabel(counts[i]);
            labels.setAlignmentX(Component.CENTER_ALIGNMENT);
            labels.setForeground(Color.WHITE);
            scorePanel.add(labels);
        }

        //adding buttons now
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0)); //make navigational buttons panel
        buttonPanel.setOpaque(false);

        buttonRetry = new JButton("Play Again");
        buttonRetry.setPreferredSize(new Dimension(100,50));
        buttonRetry.setForeground(Color.WHITE);
        buttonRetry.setOpaque(false);
        buttonRetry.setContentAreaFilled(false);
 
        buttonPanel.add(buttonRetry);

        buttonMain = new JButton("Main Menu");
        buttonPanel.add(buttonMain);
        buttonMain.setForeground(Color.white);
        buttonMain.setOpaque(false);
        buttonMain.setContentAreaFilled(false);

        buttonMain.setPreferredSize(new Dimension(100,50));

        //final adding stuff
        scorePanel.add(buttonPanel);
        frame3.add(scorePanel);
        frame3.pack();
        frame3.setResizable(false);
        frame3.setVisible(true);
    }

        public void disable(){
        frame3.setVisible(false);
        frame3.setEnabled(false);
        }

        public void enable(){
        frame3.setVisible(true);
        frame3.setEnabled(true);
        }
}
