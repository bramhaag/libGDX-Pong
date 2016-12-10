package me.bramhaag.pong.scene;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.annotation.Nonnull;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Bram on 10-12-2016.
 */
public class SceneHandler {

    private SpriteBatch batch;
    private Scene currentScene;

    public SceneHandler(@Nonnull SpriteBatch batch) {
        this.batch = batch;
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void switchScene(@Nonnull Class<? extends Scene> scene) {
        dispose();

        try {
            currentScene = scene.getDeclaredConstructor(SpriteBatch.class).newInstance(batch);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void render() {
        if(currentScene != null)
            currentScene.render();
    }

    public void dispose() {
        if(currentScene != null)
            currentScene.dispose();
    }
}
