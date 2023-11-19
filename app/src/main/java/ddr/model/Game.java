package ddr.model;

import java.util.ArrayList;

import ddr.ClearType;
import ddr.gameObserver;

public class Game {
    int startingx; //positional stuff
    int startingy;
    int currentx;
    int currenty;
    
    int score; //things to keep track of for end screen
    int currCombo;
    int maxCombo;
    int hits; 
    int misses;

    
/*   ArrayList<JLabel> leftArrows; //array list of arrows for columns
    ArrayList<JLabel> downArrows;
    ArrayList<JLabel> upArrows;
    ArrayList<JLabel> rightArrows;
    */ 

    boolean flag; //flag for gameOver method
    ClearType clearType; //enum for clear type

    gameObserver game;

    public Game(){
        this.score = 100;
        this.currCombo = 0;
        this.maxCombo = 0;
        this.hits = 0;
        this.misses = 0;
       
/*         this.leftArrows = new ArrayList<JLabel>();
        this.downArrows = new ArrayList<JLabel>();
        this.upArrows = new ArrayList<JLabel>();
        this.rightArrows = new ArrayList<JLabel>();
        */ 

        

        this.flag = false;
    }


    public void save_start(int startx, int starty){
        startingx = startx;
        startingy = starty;
    }

    public void change_local(int startx, int starty){
        currentx = startx;
        currenty = starty;
    }

    public void hit(int col){
        this.hits++;
        this.currCombo++;
        this.score+= 10;
        this.notify_obvs();
        if (col == 1){
            if (leftArrows.size() !=0){
            leftArrows.remove(0);
            }
        }
        else if (col ==2){
            if (downArrows.size() !=0){
            downArrows.remove(0);
            }
        }
        else if (col ==3){
             if (upArrows.size() !=0){
            upArrows.remove(0);
            }           
        }
        else if (col ==4){
             if (rightArrows.size() !=0){
            rightArrows.remove(0);
            }           
        }
        
    }

    public void miss(){
        this.misses++;
        if (this.currCombo > this.maxCombo){
            this.maxCombo = this.currCombo;
        }
        this.currCombo = 0;
        this.score-= 10;
    }

    public boolean gameOver(){ 
        if(this.score < 0){
            this.flag = true; //gameOver is TRUE because LOSE (score < 0)
            System.out.println("u losT skill issue");
            this.clearType = ClearType.FAIL;
            return this.flag;
        }

        if (this.leftArrows.isEmpty() && this.downArrows.isEmpty() && this.upArrows.isEmpty() && this.rightArrows.isEmpty()) {
            this.flag = true; //gameOver is TRUE because WIN (no notes left)
            System.out.println("u cleared! ! yay!");
            this.clearType = ClearType.CLEAR;
            //can put return here as well
        }
        return this.flag;
    }

    public int getScore(){
        return this.score;
    }

    public int getHits(){
        return this.hits;
    }

    public int getMisses(){
        return this.misses;
    }

    public int getHighestCombo(){
        return this.maxCombo;
    }

    public void set_obvs(gameObserver gamer){
        game = gamer;
    }

    public void notify_obvs(){
        game.update();
    }

        public int getCurrentCombo(){
        return this.currCombo;
    }
}
