package me.bramhaag.pong.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Bram on 10-12-2016.
 */
public class Score extends UIObject {

    private int score = 0;

    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    private BitmapFont scoreFont;
    private GlyphLayout scoreLayout;

    private SpriteBatch batch;

    public Score(int x, int y, SpriteBatch batch) {
        super(x, y);

        this.batch = batch;

        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Kenney_Future.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 150;

        scoreFont = generator.generateFont(parameter);
        scoreLayout = new GlyphLayout(scoreFont, String.valueOf(score));
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int score) {
        this.score = score;

        scoreLayout = new GlyphLayout(scoreFont, String.valueOf(this.score));
    }

    @Override
    public void draw(ShapeRenderer sr) {
        scoreFont.draw(batch, scoreLayout, x, y);
    }

    @Override
    public void dispose() {
        scoreFont.dispose();
    }
}
