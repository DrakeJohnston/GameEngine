import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class Main {

    public static boolean isActive = true;

    public static void main(String[] args) {
        GUI ui = new GUI(600,50,"0");

        GameLoop();
    }

    public static void Test(){
        System.out.println("Yup");
        isActive = false;
    }

    public static void GameLoop(){
        while(isActive){
            System.out.println("Test");
        }
    }

}