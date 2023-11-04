package ddr.view;
import java.awt.*;
import javax.swing.*;

public class MainGUI {
    JFrame frame1;
    JPanel panel;

    public MainGUI() {
        frame1 = new JFrame("Main Menu");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new GridLayout(5, 1));
        panel.setPreferredSize(new Dimension(700,500));
        panel.setBackground(Color.CYAN);
        Dimension butoonsize = new Dimension(100,50);
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(Color.CYAN);
        JLabel title = new JLabel("Dane Dance Revolution!");
        titlePanel.add(title);
        //JLabel modes = new JLabel("Modes:");
        panel.add(titlePanel);
        //panel.add(modes);

        JPanel butoonpanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
        butoonpanel.setBackground(Color.CYAN);

        JButton easy = new JButton("easy");
        butoonpanel.add(easy);
        easy.setPreferredSize(butoonsize);
        //panel.add(easyPanel);

        JButton medium = new JButton("medium");
        medium.setPreferredSize(butoonsize);
         butoonpanel.add(medium);
            //panel.add(mediumPanel);

        JButton hard = new JButton("hard");
        hard.setPreferredSize(butoonsize);
         butoonpanel.add(hard);
        //panel.add(hardPanel);

        panel.add(butoonpanel);
        frame1.add(panel);
        frame1.pack();
        frame1.setVisible(true);
    }
}