package com.drake.engine.core.UI;

import com.drake.engine.core.Engine;
import com.drake.engine.math.Vector2;

public class UIElement {

    private String text;
    private Vector2 pos;
    private boolean isActive;

    public UIElement(Vector2 pos, String text) {
        this.pos = pos;
        this.text = text;
        this.isActive = true;

        Engine.uio.add(this);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }
}
