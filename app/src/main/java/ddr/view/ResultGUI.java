package ddr.view;

import java.awt.*;
import javax.swing.*;

public class ResultGUI { //result screen after failing/finishing song
    private JFrame frame1;
    private JPanel scorePanel; // display results
    private JLabel clearType; //did player fail or clear?
    private JLabel labels;
    private JPanel buttonPanel; // display navigational buttons
    private JButton buttonRetry;
    private JButton buttonMain;

    public ResultGUI(){ //javaswing constructor
        JFrame frame3 = new JFrame("Results Screen");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        scorePanel = new JPanel(); //make the main panel
        scorePanel.setPreferredSize(new Dimension(700,500));
        scorePanel.setBackground(new Color(135, 206, 235));
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));

        //make top header of player clear result
        clearType = new JLabel("RESULT (SONG FAILED/SONG CLEARED)");
        clearType.setAlignmentX(Component.CENTER_ALIGNMENT);
        scorePanel.add(clearType);

        //make score, good, miss counters
        String[] counts = {"Score: 327928", "Good: 7398", "Miss: 21"}; //hardcoded
        for(int i = 0; i < counts.length; i++){
            labels = new JLabel(counts[i]);
            labels.setAlignmentX(Component.CENTER_ALIGNMENT);
            scorePanel.add(labels);
        }

        //adding buttons now
        buttonPanel = new JPanel(); //make navigational buttons panel
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        buttonRetry = new JButton("Play Again");
        buttonRetry.setPreferredSize(new Dimension(100,50));
        buttonPanel.add(buttonRetry);

        buttonMain = new JButton("Main Menu");
        buttonMain.setPreferredSize(new Dimension(100,50));
        buttonPanel.add(buttonMain);

        //final adding stuff
        scorePanel.add(buttonPanel);
        frame3.add(scorePanel);
        frame3.pack();
        frame3.setVisible(true);
    }
}
