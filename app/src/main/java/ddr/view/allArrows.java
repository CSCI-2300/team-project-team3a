package ddr.view;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class allArrows {
    public ArrayList<Arrow> left_col;
    public ArrayList<Arrow> up_col;
    public ArrayList<Arrow> down_col;
    public ArrayList<Arrow> right_col;
    int currentNotes;
    int mode;

    ImageIcon leftIcon;
    ImageIcon downIcon;
    ImageIcon upIcon;
    ImageIcon rightIcon;

    public allArrows(int modes) {

        left_col = new ArrayList<>();
        up_col = new ArrayList<>();
        down_col = new ArrayList<>();
        right_col = new ArrayList<>();
        mode = modes;
        leftIcon = new ImageIcon(getClass().getClassLoader().getResource("left.gif"));
        downIcon = new ImageIcon(getClass().getClassLoader().getResource("down.gif"));
        upIcon = new ImageIcon(getClass().getClassLoader().getResource("up.gif"));
        rightIcon = new ImageIcon(getClass().getClassLoader().getResource("right.gif"));
    }

    public void addArrow(int col){
        if(col == 1){
            left_col.add(new Arrow(leftIcon));
        }
        else if(col == 3){
            up_col.add(new Arrow(upIcon));
        }
        else if(col == 2){
            down_col.add(new Arrow(downIcon));
        }
        else if(col == 4){
            right_col.add(new Arrow(rightIcon));
        }
    }

    public void removeArrow(int col) {
        if (col == 1 && !left_col.isEmpty()) {
            left_col.remove(0);
        } else if (col == 3 && !up_col.isEmpty()) {
            up_col.remove(0);
        } else if (col == 2 && !down_col.isEmpty()) {
            down_col.remove(0);
        } else if (col == 4 && !right_col.isEmpty()) {
            right_col.remove(0);
        }
    }
    

    public Arrow getArrow(int col) {
        if (col == 1) {
            if (!left_col.isEmpty()) {
                return left_col.get(0);
                
            }
        } else if (col == 3) {
            if (!up_col.isEmpty()) {
                return up_col.get(0);
            }
        } else if (col == 2) {
            if (!down_col.isEmpty()) {
                return down_col.get(0);
            }
        } else if (col == 4) {
            if (!right_col.isEmpty()) {
                return right_col.get(0);
            }
        }
        //return null if the specified list is empty or the column is invalid
        return null;
    }

    public int ArrLength(int col) {
        if (col == 1) {
            return left_col.size();
        } else if (col == 3) {
            return up_col.size();
        } else if (col == 2) {
            return down_col.size();
        } else if (col == 4) {
            return right_col.size();
        }
        return 0; //return 0 if the column is invalid
    }
    
}
