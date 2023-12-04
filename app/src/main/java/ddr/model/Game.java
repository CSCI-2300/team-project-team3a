package ddr.model;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import ddr.ClearType;
import ddr.gameObserver;

public class Game {
    
    private int score; //things to keep track of for end screen
    private int currCombo;
    private int maxCombo;
    private float hits; 
    private float misses;

    private boolean flag; //flag for gameOver method
    private ClearType clearType; //enum for clear type

    private gameObserver game;
    private boolean check_flag;

    //int [] difficulty = {1000,500,250}; //windows
    int [] difficulty = {2000,1000,750}; //mac
    public  int diff;

    public ArrayList<String> sounds;

    public Game(){
        this.score = 100; // so game ends
        this.currCombo = 0;
        this.maxCombo = 0;
        this.hits = 0;
        this.misses = 0;
        this.flag = false;

        sounds = new ArrayList<String>();
        sounds.add("wawaFail.wav");
        sounds.add("robloxClear.wav");
    }

    public void hit(){
        this.hits++;
        this.currCombo++;
        this.maxCombo++;
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

    public boolean lost(){ 
        if(this.score < 0){
            this.flag = true; //gameOver is TRUE because LOSE (score < 0)
            this.clearType = ClearType.FAIL;
            //noise = sounds[0];
            playSelectNoise(sounds.get(0));
            return this.flag;
        }

        return this.flag;
    }

    public boolean won(){
        this.clearType = ClearType.CLEAR;
        if (this.clearType == ClearType.CLEAR){
            playSelectNoise(sounds.get(1));
            return true;
        }
        return true;
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
        return this.score;
    }

    public float getHits(){
        return this.hits;
    }

    public float getMisses(){
        return this.misses;
    }

    public int getHighestCombo(){
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

    public int return_speed(){
        System.out.println(diff);
        return diff;

    }

    //sound effects
    public void playSelectNoise(String string)
    {
        try 
        {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(string);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
            DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);
            clip.start();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }
}
