package main.general.gui;

import main.engine.graphics.Color;
import main.general.Stuff;

public enum GUIFunctionality {
	
	PRIMARY(Stuff.primaryDefaultColor, Stuff.primaryHoverColor),
	WARNING(Stuff.warningDefaultColor, Stuff.warningHoverColor),
	DANGER(Stuff.dangerDefaultColor, Stuff.dangerHoverColor);
	
	public Color defaultColor, hoverColor;
	
	private GUIFunctionality(Color defaultColor, Color hoverColor) {
		this.defaultColor = defaultColor;
		this.hoverColor = hoverColor;
	}
	
}
