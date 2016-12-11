package me.bramhaag.pong.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Bram on 10-12-2016.
 */
public abstract class Entity {

    private final double SPEED;

    public float x;
    public float y;

    public int width;

    public Entity(double speed, float x, float y, int width) {
        this.SPEED = speed;

        this.x = x;
        this.y = y;
    }

    public abstract void move(float x, float y);

    public abstract void draw(ShapeRenderer sr);
}
