package main.general.gui;

import org.lwjgl.util.vector.Matrix4f;

public abstract class GUIListElement {
	
	String name;
	public boolean selected;
	
	public GUIListElement() {
		
	}
	
	public GUIListElement(Object value) {
		this.setValues(value);
	}
	
	public GUIListElement(Object... values) {
		this.setValues(values);
	}
	
	public GUIListElement(GUIListElement other) {
		this.name = other.name;
		this.setValues(other.getValues());
	}
	
	public abstract float getHeight();
	
	public void update(int i) {}
	public void updateInput(int i) {}
	public abstract void render(int i, float x, float y, float width, float height, Matrix4f projectionMatrix, Matrix4f viewMatrix);
	public void click(int i, float localX, float localY) {}
	
	public String getName() {
		return name;
	}
	
	public abstract GUIListElement copy();

	public abstract void setValues(Object... object);
	public abstract Object[] getValues();
	
}
