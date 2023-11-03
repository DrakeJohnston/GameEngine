import com.drake.engine.core.Engine;
import com.drake.engine.core.Gameobject;
import com.drake.engine.helpers.InputHandler;
import com.drake.engine.math.Vector2;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MainRunner extends Engine {

//    public static int[][] playerModel = {{0}};
//    public static int[][] scModel = {
//            {0,0,0,0,0},
//            {0,1,1,1,0},
//            {0,1,1,1,0},
//            {0,1,1,1,0},
//            {0,0,0,0,0}};
//    public static int[][] doorModel = {{0,0},{0,0}};
//    public static int[][] ballModel = {{0,0},{0,0}};
//
//    public static void main(String[] args) {
//        MainRunner m = new MainRunner();
//        m.init();
//    }
//
//    @Override
//    public void init() {
//        //Other
//        Gameobject sc = new Gameobject(new Vector2(5,5), new String[]{"w", "-"}, scModel, "sc");
//        Gameobject door = new Gameobject(new Vector2(47,5), new String[]{"D"}, doorModel, "door");
//
//
//        //Player
//        Gameobject test = new Gameobject(new Vector2(8,8), new String[]{"A"}, playerModel, "TEST");
//
//        Gameobject ball = new Gameobject(new Vector2(4, 30), new String[]{"B"}, ballModel, "ball");
//
//        sc.setStatic(true);
//        door.setStatic(false);
//        ball.setStatic(true);
//
//        setbColor(Color.GRAY);
//        super.init();
//    }
//
//    @Override
//    public void HandleInput() {
//        Gameobject o = FindGameObject("TEST");
//        if(InputHandler.KeyMap.get(KeyEvent.VK_W)){
//            //o.setPos(new Vector2(o.getPos().x, o.getPos().y-1));
//            o.Move(1, Gameobject.Direction.UP);
//        }
//        if(InputHandler.KeyMap.get(KeyEvent.VK_S)){
//            o.Move(1, Gameobject.Direction.DOWN);
//        }
//        if(InputHandler.KeyMap.get(KeyEvent.VK_A)){
//            o.Move(1, Gameobject.Direction.LEFT);
//        }
//        if(InputHandler.KeyMap.get(KeyEvent.VK_D)){
//            o.Move(1, Gameobject.Direction.RIGHT);
//        }
//        if(InputHandler.KeyMap.get(KeyEvent.VK_P)){
//            Gameobject[] go = Engine.FindGameObjects(new int[]{1, 2, 3});
//            for(Gameobject g : go){
//                System.out.println("Names: "+g.getName());
//            }
//        }
//        super.HandleInput();
//    }
//
//    @Override
//    public void gameLoop() {
//        Gameobject o = Engine.FindGameObject("ball");
//        o.Move(2, Gameobject.Direction.RIGHT);
//        super.gameLoop();
//    }
}