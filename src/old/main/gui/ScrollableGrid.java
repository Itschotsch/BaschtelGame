package main.gui;

import main.engine.graphics.Texture;
import main.engine.graphics.Textures;
import main.items.ItemType;

public class ScrollableGrid extends Grid{
	
//	private ItemType[] itemTypes;
	private float yOffset, yOffsetVelocity;

	public ScrollableGrid(int posX, int posY, int sizeX, int sizeY, int spacing, int rows, Texture texture, Texture hoverTexture, boolean enableSideScrolling) {
		super(posX, posY, sizeX, sizeY, spacing, rows, 1, texture, hoverTexture);
	}
	
	@Override
	protected void init(){
		super.init();
		
		//TODO add sidescrolling arrows
		
		initItems();
	}
	
	private void initItems(){
		// function to add items
		this.components = new ItemContainer[][]{{
			createItemContainer(ItemType.BLADE, 0),
			createItemContainer(ItemType.BOW, 1),
			createItemContainer(ItemType.GRASS, 2),
			createItemContainer(ItemType.KOALA, 3)
		}};
	}
	
	private ItemContainer createItemContainer(ItemType itemType, int index) {
		return new ItemContainer(posX, posY, sizeX, sizeY, itemType.texture, Textures.notFound);
	}
	
	public void scroll(float amount){
		this.yOffsetVelocity += amount;
	}
	
	public void update() {
		this.yOffset += this.yOffsetVelocity;
		this.yOffsetVelocity /= 1.2f;
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render(0, this.yOffset);
	}
	
//	private void updateButtons(){
//		int localIndex = Math.abs(indexOfFirstItem) % (items.size() - 1);
//		for(Button button: components[0]){
//			if(items.size() > localIndex){
//				button.item = items.get(localIndex);
//			}else{
//				button.item = null;
//			}
//			localIndex = (localIndex + 1) % (items.size());
//		}
//	}

}
