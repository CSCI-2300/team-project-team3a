package ddr.view;

import java.awt.*;

import javax.swing.*;

public class ImagePanel extends JPanel {
    private ImageIcon backgroundImage;

    public ImagePanel(ImageIcon backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            backgroundImage.paintIcon(this, g, 0, 0);
        }
    }
}
