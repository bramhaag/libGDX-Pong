package me.bramhaag.pong.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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

    public Score(int x, int y, Side side, SpriteBatch batch) {
        super(x, y);

        this.batch = batch;

        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Kenney_Future.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 100;

        scoreFont = generator.generateFont(parameter);
        scoreLayout = new GlyphLayout(scoreFont, String.valueOf(score));

        if(side == Side.RIGHT)
            this.x = x - (int)scoreLayout.width;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int score) {
        //TODO adjust x if side == LEFT && score >= 10

        //Restore x to it's original value
        if(side == Side.RIGHT) {
            this.x = x + (int)scoreLayout.width;
        }

        this.score = score;
        scoreLayout = new GlyphLayout(scoreFont, String.valueOf(score));

        //Adjust x to be symmetrical with the left side
        if(side == Side.RIGHT) {
            this.x = x - (int)scoreLayout.width;
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
