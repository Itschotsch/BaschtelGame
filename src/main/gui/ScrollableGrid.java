package main.gui;

import java.util.ArrayList;
import java.util.List;

import main.items.Item;

public class ScrollableGrid extends Grid{
	
	private List<Item> items;
	private int indexOfFirstItem = 0;

	public ScrollableGrid(int posX, int posY, int sizeX, int sizeY, int spacing, int rows, String texture,
			String hoverTexture, boolean enableSideScrolling) {
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
		items = new ArrayList<Item>();
		
		if(items != null){
			items.add(new Item("blade"));
			items.add(new Item("bow"));
			items.add(new Item("grass"));
			items.add(new Item("koala"));
		}
		updateButtons();
	}
	
	public void scrolling(int axisScale){
		if(!items.isEmpty()){
			indexOfFirstItem += axisScale;
			updateButtons();
		}
	}
	
	private void updateButtons(){
		int localIndex = Math.abs(indexOfFirstItem) % (items.size() - 1);
		for(Button button: components[0]){
			if(items.size() > localIndex){
				button.item = items.get(localIndex);
			}else{
				button.item = null;
			}
			localIndex = (localIndex + 1) % (items.size());
		}
	}

}
