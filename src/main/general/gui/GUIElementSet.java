package main.general.gui;

import java.util.HashMap;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Matrix4f;

import main.engine.graphics.geometry.Vector2;
import main.engine.util.Util;

public class GUIElementSet {
	
	private HashMap<String, GUIElement> elements;
	public boolean changed = true;
	
	public GUIElementSet() {
		this.elements = new HashMap<String, GUIElement>();
	}
	
	public void add(String name, GUIElement element) {
		this.elements.put(name, element);
	}
	
	public void updateInput() {
		for (GUIElement element : this.elements.values()) {
			element.updateInput();
		}
	}
	
	public void update() {
		this.changed = false;
		for (GUIElement element : this.elements.values()) {
			element.update();
			if (element.changed == true) {
				this.changed = true;
				element.changed = false;
			}
		}
	}
	
	public void render() {
		Matrix4f projectionMatrix = Util.createGUIProjectionMatrix(0, Display.getWidth(), Display.getHeight(), 0);
		Matrix4f viewMatrix = Util.createGUIViewMatrix(new Vector2(), 0, 1);
		this.render(projectionMatrix, viewMatrix);
	}
	
	public void render(Matrix4f projectionMatrix, Matrix4f viewMatrix) {
		for (GUIElement element : this.elements.values()) {
			element.render(projectionMatrix, viewMatrix);
		}
	}
	
	public GUIElement get(String name) {
		return this.elements.get(name);
	}
	
	public void remove(String name) {
		this.elements.remove(name);
	}
	
}
