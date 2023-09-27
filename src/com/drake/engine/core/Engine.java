package com.drake.engine.core;

import com.drake.engine.helpers.InputHandler;
import com.drake.engine.math.Vector2;

import java.awt.*;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

public class Engine {

    public static ArrayList<Gameobject> objects = new ArrayList<>();
    public static boolean isActive = true;
    private Color bColor;

    public GUI ui;

    public void init(){
        ui = new GUI("0", bColor);
        gameLoop();
    }

    public void gameLoop(){

        ui.PreparePreScreen();
        HandleInput();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(isActive) {
            gameLoop();
        }
    }

    public void HandleInput() {
        if (InputHandler.KeyMap.get(VK_BACK_SLASH)) {
            System.out.println("debug key! : " + InputHandler.KeyMap.get(VK_BACK_SLASH));
        }
    }

//    private void RenderObjects() {
//        ui.ClearPreScreen();
//        for(com.drake.engine.core.Gameobject g : objects){
//            ui.addToScreen(g.getPos(), g.getSymbol());
//        }
//    }

    public static void AddNewObject(Gameobject gameobject){
        objects.add(gameobject);
    }

    public static Gameobject FindGameObject(String name){
        for(Gameobject g : objects){
            if(g.getName().equals(name)){
                return g;
            }
        }
        return null;
    }

    public static Gameobject FindGameObject(Vector2 vec){
        for(Gameobject g : objects){
            Vector2[][] s = g.getShape();
            for(int x=0; x < s.length; x++){
                for (int y=0; y < s[0].length; y++){
                    if(s[x][y].CompareTo(vec)){
                        return g;
                    }
                }
            }
        }

        return null;
    }

    public static Gameobject FindGameObject(int id){
        for(Gameobject g : objects){
            if(g.getID() == id){
                return g;
            }
        }
        return null;
    }

    public void setbColor(Color bColor) {
        this.bColor = bColor;
    }
}
