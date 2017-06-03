package main.gui;

public class Grid {

	private int posX;
	private int posY;
	
	private int sizeX;
	private int sizeY;
	
	private int spacing;
	private int quadSizeX;
	private int quadSizeY;
	
	private int rows;
	private int columns;
	
	private String texture;
	
	private Button[][] components;
	
	
	public Grid(int posX, int posY, int sizeX, int sizeY, int spacing, int rows, int columns, String texture) {
		this.posX = posX;
		this.posY = posY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.spacing = spacing;
		this.rows = rows;
		this.columns = columns;
		this.texture = texture;
		
		init();
	}
	
	private void init(){
		components = new Button[columns][rows];
		
		quadSizeX = (sizeX / columns) - (columns - 1) * spacing;
		quadSizeY = (sizeY / rows) - (rows - 1) * spacing;
		
		for(int i = 0; i <= columns - 1; i++){
			for(int j = 0; j <= rows - 1; j++){
				
				int quadPosX = posX + (i * spacing) + (i * quadSizeX);
				int quadPosY = posY + (j * spacing) + (j * quadSizeY);
				
				components[i][j] = new Button(quadPosX, quadPosY, quadSizeX, quadSizeY, texture);
			}
			
		}
	}
	
	public void render(){
		for(int i = 0; i <= columns - 1; i++){
			for(int j = 0; j <= rows - 1; j++){
				components[i][j].render();
			}
		}
	}
	
	
	
}