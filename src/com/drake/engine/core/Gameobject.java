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
    CollisionBox collider;
    private boolean debugMode = false;
    private int center;
    //___________________________________________________
    private String name;
    private int size;
    public static final int maxLayers = 5;
    private int Layer;
    private int id = 0;
    static int lastID = 0;

    boolean isActive = true;
    private boolean canCollide = false;

    private final boolean isEmpty;
    private boolean isParent = false;
    private ArrayList<Gameobject> children = new ArrayList<>();

    /**
     * The class to store information regarding the collision box on game objects
     */
    public static class CollisionBox{
        int size;
        Vector2[][] collider;
        public static ArrayList<CollisionBox> colliders = new ArrayList<>();

        public Gameobject parent;

        /**
         * @param size size of the collider
         * @param collider the matrix representing the collision box
         */
        public CollisionBox(int size, Vector2[][] collider, Gameobject parent){
            this.collider = collider;
            this.size = size;
            this.parent = parent;
            colliders.add(this);
        }

        /**
         * checks the collider if it contains the position
         * @param pos the position to check
         * @return returns true if the collider has the position else returns false
         */
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

        /**
         * changes the collider to the params collider
         * @param collider the new collider
         */
        public void setCollider(Vector2[][] collider) {
            this.collider = collider;
        }

        /**
         * @return returns the collider matrix
         */
        public Vector2[][] getCollider() {
            return collider;
        }
    }

    /**
     * Creates a sprite-less game object does not collide by default
     * @param pos initial position of the object
     * @param name name of game object
     * @param size size of game object
     */
    public Gameobject(Vector2 pos, String name, int size){
        this.pos = pos;
        this.name = name;
        isEmpty = true;
        canCollide = false;
        this.size = size;
        initGameObject();
    }

    /**
     * Creates a basic empty game object with given parameters
     * @param pos initial position of the game object
     * @param name name of the game object
     * @param children children of the game object
     */
    public Gameobject(Vector2 pos, String name, Gameobject[] children){
        this.pos = pos;
        this.name = name;
        isEmpty = true;
        canCollide = false;

        this.children.addAll(Arrays.asList(children));
        this.isParent = true;

        initGameObject();
    }

    /**
     * Creates a standard game object using params
     * @param pos initial position of the object
     * @param sprite sprite of the object
     * @param size size of the object(default is based of sprite supplied)
     * @param name name of the object
     * @param canCollide should the object collide with others
     */
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

    /**
     * Setup for the gameobject, handles all required initial parameters
     */
    public void initGameObject() {
        id = lastID+1;
        lastID = id;

        Vector2[][] c = new Vector2[size][size];

        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                c[x][y] = new Vector2(pos.x+x,pos.y+y);
            }
        }

        collider = new CollisionBox(size, c, this);

        AddNewObject(this);
    }

    /**
    * Transforms an object to a Vector2 position checking for collision
    * @param pos position to move to.
    * */
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

    /**
     * returns size of the gameobject
     * @return returns size
     */
    public int getSize() {
        return size;
    }

    /**
     * @return returns the id of the game object
     */
    public int getID(){
        return id;
    }


    /**
     * @return returns the render order for the game object
     */
    public int getLayer(){
        return Layer;
    }

    /**
     * sets the objects layer, cannot go above 5 layers
     * @param layer the render order of the object
     */
    public void setLayer(int layer){
        if(layer <= maxLayers) {
            Layer = layer;
        }else{
            throw new RuntimeException("Layer above max allowed layers");
        }
    }

    /**
     * sets the active state of the game object
     * @param active the new value of gameobjects active state
     */
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

    /**
     * returns active state of the gameobject
     * @return returns active
     */
    public boolean getActive(){
        return isActive;
    }

    /**
     * returns position of the gameobject
     * @return returns position
     */
    public Vector2 getPos() {
        return pos;
    }

    /**
     * Sets the position of the game object, ignores collision detection
     * @param pos position to set object to
     */
    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    /**
     * returns the gray scale pixels of the gameobject
     * @return returns array of pixels
     */
    public int[] getGrayscalePixels() {
        return grayscalePixels;
    }

    /**
     * returns box collider of the gameobject
     * @return returns collider
     */
    public CollisionBox getCollider() {
        return collider;
    }

    /**
     * returns name of the gameobject
     * @return returns name
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of the object
     * @param name sets the name of the object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns if the gameobject can collide
     * @return returns bool
     */
    public boolean isCanCollide() {
        return canCollide;
    }

    /**
     * Changes if the object can collide with other objects
     * @param canCollide bool - should collide or not
     */
    public void setCanCollide(boolean canCollide) {
        this.canCollide = canCollide;
    }


    /**
     * Tells you if the object is a parent or not
     * @return returns bool - is a parent or child
     */
    public boolean isParent() {
        return isParent;
    }


    /**
     * Changes the object to be a parent of another object.
     * @param parent bool parent or not
     */
    public void setParent(boolean parent) {
        isParent = parent;
    }

    /**
     * Returns a list of gameobject children
     * @return ArrayList of children
     */
    public ArrayList<Gameobject> getChildren() {
        return children;
    }

    /**Function to add a list of children to the object,
     * automatically sets object to parent
     * @param children the children to add
     * */
    public void setChildren(ArrayList<Gameobject> children) {
        this.children = children;
        this.isParent = true;
    }


    /**
     * Adds a single child and makes the object parented
     * @param child the child to append
     */
    public void addChild(Gameobject child){
        this.children.add(child);
        this.isParent = true;
    }


    /**
     * Removes specified gameobject child from child list, automatically checks if
     * object still has children
     * @param obj object to remove from list
     */
    public void removeChild(Gameobject obj){
        this.children.remove(obj);
        if(children.isEmpty()){
            this.isParent = false;
        }
    }


    /**
     * Adds an object to the master game object list, this is done automatically
     * by the gameobject class
     * @param gameobject gameobject to add to the list of objects
     */
    private static void AddNewObject(Gameobject gameobject){
        objects.add(gameobject);
    }

    public static void RemoveGameObject(String name){
        Gameobject r = FindGameObject(name);
        if(r!=null) {
            objects.remove(r);
        }
    }

    public static void ClearGameObjects(){
        objects.clear();
    }

    //todo: add find game objects for finding objects in the same space

    /**
     * Searches the object list for objects with the same name as the param
     * @param name name of the object to look for
     * @return returns the gameobject found or null if none
     */
    public static Gameobject FindGameObject(String name){
        for(Gameobject g : objects){
            if(g.getName().equals(name)){
                return g;
            }
        }
        return null;
    }

    /**
     * Searches the object list for objects with the same position as the param
     * @param vec position of the object to look for
     * @return returns the gameobject found or null if none
     */
    public static Gameobject FindGameObject(Vector2 vec){
        for(Gameobject g : objects){
            if(g.isActive && g.getPos().equals(vec)) {
                return g;
            }
        }
        return null;
    }

    /**
     * Searches the object list for objects with the same unique id as the param
     * @param id id of the object to look for
     * @return returns the gameobject found or null if none
     */
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


    /**
     * Finds a list of gameobjects by their unique ids
     * @param ids list of unique object ids
     * @return returns a gameobject list
     */
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

    /**
     * Finds a list of gameobjects by their positions
     * @param positions list of object positions
     * @return returns a gameobject list
     */
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


    /**
     * @return returns if the object is empty
     */
    public boolean isEmpty() {
        return isEmpty;
    }


    /**
     * @return returns the sprite of the gameobject if any
     */
    public Image getSprite() {
        return sprite;
    }

    /**
     * @param sprite the sprite for the gameobject to render
     */
    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    /**
     * @return returns the center
     */
    public int getCenter() {
        return center;
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
