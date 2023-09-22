import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowHelper implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Closing Window: " + Main.isActive);
        Main.Test();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Closed Window: " + Main.isActive);
        Main.Test();
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
