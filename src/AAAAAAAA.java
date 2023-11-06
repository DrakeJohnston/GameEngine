import com.drake.engine.GameFileManager;
import com.drake.engine.MusicHandler;
import com.drake.engine.core.Engine;
import com.drake.engine.core.Gameobject;
import com.drake.engine.math.Vector2;
import jm.JMC;
import jm.music.data.Phrase;

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
        Gameobject wall = new Gameobject(new Vector2(40,40), Engine.LoadImage("C:\\Users\\ironb\\OneDrive\\Documents\\GameEngine\\Resources\\Wall.png"), 8, "Wall", true);
        super.init();
    }

    @Override
    public void OnKeyPressed(KeyEvent e) {
        super.OnKeyPressed(e);
        Gameobject o = Engine.FindGameObject("Test");
        if(e.getKeyCode() == KeyEvent.VK_D){
            o.Move(1, Gameobject.Direction.RIGHT);
            //System.out.println("Moved: " + o.getPos().x);
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            o.Move(1, Gameobject.Direction.LEFT);
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            o.Move(1, Gameobject.Direction.UP);
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            o.Move(1, Gameobject.Direction.DOWN);
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
