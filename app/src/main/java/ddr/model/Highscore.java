package ddr.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Highscore implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Integer> highscores;

    public Highscore() {
        this.highscores = new ArrayList<>();
        initializeDefaultHighScores(); 
    }

    private void initializeDefaultHighScores() {
        highscores.add(100);
        highscores.add(90);
        highscores.add(80);
    }

    public boolean isNewHighscore(int newScore) {
        return newScore > Collections.min(highscores);
    }

    public void addHighscore(int newScore) {
        if (isNewHighscore(newScore)) {
            highscores.remove(Collections.min(highscores));
            highscores.add(newScore);
            Collections.sort(highscores, Collections.reverseOrder());
        }
    }

    public ArrayList<Integer> getHighscores() {
        return new ArrayList<>(highscores);
    }

    //i don't think i need this
    public void displayHighscores() {
        System.out.println("High Scores:");
        for (int i = 0; i < highscores.size(); i++) {
            System.out.println((i + 1) + ". " + highscores.get(i));
        }
    }

    private void saveHighScoreToFile() 
    {
        try 
        {
            FileOutputStream fileOut = new FileOutputStream("high_score.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(highscore);
            out.close();
            fileOut.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    private int readHighScoreFromFile() 
    {
        int highScore = 0;
        try 
        {
            FileInputStream fileIn = new FileInputStream("high_score.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            highScore = (int) in.readObject();
            in.close();
            fileIn.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
        return highScore;
    }
}
