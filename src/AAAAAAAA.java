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

        int[] p = new int[]{JMC.A1, JMC.A0, JMC.A1, JMC.A6, JMC.A6};
        Phrase ph = MusicHandler.CreateRandomPhrase(5, 50, 40);
        Engine.PlaySong(ph, false);
        //Engine.PlaySong(p, JMC.HALF_NOTE, false);

        GameFileManager.LoadData(GameFileManager.getSaveLocation()+"SAVEFILE.sgam");
        System.out.println(GameFileManager.GetData("E") + " Dis the data!!!");
        int testT = Integer.parseInt(GameFileManager.GetData("E"));
        GameFileManager.SaveInteger("E", 55);

        //mainCanvas.addElement(title_s);
        //mainCanvas.setActive(false);

        Gameobject test = new Gameobject(new Vector2(5,5), Engine.LoadImage("D:\\Repositories\\GameEngine\\Resources\\TestSprite3.png"), 5, "Test");
        super.init();
    }

    @Override
    public void OnKeyPressed(KeyEvent e) {
        super.OnKeyPressed(e);
        if(e.getKeyCode() == KeyEvent.VK_D){
            Gameobject o = Engine.FindGameObject("Test");
            o.Move(1, Gameobject.Direction.RIGHT);
            //System.out.println("Moved: " + o.getPos().x);
        }
    }

    @Override
    public void OnGameExit() {
        GameFileManager.SaveData("SAVEFILE");
        super.OnGameExit();
    }

    @Override
    public void gameLoop() {

        //player.Move(1, direction);

        super.gameLoop();
    }
}
