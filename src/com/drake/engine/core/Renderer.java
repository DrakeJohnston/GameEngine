package com.drake.engine.core;

import com.drake.engine.helpers.InputHandler;
import com.drake.engine.helpers.WindowHelper;

import javax.swing.*;
import java.awt.*;

public class Renderer {

    public static int DIMX = 600;
    public static int DIMY = 600;
    public static JPanel uiSpace;
    public static JFrame window;

    public Renderer(Color c, int windowX, int windowY){
        window = new JFrame();
        uiSpace = new Screen();

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

    public void addToRenderList(Gameobject obj){
        Screen.AddToScreen(obj.getPos(), obj.getSprite());
    }
}
