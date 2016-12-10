package me.bramhaag.pong.input;

import com.badlogic.gdx.InputAdapter;
import me.bramhaag.pong.Game;

import javax.annotation.Nonnull;

/**
 * Created by Bram on 10-12-2016.
 */
public class InputHandler extends InputAdapter {

    @Override
    public boolean keyDown(@Nonnull int keycode) {
        for(GameKey key : GameKey.values()) {
            if(key.getKeyCode() == keycode) {
                Game.sceneHandler.getCurrentScene().onKeyDown(key);

                break;
            }
        }

        return true;
    }

    @Override
    public boolean keyUp(@Nonnull int keycode) {
        for(GameKey key : GameKey.values()) {
            if(key.getKeyCode() == keycode) {
                Game.sceneHandler.getCurrentScene().onKeyUp(key);

                break;
            }
        }

        return true;
    }
}
