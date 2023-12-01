package ddr.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Highscore implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Integer> highscores;

    public Highscore() {
        this.highscores = loadHighScoresFromFile("highscores.ser"); 
        initializeDefaultHighScores(); 
    }

    private void initializeDefaultHighScores() {
        if (highscores.isEmpty()) {
            highscores.add(0);
            highscores.add(0);
            highscores.add(0);
        }
    }

    public boolean isNewHighscore(int newScore) {
        return newScore > Collections.min(highscores);
    }

    public void addHighscore(int newScore) {
        if (isNewHighscore(newScore)) {
            highscores.remove(Collections.min(highscores));
            highscores.add(newScore);
            Collections.sort(highscores, Collections.reverseOrder());
            saveHighScoresToFile("highscores.ser"); // Save high scores after updating
        }
    }

    public ArrayList<Integer> getHighscores() {
        return new ArrayList<>(highscores);
    }

    public void saveHighScoresToFile(String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(highscores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Integer> loadHighScoresFromFile(String filename) {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (ArrayList<Integer>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(); 
    }
}
