package com.drake.engine.core;

import com.drake.engine.math.Vector2;

import java.util.ArrayList;
import java.util.Arrays;

public class Gameobject {

    public static enum Direction{
        UP,DOWN,LEFT,RIGHT
    }

    private Vector2 pos;
    private String symbol;
    private String name;
    private int RenderOrder;
    private int id = 0;
    boolean isActive = true;
    private Vector2 size;
    private final Vector2[][] shape;

    //for creating multichar objects
    public String[][] model;

    private boolean isStatic = true;

    static int lastID = 0;

    private final boolean isEmpty;
    private boolean isParent = false;
    private ArrayList<Gameobject> children = new ArrayList<>();

    /*Constructor for the gameobject*/
    public Gameobject(Vector2 pos, String name){
        this.pos = pos;
        this.name = name;
        shape = null;
        isEmpty = true;
        isStatic = false;
        initGameObject();
    }

    public Gameobject(Vector2 pos, String name, Gameobject[] children){
        this.pos = pos;
        this.name = name;
        shape = null;
        isEmpty = true;
        isStatic = false;

        this.children.addAll(Arrays.asList(children));
        this.isParent = true;

        initGameObject();
    }

    public Gameobject(Vector2 pos, Vector2 size, String symbol, String name){
        this.pos = pos;
        this.symbol = symbol;
        this.name = name;
        this.size = size;
        isEmpty = false;
        shape = new Vector2[size.x][size.y];
        RenderOrder = 0;
        createShape();
        createModel();
        initGameObject();
    }

    private void createModel() {
        
    }

    public Gameobject(Vector2 pos, Vector2 size, String symbol, String name, Gameobject[] children){
        this.pos = pos;
        this.symbol = symbol;
        this.name = name;
        this.size = size;
        isEmpty = false;

        this.children.addAll(Arrays.asList(children));
        this.isParent = true;

        shape = new Vector2[size.x][size.y];
        RenderOrder = 0;
        createShape();
        initGameObject();
    }

    /*
    * Setup for the gameobject, adding it to the engine list and giving it a unique id
    * */
    public void initGameObject() {
        id = lastID+1;
        lastID = id;

        Engine.AddNewObject(this);
    }

    /*used to create the vector array for each part of the general shape of the
    \game object
    */
    private void createShape(){
        for(int x=0; x<size.x; x++){
            for(int y=0; y<size.y; y++){
                shape[x][y] = new Vector2(getPos().x + x, getPos().y + y);
            }
        }
    }

    //TODO: Optimise a lil as the cases can probably be made into one method as they are similar

    //Method to handle the movement of gameobjects, uses collision detection
    public void Move(int amount, Direction d){
        if(isActive) {
            switch (d) {
                case UP -> {
                    if (Engine.FindGameObject(new Vector2(pos.x, pos.y - amount)) != null) {
                        Gameobject o = Engine.FindGameObject(new Vector2(pos.x, pos.y - amount));
                        if (!o.isStatic) {
                            setPos(new Vector2(pos.x, pos.y - amount));
                        } else {
                            if (amount > 0) {
                                Move(amount - 1, d);
                            }
                        }
                    } else {
                        setPos(new Vector2(pos.x, pos.y - amount));
                    }
                }
                case DOWN -> {
                    if (size.y > 1) {
                        if (Engine.FindGameObject(new Vector2(pos.x, pos.y + (amount + size.y))) != null) {
                            Gameobject o = Engine.FindGameObject(new Vector2(pos.x, pos.y + (amount + size.y)));
                            if (!o.isStatic) {
                                setPos(new Vector2(pos.x, pos.y + amount));
                            } else {
                                if (amount > 0) {
                                    Move(amount - 1, d);
                                }
                            }
                        } else {
                            setPos(new Vector2(pos.x, pos.y + amount));
                        }
                    } else {
                        if (Engine.FindGameObject(new Vector2(pos.x, pos.y + amount)) != null) {
                            Gameobject o = Engine.FindGameObject(new Vector2(pos.x, pos.y + amount));
                            if (!o.isStatic) {
                                setPos(new Vector2(pos.x, pos.y + amount));
                            } else {
                                if (amount > 0) {
                                    Move(amount - 1, d);
                                }
                            }
                        } else {
                            setPos(new Vector2(pos.x, pos.y + amount));
                        }
                    }
                }
                case LEFT -> {
                    if (Engine.FindGameObject(new Vector2(pos.x - amount, pos.y)) != null) {
                        Gameobject o = Engine.FindGameObject(new Vector2(pos.x - amount, pos.y));
                        if (!o.isStatic) {
                            setPos(new Vector2(pos.x - amount, pos.y));
                        } else {
                            if (amount > 0) {
                                Move(amount - 1, d);
                            }
                        }
                    } else {
                        setPos(new Vector2(pos.x - amount, pos.y));
                    }
                }
                case RIGHT -> {
                    if (size.x > 0) {
                        if (Engine.FindGameObject(new Vector2(pos.x + (amount + size.x), pos.y)) != null) {
                            Gameobject o = Engine.FindGameObject(new Vector2(pos.x + (amount + size.x), pos.y));
                            if (!o.isStatic) {
                                setPos(new Vector2(pos.x + amount, pos.y));
                            } else {
                                if (amount > 0) {
                                    Move(amount - 1, d);
                                }
                            }
                        } else {
                            setPos(new Vector2(pos.x + amount, pos.y));
                        }
                    } else {
                        if (Engine.FindGameObject(new Vector2(pos.x + amount, pos.y)) != null) {
                            Gameobject o = Engine.FindGameObject(new Vector2(pos.x + amount, pos.y));
                            if (!o.isStatic) {
                                setPos(new Vector2(pos.x + amount, pos.y));
                            } else {
                                if (amount > 0) {
                                    Move(amount - 1, d);
                                }
                            }
                        } else {
                            setPos(new Vector2(pos.x + amount, pos.y));
                        }
                    }
                }
            }
        }
    }

    private boolean CheckForBlocking(Vector2 pos){
        if (Engine.FindGameObject(pos) != null) {
            Gameobject o = Engine.FindGameObject(pos);
            return o.isStatic;
        }
        return false;
    }

    public Vector2[][] getShape() {
        return shape;
    }

    public Vector2 getSize() {
        return size;
    }

    public void setSize(Vector2 size) {
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

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

    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public String toString() {
        return name;
    }
}
