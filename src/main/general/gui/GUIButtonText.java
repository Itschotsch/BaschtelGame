package main.general.gui;

import org.lwjgl.util.vector.Matrix4f;

import main.general.S;

public class GUIButtonText extends GUIButton {
	
	public String text;
	float textX, textY;
	
	public GUIButtonText(String text, float x, float y, float width, float height, GUIFunctionality functionality, Runnable action) {
		super(x, y, width, height, functionality, action);
		this.setText(text);
	}
	
	@Override
	public void render(Matrix4f projectionMatrix, Matrix4f viewMatrix) {
		super.render(projectionMatrix, viewMatrix);
		S.drawSmallString(this.text, this.textX, this.textY, this.goalColor.a);
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
		this.textX = x + (width - S.getSmallStringWidth(text)) / 2f;
		this.textY = y + (height - S.getSmallStringHeight() * 0.65f) / 2f + S.getSmallStringHeight() * 0.65f;
	}
	
}
