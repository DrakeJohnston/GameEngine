package com.drake.engine.core;

import com.drake.engine.core.UI.UIElement;
import com.drake.engine.helpers.InputHandler;
import com.drake.engine.helpers.WindowHelper;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
//    public static int DIM = 600;
//    public static int GRID_SIZE = 50;
//    private static String bgChar = "0";
//
//    public static String[][] preScreenSpace;
//    public static JLabel[][] screenSpace;
//
//
//    public static JPanel uiSpace;
//    public static JFrame window;
//
//    /*Setup for the gui window, at the moment the user has no ability to change the gui
//    * Could change in the future but would have to have limitations*/
//    //TODO: Make gui more customizable by users
//    public GUI(String backgroundChar, Color c){
//
//        preScreenSpace = new String[GRID_SIZE][GRID_SIZE];
//        screenSpace = new JLabel[GRID_SIZE][GRID_SIZE];
//
//        window = new JFrame();
//        uiSpace = new JPanel();
//
//        window.addWindowListener(new WindowHelper());
//        window.setSize(DIM,DIM);
//        window.setVisible(true);
//        window.setResizable(false);
//        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//
//        window.addKeyListener(new InputHandler());
//
//        window.add(uiSpace);
//        uiSpace.setSize(DIM,DIM);
//        uiSpace.setBackground(c);
//        uiSpace.setVisible(true);
//
//        uiSpace.setLayout(null);
//
//        for(int x = 0; x < GRID_SIZE; x++) {
//            for (int y = 0; y < GRID_SIZE; y++) {
//                JLabel l = new JLabel("0");
//                l.setBounds((x*10) + 40, (y*10)+30, 10, 10);
//                //System.out.println("x: " + x + " y: " + y);
//                l.setText(backgroundChar);
//                uiSpace.add(l);
//                screenSpace[x][y] = l;
//            }
//        }
//
//
//        uiSpace.repaint();
//    }
//
//    /*Prepares the screen buffer before posting it to the screen*/
//    public void PreparePreScreen(){
//        ClearPreScreen();
//
//        SetupScreenObjects();
//        SetupScreenUIE();
//
//        UpdateScreen();
//    }
//
//    //resets the pre screen
//    public void ClearPreScreen(){
//        for(int x = 0; x < preScreenSpace.length; x++){
//            for(int y = 0; y < preScreenSpace[0].length; y++){
//                preScreenSpace[x][y] = bgChar;
//            }
//        }
//    }
//
//    private void SetupScreenUIE() {
//        for(UIElement e : Engine.uio){
//            if(e.isActive()){
//                char[] chars = e.getText().toCharArray();
//                //System.out.println(chars.length);
//                for(int i=0; i < chars.length; i++){
//                    preScreenSpace[i+e.getPos().x][e.getPos().y] = String.valueOf(chars[i]);
//                }
//            }
//        }
//    }
//
//    //adds the gameobject locations and symbols to the pre screen for the next screen uppdate
//    private static void SetupScreenObjects() {
//        for(Gameobject s : Engine.objects) {
//            if (s.isActive) {
//                if(!s.isEmpty()) {
//
//                    for (int x = 0; x < s.getSize(); x++) {
//                        for (int y = 0; y < s.getSize(); y++) {
//
//                            if (s.getPos().x < GRID_SIZE - 1 && s.getPos().x >= 0) {
//                                if (s.getPos().y < GRID_SIZE - 1 && s.getPos().y >= 0) {
//                                    //looping through the current gameobject's space
//                                    RenderObject(s, x, y);
//                                }
//                            }
//
//                        }
//                    }
//
//                }
//            }
//        }
//    }
//
//    private static void RenderObject(Gameobject s, int x, int y) {
//
//        //System.out.println(s.getName() + " " + x);
//        int key = s.getModel()[x][y];
//        String keyChar = s.chars[key];
//
//        int locationX = x+s.getPos().x;
//        int locationY = y+s.getPos().y;
//
//        preScreenSpace[locationX][locationY] = keyChar;
//        //preScreenSpace[x][y] = s.getSymbol();
//    }
//
//    //updates the screen from pre screen
//    public void UpdateScreen(){
//        for(int x = 0; x < GRID_SIZE; x++) {
//            for (int y = 0; y < GRID_SIZE; y++) {
////                JLabel l = new JLabel("0");
////                l.setBounds((x*10) + 40, (y*10)+30, 10, 10);
////                System.out.println("x: " + x + " y: " + y);
//                JLabel l = screenSpace[x][y];
//                l.setText(preScreenSpace[x][y]);
//            }
//        }
//        uiSpace.repaint();
//    }
//
//    public static String getBgChar() {
//        return bgChar;
//    }
//
//    public static void setBgChar(String bgChar) {
//        GUI.bgChar = bgChar;
//    }
}
