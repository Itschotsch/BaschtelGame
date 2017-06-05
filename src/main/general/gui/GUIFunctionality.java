package main.general.gui;

import main.engine.graphics.Color;
import main.general.S;

public enum GUIFunctionality {
	
	PRIMARY(S.primaryDefaultColor, S.primaryHoverColor),
	WARNING(S.warningDefaultColor, S.warningHoverColor),
	DANGER(S.dangerDefaultColor, S.dangerHoverColor);
	
	public Color defaultColor, hoverColor;
	
	private GUIFunctionality(Color defaultColor, Color hoverColor) {
		this.defaultColor = defaultColor;
		this.hoverColor = hoverColor;
	}
	
}
