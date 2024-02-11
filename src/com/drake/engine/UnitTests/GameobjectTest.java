package com.drake.engine.UnitTests;

import com.drake.engine.core.Gameobject;
import com.drake.engine.math.Physics;
import com.drake.engine.math.Vector2;

import static org.junit.jupiter.api.Assertions.*;

class GameobjectTest {

    @org.junit.jupiter.api.Test
    void getCenter() {
    }

    @org.junit.jupiter.api.Test
    void setCenter() {
    }

    @org.junit.jupiter.api.Test
    void move() {
        Gameobject a = new Gameobject(new Vector2(1,1), "oa", 1);
        Gameobject b = new Gameobject(new Vector2(5,5), "ob", 1);
        a.setCanCollide(true);
        b.setCanCollide(true);

        a.transformObject(new Vector2(5,5));
        assertEquals(new Vector2(1,1), a.getPos());
    }

    @org.junit.jupiter.api.Test
    void move_2() {
        Gameobject a = new Gameobject(new Vector2(1,1), "oa", 1);
        Gameobject b = new Gameobject(new Vector2(5,5), "ob", 4);
        a.setCanCollide(true);
        b.setCanCollide(true);

        a.transformObject(new Vector2(6,6));
        assertEquals(new Vector2(1,1), a.getPos());
    }

    //technically checking both the update going through and if the physic method works
    @org.junit.jupiter.api.Test
    void move_3() {
        Gameobject a = new Gameobject(new Vector2(1,1), "oa", 1);
        a.setCanCollide(true);

        a.transformObject(new Vector2(6,6));
        Physics.UpdateColliders();
        Vector2[][] v = a.getCollider().getCollider();
        System.out.println(a.getPos());
        assertEquals(new Vector2(6,6), v[0][0]);
    }

    @org.junit.jupiter.api.Test
    void move_4() {
        Gameobject a = new Gameobject(new Vector2(1,1), "oa", 2);
        a.setCanCollide(true);

        a.transformObject(new Vector2(2,2));
        Physics.UpdateColliders();

        assertEquals(new Vector2(2,2), a.getPos());
    }

    @org.junit.jupiter.api.Test
    void move_5() {
        Gameobject a = new Gameobject(new Vector2(1,1), "oa", 2);
        Gameobject b = new Gameobject(new Vector2(10,10), "ob", 1);

        a.setCanCollide(true);

        a.transformObject(new Vector2(2,2));
        Physics.UpdateColliders();

        assertEquals(new Vector2(2,2), a.getPos());
    }

    @org.junit.jupiter.api.Test
    void getRenderOrder() {
    }

    @org.junit.jupiter.api.Test
    void setRenderOrder() {
    }

    @org.junit.jupiter.api.Test
    void setActive() {
        Gameobject o = new Gameobject(new Vector2(0,0), "Test1", 1);
        o.setActive(true);
        assertTrue(o.getActive());
        o.setActive(false);
        assertFalse(o.getActive());
    }

    @org.junit.jupiter.api.Test
    void getPos() {
    }

    @org.junit.jupiter.api.Test
    void setPos() {
    }
}