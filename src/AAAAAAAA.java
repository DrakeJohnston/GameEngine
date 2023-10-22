import com.drake.engine.core.Engine;
import com.drake.engine.core.Gameobject;
import com.drake.engine.helpers.InputHandler;
import com.drake.engine.math.Vector2;

import java.awt.event.KeyEvent;

public class AAAAAAAA extends Engine {
    public Gameobject.Direction direction;

    public static Gameobject game = new Gameobject(new Vector2(0,0), "root");
    public static Gameobject player = new Gameobject(new Vector2(5,5), new String[]{"@"}, Models.PlayerModel, "Player");

    public static Gameobject mainmenu = new Gameobject(new Vector2(0,0), "root");
    public static  Gameobject title_s = new Gameobject(new Vector2(5,8), new String[]{"s", "n", "a", "k", "e"}, Models.titleModelS, "Title_s");
    public static  Gameobject title_g = new Gameobject(new Vector2(5,5), new String[]{"g", "a", "m", "e"}, Models.titleModelG, "Title_g");

    public static void main(String[] args) {
        System.out.println("Hello world!");
        AAAAAAAA m = new AAAAAAAA();
        m.init();
    }

    @Override
    public void init() {
        direction = Gameobject.Direction.UP;
        game.addChild(player);

        mainmenu.addChild(title_s);
        mainmenu.addChild(title_g);

        mainmenu.setActive(false);
        super.init();
    }

    @Override
    public void HandleInput() {
        if(game.getActive()){
            if(InputHandler.KeyMap.get(KeyEvent.VK_W)){
                direction = Gameobject.Direction.UP;
            }
            if(InputHandler.KeyMap.get(KeyEvent.VK_A)){
                direction = Gameobject.Direction.LEFT;
            }
            if(InputHandler.KeyMap.get(KeyEvent.VK_S)){
                direction = Gameobject.Direction.DOWN;
            }
            if(InputHandler.KeyMap.get(KeyEvent.VK_D)){
                direction = Gameobject.Direction.RIGHT;
                //System.out.println("Test");
            }
        }

        if(InputHandler.KeyMap.get(KeyEvent.VK_ESCAPE)){
            game.setActive(false);
            mainmenu.setActive(true);
        }

        super.HandleInput();
    }

    @Override
    public void gameLoop() {

        player.Move(1, direction);

        super.gameLoop();
    }
}
