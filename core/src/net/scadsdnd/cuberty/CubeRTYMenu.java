package net.scadsdnd.cuberty;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class CubeRTYMenu implements Screen {

    private Stage myStage;
    private Game myGame;

    public CubeRTYMenu(Game rootGame){

        myGame = rootGame;
        myStage = new Stage(new ScreenViewport());

        Texture imgIco = new Texture(Gdx.files.internal("icon0001.png"));
        String[] intro = new String[3];
        intro[0] = "Welcome to CubeRTY Labyrinth game!";
        intro[1] = "Your goal here, is to touch glowing yellow stick (hidden somewhere in each level) " +
                "with your spherocube. But you can't actually control it. Instead, you can " +
                "tilt (W,S), roll (A,D), and rotate (Q,E) the game board thus making game physics work for you. " +
                "Remember, that camera will always follow your cube, trying to stay above it, " +
                "while game board may easily flip upside-down during action.";
        intro[2] = "Continue...";

        FreeTypeFontGenerator fontGen = new FreeTypeFontGenerator(Gdx.files.internal("fonts/LiberationSerif-Bold.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParam = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParam.size = 20;
        BitmapFont myFont = fontGen.generateFont(fontParam);

        Label.LabelStyle[] myStyle = {
                new Label.LabelStyle(),
                new Label.LabelStyle(),
        };
        myStyle[0].font = myFont;
        myStyle[0].fontColor =  Color.valueOf("#fffe92");
        myStyle[1].font = myFont;
        myStyle[1].fontColor =  Color.WHITE;

        Label lblTitle = new Label(intro[0], myStyle[0]);
        lblTitle.setWidth(Gdx.graphics.getWidth() - 20);
        lblTitle.setPosition(10, Gdx.graphics.getHeight() - 30);
        lblTitle.setAlignment(Align.center);
        myStage.addActor(lblTitle);

        Label lblIntro = new Label(intro[1], myStyle[1]);
        lblIntro.setWidth(Gdx.graphics.getWidth() - 20);
        lblIntro.setWrap(true);
        lblIntro.setPosition(10, Gdx.graphics.getHeight() - 130);
        lblIntro.setAlignment(Align.center);
        myStage.addActor(lblIntro);

        Skin uiSkin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        TextButton btnCont = new TextButton(intro[2], uiSkin);
        btnCont.setWidth(Gdx.graphics.getWidth() - 400);
        btnCont.setPosition(200, 30);

        btnCont.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                myGame.setScreen(new CubeRTYlvl1(myGame));
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        myStage.addActor(btnCont);

        Image imgLogo = new Image(imgIco);
        imgLogo.setSize(128, 128);
        imgLogo.setPosition(Gdx.graphics.getWidth() / 2 - 128 /2, 100);
        myStage.addActor(imgLogo);

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
