package main.gui;

import main.engine.graphics.Texture;
import main.engine.graphics.geometry.G;
import main.engine.graphics.geometry.collision.AABB;
import main.items.ItemType;

public class ItemContainer {
	
	AABB aabb;
	
	public static ItemContainer hoveringButton = null;
	
	private Texture defaultTexture;
	private Texture hoverTexture;
	private Texture currentTexture;
	
	public ItemType itemType = null;
	
	private boolean isHovered;
	
	public ItemContainer(int posX, int posY, int sizeX, int sizeY, Texture texture, Texture hoverTexture) {
		this.aabb = new AABB(posX, posY, posX + sizeX, posY + sizeY);
		this.defaultTexture = texture;
		this.currentTexture = this.defaultTexture;
		this.hoverTexture = hoverTexture;
		
	}
	
	public void render(){
		this.render(0, 0);
	}
	
	public void render(float xOffset, float yOffset){
		if(itemType == null){
			currentTexture.bind();
		}else{
			itemType.texture.bind();
		}
		G.drawTexturedQuad(aabb.x1 + xOffset, aabb.y1 + yOffset, aabb.x2 - aabb.x1 + xOffset, aabb.y2 - aabb.y1 + yOffset);
	}
	
	public boolean checkMouseCollision(int mouseX, int mouseY){
		if(aabb.collidesWith(mouseX, mouseY)){
			if(!isHovered){
				mouseEnter();
			}
		}else{
			if(isHovered){
				mouseLeave();
			}
		}
		
		return false;
	}
	
	private void mouseEnter(){
		isHovered = true;
		currentTexture = hoverTexture;
		ItemContainer.hoveringButton = this;
	}
	
	private void mouseLeave(){
		isHovered = false;
		currentTexture = defaultTexture;
		ItemContainer.hoveringButton = null;
	}
	
	public void click(){
		System.out.println("click");
	}
	
}
