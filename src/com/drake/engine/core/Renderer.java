package com.drake.engine.core;

import com.drake.engine.helpers.WindowHelper;
import com.drake.engine.math.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Renderer {

    public static int DIMX = 600;
    public static int DIMY = 600;
    public static JPanel uiSpace;
    public static JFrame window;

    static int defColor = 0;

    public static void InitRenderer(Color c, int windowX, int windowY){
        DIMX = windowX;
        DIMY = windowY;

        window = new JFrame();
        uiSpace = new Screen(DIMX, DIMY, defColor);
        uiSpace.setDoubleBuffered(true);

        window.addWindowListener(new WindowHelper());
        window.setSize(DIMX,DIMY);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //window.addKeyListener(new InputHandler());
        window.addKeyListener((KeyListener) uiSpace);

        window.add(uiSpace);
        uiSpace.setSize(DIMX,DIMY);
        uiSpace.setBackground(c);
        uiSpace.setVisible(true);

        uiSpace.setLayout(null);
        uiSpace.repaint();
    }

    public static void UpdateScreen(){

        for(int j = 0; j < Screen.ScreenBuffer.length; j++){
            for (int k = 0; k < Screen.ScreenBuffer[j].length; k++){
                Screen.ScreenBuffer[j][k] = defColor;
            }
        }

        for(Gameobject g : Engine.objects){
            BufferedImage i = (BufferedImage) g.getSprite();
            //(i.getWidth()*i.getHeight()) * 2 is the proper equation
            //128 for 8x8

            int ax = 0;
            for (int x = 0; x < i.getWidth(); x++){
                for(int y = 0; y < i.getHeight(); y++){
                    int px = g.getGrayscalePixels()[ax];
                    //x and y must be inverted for image to show properly
                    Screen.setPixel(new Vector2(g.getPos().x+y, g.getPos().y+x), px, 255);
                    ax++;
                }
            }
        }

    }
}
