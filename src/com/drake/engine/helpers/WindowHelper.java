package com.drake.engine.helpers;

import com.drake.engine.core.Engine;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowHelper implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Closing Window: " + Engine.isActive);
        Engine.isActive = false;
    }

    @Override
    public void windowClosed(WindowEvent e) {

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
