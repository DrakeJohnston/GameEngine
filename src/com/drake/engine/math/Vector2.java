package com.drake.engine.math;

public class Vector2 {

    public int x,y;

    public Vector2(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean CompareTo(Vector2 vec){
        if(vec.x == this.x && vec.y == this.y){
            return true;
        }
        return false;
    }
}
