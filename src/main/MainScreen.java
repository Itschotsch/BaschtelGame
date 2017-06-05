package main;

import main.engine.graphics.Graphics;
import main.engine.graphics.Textures;
import main.engine.graphics.shaders.Shaders;
import main.engine.input.Input;
import main.engine.screens.Screen;
import main.gui.Button;
import main.gui.Grid;

public class MainScreen extends Screen {
	
	Grid koalaField = new Grid(200, 200, 500, 500, 5, 5, 5, "koala", "grass");
	
	Button activeButton = null;

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
		activeButton = koalaField.checkCollision(Input.mouseX, Input.mouseY);

	}

	@Override
	public void updateInput() {
		if(activeButton != null){
			if(Input.isLeftMouseButtonDownNow()){
				activeButton.click();
			}
		}

	}
}
