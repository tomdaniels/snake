package com.td;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private ImageIcon titleImage, headRight, headLeft, headDown, headUp, tail;

    private int [] snakeXlength = new int[750];
    private int [] snakeYlength = new int[750];

    private byte snakeLength = 3;

    private boolean left, right, up ,down = false;

    private Timer timer;
    private int delay = 100;

    private int moves = 0;
    private int score = 0;

    public GamePlay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        Timer timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {

        if (moves == 0) {
            snakeXlength[0] = 100;
            snakeXlength[1] = 75;
            snakeXlength[2] = 50;

            snakeYlength[0] = 100;
            snakeYlength[1] = 100;
            snakeYlength[2] = 100;
        }

        titleImage = new ImageIcon("./src/assets/title.png");
        titleImage.paintIcon(this, g, 25, 5);

        // border
        g.setColor(Color.DARK_GRAY);
        g.drawRect(24, 74, 851, 577);

        //background
        g.setColor(Color.black);
        g.fillRect(25,75,850,575);

        headRight = new ImageIcon("./src/assets/headRight.png");
        headRight.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);

        for (int i = 0; i < snakeLength; i++) {
            if (i==0 && right) {
                headRight = new ImageIcon("./src/assets/headRight.png");
                headRight.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            if (i==0 && left) {
                headLeft = new ImageIcon("./src/assets/headLeft.png");
                headLeft.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            if (i==0 && up) {
                headUp = new ImageIcon("./src/assets/headUp.png");
                headUp.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            if (i==0 && down) {
                headDown = new ImageIcon("./src/assets/headDown.png");
                headDown.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }

            if (i != 0) {
                tail = new ImageIcon("./src/assets/tail.png");
                tail.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
