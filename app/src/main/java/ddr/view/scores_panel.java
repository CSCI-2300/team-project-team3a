package ddr.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class scores_panel extends JPanel {
    JLabel comboJLabel;
    JLabel scoreLabel;
    JLabel missJLabel;
    int score;
    int combo;

    public scores_panel() {
        setLayout(new GridLayout(2, 1,0,5));
        setPreferredSize(new Dimension(200, 150));


        score = 0;
        combo = 0;
        scoreLabel = new JLabel(score +" score");
        comboJLabel = new JLabel(combo + " combo");


        Font scoreFont = new Font("Arial", Font.PLAIN, 20);
        scoreLabel.setFont(scoreFont);

        Font comboFont = new Font("Arial", Font.PLAIN, 50);
        comboJLabel.setFont(comboFont);

        add(scoreLabel);
        add(comboJLabel);

        setOpaque(false);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setOpaque(false);
        comboJLabel.setForeground(Color.WHITE);
        comboJLabel.setOpaque(false);
    }

    public void score_update(int num){
        score = num;
        scoreLabel.setText(score + " score");

    }
    public void combo_update(int num){
        combo = num;
        comboJLabel.setText(combo + " combo");
    }

}


