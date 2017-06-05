package main.general.gui;

public class GUIButtonTextValue extends GUIButtonText {
	
	public Object value;
	
	public GUIButtonTextValue(String text, Object value, float x, float y, float width, float height, GUIFunctionality functionality, Runnable action) {
		super(text, x, y, width, height, functionality, action);
		this.value = value;
	}
	
}
