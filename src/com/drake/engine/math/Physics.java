package com.drake.engine.math;

import com.drake.engine.core.Engine;
import com.drake.engine.core.Gameobject;
import com.drake.engine.helpers.CollisionOut;

import java.util.ArrayList;

public class Physics {

    public static ArrayList<Gameobject> Raycast(int maxDist, Vector2 startPos, Vector2 dir){
        ArrayList<Gameobject> hits = new ArrayList<>();

        Vector2 change = Vector2.multiply(dir, maxDist);
        Vector2 endZone = Vector2.add(startPos, change);

        Vector2 currentSpace = new Vector2(startPos);
        int maxrec = 0;

        while(maxrec < maxDist*2){
            currentSpace.add(dir);
            Gameobject o = Gameobject.FindGameObject(currentSpace);
            if(o!=null){
                hits.add(o);
            }
            if(currentSpace.equals(endZone)){
                break;
            }
            maxrec++;
        }
        return hits;
    }

    public static ArrayList<Gameobject> Raycast(int maxDist, Vector2 startPos, Vector2 dir, int layer){
        ArrayList<Gameobject> hits = new ArrayList<>();

        Vector2 change = Vector2.multiply(dir, maxDist);
        Vector2 endZone = Vector2.add(startPos, change);

        Vector2 currentSpace = new Vector2(startPos);
        int maxrec = 0;

        while(maxrec < maxDist*2){
            currentSpace.add(dir);
            Gameobject o = Gameobject.FindGameObject(currentSpace);
            if(o!=null && o.getLayer() == layer){
                hits.add(o);
            }
            if(currentSpace.equals(endZone)){
                break;
            }
            maxrec++;
        }
        return hits;
    }

    public static void CheckCollisions(){
        ArrayList<Gameobject.CollisionBox> cb = new ArrayList<>();

        for(Gameobject.CollisionBox c : Gameobject.CollisionBox.colliders){
            cb.add(new Gameobject.CollisionBox(c.getCollider().length, c.getCollider(), c.parent));
        }

        int i = Gameobject.CollisionBox.colliders.size();
        while(i > 0) {
            Gameobject.CollisionBox currBox = cb.get(0);
            for (Gameobject.CollisionBox box : cb) {
                if (box != currBox) {
                    for (Vector2[] x : box.getCollider()) {
                        for (Vector2 y : x) {
                            if (currBox.hasPos(y)) {
                                Engine.OnCollision(new CollisionOut(box.parent, y, new Vector2(0, 0)));
                                System.out.println("Collision detected");
                            }
                        }
                    }
                }
            }
            cb.remove(0);
            i--;
        }
    }

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
