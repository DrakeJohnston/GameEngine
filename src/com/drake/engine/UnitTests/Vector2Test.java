package com.drake.engine.UnitTests;

import com.drake.engine.math.Vector2;
import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2Test {

    @org.junit.Test
    public void magnitude() {
        Vector2 vecA = new Vector2(1,1);
        Vector2 vecB = new Vector2(3,3);
        int actual = Vector2.getMagnitude(vecA, vecB);
        int expected = 2;
        String message = "Expected: " + expected +" got: " + actual;
        assertEquals(message, expected, actual);
    }

    @Test
    public void magnitude_1() {
        Vector2 vecA = new Vector2(1,1);
        Vector2 vecB = new Vector2(3,3);
        int actual = Vector2.getMagnitude(vecB, vecA);
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

        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void normalize() {
        Vector2 vec2 = new Vector2(3,3);
        Vector2 vec1 = new Vector2(0,0);
        Vector2 vD = Vector2.distance(vec1, vec2);

        Vector2 expected = new Vector2(1, 1);
        Vector2 actual = vD.normalize();

        String message = "Expected: " + expected +" got: " + actual;
        assertEquals(message, expected, actual);
    }

    @org.junit.Test
    public void normalize_1() {
        Vector2 vec = new Vector2(10,5);

        Vector2 expected = new Vector2(1, 1);
        Vector2 actual = vec.normalize();

        String message = "Expected: " + expected +" got: " + actual;
        assertEquals(message, expected, actual);
    }

    @org.junit.Test
    public void normalize_2() {
        Vector2 vec = new Vector2(10,5);
        Vector2 vec2 = new Vector2(3,3);
        Vector2 dist = Vector2.distance(vec, vec2);

        Vector2 expected = new Vector2(-1, -1);
        Vector2 actual = dist.normalize();

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

    @Test
    public void add() {
        Vector2 a = new Vector2(1,1);
        Vector2 b = new Vector2(1,1);
        assertEquals(new Vector2(2,2), Vector2.add(a, b));
    }

    @Test
    public void add_2() {
        Vector2 a = new Vector2(1,1);
        Vector2 b = new Vector2(-1,1);
        assertEquals(new Vector2(0,2), Vector2.add(a, b));
    }
    @Test
    public void add_3() {
        Vector2 a = new Vector2(1,1);
        Vector2 b = new Vector2(1,1);
        a.add(b);
        assertEquals(new Vector2(2,2), a);
    }

    @Test
    public void subtract() {
        Vector2 a = new Vector2(1,1);
        Vector2 b = new Vector2(1,1);
        assertEquals(new Vector2(0,0), Vector2.subtract(a, b));
    }

    @Test
    public void subtract_2() {
        Vector2 a = new Vector2(1,1);
        Vector2 b = new Vector2(1,1);
        a.subtract(b);
        assertEquals(new Vector2(0,0), a);
    }
}