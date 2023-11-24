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

    public static int getMagnitude(Vector2 a, Vector2 b){
        Vector2 v = Vector2.distance(a,b);

        int rawDist = MathEngine.Exponent(v.x, 2) + MathEngine.Exponent(v.y, 2);
        int dist = MathEngine.SRoot(rawDist);
        return Abs(dist);
    }
    public static int getMagnitude(Vector2 v){

        int rawDist = MathEngine.Exponent(v.x, 2) + MathEngine.Exponent(v.y, 2);
        int dist = MathEngine.SRoot(rawDist);
        return Abs(dist);
    }
    public static Vector2 distance(Vector2 a, Vector2 b){
        int yP = b.y - a.y;
        int xP = b.x - a.x;

        return new Vector2(xP, yP);
    }

    public Vector2 normalize(){
        float val = getMagnitude(new Vector2(x,y));
        float xTmp = x/val;
        float yTmp = y/val;
        int xV = MathEngine.RoundUp(xTmp);
        int yV = MathEngine.RoundUp(yTmp);
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vector2){
            Vector2 v = (Vector2) obj;
            return x == v.x && y == v.y;
        }
        return false;
    }
}
