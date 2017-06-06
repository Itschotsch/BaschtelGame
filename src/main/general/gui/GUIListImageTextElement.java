package main.general.gui;

import org.lwjgl.util.vector.Matrix4f;

import main.engine.graphics.Texture;
import main.engine.graphics.geometry.G;
import main.engine.graphics.shaders.Shaders;
import main.general.S;

public class GUIListImageTextElement extends GUIListElement {
	
	Texture texture;
	float imageX, imageY;
	float imageWidth, imageHeight;
	String text;
	float textX, textY;
	int padding;
	
	public GUIListImageTextElement(GUIListImageTextElement other) {
		super(other);
		this.texture = other.texture;
		this.imageX = other.imageX;
		this.imageY = other.imageY;
		this.imageWidth = other.imageWidth;
		this.imageHeight = other.imageHeight;
		this.text = other.text;
		this.textX = other.textX;
		this.textY = other.textY;
		this.padding = other.padding;
	}
	
	public GUIListImageTextElement(Texture texture, String text) {
		super(texture, text);
		System.out.println(texture);
		System.out.println(text);
	}
	
	public GUIListImageTextElement(Object value) {
		super(value);
	}
	
	public GUIListImageTextElement(Object... values) {
		super(values);
	}
	
	protected void init(Texture texture, String text) {
		this.texture = texture;
		this.padding = S.uX(0.01f);
		this.imageX = this.padding;
		this.imageY = this.padding;
		this.imageWidth = S.uY(0.15f);
		this.imageHeight = S.uY(0.15f);
		this.textX = this.imageX + this.imageWidth + 2 * this.padding;
		this.textY = (this.getHeight() - S.getSmallStringHeight() * 0.65f) / 2f + S.getSmallStringHeight() * 0.65f;
		this.text = text;
	}
	
	@Override
	public void setValues(Object... valueArray) {
		this.init((Texture) valueArray[0], valueArray[1].toString());
	}
	
	@Override
	public Object[] getValues() {
		return new Object[]{this.texture, this.text};
	}
	
	@Override
	public float getHeight() {
		return this.padding + this.imageHeight + this.padding; //S.getSmallStringHeight() + 2 * padding;
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
		
		Shaders.bindTextureGUI();
		Shaders.getCurrentlyBoundShader().passProjectionMatrix(projectionMatrix);
		Shaders.getCurrentlyBoundShader().passViewMatrix(viewMatrix);
			this.texture.bind();
			G.drawTexturedQuad(x + this.imageX, y + this.imageY, this.imageWidth, this.imageHeight);
		Shaders.unbind();
		
		S.drawSmallString(this.text, x + this.textX, y + this.textY);
	}
	
	public GUIListImageTextElement copy() {
		GUIListImageTextElement element = new GUIListImageTextElement(this);
		return element;
	}
	
}
