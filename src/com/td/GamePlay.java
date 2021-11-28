package com.td;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePlay extends JPanel {

    private ImageIcon titleImage;


    public GamePlay() {

    }

    public void paint(Graphics g) {

        //draw title image
        titleImage = new ImageIcon("./src/assets/title.png");
        titleImage.paintIcon(this, g, 25, 5);


        //draw border for gameplay
        g.setColor(Color.DARK_GRAY);
        g.drawRect(24, 74, 851, 577);

        //background for the gameplay
        g.setColor(Color.black);
        g.fillRect(25,75,850,575);

        g.dispose();
    }
}
