package com.drake.engine.math;

import com.drake.engine.core.Gameobject;

public class CollisionReturn {
    public Gameobject hit;
    public Vector2 location;
    public Gameobject.Direction direction;

    public CollisionReturn(Gameobject hit, Vector2 location, Gameobject.Direction direction){
        this.hit = hit;
        this.location = location;
        this.direction = direction;
    }
}
