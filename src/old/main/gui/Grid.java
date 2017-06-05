package main.gui;

import main.engine.graphics.Texture;

public class Grid {

	protected int posX, posY, sizeX, sizeY;
	
	protected int spacing;
	protected int quadSizeX, quadSizeY;
	
	protected int rows, columns;
	
	private Texture texture;
	private Texture hoverTexture;
	
	protected ItemContainer[][] components;
	
	
	
	public Grid(int posX, int posY, int sizeX, int sizeY, int spacing, int rows, int columns, Texture texture, Texture hoverTexture) {
		this.posX = posX;
		this.posY = posY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.spacing = spacing;
		this.rows = rows;
		this.columns = columns;
		this.texture = texture;
		this.hoverTexture = hoverTexture;
		
		init();
	}
	
	protected void init(){
		components = new ItemContainer[columns][rows];
		
		quadSizeX = (sizeX / columns) - (columns - 1) * spacing;
		quadSizeY = (sizeY / rows) - (rows - 1) * spacing;
		
		for(int i = 0; i <= columns - 1; i++){
			for(int j = 0; j <= rows - 1; j++){
				
				int quadPosX = posX + (i * spacing) + (i * quadSizeX);
				int quadPosY = posY + (j * spacing) + (j * quadSizeY);
				
				components[i][j] = new ItemContainer(quadPosX, quadPosY, quadSizeX, quadSizeY, texture, hoverTexture);
			}
			
		}
	}
	
	public void render(){
		this.render(0, 0);
	}
	
	public void render(float xOffset, float yOffset){
		for(int i = 0; i <= columns - 1; i++){
			for(int j = 0; j <= rows - 1; j++){
				components[i][j].render(xOffset, yOffset);
			}
		}
	}
	
	public ItemContainer checkCollision(int mouseX, int mouseY){
		ItemContainer hoveredButton = null;
		for(ItemContainer[] buttonArray: components){
			for(ItemContainer button: buttonArray){
				if(button.checkMouseCollision(mouseX, mouseY) == true){
					hoveredButton = button;
				}
			}
		}
		return hoveredButton;
	}
	
	
	
}
