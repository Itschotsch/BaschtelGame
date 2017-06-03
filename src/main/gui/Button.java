package main.gui;

import main.engine.graphics.Textures;
import main.engine.graphics.geometry.G;
import main.items.Item;

public class Button {

	private int posX;
	private int posY;
	
	private int sizeX;
	private int sizeY;
	
	private String texture;
	
	public Item item = null;

	public Button(int posX, int posY, int sizeX, int sizeY, String texture) {
		this.posX = posX;
		this.posY = posY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.texture = texture;
		
	}
	
	public void render(){
		if(item == null){
			Textures.get(texture).bind();
		}else{
			Textures.get(item.texture).bind();
		}
		G.drawTexturedQuad(posX, posY, sizeX, sizeY);
	}
	
	
	
}
