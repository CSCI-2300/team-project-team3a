package ddr.model;

public class Arrows {
    int health;
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
}
