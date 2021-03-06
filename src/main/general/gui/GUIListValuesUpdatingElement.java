package main.general.gui;

import org.lwjgl.util.vector.Matrix4f;

import main.engine.graphics.geometry.G;
import main.engine.graphics.shaders.Shaders;
import main.general.S;

public class GUIListValuesUpdatingElement extends GUIListElement {
	
	Object[] values;
	float[] columnWidths;
	float textX, textY;
	int padding;
	
	public GUIListValuesUpdatingElement(GUIListValuesUpdatingElement other) {
		super(other);
		this.values = other.values;
		this.textX = other.textX;
		this.textY = other.textY;
		this.padding = other.padding;
	}
	
	public GUIListValuesUpdatingElement(float[] columnWidths, Object valueArray) {
		this.init(columnWidths, valueArray);
	}
	
	public GUIListValuesUpdatingElement(float[] columnWidths, Object... values) {
		this.init(columnWidths, values);
	}
	
	protected void init(float[] columnWidths, Object... values) {
		this.columnWidths = columnWidths;
		this.values = values;
		this.padding = S.uX(0.01f);
		this.textX = this.padding;
		this.textY = (this.getHeight() - S.getSmallStringHeight() * 0.65f) / 2f + S.getSmallStringHeight() * 0.65f;
	}
	
	@Override
	public void setValues(Object... valueArray) {
		this.init(this.columnWidths, valueArray);
	}
	
	@Override
	public Object[] getValues() {
		return this.values;
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
		
		for (int j = 0; j < this.values.length; j ++) {
			S.drawSmallString(this.values[j].toString(), x + this.textX, y + this.textY);
			x += (j >= this.columnWidths.length ? S.getSmallStringWidth(this.values[j].toString()) : this.columnWidths[j]);
		}
	}
	
	public GUIListValuesUpdatingElement copy() {
		return new GUIListValuesUpdatingElement(this);
	}
	
}
