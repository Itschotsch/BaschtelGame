package main.general.gui;

public class GUIListSingleSelectionCenteredXY extends GUIListSingleSelection {
	
	public GUIListSingleSelectionCenteredXY(float x, float y, float width, float height) {
		super(x - width / 2f, y - height / 2f, width, height);
	}
	
}
