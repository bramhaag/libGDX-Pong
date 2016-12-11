package me.bramhaag.pong;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.bramhaag.pong.input.InputHandler;
import me.bramhaag.pong.scene.MainScene;
import me.bramhaag.pong.scene.SceneHandler;

import javax.annotation.Nonnull;

public class Game implements ApplicationListener {

	public static final String TITLE = "Pong";

	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;

    @Nonnull
    public static OrthographicCamera camera;

    @Nonnull
    public static SceneHandler sceneHandler;

    @Nonnull
	private SpriteBatch batch;

    @Nonnull
    private InputHandler inputHandler;

	@Override
	public void create() {
        camera = new OrthographicCamera(WIDTH, HEIGHT);
        camera.update();

        batch = new SpriteBatch();

        sceneHandler = new SceneHandler(batch);
        sceneHandler.switchScene(MainScene.class);

        inputHandler = new InputHandler();
        Gdx.input.setInputProcessor(inputHandler);
    }

    @Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        sceneHandler.render();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
	public void dispose() {
		batch.dispose();
		sceneHandler.dispose();
	}
}
