package com.drake.engine.core;

import com.drake.engine.helpers.InputHandler;
import com.drake.engine.helpers.WindowHelper;
import com.drake.engine.math.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Renderer {

    public static int DIMX = 600;
    public static int DIMY = 600;
    public static JPanel uiSpace;
    public static JFrame window;

    public Renderer(Color c, int windowX, int windowY){
        window = new JFrame();
        uiSpace = new Screen(600, 600, 0);

        window.addWindowListener(new WindowHelper());
        window.setSize(DIMX,DIMY);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        window.addKeyListener(new InputHandler());

        window.add(uiSpace);
        uiSpace.setSize(DIMX,DIMY);
        uiSpace.setBackground(c);
        uiSpace.setVisible(true);

        uiSpace.setLayout(null);
        uiSpace.repaint();
    }

    public static void UpdateScreen(){
        for(Gameobject g : Engine.objects){
            BufferedImage i = (BufferedImage) g.getSprite();
            //(i.getWidth()*i.getHeight()) * 2 is the proper equation
            //128 for 8x8
            int[] pixels = new int[((i.getWidth()*i.getHeight())*2)];
            i.getData().getPixels(0,0, i.getWidth(), i.getHeight(), pixels);

            int[] greyScale = new int[i.getHeight()*i.getWidth()];

            boolean tmp = false;
            int index = 0;
            for(int px : pixels){
                if(!tmp){
                    greyScale[index] = px;
                    index++;
                    tmp=true;
                }else {
                    tmp = false;
                }
            }

            
            for (int x = 0; x < i.getWidth(); x++){
                for(int y = 0; y < i.getHeight(); y++){
                    int px = pixels[1];
                    Screen.setPixel(new Vector2(g.getPos().x+x, g.getPos().y+y), px, 255);
                }
            }

//            String s = "";
//            for(int j = 0; j < pixels.length; j++){
//                s = s.concat(" " + pixels[j]);
//            }
//            System.out.println(s);
        }
    }
}
