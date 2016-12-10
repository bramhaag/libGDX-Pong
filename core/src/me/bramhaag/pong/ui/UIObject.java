package me.bramhaag.pong.ui;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Bram on 10-12-2016.
 */
public abstract class UIObject {

    public int x;
    public int y;

    public UIObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(ShapeRenderer sr);
    public abstract void dispose();
}
