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

    /**
     * @param a vector a
     * @param b vector b
     * @return returns the magnitude between the two vectors
     */
    public static int getMagnitude(Vector2 a, Vector2 b){
        Vector2 v = Vector2.distance(a,b);

        int rawDist = MathEngine.Exponent(v.x, 2) + MathEngine.Exponent(v.y, 2);
        int dist = MathEngine.SRoot(rawDist);
        return Abs(dist);
    }

    /**
     * @param v the vector to use
     * @return returns the magnitude using only the x,y of one vector
     */
    public static int getMagnitude(Vector2 v){

        int rawDist = MathEngine.Exponent(v.x, 2) + MathEngine.Exponent(v.y, 2);
        int dist = MathEngine.SRoot(rawDist);
        return Abs(dist);
    }

    /**
     * @param a vector a
     * @param b vector b
     * @return returns the distance between the two vectors
     */
    public static Vector2 distance(Vector2 a, Vector2 b){
        int yP = b.y - a.y;
        int xP = b.x - a.x;

        return new Vector2(xP, yP);
    }

    /**
     * @return returns the normalized value of the vector
     */
    public Vector2 normalize(){
        float val = getMagnitude(new Vector2(x,y));
        float xTmp = x/val;
        float yTmp = y/val;
        int xV = MathEngine.RoundUp(xTmp);
        int yV = MathEngine.RoundUp(yTmp);
        return new Vector2(xV, yV);
    }

    /**
     * @param vec vector to compare this one to
     * @return returns true if they are the same
     */
    //todo: correct the function to compare magnitudes, equals compares x,y values
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
