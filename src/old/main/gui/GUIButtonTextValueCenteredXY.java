package main.general.gui;

public class GUIButtonTextValueCenteredXY extends GUIButtonTextValue {
	
	public GUIButtonTextValueCenteredXY(String text, Object value, float x, float y, float width, float height, GUIFunctionality functionality, Runnable action) {
		super(text, value, x - width / 2f, y - height / 2f, width, height, functionality, action);
	}

}
