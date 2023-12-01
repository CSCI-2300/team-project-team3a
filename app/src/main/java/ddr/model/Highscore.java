package ddr.model;

import java.util.ArrayList;
import java.util.Collections;

public class Highscore {
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
}
