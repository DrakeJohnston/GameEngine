package com.drake.engine.core;

import com.drake.engine.helpers.CollisionOut;
import com.drake.engine.math.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class Gameobject {

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

    public static enum Direction{
        UP,DOWN,LEFT,RIGHT
    }

    private Vector2 pos;
    //private String symbol;
    //_______________NEW AREA_____________________________
    private BufferedImage sprite;
    private int[] pixelArray;
    private int[] grayscalePixels;

    private Vector2[][] collider;
    private int center;
    //___________________________________________________
    private String name;
    private int size;

    private int RenderOrder;
    private int id = 0;
    static int lastID = 0;

    boolean isActive = true;
    private boolean isStatic = false;

//    private int[][] model;
//    public String[] chars;
//    private final Vector2[][] collisionBox;

    private final boolean isEmpty;
    private boolean isParent = false;
    private ArrayList<Gameobject> children = new ArrayList<>();

    /*Constructor for the gameobject*/
    //for empty game objects
    public Gameobject(Vector2 pos, String name){
        this.pos = pos;
        this.name = name;
        isEmpty = true;
        isStatic = false;
        initGameObject();
    }
    //for empty game objects
    public Gameobject(Vector2 pos, String name, Gameobject[] children){
        this.pos = pos;
        this.name = name;
        isEmpty = true;
        isStatic = false;

        this.children.addAll(Arrays.asList(children));
        this.isParent = true;

        initGameObject();
    }

    public Gameobject(Vector2 pos, BufferedImage sprite, int size, String name, boolean isStatic){
        this.pos = pos;
        this.name = name;
        this.isEmpty = false;
        this.size = size;
        this.isStatic = isStatic;

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

        collider = new Vector2[size][size];
        int xVal = -size/2;
        int yVal = -size/2;

        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                collider[x][y] = new Vector2(pos.x+x,pos.y+y);
                //xVal++;
                //yVal++;
                //System.out.println((x+xVal) + " : " + (y+yVal) + "----" + pos.x + " : " + pos.y);
            }
        }

        Engine.AddNewObject(this);
    }

    public CollisionOut hasCollided(){
        for (Gameobject g : Engine.objects){
            int dist = Vector2.getMagnitude(this.pos, g.pos);
            if(dist <= 1){
                if(CheckNeighbouring()){
                    Vector2 distComp = Vector2.distance(this.pos, g.pos).normalize();
                    return new CollisionOut(dist, g.getPos(), distComp);
                }
            }
        }
        return new CollisionOut(10000, new Vector2(0,0), null);
    }

    private boolean CheckNeighbouring() {
        for(int i = 1; i < size; i++){
            for (int j = 1; j < size; j++){
                Vector2 chkPos = new Vector2(size+i, size+j);
                if(Screen.hasPixelAt(chkPos)){
                    return true;
                }
            }
        }
        return false;
    }

    /*used to create the vector array for each part of the general shape of the
    \game object
    */
//    private void createShape(){
//        for(int x=0; x<size; x++){
//            for(int y=0; y<size; y++){
//                collisionBox[x][y] = new Vector2(getPos().x + x, getPos().y + y);
//            }
//        }
//    }

    //TODO: Optimise a lil as the cases can probably be made into one method as they are similar


    private boolean CheckForBlocking(Vector2 pos){
        if (Engine.FindGameObject(pos) != null) {
            Gameobject o = Engine.FindGameObject(pos);
            return o.isStatic;
        }
        return false;
    }

//    public Vector2[][] getCollisionBox() {
//        return collisionBox;
//    }

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

    public Vector2[][] getCollider() {
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

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
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

    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public String toString() {
        return name;
    }
}
