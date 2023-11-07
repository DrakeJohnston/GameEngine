package com.drake.engine.math;

import com.drake.engine.core.Engine;
import com.drake.engine.core.Gameobject;

public class Physics {

    public static void UpdateColliders(){
        for (Gameobject o : Engine.objects) {
            for (Vector2 vec : o.getCollider()) {
                vec.x += vec.x + o.getPos().x;
                vec.y += vec.y + o.getPos().y;
                //System.out.println("Workin!");
            }
        }
    }
}
