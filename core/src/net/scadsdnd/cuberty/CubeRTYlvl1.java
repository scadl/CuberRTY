package net.scadsdnd.cuberty;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class CubeRTYlvl1 implements Screen {

    private Stage myStage;
    private Game myGame;

    public PerspectiveCamera pCam;

    public ModelInstance cbInst, fnInst, lvlInst;
    public ModelBatch mdlBatch;
    public Environment mEnv;

    public CubeRTYlvl1(Game rootGame){

        myGame = rootGame;
        myStage = new Stage(new ScreenViewport());

        mdlBatch = new ModelBatch();
        mEnv = new Environment();
        pCam = new PerspectiveCamera(67,
                Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        pCam.position.set(10f,10f,10f);
        pCam.lookAt(0f,0f,0f);
        pCam.near = 1f;
        pCam.far = 300f;
        pCam.update();

        myStage.getViewport().setCamera(pCam);

        /*
        // Model builder - generator of 3d objects
        ModelBuilder mdlB = new ModelBuilder();
        Model myCube = mdlB.createBox(
                5f, 5f, 5f,
                new Material(ColorAttribute.createDiffuse(Color.ROYAL)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal
        );
        new Color(Color.valueOf("#5968AF"))
        */

        ModelLoader myLoader = new ObjLoader();
        Model myCube = myLoader.loadModel(Gdx.files.internal("models/CubeRTYPlayer.obj"));
        Model myLevel = myLoader.loadModel(Gdx.files.internal("models/CubeRTYStage1.obj"));
        Model myTrig = myLoader.loadModel(Gdx.files.internal("models/CubeRTYFinTrigger.obj"));

        cbInst = new ModelInstance(myCube);
        lvlInst = new ModelInstance(myLevel);
        fnInst = new ModelInstance(myTrig);

        cbInst.transform.translate(new Vector3(7, 0, 7));

        Gdx.app.log("MODEL-CB", myCube.materials.toString());

        mEnv.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.3f, 0.3f, 0.3f, 1f));
        mEnv.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, 0.2f));

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(myStage);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        myStage.act();
        myStage.draw();

        mdlBatch.begin(pCam);
        mdlBatch.render(cbInst, mEnv);
        mdlBatch.render(lvlInst, mEnv);
        mdlBatch.render(fnInst);
        mdlBatch.end();

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
