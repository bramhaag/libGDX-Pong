package me.bramhaag.pong.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Bram on 10-12-2016.
 */
public class Wall extends Entity {

    public static final int HEIGHT = 250;
    public static final int WIDTH = 15;

    public static final int SPEED = 5;

    public Wall(int x, int y) {
        super(SPEED, x, y, WIDTH);
    }

    @Override
    public void draw(ShapeRenderer sr) {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(Color.WHITE);
        sr.rect(x, y, WIDTH, HEIGHT);
        sr.end();
    }
}
