import java.awt.event.KeyEvent;

public class MainRunner extends Engine {

    public static void main(String[] args) {
        MainRunner m = new MainRunner();
        m.init();
    }

    @Override
    public void init() {
        Gameobject test = new Gameobject(new Vector2(0,0), "A", "TEST");
        super.init();
    }

    @Override
    public void HandleInput() {
        Gameobject o = Engine.FindGameObject("TEST");
        if(KeyEventListener.KeyMap.get(KeyEvent.VK_W)){
            o.setPos(new Vector2(o.getPos().x, o.getPos().y-1));
        }
        if(KeyEventListener.KeyMap.get(KeyEvent.VK_S)){
            o.setPos(new Vector2(o.getPos().x, o.getPos().y+1));
        }
        if(KeyEventListener.KeyMap.get(KeyEvent.VK_A)){
            o.setPos(new Vector2(o.getPos().x-1, o.getPos().y));
        }
        if(KeyEventListener.KeyMap.get(KeyEvent.VK_D)){
            o.setPos(new Vector2(o.getPos().x+1, o.getPos().y));
        }
        super.HandleInput();
    }

    @Override
    public void gameLoop() {
       // System.out.println("A");
        super.gameLoop();
    }
}