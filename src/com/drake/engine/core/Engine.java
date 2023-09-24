package com.drake.engine.core;

import com.drake.engine.helpers.InputHandler;

import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

public class Engine {

    public static ArrayList<Gameobject> objects = new ArrayList<>();
    public static boolean isActive = true;

    public GUI ui;

    public void init(){
        ui = new GUI(600,50,"0");
        gameLoop();
    }

    public void gameLoop(){

        ui.PreparePreScreen();
        HandleInput();

        try {
            Thread.sleep(10);
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

    public static Gameobject FindGameObject(String name){
        for(Gameobject g : objects){
            if(g.getName().equals(name)){
                return g;
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

}
