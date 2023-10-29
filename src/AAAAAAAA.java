import com.drake.engine.MusicHandler;
import com.drake.engine.core.Engine;
import com.drake.engine.core.Gameobject;
import com.drake.engine.core.UI.Canvas;
import com.drake.engine.core.UI.UIElement;
import com.drake.engine.helpers.InputHandler;
import com.drake.engine.math.Vector2;
import jm.JMC;
import jm.music.data.Phrase;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class AAAAAAAA extends Engine {
    public Gameobject.Direction direction;

    public static Gameobject game = new Gameobject(new Vector2(0,0), "root");
    public static Gameobject player = new Gameobject(new Vector2(5,5), new String[]{"S"}, Models.PlayerModel, "Player");

    public static Canvas mainCanvas = new Canvas(new ArrayList<>());
    public static UIElement title_s = new UIElement(new Vector2(5,8), "Test");

    public static void main(String[] args) {
        System.out.println("Hello world!");
        AAAAAAAA m = new AAAAAAAA();
        m.init();
    }

    @Override
    public void init() {
        direction = Gameobject.Direction.UP;
        Engine.changeBGChar("-");
        game.addChild(player);

        int[] p = new int[]{JMC.A1, JMC.A0, JMC.A1};
        Engine.PlaySong(p, JMC.HALF_NOTE, false);

        mainCanvas.addElement(title_s);
        mainCanvas.setActive(false);

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
            mainCanvas.setActive(true);
        }

        super.HandleInput();
    }

    @Override
    public void gameLoop() {

        player.Move(1, direction);

        super.gameLoop();
    }
}
