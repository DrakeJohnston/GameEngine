package com.drake.engine.math;

import com.drake.engine.core.Engine;
import com.drake.engine.core.Gameobject;

public class Physics {

    /**
     * Updates the colliders on gameobjects currently active in the scene
     */
    public static void UpdateColliders(){
        for (Gameobject o : Gameobject.objects) {
            Gameobject.CollisionBox collider = o.getCollider();
            Vector2 op = o.getPos();
            Vector2[][] col = collider.getCollider();

            if (!col[0][0].equals(op)) {
                Vector2[][] c = new Vector2[o.getSize()][o.getSize()];

                for (int x = 0; x < o.getSize(); x++) {
                    for (int y = 0; y < o.getSize(); y++) {
                        c[x][y] = new Vector2(o.getPos().x + x, o.getPos().y + y);
                    }
                }

                collider.setCollider(c);
            }
        }
    }
}
