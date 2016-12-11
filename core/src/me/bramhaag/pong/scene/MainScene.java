package me.bramhaag.pong.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import me.bramhaag.pong.Game;
import me.bramhaag.pong.input.GameKey;
import me.bramhaag.pong.util.Message;

import javax.annotation.Nonnull;

/**
 * Created by Bram on 10-12-2016.
 */
public class MainScene extends Scene {

    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    private final BitmapFont TITLE_FONT;
    private final GlyphLayout TITLE_LAYOUT;

    private final BitmapFont SUBTITLE_FONT;
    private final GlyphLayout SUBTITLE_LAYOUT;

    private float timeState = 0f;

    public MainScene(SpriteBatch batch) {
        super(batch);

        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Scream.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 150;

        TITLE_FONT = generator.generateFont(parameter);
        TITLE_LAYOUT = new GlyphLayout(TITLE_FONT, Game.TITLE);

        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/VT323.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 100;

        SUBTITLE_FONT = generator.generateFont(parameter);
        SUBTITLE_LAYOUT = new GlyphLayout(SUBTITLE_FONT, Message.PRESS_TO_CONTINUE.toString());
    }

    @Override
    public void render() {
        getBatch().begin();

        TITLE_FONT.draw(getBatch(), TITLE_LAYOUT, (Game.WIDTH - TITLE_LAYOUT.width) / 2, Game.HEIGHT - 200);

        timeState += Gdx.graphics.getDeltaTime();

        if(timeState >= 0.5f && timeState <= 1.3f) {
            SUBTITLE_FONT.draw(getBatch(), SUBTITLE_LAYOUT, (Game.WIDTH - SUBTITLE_LAYOUT.width) / 2, 200);
        } else if(timeState > 1.3f) {
            timeState = 0f;
        }

        getBatch().end();

    }

    @Override
    public void dispose() {
        TITLE_FONT.dispose();
        SUBTITLE_FONT.dispose();
    }

    @Override
    public void onKeyPress(@Nonnull GameKey key) {

    }

    @Override
    public void onKeyDown(@Nonnull GameKey key) {
        if(key == GameKey.SPACE) {
            Game.sceneHandler.switchScene(PlayScene.class);
        }
    }

    @Override
    public void onKeyUp(@Nonnull GameKey key) {

    }
}
