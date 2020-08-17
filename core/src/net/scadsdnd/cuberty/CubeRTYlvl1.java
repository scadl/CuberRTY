package net.scadsdnd.cuberty;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class CubeRTYlvl1 implements Screen {

    private Stage myStage;
    private Game myGame;

    public CubeRTYlvl1(Game rootGame){

        myGame = rootGame;
        myStage = new Stage(new ScreenViewport());

    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(myStage);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        myStage.act();
        myStage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        myStage.dispose();
    }
}
