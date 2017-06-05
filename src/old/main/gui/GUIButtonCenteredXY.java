package main.general.gui;

public class GUIButtonCenteredXY extends GUIButton {
	
	public GUIButtonCenteredXY(float x, float y, float width, float height, GUIFunctionality functionality, Runnable action) {
		super(x - width / 2f, y - height / 2f, width, height, functionality, action);
	}

}
