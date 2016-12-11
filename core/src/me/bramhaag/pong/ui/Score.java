package me.bramhaag.pong.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import me.bramhaag.pong.Game;
import me.bramhaag.pong.util.Side;

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

    private Side side;

    private int xOffset;

    public Score(int xOffset, int yOffset, Side side, SpriteBatch batch) {
        super((Game.WIDTH / 2) + xOffset, Game.HEIGHT + yOffset);

        this.batch = batch;

        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Kenney_Future.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 100;

        scoreFont = generator.generateFont(parameter);
        scoreLayout = new GlyphLayout(scoreFont, String.valueOf(score));

        this.side = side;
        this.xOffset = xOffset;

        if(this.side == Side.LEFT) {
            this.x = x - (int)scoreLayout.width;
        }
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int score) {
        this.score = score;
        scoreLayout = new GlyphLayout(scoreFont, String.valueOf(this.score));

        if(side == Side.LEFT) {
            this.x = (Game.WIDTH / 2) - (int)scoreLayout.width + xOffset;
        }
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
