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

    /*Init function expected to be overriden to add new functionality on its own
    * starts the game loop and sets up the gui. Note: use super(bla, bla)
    * so that the rest of the init function continues
    * */
    public void init(){
        ui = new GUI("0", bColor);
        gameLoop();
    }

    /*The Main game loop where updates happen, For now an update happens every 100 ms
    * but a better method will be implemented once found
    * Again its expected that this will be overridden but do not forget to super
    * after your code
    * */
    //TODO: find a new method of creating a game loop
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

    //Basic input handling using the InputHandler helper class, should be overridden for new functionallity
    //TODO: improve input system to allow more control
    public void HandleInput() {
        if (InputHandler.KeyMap.get(VK_BACK_SLASH)) {
            System.out.println("debug key! : " + InputHandler.KeyMap.get(VK_BACK_SLASH));
        }
    }

    //Adds a new object to the list
    public static void AddNewObject(Gameobject gameobject){
        objects.add(gameobject);
    }

    /*Below are various ways to find game objects other than having a
    * static variable with it for cleanliness of code
    * */
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

    public static Gameobject[] FindGameObjects(int[] ids){
        ArrayList<Gameobject> ret = new ArrayList<>();
        for(int i=0; i < ids.length; i++){
            Gameobject g = Engine.FindGameObject(ids[i]);
            if(g!=null){
                ret.add(g);
            }
        }
        return ret.toArray(Gameobject[]::new);
    }

    public static Gameobject[] FindGameObjects(Vector2[] positions){
        ArrayList<Gameobject> ret = new ArrayList<>();
        for(int i=0; i < positions.length; i++){
            Gameobject g = Engine.FindGameObject(positions[i]);
            if(g!=null){
                ret.add(g);
            }
        }
        return ret.toArray(Gameobject[]::new);
    }

    //used to allow changing of the background, uses AWT color library
    public void setbColor(Color bColor) {
        this.bColor = bColor;
    }
}
