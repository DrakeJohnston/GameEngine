import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

public class Engine {

    public static ArrayList<Gameobject> objects = new ArrayList<>();
    public static boolean isActive = true;

    public GUI ui;

    public void init(){
        ui = new GUI(600,50,"0");
        gameLoop();
    }

    public void gameLoop(){

        RenderObjects();
        HandleInput();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(isActive) {
            gameLoop();
        }
    }

    public void HandleInput() {
        if (KeyEventListener.KeyMap.get(VK_BACK_SLASH)) {
            System.out.println("debug key! : " + KeyEventListener.KeyMap.get(VK_BACK_SLASH));
        }
    }

    private void RenderObjects() {
        for(Gameobject g : objects){
            ui.addToScreen(g.getPos(), g.getSymbol());
        }
    }

}
