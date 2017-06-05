package main.general.gui;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Matrix4f;

import main.engine.graphics.geometry.Vector2;
import main.engine.util.Util;

public abstract class GUIElement {
	
	float x, y, width, height;
	public boolean enabled = true;
	public boolean changed = false;
	
	public GUIElement(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void updateInput();
	public abstract void update();
	public abstract void render(Matrix4f projectionMatrix, Matrix4f viewMatrix);
	
	public void render() {
		this.render(Util.createGUIProjectionMatrix(0, Display.getWidth(), Display.getHeight(), 0), Util.createGUIViewMatrix(new Vector2(), 0, 1));
	}
	
}
