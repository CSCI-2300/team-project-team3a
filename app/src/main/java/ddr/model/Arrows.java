package ddr.model;

import javax.swing.JLabel;

public class Arrows {
    int health;
    int startingx;
    int startingy;
    int currentx;
    int currenty;
    JLabel [] leftarr, rightarr, uparr, downarr ;
    public Arrows(){
        health = 100;
    }

    public void lose_health(){
        health --;
    }

    public boolean check_health(){
        if (health <10){
            return false;
        }
        return true;
    }

    public void save_start(int startx, int starty){
        startingx = startx;
        startingy = starty;
    }

    public void change_local(int startx, int starty){
        currentx = startx;
        currenty = starty;
    }
}
