import java.awt.event.KeyEvent;

public class MainRunner extends Engine {

    public static void main(String[] args) {
        MainRunner m = new MainRunner();
        m.init();
    }

    @Override
    public void init() {
        Gameobject test = new Gameobject(new Vector2(0,0), "A");
        super.init();
    }

    @Override
    public void HandleInput() {
        if(KeyEventListener.KeyMap.get(KeyEvent.VK_P)){
            System.out.println("Test Case Worked!!");
        }
        super.HandleInput();
    }

    @Override
    public void gameLoop() {
       // System.out.println("A");
        super.gameLoop();
    }
}