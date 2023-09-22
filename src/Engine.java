import java.util.ArrayList;

public class Engine {

    public static ArrayList<Gameobject> objects = new ArrayList<>();
    public static boolean isActive = true;

    public void init(){
        GUI ui = new GUI(600,50,"0");
        gameLoop();
    }

    public void gameLoop(){

        RenderObjects();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(isActive) {
            gameLoop();
        }
    }

    private void RenderObjects() {

    }

}
