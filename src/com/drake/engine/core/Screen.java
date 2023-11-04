package com.drake.engine.core;

import com.drake.engine.math.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Screen extends JPanel implements MouseListener, KeyListener {

    public static int[][] pixels;

    private int sx;
    private int sy;
    private int color;

    int pixelCount_x;
    int pixelCount_y;

    public Screen(int sizex, int sizey, int defColor){
        sx = sizex;
        sy = sizey;
        color = defColor;

        pixelCount_x = sizex/8;
        pixelCount_y = sizey/8;

        pixels = new int[pixelCount_x][pixelCount_y];
        for(int x = 0; x < pixelCount_x; x++){
            for(int y = 0; y < pixelCount_y; y++){
                pixels[x][y] = defColor;
            }
        }
    }

    public static void setPixel(Vector2 pos, int color){
        pixels[pos.x][pos.y] = color;
    }
    public static void setPixel(Vector2 pos, int rgb, int a){
        pixels[pos.x][pos.y] = rgb;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i < pixelCount_x; i++) {
            for(int j = 0; j < pixelCount_y; j++) {
                int co = pixels[i][j];
                CreatePixel(new Vector2(i,j), g, new Color(co,co,co,255));
            }
        }
    }

    public void CreatePixel(Vector2 pos, Graphics g, Color c){
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                g.setColor(c);
                g.fillRect(x + (pos.x*8), y + (pos.y*8),1,1);
            }
        }
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
