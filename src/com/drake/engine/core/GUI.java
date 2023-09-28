package com.drake.engine.core;

import com.drake.engine.math.Vector2;
import com.drake.engine.helpers.InputHandler;
import com.drake.engine.helpers.WindowHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GUI extends JFrame {
    public static int DIM = 600;
    public static int GRID_SIZE = 50;

    public static String[][] preScreenSpace;
    public static JLabel[][] screenSpace;


    public static JPanel uiSpace;
    public static JFrame window;

    /*Setup for the gui window, at the moment the user has no ability to change the gui
    * Could change in the future but would have to have limitations*/
    //TODO: Make gui more customizable by users
    public GUI(String backgroundChar, Color c){

        preScreenSpace = new String[GRID_SIZE][GRID_SIZE];
        screenSpace = new JLabel[GRID_SIZE][GRID_SIZE];

        window = new JFrame();
        uiSpace = new JPanel();

        window.addWindowListener(new WindowHelper());
        window.setSize(DIM,DIM);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        window.addKeyListener(new InputHandler());

        window.add(uiSpace);
        uiSpace.setSize(DIM,DIM);
        uiSpace.setBackground(c);
        uiSpace.setVisible(true);

        uiSpace.setLayout(null);

        for(int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++) {
                JLabel l = new JLabel("0");
                l.setBounds((x*10) + 40, (y*10)+30, 10, 10);
                //System.out.println("x: " + x + " y: " + y);
                l.setText(backgroundChar);
                uiSpace.add(l);
                screenSpace[x][y] = l;
            }
        }

//        JButton b = new JButton();
//        b.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("Test");
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });
//        b.setSize(10,20);
//        b.setVisible(true);
//        b.setLocation(0,0);
//        uiSpace.add(b);

        uiSpace.repaint();
    }

    /*Prepares the screen buffer before posting it to the screen*/
    public void PreparePreScreen(){
        ClearPreScreen();
        SetupScreen();
        UpdateScreen();
    }

    //resets the pre screen
    public void ClearPreScreen(){
        for(int x = 0; x < preScreenSpace.length; x++){
            for(int y = 0; y < preScreenSpace[0].length; y++){
                preScreenSpace[x][y] = "'";
            }
        }
    }

    //adds the gameobject locations and symbols to the pre screen for the next screen uppdate
    private static void SetupScreen() {
        for(Gameobject s : Engine.objects){
            for(int x=s.getPos().x; x < s.getPos().x + s.getSize().x; x++){
                for(int y=s.getPos().y; y < s.getPos().y + s.getSize().y; y++){
                    if(s.getPos().x < GRID_SIZE-1 && s.getPos().x >= 0) {
                        if(s.getPos().y < GRID_SIZE-1 && s.getPos().y >= 0) {
                            preScreenSpace[x][y] = s.getSymbol();
                        }
                    }
                }
            }
        }
    }

    //updates the screen from pre screen
    public void UpdateScreen(){
        for(int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++) {
//                JLabel l = new JLabel("0");
//                l.setBounds((x*10) + 40, (y*10)+30, 10, 10);
//                System.out.println("x: " + x + " y: " + y);
                JLabel l = screenSpace[x][y];
                l.setText(preScreenSpace[x][y]);
            }
        }
        uiSpace.repaint();
    }
}
