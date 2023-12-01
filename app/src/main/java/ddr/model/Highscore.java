package ddr.model;

import java.io.ObjectInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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

    public void saveHighScoresToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(highscores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialize the high scores from a file
    @SuppressWarnings("unchecked")
    public void loadHighScoresFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            highscores = (ArrayList<Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
