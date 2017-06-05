package main.general.gui;

import org.lwjgl.util.vector.Matrix4f;

import main.engine.graphics.geometry.G;
import main.engine.graphics.shaders.Shaders;
import main.general.S;

public class GUIListTextElement extends GUIListElement {
	
	String text;
	float textX, textY;
	int padding;
	
	public GUIListTextElement(GUIListTextElement other) {
		super(other);
		this.text = other.text;
		this.textX = other.textX;
		this.textY = other.textY;
		this.padding = other.padding;
	}
	
	public GUIListTextElement(String text) {
		super(text);
	}
	
	public GUIListTextElement(Object value) {
		super(value);
	}
	
	public GUIListTextElement(Object... values) {
		super(values);
	}
	
	protected void init(String text) {
		this.text = text;
		this.padding = S.uX(0.01f);
		this.textX = this.padding;
		this.textY = (this.getHeight() - S.getSmallStringHeight() * 0.65f) / 2f + S.getSmallStringHeight() * 0.65f;
	}
	
	@Override
	public void setValues(Object... valueArray) {
		this.init(valueArray[0].toString());
	}
	
	@Override
	public Object[] getValues() {
		return new String[]{this.text};
	}
	
	@Override
	public float getHeight() {
		return S.getSmallStringHeight() + 2 * padding;
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
				S.foregroundColor4.bind();
			} else if (i % 2 == 0) {
				S.foregroundColor1.bind();
			} else {
				S.foregroundColor2.bind();
			}
			G.drawColoredQuad(x, y, width, height);
			
		Shaders.unbind();
		
		S.drawSmallString(this.text, x + this.textX, y + this.textY);
	}
	
	public GUIListTextElement copy() {
		GUIListTextElement element = new GUIListTextElement(this);
		return element;
	}
	
}
