package main.general.gui;

import org.lwjgl.util.vector.Matrix4f;

import main.engine.graphics.geometry.G;
import main.engine.graphics.shaders.Shaders;
import main.general.Stuff;

public class GUIListValueUpdatingElement extends GUIListElement {
	
	Object value;
	float textX, textY;
	int padding;
	
	public GUIListValueUpdatingElement(GUIListValueUpdatingElement other) {
		super(other);
		this.value = other.value;
		this.textX = other.textX;
		this.textY = other.textY;
		this.padding = other.padding;
	}
	
	public GUIListValueUpdatingElement(String text) {
		super(text);
	}
	
	public GUIListValueUpdatingElement(Object value) {
		super(value);
	}
	
	public GUIListValueUpdatingElement(Object... values) {
		super(values);
	}
	
	protected void init(Object value) {
		this.value = value;
		this.padding = Stuff.uX(0.01f);
		this.textX = this.padding;
		this.textY = (this.getHeight() - Stuff.getSmallStringHeight() * 0.65f) / 2f + Stuff.getSmallStringHeight() * 0.65f;
	}
	
	@Override
	public void setValues(Object... valueArray) {
		this.init(valueArray[0]);
	}
	
	@Override
	public Object[] getValues() {
		return new Object[]{this.value};
	}
	
	@Override
	public float getHeight() {
		return Stuff.getSmallStringHeight() + 2 * padding;
	}
	
	@Override
	public void updateInput(int i) {
		
	}
	
	@Override
	public void update(int i) {
		
	}
	
	@Override
	public void render(int i, float x, float y, float width, float height, Matrix4f projectionMatrix, Matrix4f viewMatrix) {
		Shaders.bindColorGUI();
		Shaders.getCurrentlyBoundShader().passProjectionMatrix(projectionMatrix);
		Shaders.getCurrentlyBoundShader().passViewMatrix(viewMatrix);
			if (this.selected == true) {
				Stuff.foregroundColor4.bind();
			} else if (i % 2 == 0) {
				Stuff.foregroundColor1.bind();
			} else {
				Stuff.foregroundColor2.bind();
			}
			G.drawColoredQuad(x, y, width, height);
			
		Shaders.unbind();
		
		Stuff.drawSmallString(this.value.toString(), x + this.textX, y + this.textY);
	}
	
	public GUIListValueUpdatingElement copy() {
		return new GUIListValueUpdatingElement(this);
	}
	
}
