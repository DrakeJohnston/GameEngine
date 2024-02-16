package com.drake.engine.helpers;

import com.drake.engine.core.Gameobject;
import com.drake.engine.math.Vector2;

public class CollisionOut {
    public Gameobject hit;
    public Vector2 location;
    public Vector2 direction;

    public CollisionOut(Gameobject hit, Vector2 location, Vector2 dir){
        this.hit = hit;
        this.location = new Vector2(location);
        direction = new Vector2(dir);
    }
}
