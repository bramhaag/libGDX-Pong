package me.bramhaag.pong.scene;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.bramhaag.pong.input.GameKey;

import javax.annotation.Nonnull;

/**
 * Created by Bram on 10-12-2016.
 */
public abstract class Scene {

    private final SpriteBatch batch;

    public Scene(SpriteBatch batch) {
        this.batch = batch;
    }

    public abstract void render();
    public abstract void dispose();

    public abstract void onKeyPress(@Nonnull GameKey key);
    public abstract void onKeyDown(@Nonnull GameKey key);
    public abstract void onKeyUp(@Nonnull GameKey key);

    public SpriteBatch getBatch() {
        return batch;
    }
}
