package com.drake.engine.core.UI;

import java.util.ArrayList;

public class Canvas {
    private ArrayList<UIElement> elements;
    private boolean isActive = true;

    public Canvas(ArrayList<UIElement> elements){
        this.elements = elements;
    }

    public void addElement(UIElement e){
        elements.add(e);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        if(elements.isEmpty()) {
            isActive = active;
        }else{
            for(UIElement e : elements){
                e.setActive(active);
            }
            isActive = active;
        }
    }

    public ArrayList<UIElement> getElements() {
        return elements;
    }

    public void setElements(ArrayList<UIElement> elements) {
        this.elements = elements;
    }
}
