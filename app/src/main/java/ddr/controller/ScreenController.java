package ddr.controller;

import ddr.ScreenObserver;
import ddr.model.Game;
import ddr.view.GameplayGUI;
import ddr.view.MainGUI;
import ddr.view.ResultGUI;

public class ScreenController implements ScreenObserver {
    MainGUI main;
    GameplayGUI game;
    ResultGUI result;
    Game gameplay;
    public ScreenController(){
        main = new MainGUI(this);
        gameplay = new Game();
        game = new GameplayGUI(this,gameplay);
        gameplay.set_obvs(game);
        game.disable();
        result = new ResultGUI(gameplay,this);
        result.disable();

    }

    public void transition(){
        main.disable();
        game.enable();
        game.set_start();
    }

    public void press(int col){
        gameplay.hit(col);
    }

    public void miss(){
        gameplay.miss();
    }

    public void move(){
        game.disable();
        result.enable();
    }

    public void to_main(){
        result.disable();
        main.enable();
        System.out.println("hiii");
    }
    public void retry(){
       main.enable();
        result.disable();
        main.enable();
    }
}
