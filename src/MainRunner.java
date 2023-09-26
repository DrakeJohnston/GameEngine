import com.drake.engine.core.Engine;
import com.drake.engine.core.Gameobject;
import com.drake.engine.helpers.InputHandler;
import com.drake.engine.math.Vector2;

import java.awt.event.KeyEvent;

public class MainRunner extends Engine {

    public static void main(String[] args) {
        MainRunner m = new MainRunner();
        m.init();
    }

    @Override
    public void init() {
        //Other
        Gameobject sc = new Gameobject(new Vector2(5,5), new Vector2(5,5), "|", "sc");
        Gameobject sc2 = new Gameobject(new Vector2(9,9), new Vector2(5,5), "|", "sc");

        Gameobject door = new Gameobject(new Vector2(47,5), new Vector2(1,2), "D", "door");
        Gameobject doorp2 = new Gameobject(new Vector2(47,7), new Vector2(1,1), "~", "door");
        Gameobject doorp3 = new Gameobject(new Vector2(47,4), new Vector2(1,1), "~", "door");

        //Walls
        Gameobject sc3 = new Gameobject(new Vector2(0,0), new Vector2(50,2), "|", "sc");
        Gameobject sc4 = new Gameobject(new Vector2(0,0), new Vector2(2,50), "|", "sc");
        Gameobject sc5 = new Gameobject(new Vector2(0,48), new Vector2(50,2), "|", "sc");
        Gameobject sc6 = new Gameobject(new Vector2(48,0), new Vector2(2,50), "|", "sc");

        //Player
        Gameobject test = new Gameobject(new Vector2(8,8), new Vector2(1,1), "A", "TEST");

        sc.setStatic(false);
        door.setStatic(false);
        super.init();
    }

    @Override
    public void HandleInput() {
        Gameobject o = FindGameObject("TEST");
        if(InputHandler.KeyMap.get(KeyEvent.VK_W)){
            //o.setPos(new Vector2(o.getPos().x, o.getPos().y-1));
            o.Move(new Vector2(o.getPos().x, o.getPos().y-1));
        }
        if(InputHandler.KeyMap.get(KeyEvent.VK_S)){
            o.Move(new Vector2(o.getPos().x, o.getPos().y+1));
        }
        if(InputHandler.KeyMap.get(KeyEvent.VK_A)){
            o.Move(new Vector2(o.getPos().x-1, o.getPos().y));
        }
        if(InputHandler.KeyMap.get(KeyEvent.VK_D)){
            o.Move(new Vector2(o.getPos().x+1, o.getPos().y));
        }
        super.HandleInput();
    }

    @Override
    public void gameLoop() {
       // System.out.println("A");
        super.gameLoop();
    }
}