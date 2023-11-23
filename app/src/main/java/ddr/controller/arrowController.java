package ddr.controller;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.event.*;
import ddr.view.GameplayGUI;


public class arrowController implements ActionListener {
  ArrayList<JLabel> leftArrows; //array list of arrows for columns
    ArrayList<JLabel> downArrows;
    ArrayList<JLabel> upArrows;
    ArrayList<JLabel> rightArrows;
    GameplayGUI game;

    private Timer leftTimer, downTimer, upTimer, rightTimer;   

    public arrowController(GameplayGUI game){
        
        int stepSize =2;
        this.game = game;
        leftArrows = new ArrayList<JLabel>();
        leftTimer = new Timer(40, new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                for (int i= 0; i< leftArrows.size();i++)
                {
                    leftArrows.get(i).setLocation(leftArrows.get(i).getX(), leftArrows.get(i).getY() + stepSize);
                }
            }
        });


        downTimer = new Timer(40, new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                for (int i= 0; i< downArrows.size();i++)
                {
                    downArrows.get(i).setLocation(downArrows.get(i).getX(), downArrows.get(i).getY() + stepSize);
                }
            }
        });

        upTimer = new Timer(60, new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                    for (int i= 0; i< upArrows.size();i++)
                    {
                        upArrows.get(i).setLocation(upArrows.get(i).getX(), upArrows.get(i).getY() + stepSize);
                    }
                }
        });
            
        

        rightTimer = new Timer(80, new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                for (int i= 0; i< rightArrows.size();i++)
                {
                    rightArrows.get(i).setLocation(rightArrows.get(i).getX(), rightArrows.get(i).getY() + stepSize);
                }
            }
        });


            rightTimer.start();
            leftTimer.start();
            upTimer.start();
            downTimer.start();

    }

    public void actionPerformed(ActionEvent e){
        
    }
}
