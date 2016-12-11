package me.bramhaag.pong.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import me.bramhaag.pong.Game;

/**
 * Created by Bram on 10-12-2016.
 */
public class Wall extends Entity {

    public static final int HEIGHT = 250;
    public static final int WIDTH = 15;

    public static final int SPEED = 800;

    public Wall(float x, float y) {
        super(SPEED, x, y, WIDTH);
    }

    @Override
    public void draw(ShapeRenderer sr) {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(Color.WHITE);
        sr.rect(x, y, WIDTH, HEIGHT);
        sr.end();
    }

    @Override
    public void move(float x, float y) {
        if(y < 0) {
            y = 0;
        }

        if(y > Game.HEIGHT - HEIGHT) {
            y = Game.HEIGHT - HEIGHT;
        }

        this.x = x;
        this.y = y;
    }
}
