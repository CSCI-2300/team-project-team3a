package ddr.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Arrow extends JLabel {
    boolean hit_flag;
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
}
