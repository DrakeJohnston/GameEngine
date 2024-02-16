package com.drake.engine.UnitTests;

import com.drake.engine.core.Gameobject;
import com.drake.engine.math.Physics;
import com.drake.engine.math.Vector2;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PhysicsTest {

    @Test
    public void raycast() {
        Gameobject oa = new Gameobject(new Vector2(0,0), "Oa", 1);
        Gameobject ob = new Gameobject(new Vector2(5,0), "Ob", 1);

        ArrayList<Gameobject> hits = Physics.Raycast(10, oa.getPos(), new Vector2(1,0));
        assertEquals(ob, hits.get(0));
    }

    @Test
    public void raycast_a() {
        Gameobject oa = new Gameobject(new Vector2(0,1), "Oa", 1);
        Gameobject ob = new Gameobject(new Vector2(5,0), "Ob", 2);

        ArrayList<Gameobject> hits = Physics.Raycast(10, oa.getPos(), new Vector2(1,0));
        assertEquals(ob, hits.get(0));
    }

    @After
    public void tearDown(){
        Gameobject.ClearGameObjects();
    }

    @Test
    public void raycast_2() {
        Gameobject o1 = new Gameobject(new Vector2(0,0), "O1", 1);
        Gameobject o2 = new Gameobject(new Vector2(5,0), "O2", 1);
        Gameobject o3 = new Gameobject(new Vector2(15, 0), "O3", 1);

        ArrayList<Gameobject> hits = Physics.Raycast(20, o1.getPos(), new Vector2(1,0));
        boolean t1 = hits.get(0).equals(o2);
        boolean t2 = hits.get(1).equals(o3);
        assertTrue(t1 && t2);
    }

    @Test
    public void raycast_3() {
        Gameobject o = new Gameobject(new Vector2(0,0), "O1", 1);
        Gameobject o2 = new Gameobject(new Vector2(5,0), "O2", 1);
        Gameobject o3 = new Gameobject(new Vector2(15, 0), "O3", 1);

        o2.setLayer(1);
        o3.setLayer(0);

        ArrayList<Gameobject> hits = Physics.Raycast(20, o.getPos(), new Vector2(1,0), 1);
        if(!hits.isEmpty()) {
            boolean t1 = hits.size() == 1;
            boolean t2 = hits.get(0).equals(o2);
            assertTrue(t1 && t2);
        }
        else {
            fail();
        }
    }

    @Test
    public void checkcollisions(){
        Gameobject staticObj = new Gameobject(new Vector2(3,3), "go1", 2);
        Gameobject collidedObj = new Gameobject(new Vector2(3,4), "cobj", 1);

        Physics.UpdateColliders();
        Physics.CheckCollisions();
    }
}