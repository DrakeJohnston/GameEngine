package com.drake.engine.core;

import com.drake.engine.MusicHandler;
import com.drake.engine.core.UI.UIElement;
import com.drake.engine.math.Vector2;
import jm.music.data.Phrase;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Engine {

    public static ArrayList<Gameobject> objects = new ArrayList<>();
    public static ArrayList<UIElement> uio = new ArrayList<>();
    public static boolean isActive = true;
    public static boolean debugGrid = false;
    private Color bColor;

    //todo: Engine probably shouldnt be handling this much music handling
    public static ArrayList<Phrase> songs = new ArrayList<>();
    public static ArrayList<MusicHandler> musicInstances = new ArrayList<>();
    public static ArrayList<Thread> musicThreads = new ArrayList<>();


    /*Init function expected to be overriden to add new functionality on its own
    * starts the game loop and sets up the gui. Note: use super(bla, bla)
    * so that the rest of the init function continues
    * */
    public void init(){
        Renderer.InitRenderer(bColor, 600,600);
        Screen.engine = this;
        new File("./data").mkdir();
        gameLoop();
    }

    /*The Main game loop where updates happen, For now an update happens every 100 ms
    * but a better method will be implemented once found
    * Again its expected that this will be overridden but do not forget to super
    * after your code
    * */
    //TODO: find a new method of creating a game loop
    public void gameLoop(){

        Renderer.UpdateScreen();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(isActive) {
            gameLoop();
        }else {
            OnGameExit();
            System.exit(1);
        }

    }

    //Note: for the transition between pc use this code cus of the locations of projects:
    //D:\Repositories\GameEngine\Resources\SpriteTest2.png
    //C:\Users\ironb\OneDrive\Documents\GameEngine\Resources\SpriteTest2.png
    public static BufferedImage LoadImage(String directory){
        try {
            return ImageIO.read(new File(directory));

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void OnGameExit() {
        for(MusicHandler m : musicInstances){
            m.setActive(false);
        }
        for(Thread t : musicThreads){
            t.interrupt();
        }
    }

    public void OnKeyPressed(KeyEvent e){

    }

    public void OnKeyReleased(KeyEvent e){

    }


    public static void PlaySongFromList(int num, boolean playOnce){
        MusicHandler m = new MusicHandler(songs.get(num), playOnce);
        Thread t = new Thread(m);
        musicThreads.add(t);
        t.start();
    }

    public static void PlaySong(Phrase p, boolean playOnce){
        MusicHandler m = new MusicHandler(p, playOnce);
        Thread t = new Thread(m);
        musicThreads.add(t);
        t.start();
    }

    public static void PlaySong(int[] pitches, double rythym, boolean playOnce){
        MusicHandler m = new MusicHandler(pitches, rythym, playOnce);
        Thread t = new Thread(m);
        musicThreads.add(t);
        t.start();
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
            if(g.isActive && !g.isEmpty()) {
                Gameobject f = g.getPos() == vec ? g : null;
                if(f != null){
                    return f;
                }
            }
        }

        return null;
    }

    public static Gameobject FindGameObject(int id){
        for(Gameobject g : objects){
            if(g.isActive && !g.isEmpty()) {
                if (g.getID() == id) {
                    return g;
                }
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

    public static void changeBGChar(String s){

    }

    //used to allow changing of the background, uses AWT color library
    public void setbColor(Color bColor) {
        this.bColor = bColor;
    }

    public ArrayList<Phrase> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Phrase> songs) {
        this.songs = songs;
    }

}
