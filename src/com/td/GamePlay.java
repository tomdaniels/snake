package com.td;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private final int [] snakeXlength = new int[750];
    private final int [] snakeYlength = new int[750];

    private byte snakeLength = 3;

    private boolean left, right, up ,down = false;

    private final Timer timer;
    private final int delay = 100;

    private int moves = 0;
    private int score = 0;

    private final int [] fruitXpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,250,375,400,425,450,475,500,525,550,575,600,
            625,650,675,700,725,750,775,800,825,850};

    private final int [] fruitYpos = {75,100,125,150,175,200,225,250,275,300,325,250,375,400,425,450,475,500,525,550,575,600,
            625};

    private final Random random = new Random();
    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);

    public GamePlay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {

        ImageIcon titleImage, headRight, headLeft, headDown, headUp, tail, fruitImage;


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
            fruitImage = new ImageIcon("./src/assets/fruit.png");

            if (fruitXpos[xpos] == snakeXlength[0] && fruitYpos[ypos] == snakeYlength[0]) {
                score += 5;
                snakeLength++;
                xpos = random.nextInt(34);
                ypos = random.nextInt(23);
            }

            fruitImage.paintIcon(this, g, fruitXpos[xpos], fruitYpos[ypos]);
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.restart();

        if(right)
        {
            for(int n = snakeLength-1; n>=0;n--)
            {
                snakeYlength[n+1] = snakeYlength[n];
            }
            for(int n = snakeLength; n>=0; n--)
            {
                if (n==0)
                {
                    snakeXlength[n] = snakeXlength[n]+25;
                }
                else
                {
                    snakeXlength[n] = snakeXlength[n-1];
                }
                if(snakeXlength[n] >850)
                {
                    snakeXlength[n] = 25;
                }

            }
            repaint();
        }

        if(left)
        {
            for(int n = snakeLength-1; n>=0;n--)
            {
                snakeYlength[n+1] = snakeYlength[n];
            }
            for(int n = snakeLength; n>=0; n--)
            {
                if (n==0)
                {
                    snakeXlength[n] = snakeXlength[n]-25;
                }
                else
                {
                    snakeXlength[n] = snakeXlength[n-1];
                }
                if(snakeXlength[n] < 25)
                {
                    snakeXlength[n] = 850;
                }

            }
            repaint();

        }
        if(up)
        {
            for(int n = snakeLength-1; n>=0;n--)
            {
                snakeXlength[n+1] = snakeXlength[n];
            }
            for(int n = snakeLength; n>=0; n--)
            {
                if (n==0)
                {
                    snakeYlength[n] = snakeYlength[n]-25;
                }
                else
                {
                    snakeYlength[n] = snakeYlength[n-1];
                }
                if(snakeYlength[n] < 75)
                {
                    snakeYlength[n] = 625;
                }

            }
            repaint();

        }
        if(down)
        {
            for(int n = snakeLength-1; n>=0;n--)
            {
                snakeXlength[n+1] = snakeXlength[n];
            }
            for(int n = snakeLength; n>=0; n--)
            {
                if (n==0)
                {
                    snakeYlength[n] = snakeYlength[n]+25;
                }
                else
                {
                    snakeYlength[n] = snakeYlength[n-1];
                }
                if(snakeYlength[n] > 625)
                {
                    snakeYlength[n] = 75;
                }

            }

            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moves++;

            if (!left) {
                right = true;
            } else {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moves++;

            if (!right) {
                left = true;
            } else {
                left = false;
                right = true;
            }
            up = false;
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moves++;

            if (!down) {
                up = true;
            } else {
                up = false;
                down = true;
            }
            left = false;
            right = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moves++;

            if (!up) {
                down = true;
            } else {
                down = false;
                up = true;
            }
            left = false;
            right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
