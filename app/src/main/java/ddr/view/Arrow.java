package ddr.view;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Arrow extends JLabel {
    boolean hit_flag;
    Point location;
    public Arrow(){
        hit_flag = false;
    }

    public Arrow(ImageIcon image){
        hit_flag = false;
        this.setIcon(image);
    }


    public void set_flag(){
        hit_flag = true;
    }

    public boolean check_flag(){
        return hit_flag;
    }

    public void store_local(){
    location = this.getLocation(); 
    }

    public Point getPoint(){
    return location;
    }

}

