package com.drake.engine.math;

import static com.drake.engine.math.MathEngine.Abs;

/*A class to handle basic vectors*/
//TODO: add more vector methods for various utilities
public class Vector2 {

    public int x,y;

    public Vector2(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Vector2(Vector2 vec){
        this.x = vec.x;
        this.y = vec.y;
    }

    //Todo: test fuctionallity of new functions

    public static int distanceTo(Vector2 a, Vector2 b){
        int yP = b.y - a.y;
        int xP = b.x - a.x;

        int rawDist = MathEngine.Exponent(xP, 2) + MathEngine.Exponent(yP, 2);
        int dist = MathEngine.SRoot(rawDist);
        return Abs(dist);
    }
    public static Vector2 distance(Vector2 a, Vector2 b){
        int yP = b.y - a.y;
        int xP = b.x - a.x;

        return new Vector2(xP, yP);
    }

    public Vector2 normalize(){
        int val = y/x;
        int xV = x/val;
        int yV = y/val;
        return new Vector2(xV, yV);
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
