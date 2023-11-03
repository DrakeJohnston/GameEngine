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

    public static ArrayList<Image> images = new ArrayList<>();
    public static HashMap<Vector2, Image> toDisplay = new HashMap<>();

    public static void AddToScreen(Vector2 loc, Image sprite){
        toDisplay.put(loc, sprite);
    }

    @Override
    protected void paintComponent(Graphics g) {
        for(Vector2 v : toDisplay.keySet()){
            g.drawImage(toDisplay.get(v), v.x,v.y, null);
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
