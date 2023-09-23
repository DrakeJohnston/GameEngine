import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI extends JFrame {
    public int DIM = 600;
    public int GRID_SIZE = 50;

    public static String[][] preScreenSpace;
    public static JLabel[][] screenSpace;


    public static JPanel uiSpace;
    public static JFrame window;

    public GUI(int DIM, int GRID_SIZE, String backgroundChar){
        this.DIM = DIM;
        this.GRID_SIZE = GRID_SIZE;

        preScreenSpace = new String[GRID_SIZE][GRID_SIZE];
        screenSpace = new JLabel[GRID_SIZE][GRID_SIZE];

        window = new JFrame();
        uiSpace = new JPanel();

        window.addWindowListener(new WindowHelper());
        window.setSize(DIM,DIM);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        window.addKeyListener(new KeyEventListener());

        window.add(uiSpace);
        uiSpace.setSize(DIM,DIM);
        uiSpace.setBackground(Color.PINK);
        uiSpace.setVisible(true);

        uiSpace.setLayout(null);

        for(int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++) {
                JLabel l = new JLabel("0");
                l.setBounds((x*10) + 40, (y*10)+30, 10, 10);
                //System.out.println("x: " + x + " y: " + y);
                l.setText(backgroundChar);
                uiSpace.add(l);
                screenSpace[x][y] = l;
            }
        }

        JButton b = new JButton();
        b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Test");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        b.setSize(10,20);
        b.setVisible(true);
        b.setLocation(0,0);
        uiSpace.add(b);

        uiSpace.repaint();
    }

    public void addToScreen(Vector2 pos, String sym){
        preScreenSpace[pos.x][pos.y] = sym;
        renderScreen();
    }

    public void renderScreen(){
        for(int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++) {
//                JLabel l = new JLabel("0");
//                l.setBounds((x*10) + 40, (y*10)+30, 10, 10);
//                System.out.println("x: " + x + " y: " + y);
                JLabel l = screenSpace[x][y];
                l.setText(preScreenSpace[x][y]);
            }
        }
        uiSpace.repaint();
    }
}
