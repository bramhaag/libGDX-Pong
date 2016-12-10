package me.bramhaag.pong.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import me.bramhaag.pong.util.Direction;

/**
 * Created by Bram on 10-12-2016.
 */
public abstract class Entity {

    private final double SPEED;

    public int x;
    public int y;

    public int width;

    public Entity(double speed, int x, int y, int width) {
        this.SPEED = speed;

        this.x = x;
        this.y = y;
    }

    public void move(Direction direction) {

    }

    public abstract void draw(ShapeRenderer sr);
}
