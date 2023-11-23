package com.drake.engine.helpers;

import com.drake.engine.core.Gameobject;
import com.drake.engine.math.Vector2;

public class CollisionOut {
    public int distance;
    public Vector2 location;
    public Vector2 direction;

    public CollisionOut(int dist, Vector2 location, Vector2 dir){
        distance = dist;
        this.location = new Vector2(location);
        direction = new Vector2(dir);
    }
}
