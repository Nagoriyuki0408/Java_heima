package com.shiokou.HM.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(String imagePath) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(imagePath);
            if (inputStream != null) {
                image = ImageIO.read(inputStream);
            } else {
                System.err.println("找不到图片: " + imagePath);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}