package com.drake.engine.math;

import com.drake.engine.core.Engine;
import com.drake.engine.core.Gameobject;
import com.drake.engine.helpers.CollisionOut;

import java.util.ArrayList;
import java.util.Arrays;

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
        Gameobject a = Gameobject.objects.get(0);
        ArrayList<Gameobject> b = new ArrayList<>(Gameobject.objects);
        b.remove(0);

        //Checks a against all objects in b
        for(Gameobject obj : b){
            for(Vector2[] v : obj.getCollider().getCollider()){
                for(Vector2 v2 : v){
                    if(a.getCollider().hasPos(v2)){
                        if(obj.isKinematic()) {
                            Engine.engine.OnCollision(new CollisionOut(obj, v2, new Vector2(0, 0)));
                        }else {
                            outerloop:
                            while (true) {
                                for (Vector2[] veca : a.getCollider().getCollider()) {
                                    for (Vector2 vecb : veca) {
                                        if (obj.getCollider().hasPos(vecb)) {
                                            Vector2 vec = a.getPos();
                                            vec.subtract(new Vector2(1, 1));
                                            a.transformObject(vec);
                                            UpdateColliders();
                                        } else {
                                            break outerloop;
                                        }
                                    }
                                }
                            }
                            System.out.println("Worked? " + a.getPos());
                        }
                    }
                }
            }
        }

        CheckCollisions(b);

    }
    private static void CheckCollisions(ArrayList<Gameobject> o){
        Gameobject a = o.get(0);
        ArrayList<Gameobject> b = new ArrayList<>(o);
        b.remove(0);

        //Checks a against all objects in b
        for(Gameobject obj : b){
            for(Vector2[] v : obj.getCollider().getCollider()){
                for(Vector2 v2 : v){
                    if(a.getCollider().hasPos(v2)){
                        if(obj.isKinematic()) {
                            Engine.engine.OnCollision(new CollisionOut(obj, v2, new Vector2(0, 0)));
                        }else{
                            outerloop:
                            while (true) {
                                for (Vector2[] veca : a.getCollider().getCollider()) {
                                    for (Vector2 vecb : veca) {
                                        if (obj.getCollider().hasPos(vecb)) {
                                            Vector2 vec = a.getPos();
                                            vec.subtract(new Vector2(1, 1));
                                            a.transformObject(vec);
                                            UpdateColliders();
                                        } else {
                                            break outerloop;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if(o.size() > 1) {
            CheckCollisions(b);
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
