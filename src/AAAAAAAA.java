import com.drake.engine.GameFileManager;
import com.drake.engine.core.Engine;
import com.drake.engine.core.Gameobject;
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
        direction = Gameobject.Direction.UP;
        Engine.changeBGChar("-");
        //game.addChild(player);

//        int[] p = new int[]{JMC.A1, JMC.A0, JMC.A1, JMC.A6, JMC.A6};
//        Phrase ph = MusicHandler.CreateRandomPhrase(5, 100, 90);
//        Engine.PlaySong(p, JMC.EIGHTH_NOTE, false);

        GameFileManager.LoadData(GameFileManager.getSaveLocation()+"SAVEFILE.sgam");
        System.out.println(GameFileManager.GetData("E") + " Dis the data!!!");
        int testT = Integer.parseInt(GameFileManager.GetData("E"));
        GameFileManager.SaveInteger("E", 55);

        //mainCanvas.addElement(title_s);
        //mainCanvas.setActive(false);

        Gameobject test = new Gameobject(new Vector2(5,5), Engine.LoadImage("C:\\Users\\ironb\\OneDrive\\Documents\\GameEngine\\Resources\\TestSprite3.png"), 5, "Test", false);
        Gameobject wall = new Gameobject(new Vector2(30,30), Engine.LoadImage("C:\\Users\\ironb\\OneDrive\\Documents\\GameEngine\\Resources\\Wall.png"), 8, "Wall", true);
        super.init();
    }

    @Override
    public void OnKeyPressed(KeyEvent e) {
        super.OnKeyPressed(e);
        Gameobject o = Engine.FindGameObject("Test");
        //CollisionReturn c = Physics.HasCollided(o);

        if(e.getKeyCode() == KeyEvent.VK_D){
            if(!o.hasCollided()){
                o.setPos(new Vector2(o.getPos().x+1, o.getPos().y));
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            if(!o.hasCollided()){
                //System.out.println("Test");
                o.setPos(new Vector2(o.getPos().x, o.getPos().y+1));
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            if(!o.hasCollided()){
                o.setPos(new Vector2(o.getPos().x-1, o.getPos().y));
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            if(!o.hasCollided()){
                o.setPos(new Vector2(o.getPos().x, o.getPos().y-1));
            }
        }
    }

    @Override
    public void OnGameExit() {
        GameFileManager.SaveData("SAVEFILE");
        super.OnGameExit();
    }

    @Override
    public void Update() {

        //player.Move(1, direction);

        super.Update();
    }
}
