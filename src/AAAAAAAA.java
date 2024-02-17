import com.drake.engine.GameFileManager;
import com.drake.engine.core.Engine;
import com.drake.engine.core.Gameobject;
import com.drake.engine.helpers.CollisionOut;
import com.drake.engine.math.Vector2;

import java.awt.event.KeyEvent;

public class AAAAAAAA extends Engine {
    public Gameobject.Direction direction;

//    public static Gameobject game = new Gameobject(new Vector2(0,0), "root");
//    public static Gameobject player = new Gameobject(new Vector2(5,5), new String[]{"S"}, Models.PlayerModel, "Player");
//
//    public static Canvas mainCanvas = new Canvas(new ArrayList<>());
//    public static UIElement title_s = new UIElement(new Vector2(5,8), "Test");

    public static void main(String[] args) {
        System.out.println("Hello world!");
        AAAAAAAA m = new AAAAAAAA();
        m.init();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void OnCollision(CollisionOut col) {
    }

    @Override
    public void OnKeyPressed(KeyEvent e) {
        super.OnKeyPressed(e);
    }

    @Override
    public void OnGameExit() {
        super.OnGameExit();
    }

    @Override
    public void Update() {
        super.Update();
    }
}
