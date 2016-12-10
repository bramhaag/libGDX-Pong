package me.bramhaag.pong.scene;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import me.bramhaag.pong.Game;
import me.bramhaag.pong.entity.Wall;
import me.bramhaag.pong.input.GameKey;
import me.bramhaag.pong.ui.DottedLine;
import me.bramhaag.pong.ui.Score;

import javax.annotation.Nonnull;

/**
 * Created by Bram on 10-12-2016.
 */
public class PlayScene extends Scene {

    private Wall wallLeft;
    private Wall wallRight;

    private Score scoreLeft;
    private Score scoreRight;

    private DottedLine middleLine;

    public PlayScene(SpriteBatch batch) {
        super(batch);

        wallLeft = new Wall(100, (Game.HEIGHT - Wall.HEIGHT) / 2);
        wallRight = new Wall(Game.WIDTH - 100, (Game.HEIGHT - Wall.HEIGHT) / 2);

        middleLine = new DottedLine(Game.WIDTH / 2, (Game.HEIGHT - Wall.HEIGHT) / 2);

        scoreLeft = new Score((Game.WIDTH / 2) - 100,Game.HEIGHT - 100, getBatch());
        scoreRight = new Score((Game.WIDTH / 2) + 100,Game.HEIGHT - 100, getBatch());
    }

    @Override
    public void render() {
        wallLeft.draw(new ShapeRenderer());
        wallRight.draw(new ShapeRenderer());

        middleLine.draw(new ShapeRenderer());

        scoreLeft.draw(new ShapeRenderer());
        scoreRight.draw(new ShapeRenderer());
    }

    @Override
    public void dispose() {
    }

    @Override
    public void onKeyDown(@Nonnull GameKey key) {

    }

    @Override
    public void onKeyUp(@Nonnull GameKey key) {

    }
}
