import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class KeyEventListener implements KeyListener {

    /*List of keycodes*/
    //32 -- Space
    //33 -- Page Up
    //34 -- Page Down
    //35 -- End
    //36 -- Home
    //37 -- Left
    //38 -- Up
    //39 -- Right
    //40 -- Down
    //44 -- Comma
    //45 -- Minus
    //46 -- Period
    //47 -- Slash
    //48 -- 0
    //49 -- 1
    //50 -- 2
    //51 -- 3
    //52 -- 4
    //53 -- 5
    //54 -- 6
    //55 -- 7
    //56 -- 8
    //57 -- 9
    //59 -- Semicolon
    //61 -- Equals
    //65 -- A
    //66 -- B
    //67 -- C
    //68 -- D
    //69 -- E
    //70 -- F
    //71 -- G
    //72 -- H
    //73 -- I
    //74 -- J
    //75 -- K
    //76 -- L
    //77 -- M
    //78 -- N
    //79 -- O
    //80 -- P
    //81 -- Q
    //82 -- R
    //83 -- S
    //84 -- T
    //85 -- U
    //86 -- V
    //87 -- W
    //88 -- X
    //89 -- Y
    //90 -- Z
    //91 -- Open Bracket
    //92 -- Back Slash
    //93 -- Close Bracket
    //96 -- NumPad-0
    //97 -- NumPad-1
    //98 -- NumPad-2
    //99 -- NumPad-3
    //100 -- NumPad-4
    //101 -- NumPad-5
    //102 -- NumPad-6
    //103 -- NumPad-7
    //104 -- NumPad-8
    //105 -- NumPad-9
    //106 -- NumPad *
    //107 -- NumPad +
    //108 -- NumPad ,
    //110 -- NumPad .
    //109 -- NumPad -
    //111 -- NumPad /
    //112 -- F1
    //113 -- F2
    //114 -- F3
    //115 -- F4
    //116 -- F5
    //117 -- F6
    //118 -- F7
    //119 -- F8
    //120 -- F9
    //121 -- F10
    //122 -- F11
    //123 -- F12
    //Hashmap containing the keykode - state pairs
    public static Map<Integer, Boolean> KeyMap = new HashMap<>();

    //adds all relevant keycodes to the map
    public KeyEventListener(){
        //char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for(int i = 0; i < 526; i++){
            KeyMap.put(i, false);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(KeyMap.containsKey(e.getKeyCode())) {
            KeyMap.replace(e.getKeyCode(), true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(KeyMap.containsKey(e.getKeyCode())) {
            KeyMap.replace(e.getKeyCode(), false);
        }
    }
}
