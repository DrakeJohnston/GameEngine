package com.drake.engine.math;

public class MathEngine {
    /**
     * Power function
     * @param num base number for pow function
     * @param power the exponent of the base
     * @return returns the number to the power
     */
    public static int Exponent(int num, int power)
    {
        int val = num;
        for (int i = 1; i < power; i++){
            val *= num;
        }
        return val;
    }

    /**
     * Square root function
     * @param x number to take the root of
     * @return returns the number square rooted
     */
    public static int SRoot(int x){
        // Base Cases
        if (x == 0 || x == 1)
            return x;

        // Do Binary Search for floor(sqrt(x))
        long start = 1, end = x / 2, ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            // If x is a perfect square
            if (mid * mid == x)
                return (int)mid;

            // Since we need floor, we update answer when
            // mid*mid is smaller than x, and move closer to
            // sqrt(x)
            if (mid * mid < x) {
                start = mid + 1;
                ans = mid;
            }
            else // If mid*mid is greater than x
                end = mid - 1;
        }
        return (int)ans;
    }

    /**
     * The absolute value function
     * @param n value to take abs of
     * @return returns the absolute value of n
     */
    public static int Abs(int n){
        if(n<0){
            return -n;
        }else {
            return n;
        }
    }

    /**
     * Rounds the value down
     * @param f float to round
     * @return returns an int rounded down
     */
    public static int RoundDown(float f){
        return (int) f;
    }

    /**
     * @param f the float to round
     * @return returns the rounded up float as int
     */
    public static int RoundUp(float f){
        int intVers = (int) f;

        if(f < 0) {
            intVers = Abs(intVers);
            float dec = f + intVers;
            if (dec != 0) {
                return -(intVers + 1);
            }else {
                return (int) f;
            }
        }else {
            float dec = f - intVers;
            if(dec != 0) {
                return intVers + 1;
            }
        }
        return intVers;
    }

    /**
     * Rounds the float in up or down based on standard
     * conventions( f < 0.5 round down)
     * @param f the float to round
     * @return returns the rounded float as int
     */
    public static int Round(float f){
        int intVers = (int) f;
        if(intVers > 0) {
            float decimal = f - intVers;
            if (decimal >= 0.5 && decimal < 1) {
                return intVers + 1;
            }
        }else {
            intVers = -intVers;
            float decimal = f - intVers;
            if (decimal >= 0.5 && decimal < 1) {
                return -(intVers + 1);
            }
        }
        return intVers;
    }
}
