package main.general.gui;

public class GUIButtonTextCenteredXY extends GUIButtonText {
	
	public GUIButtonTextCenteredXY(String text, float x, float y, float width, float height, GUIFunctionality functionality, Runnable action) {
		super(text, x - width / 2f, y - height / 2f, width, height, functionality, action);
	}

}
