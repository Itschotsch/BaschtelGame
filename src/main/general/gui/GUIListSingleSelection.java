package main.general.gui;

public class GUIListSingleSelection extends GUIList {
	
	public GUIListElement selectedElement = null;
	
	public GUIListSingleSelection(float x, float y, float width, float height) {
		super(x, y, width, height);
	}
	
	@Override
	public void click(GUIListElement listElement, int i, float localX, float localY) {
		if (this.selectedElement != null) {
			this.selectedElement.selected = false;
		}
		super.click(listElement, i, localX, localY);
		listElement.selected = true;
		this.selectedElement = listElement;
		this.changed = true;
	}
	
	public void selectElement(String name) {
		if (this.selectedElement != null) {
			this.selectedElement.selected = false;
		}
		GUIListElement listElement = this.listElements.get(name);
		if (listElement != null) {
			listElement.selected = true;
			this.selectedElement = listElement;
			this.changed = true;
		}
	}
	
}
