package net.scadsdnd.cuberty;

import com.badlogic.gdx.Game;

public class CubeRTYGame extends Game {

	
	@Override
	public void create () {
		this.setScreen(new CubeRTYMenu(this));
	}

	@Override
	public void render () {
super .render();
			}
	
	@Override
	public void dispose () {

	}
}
