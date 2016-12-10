package me.bramhaag.pong.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import me.bramhaag.pong.Game;
import me.bramhaag.pong.input.GameKey;

import javax.annotation.Nonnull;

/**
 * Created by Bram on 10-12-2016.
 */
public class PlayScene extends Scene {

    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    private BitmapFont font;

    public PlayScene(SpriteBatch batch) {
        super(batch);

        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Scream.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size = 150;

        font = generator.generateFont(parameter);
    }

    @Override
    public void render() {
        final GlyphLayout layout = new GlyphLayout(font, "Play");
        font.draw(getBatch(), layout, (Game.WIDTH - layout.width)/2, Game.HEIGHT - 500);
    }

    @Override
    public void dispose() {
        font.dispose();
    }

    @Override
    public void onKeyDown(@Nonnull GameKey key) {

    }

    @Override
    public void onKeyUp(@Nonnull GameKey key) {

    }
}
