package me.bramhaag.pong.ui;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import me.bramhaag.pong.Game;

/**
 * Created by Bram on 10-12-2016.
 */
public class DottedLine extends UIObject {

    private static final int WIDTH = 15;
    private static final int HEIGHT = 100;

    public DottedLine(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(ShapeRenderer sr) {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(1, 1, 1, 0.5f);

        int yOffset = (Game.HEIGHT % HEIGHT) / 2;

        for(int posY = 0; posY < Math.floor(Game.HEIGHT / HEIGHT); posY++) {
            sr.rectLine(x, (posY * HEIGHT) + yOffset, x, (posY * HEIGHT) + HEIGHT, WIDTH);
        }

        sr.end();
    }

    @Override
    public void dispose() {

    }
}
