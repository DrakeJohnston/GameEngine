package com.drake.engine.UnitTests;

import com.drake.engine.math.Vector2;

import static org.junit.Assert.*;

public class Vector2Test {

    @org.junit.Test
    public void distanceTo() {
        Vector2 vecA = new Vector2(1,1);
        Vector2 vecB = new Vector2(3,3);
        int actual = Vector2.distanceTo(vecA, vecB);
        int expected = 2;
        String message = "Expected: " + expected +" got: " + actual;
        assertEquals(message, expected, actual);
    }

    public void distanceTo_1() {
        Vector2 vecA = new Vector2(1,1);
        Vector2 vecB = new Vector2(3,3);
        int actual = Vector2.distanceTo(vecB, vecA);
        int expected = 2;
        String message = "Expected: " + expected +" got: " + actual;
        assertEquals(message, expected, actual);
    }

    @org.junit.Test
    public void distance() {
        Vector2 vecA = new Vector2(1,1);
        Vector2 vecB = new Vector2(3,3);
        Vector2 actual = Vector2.distance(vecA, vecB);
        Vector2 expected = new Vector2(2,2);
        String message = "Expected: " + expected +" got: " + actual;
        assertEquals(message, expected, actual);
    }

    @org.junit.Test
    public void normalize() {
        Vector2 vec = new Vector2(3,4);
        Vector2 expected = new Vector2(0, 0);
        Vector2 actual = vec.normalize();
        String message = "Expected: " + expected +" got: " + actual;
        assertEquals(message, expected, actual);
    }

    @org.junit.Test
    public void compareTo() {
        Vector2 vec1 = new Vector2(1,1);
        Vector2 vec2 = new Vector2(1,1);
        boolean actual = vec1.CompareTo(vec2);
        String message = "Expected: true got: " + actual;
        assertTrue(message, actual);
    }

    @org.junit.Test
    public void compareTo_1() {
        Vector2 vec1 = new Vector2(1,1);
        Vector2 vec2 = new Vector2(2,1);
        boolean actual = vec1.CompareTo(vec2);
        String message = "Expected: true got: " + actual;
        assertFalse(message, actual);
    }

    @org.junit.Test
    public void compareTo_2() {
        Vector2 vec1 = new Vector2(1,1);
        Vector2 vec2 = new Vector2(1,2);
        boolean actual = vec1.CompareTo(vec2);
        String message = "Expected: true got: " + actual;
        assertFalse(message, actual);
    }

    @org.junit.Test
    public void compareTo_3() {
        Vector2 vec1 = new Vector2(1,1);
        Vector2 vec2 = new Vector2(2,5);
        boolean actual = vec1.CompareTo(vec2);
        String message = "Expected: true got: " + actual;
        assertFalse(message, actual);
    }

    @org.junit.Test
    public void compareTo_4() {
        Vector2 vec1 = new Vector2(2,1);
        Vector2 vec2 = new Vector2(1,1);
        boolean actual = vec1.CompareTo(vec2);
        String message = "Expected: true got: " + actual;
        assertFalse(message, actual);
    }
}