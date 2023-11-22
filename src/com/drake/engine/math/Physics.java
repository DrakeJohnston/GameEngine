package com.drake.engine.math;

import com.drake.engine.core.Engine;
import com.drake.engine.core.Gameobject;

public class Physics {

    public static void UpdateColliders(){
        for (Gameobject o : Engine.objects) {
            Vector2[][] collider = o.getCollider();
            int xVal = -o.getSize()/2;
            int yVal = -o.getSize()/2;

            for(int x = 0; x < o.getSize(); x++){
                for(int y = 0; y < o.getSize(); y++){
                    collider[x][y] = new Vector2(o.getPos().x,o.getPos().y);
                }
            }
        }
    }
}
