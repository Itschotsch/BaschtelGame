package main;

import main.engine.graphics.Graphics;
import main.engine.graphics.Textures;
import main.engine.graphics.shaders.Shaders;
import main.engine.screens.Screen;
import main.gui.Grid;

public class MainScreen extends Screen {
	
	Grid koalaField = new Grid(200, 200, 200, 100, 5, 3, 5, "koala");

	@Override
	public void init() {
		Textures.load("koala");

		Textures.load("grass");
	}

	@Override
	public void render() {
		Graphics.prepareRender(true, false);
		
		Shaders.bindTextureGUI();

		koalaField.render();
		
		Shaders.unbind();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateInput() {
		// TODO Auto-generated method stub

	}
}
