package me.bramhaag.pong.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import me.bramhaag.pong.Game;
import me.bramhaag.pong.entity.Wall;
import me.bramhaag.pong.input.GameKey;
import me.bramhaag.pong.ui.DottedLine;
import me.bramhaag.pong.ui.Score;
import me.bramhaag.pong.util.Side;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bram on 10-12-2016.
 */
public class PlayScene extends Scene {

    private List<ShapeRenderer> renderers;
    private ShapeRenderer renderer;

    private Wall wallLeft;
    private Wall wallRight;

    private Score scoreLeft;
    private Score scoreRight;

    private DottedLine middleLine;

    //Score test code
    private double score = 0;

    public PlayScene(SpriteBatch batch) {
        super(batch);

        renderers = new ArrayList<>();
        renderer = new ShapeRenderer();

        wallLeft = new Wall(100, (Game.HEIGHT - Wall.HEIGHT) / 2);
        wallRight = new Wall(Game.WIDTH - 100, (Game.HEIGHT - Wall.HEIGHT) / 2);

        middleLine = new DottedLine(Game.WIDTH / 2, (Game.HEIGHT - Wall.HEIGHT) / 2);

        scoreLeft = new Score(-100, -100, Side.LEFT, getBatch());
        scoreRight = new Score(100, -100, Side.RIGHT, getBatch());
    }

    @Override
    public void render() {

        //Score test code
        /*score += Gdx.graphics.getDeltaTime();
        scoreLeft.updateScore((int)Math.floor(score));
        scoreRight.updateScore((int)Math.floor(score));*/

        getBatch().begin();

        scoreRight.draw(null);
        scoreLeft.draw(null);

        getBatch().end();

        //TODO implement a method to the InputHandler to be able to do such things
        if(Gdx.input.isKeyPressed(GameKey.DOWN.getKeyCode()) && !Gdx.input.isKeyPressed(GameKey.UP.getKeyCode()))
            wallLeft.move(wallLeft.x,wallLeft.y - (Gdx.graphics.getDeltaTime() * wallLeft.SPEED));
        else if(Gdx.input.isKeyPressed(GameKey.UP.getKeyCode()) && !Gdx.input.isKeyPressed(GameKey.DOWN.getKeyCode()))
            wallLeft.move(wallLeft.x,wallLeft.y + (Gdx.graphics.getDeltaTime() * wallLeft.SPEED));

        wallLeft.draw(renderer);
        wallRight.draw(renderer);

        middleLine.draw(renderer);
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void onKeyPress(@Nonnull GameKey key) {
        /*if(key == GameKey.DOWN)
            wallLeft.move(wallLeft.x, wallLeft.y-1);*/
    }

    @Override
    public void onKeyDown(@Nonnull GameKey key) {

    }

    @Override
    public void onKeyUp(@Nonnull GameKey key) {

    }
}
