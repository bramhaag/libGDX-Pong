package me.bramhaag.pong.input;

import com.badlogic.gdx.Input;

import javax.annotation.Nonnull;

/**
 * Created by Bram on 10-12-2016.
 */
public enum GameKey {

    PAUSE(Input.Keys.ESCAPE),
    SPACE(Input.Keys.SPACE),

    UP(Input.Keys.UP),
    DOWN(Input.Keys.DOWN);

    private int keyCode;

    GameKey(@Nonnull int keyCode) {
        this.keyCode = keyCode;
    }

    public int getKeyCode() {
        return keyCode;
    }
}
