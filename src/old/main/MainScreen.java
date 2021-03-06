package main;

import main.engine.graphics.Graphics;
import main.engine.graphics.Textures;
import main.engine.graphics.shaders.Shaders;
import main.engine.input.Input;
import main.engine.screens.Screen;
import main.gui.Grid;
import main.gui.ScrollableGrid;

public class MainScreen extends Screen {
	
	Grid koalaField = new Grid(200, 200, 500, 500, 5, 5, 5, Textures.get("koala"), Textures.get("grass"));
	
	ScrollableGrid scrollGrid = new ScrollableGrid(50, 200, 100, 300, 5, 3, Textures.get("koala"), Textures.get("grass"), false);
	
	@Override
	public void init() {
		Textures.load("koala");
		Textures.load("grass");
		Textures.load("blade");
		Textures.load("bow");
	}

	@Override
	public void updateInput() {
		if(activeButton != null){
			if(Input.isLeftMouseButtonDownNow()){
				activeButton.click();
			}
		}
		
		if(Input.scrolled() != 0){
			scrollGrid.scroll(Input.scrolledAmount);
		}

	}

	@Override
	public void update() {
		activeButton = koalaField.checkCollision(Input.mouseX, Input.mouseY);
		if(activeButton == null){
			activeButton = scrollGrid.checkCollision(Input.mouseX, Input.mouseY);
		}
		
	}

	@Override
	public void render() {
		Graphics.prepareRender(true, false);
		
		Shaders.bindTextureGUI();

		koalaField.render();
		scrollGrid.render();
		
		Shaders.unbind();
	}

	@Override
	public void stop() {
		
	}
}
