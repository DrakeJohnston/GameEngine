package com.drake.engine.core;

import com.drake.engine.math.Vector2;

public class Gameobject {

    private Vector2 pos;
    private String symbol;
    private String name;
    private int id = 0;
    boolean isActive = true;
    private int size;
    private Vector2[][] shape;

    private boolean isStatic = true;

    static int lastID = 0;

    public Gameobject(Vector2 pos, String symbol, String name, int size){
        this.pos = pos;
        this.symbol = symbol;
        this.name = name;
        this.size = size;
        shape = new Vector2[size][size];
        createShape();
        initGameObject();
    }

    public void initGameObject() {
        id = lastID+1;
        lastID = id;

        Engine.objects.add(this);
    }

    private void createShape(){
        for(int x=0; x<size; x++){
            for(int y=0; y<size; y++){
                shape[x][y] = new Vector2(getPos().x + x, getPos().y + y);
            }
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

    public void setActive(boolean active) {
        isActive = active;
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
}
