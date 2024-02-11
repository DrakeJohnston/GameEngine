package com.drake.engine.core;

import com.drake.engine.MusicHandler;
import com.drake.engine.core.UI.UIElement;
import com.drake.engine.math.Physics;
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

    public static ArrayList<UIElement> uio = new ArrayList<>();
    public static boolean isActive = true;
    public static boolean debugGrid = false;
    public static Thread gameLoop;
    public static Thread physLoop;
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
    private void gameLoop(){

        while(isActive) {

            Physics.UpdateColliders();
            Update();
            Renderer.UpdateScreen();

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        OnGameExit();
        System.exit(1);

    }

    public void Update(){

    }

    //Note: for the transition between pc use this code cus of the locations of projects:
    //D:\Repositories\GameEngine\Resources\SpriteTest2.png
    //C:\Users\ironb\OneDrive\Documents\GameEngine\Resources\SpriteTest2.png
    //todo: make the engine auto find the current dir of project
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
