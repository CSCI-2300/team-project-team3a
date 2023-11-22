package ddr.view;

import javax.swing.JLabel;
import ddr.model.Game;

public class ScoresLabel extends JLabel
{
    private Game game;

    public ScoresLabel(Game game) 
    {
        this.game = game;
        int screenWidth = 640;
        int labelWidth = 300;
        int labelX = (screenWidth / 2) - (labelWidth / 2);
        this.setBounds(labelX - 40, 10, labelWidth, 30);
        setText("Score: " + 0 + "  " + "  High Score: " + 0);
        //setFont(new Font("Monospaced", Font.PLAIN, 15));
        //setForeground(Color.WHITE);
    }


    public void updateScore(int score)
    {
        setText("Score: " + 3 +"  " + "  High Score: " + 3);
        //setFont(new Font("Monospaced", Font.PLAIN, 15));
    }
}
