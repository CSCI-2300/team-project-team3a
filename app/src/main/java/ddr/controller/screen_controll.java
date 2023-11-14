package ddr.controller;

import ddr.screen_obvs;
import ddr.view.GameplayGUI;
import ddr.view.MainGUI;
import ddr.view.ResultGUI;

public class screen_controll implements screen_obvs {
    MainGUI main;
    GameplayGUI game;
    ResultGUI result;
    public screen_controll(){
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
