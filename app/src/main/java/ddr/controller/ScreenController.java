package ddr.controller;

import ddr.ScreenObserver;
import ddr.model.Game;
import ddr.model.Highscore;
import ddr.view.GameplayGUI;
import ddr.view.MainGUI;
import ddr.view.ResultGUI;

public class ScreenController implements ScreenObserver {
    MainGUI main;
    GameplayGUI game;
    ResultGUI result;
    Game gameplay;
    Highscore highscore;

    public ScreenController() {
        this.main = new MainGUI(this);
        this.gameplay = new Game();
        this.game = new GameplayGUI(this, gameplay);
        this.gameplay.set_obvs(game);
        this.game.disable();
        this.result = new ResultGUI(gameplay, this);
        this.result.disable();
        this.highscore = new Highscore();
    }

    public void transition(int mode) {
        main.disable();
        game.enable();
        game.set_start();
        gameplay.set_diff(mode);
        game.game_start();
    }

    public void press(int col) {
        gameplay.hit(col);
    }

    public void miss() {
        gameplay.miss();
    }

    public void to_main() {
        main.enable();
        result.disable();
        main.updateHighScores();
        System.out.println("hiii");
    }

    public void retry() {
        game.enable();
        result.disable();
    }

    public int rank() {
        return gameplay.getRank();
    }

    public void startGame() {
        game.game_start();
        highscore.addHighscore(gameplay.getScore());
    }

    public void endGame() {
        result.enable();
        main.disable();
        game.disable();

        highscore.addHighscore(gameplay.getScore());
        highscore.saveHighScoresToFile("highscores.ser");
        // Update the labels with the new game results
        result.updateScoreLabel(gameplay.getScore());
        result.updateComboLabel(gameplay.getHighestCombo());
        result.updateGoodLabel(gameplay.getHits());
        result.updateMissLabel(gameplay.getMisses());
        result.setRank();
    }
}
