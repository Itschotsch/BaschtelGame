package main.items;

public class Item {

	private String texture;
	private String name;
	
	private int value;
	
	public int amount;
	private int maxAmount;

	public Item(String texture) {
		this.texture = texture;
	}
	
	public String getTexture(){
		return texture;
	}
	
}
