package com.drake.engine.math;

/*A class to handle basic vectors*/
//TODO: add more vector methods for various utilities
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

    @Override
    public String toString() {
        return "x: "+x+" y: "+y;
    }
}
