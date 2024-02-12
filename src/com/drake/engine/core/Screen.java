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

    public static int[][] ScreenBuffer;
    public static int[][] pixels;
    static Engine engine;

    public static int pixelCount_x;
    public static int pixelCount_y;


    /**
     * @param sizex size x of the screen
     * @param sizey size y of the screen
     * @param defColor the default color of the background
     */
    public Screen(int sizex, int sizey, int defColor){
        addKeyListener(this);
        requestFocus();

        pixelCount_x = sizex/8;
        pixelCount_y = sizey/8;

        pixels = new int[pixelCount_x][pixelCount_y];
        ScreenBuffer = new int[pixelCount_x][pixelCount_y];
        for(int x = 0; x < pixelCount_x; x++){
            for(int y = 0; y < pixelCount_y; y++){
                pixels[x][y] = defColor;
                ScreenBuffer[x][y] = defColor;
            }
        }
    }


    /**
     * @param pos position to place pixel
     * @param color color of the pixel
     */
    public static void setPixel(Vector2 pos, int color){
        ScreenBuffer[pos.x][pos.y] = color;
    }

    /**
     * @param pos position of the pixel
     * @param rgb rgb value of the pixel
     * @param a alpha of the pixel
     */
    public static void setPixel(Vector2 pos, int rgb, int a){
        ScreenBuffer[pos.x][pos.y] = rgb;
    }

    /**
     * @return returns the amount of pixels in x and y
     */
    public static Vector2 getPixelCount(){
        return new Vector2(pixelCount_x, pixelCount_y);
    }

    /**
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x=0; x < pixelCount_x; x++){
            for(int y=0; y < pixelCount_y; y++){
                pixels[x][y] = ScreenBuffer[x][y];
            }
        }

        for(int i = 0; i < pixelCount_x; i++) {
            for(int j = 0; j < pixelCount_y; j++) {
                int co = pixels[i][j];
                CreatePixel(new Vector2(i,j), g, new Color(co,co,co,255));
            }
        }

        repaint();
    }

    /**
     * Function for making a scaled pixel from smaller pixels, the primary way to create
     * a pixel on the screen
     * @param pos position of the pixel
     * @param g graphics to use
     * @param c color of the pixel
     */
    public void CreatePixel(Vector2 pos, Graphics g, Color c){
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                g.setColor(c);
                g.fillRect(x + (pos.x*8), y + (pos.y*8),1,1);
            }
        }
    }

    /**
     * checks if a pixel is in the specified location
     * @param loc location to check for a pixel
     * @return true or false based on pixel exsistance
     */
    public static boolean hasPixelAt(Vector2 loc){
        return pixels[loc.x][loc.y] != 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        engine.OnKeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        engine.OnKeyReleased(e);
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
