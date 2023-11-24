package com.drake.engine.UnitTests;

import com.drake.engine.math.MathEngine;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathEngineTest {

    @Test
    public void root_1(){
        int expected = 5;
        int actual = MathEngine.SRoot(25);
        String message = "Expected: " + expected + " Got: " + actual;
        assertEquals(message, expected, actual);
    }

    @Test
    public void root_2(){
        int expected = 2;
        int actual = MathEngine.SRoot(8);
        String message = "Expected: " + expected + " Got: " + actual;
        assertEquals(message, expected, actual);
    }

    @Test
    public void exponent() {
        int expected = 25;
        int actual = MathEngine.Exponent(5, 2);
        String message = "Expected: " + expected + " Got: " + actual;
        assertEquals(message, expected, actual);
    }

    @Test
    public void abs() {
        int expected = 5;
        int actual = MathEngine.Abs(5);
        String message = "Expected: " + expected + " Got: " + actual;
        assertEquals(message, expected, actual);
    }

    @Test
    public void abs_1() {
        int expected = 5;
        int actual = MathEngine.Abs(-5);
        String message = "Expected: " + expected + " Got: " + actual;
        assertEquals(message, expected, actual);
    }

    @Test
    public void roundDown() {
        int expected = 2;
        int actual = MathEngine.RoundDown(2.45f);
        String message = "Expected: " + expected + " Got: " + actual;
        assertEquals(message, expected, actual);
    }

    @Test
    public void roundUp() {
        int expected = 3;
        int actual = MathEngine.RoundUp(2.45f);
        String message = "Expected: " + expected + " Got: " + actual;
        assertEquals(message, expected, actual);
    }

    @Test
    public void roundUp_1() {
        int expected = -3;
        int actual = MathEngine.RoundUp(-2.45f);
        String message = "Expected: " + expected + " Got: " + actual;
        assertEquals(message, expected, actual);
    }

    @Test
    public void roundUp_2() {
        int expected = -3;
        int actual = MathEngine.RoundUp(-3f);
        String message = "Expected: " + expected + " Got: " + actual;
        assertEquals(message, expected, actual);
    }

    @Test
    public void round() {
        int expected = 2;
        int actual = MathEngine.Round(2.45f);
        String message = "Expected: " + expected + " Got: " + actual;
        assertEquals(message, expected, actual);
    }

    @Test
    public void round_1() {
        int expected = 3;
        int actual = MathEngine.Round(2.5f);
        String message = "Expected: " + expected + " Got: " + actual;
        assertEquals(message, expected, actual);
    }
}