package main.gui;

import main.engine.graphics.Textures;
import main.engine.graphics.geometry.G;
import main.engine.util.Util;
import main.items.Item;

public class Button {

	private int posX;
	private int posY;
	
	private int sizeX;
	private int sizeY;
	
	private String defaultTexture;
	private String activeTexture;
	private String hoverTexture;
	
	public Item item = null;
	
	private boolean isHovered;
	Button hoveredButton = null;

	public Button(int posX, int posY, int sizeX, int sizeY, String texture, String hoverTexture) {
		this.posX = posX;
		this.posY = posY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.defaultTexture = texture;
		activeTexture = defaultTexture;
		this.hoverTexture = hoverTexture;
		
	}
	
	public void render(){
		if(item == null){
			Textures.get(activeTexture).bind();
		}else{
			Textures.get(item.getTexture()).bind();
		}
		G.drawTexturedQuad(posX, posY, sizeX, sizeY);
	}
	
	public Button checkMouseCollision(int mouseX, int mouseY){
		if(Util.isBetween(posX, posX + sizeX, mouseX)
			&& Util.isBetween(posY, posY + sizeY, mouseY)){
			
			if(!isHovered){
				mouseEnter();
				
			}
		}else{
			if(isHovered){
				mouseLeave();
			}
		}
		
		return hoveredButton;
	}
	
	private void mouseEnter(){
		isHovered = true;
		activeTexture = hoverTexture;
		hoveredButton = this;
	}
	
	private void mouseLeave(){
		isHovered = false;
		activeTexture = defaultTexture;
		hoveredButton = null;
	}
	
	public void click(){
		System.out.println("click");
	}
	
	
	
}
