package ddr.controller;

import ddr.ScreenObserver;
import ddr.view.GameplayGUI;
import ddr.view.MainGUI;
import ddr.view.ResultGUI;

public class ScreenController implements ScreenObserver {
    MainGUI main;
    GameplayGUI game;
    ResultGUI result;
    public ScreenController(){
        main = new MainGUI(this);
        game = new GameplayGUI();
        game.disable();
        result = new ResultGUI();
        result.disable();

    }

    public void transition(){
        main.disable();
        game.enable();
    }
}
