package net.scadsdnd.cuberty;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CubeRTYGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture imgIco, imgAbout;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		imgIco = new Texture("icon0001.png");
		imgAbout = new Texture("intro.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(imgAbout, 10, 10);
		batch.draw(imgIco, 100, 500);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		imgIco.dispose();
		imgAbout.dispose();
	}
}
