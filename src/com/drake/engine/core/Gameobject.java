package com.drake.engine.core;

import com.drake.engine.math.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class Gameobject {

    public static ArrayList<Gameobject> objects = new ArrayList<>();

    public static enum Direction{
        UP,DOWN,LEFT,RIGHT
    }

    private Vector2 pos;
    //private String symbol;
    //_______________NEW AREA_____________________________
    private BufferedImage sprite;
    private int[] pixelArray;
    private int[] grayscalePixels;

    //private Vector2[][] collider;
    CollisionBox collider;
    private boolean debugMode = false;
    private int center;
    //___________________________________________________
    private String name;
    private int size;

    private int RenderOrder;
    private int id = 0;
    static int lastID = 0;

    boolean isActive = true;
    private boolean canCollide = false;

//    private int[][] model;
//    public String[] chars;
//    private final Vector2[][] collisionBox;

    private final boolean isEmpty;
    private boolean isParent = false;
    private ArrayList<Gameobject> children = new ArrayList<>();

    public class CollisionBox{
        int size;
        Vector2[][] collider;
        static ArrayList<CollisionBox> colliders = new ArrayList<>();

        public CollisionBox(int size, Vector2[][] collider){
            this.collider = collider;
            this.size = size;
            colliders.add(this);
        }

        public boolean hasPos(Vector2 pos){
            for(Vector2[] v1 : collider){
                for(Vector2 v2 : v1){
                    if (v2.equals(pos)){
                        return true;
                    }
                }
            }
            return false;
        }

        public void setCollider(Vector2[][] collider) {
            this.collider = collider;
        }

        public Vector2[][] getCollider() {
            return collider;
        }
    }

    /*Constructor for the gameobject*/
    //for empty game objects
    public Gameobject(Vector2 pos, String name, int size){
        this.pos = pos;
        this.name = name;
        isEmpty = true;
        canCollide = false;
        this.size = size;
        initGameObject();
    }
    //for empty game objects
    public Gameobject(Vector2 pos, String name, Gameobject[] children){
        this.pos = pos;
        this.name = name;
        isEmpty = true;
        canCollide = false;

        this.children.addAll(Arrays.asList(children));
        this.isParent = true;

        initGameObject();
    }

    public Gameobject(Vector2 pos, BufferedImage sprite, int size, String name, boolean canCollide){
        this.pos = pos;
        this.name = name;
        this.isEmpty = false;
        this.size = size;
        this.canCollide = canCollide;

        this.sprite = sprite;
        pixelArray = new int[((sprite.getWidth()*sprite.getHeight())*2)];
        sprite.getData().getPixels(0,0, sprite.getWidth(), sprite.getHeight(), pixelArray);

        grayscalePixels = new int[sprite.getHeight()*sprite.getWidth()];

        boolean tmp = false;
        int index = 0;
        for(int px : pixelArray){
            if(!tmp){
                grayscalePixels[index] = px;
                index++;
                tmp=true;
            }else {
                tmp = false;
            }
        }

        center = this.size/2;

        //createShape();
        initGameObject();
    }

    /*
    * Setup for the gameobject, adding it to the engine list and giving it a unique id
    * */
    public void initGameObject() {
        id = lastID+1;
        lastID = id;

        Vector2[][] c = new Vector2[size][size];

        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                c[x][y] = new Vector2(pos.x+x,pos.y+y);
            }
        }

        collider = new CollisionBox(size, c);

        AddNewObject(this);
    }

    public void transformObject(Vector2 pos){
        if(CollisionBox.colliders.size() > 1) {
            for(CollisionBox c : CollisionBox.colliders) {
                if (!c.hasPos(pos) && c != this.collider) {
                    setPos(pos);
                }
            }
        }else{
            setPos(pos);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getID(){
        return id;
    }

    public int getRenderOrder(){
        return RenderOrder;
    }

    public void setRenderOrder(int order){
        RenderOrder = order;
    }

    public void setActive(boolean active) {
        if(this.isParent){
           for(Gameobject c : children){
               c.setActive(active);
           }
           this.isActive = active;
        }else {
            isActive = active;
        }
    }

    public boolean getActive(){
        return isActive;
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public int[] getGrayscalePixels() {
        return grayscalePixels;
    }

    public CollisionBox getCollider() {
        return collider;
    }

    //    public String getSymbol() {
//        return symbol;
//    }
//
//    public void setSymbol(String symbol) {
//        this.symbol = symbol;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanCollide() {
        return canCollide;
    }

    public void setCanCollide(boolean canCollide) {
        this.canCollide = canCollide;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public ArrayList<Gameobject> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Gameobject> children) {
        this.children = children;
        this.isParent = true;
    }
    public void addChild(Gameobject child){
        this.children.add(child);
        this.isParent = true;
    }

    public void removeChild(Gameobject obj){
        this.children.remove(obj);
        if(children.isEmpty()){
            this.isParent = false;
        }
    }

//    public int[][] getModel() {
//        return model;
//    }
//
//    public void setModel(int[][] model) {
//        this.model = model;
//    }

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
            if(g.isActive && g.getPos().equals(vec)) {
                return g;
            }
        }
        return null;
    }

    public static Gameobject FindGameObject(int id){
        for(Gameobject g : objects){
            if(g.isActive) {
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
            Gameobject g = FindGameObject(ids[i]);
            if(g!=null){
                ret.add(g);
            }
        }
        return ret.toArray(Gameobject[]::new);
    }

    public static Gameobject[] FindGameObjects(Vector2[] positions){
        ArrayList<Gameobject> ret = new ArrayList<>();
        for(int i=0; i < positions.length; i++){
            Gameobject g = FindGameObject(positions[i]);
            if(g!=null){
                ret.add(g);
            }
        }
        return ret.toArray(Gameobject[]::new);
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public int getCenter() {
        return center;
    }

    public void setCenter(int center) {
        this.center = center;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    @Override
    public String toString() {
        return name;
    }
}
