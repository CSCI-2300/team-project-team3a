package ddr.model;

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
    float hits; 
    float misses;

    boolean flag; //flag for gameOver method
    ClearType clearType; //enum for clear type

    gameObserver game;
    boolean check_flag;

    int [] difficulty = {10,80,100};
    int diff;

    public Game(){
        this.score = 100; // so game ends
        this.currCombo = 0;
        this.maxCombo = 0;
        this.hits = 0;
        this.misses = 0;


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

    public void hit(){
        this.hits++;
        this.currCombo++;
        this.score+= 10;
        this.notify_obvs();
        
    }

    public void miss(){
        this.misses++;
        if (this.currCombo > this.maxCombo){
            this.maxCombo = this.currCombo;
        }
        this.currCombo = 0;
        this.score-= 10;
        this.notify_obvs();
    }

    public boolean gameOver(){ 
        if(this.score < 0){
            this.flag = true; //gameOver is TRUE because LOSE (score < 0)
            System.out.println("u losT skill issue");
            this.clearType = ClearType.FAIL;
            return this.flag;
        }

        return this.flag;
    }
    public boolean check_hit(int col, int y){
        if(col == 1){
            if (y > 380 && y < 430){
                check_flag = true;
            }
            else{
                check_flag = false;
            }
        }
        return check_flag;
    }

    public int getScore(){
        System.out.println(score);
        return this.score;
    }

    public float getHits(){
        System.out.println(hits);
        return this.hits;
    }

    public float getMisses(){
        System.out.println(misses);
        return this.misses;
    }

    public int getHighestCombo(){
        System.out.println(maxCombo);
        return this.maxCombo;
    }

//returns what rank the user should get
    public int getRank()
    {
        int rank = 0;
        float ratio = (this.hits/(this.hits +this.misses))*100;
        if(this.score < 0)
        {
            rank = 5; // F rank
        } else {
            if(ratio >= 97)
            {
                rank = 0; // S rank
            } else if (ratio >= 90)
            {
                rank = 1; // A rank
            } else if (ratio >= 80)
            {
                rank = 2; // B rank
            } else if (ratio >= 70)
            {
                rank = 3; // C rank
            } else if (ratio < 70)
            {
                rank = 4; // D rank
            } 
        }
        return rank;
    }

    public ClearType getClearType(){
        return this.clearType;
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

    public void set_diff(int mode){
        diff = difficulty[mode];
        System.out.println(diff);
    }

    public void reset(){
        score = 100;
        currCombo = 0;
        maxCombo = 0;
        hits = 0;
        misses = 0;
        flag = false;
    }
    public int return_totalnotes(){
        return diff;
    }
}