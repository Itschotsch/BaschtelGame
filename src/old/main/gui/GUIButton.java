package main.general.gui;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import main.engine.graphics.Color;
import main.engine.graphics.Textures;
import main.engine.graphics.geometry.Vector2;
import main.engine.graphics.shaders.Shaders;
import main.engine.graphics.vao.VAO2D;
import main.engine.input.Input;
import main.engine.util.Util;
import main.general.Stuff;

public class GUIButton extends GUIElement {
	
	private static VAO2D blVAO, bcVAO, brVAO;
	private static float padding = 0.5f;
	
	public static void init() {
		GUIButton.blVAO = new VAO2D(
			new float[]{0 - padding * 2f, 0 - padding, 1, 0 - padding, 1, 1 + padding, 0 - padding * 2f, 1 + padding},
			new int[]{0, 1, 3, 2, 3, 1},
			new float[]{0, 0, 0.3333333333f, 0, 0.3333333333f, 1, 0, 1}
		);
		GUIButton.bcVAO = new VAO2D(
			new float[]{0, 0 - padding, 1, 0 - padding, 1, 1 + padding, 0, 1 + padding},
			new int[]{0, 1, 3, 2, 3, 1},
			new float[]{0.3333333333f, 0, 0.6666666666f, 0, 0.6666666666f, 1, 0.3333333333f, 1}
		);
		GUIButton.brVAO = new VAO2D(
			new float[]{0, 0 - padding, 1 + padding * 2f, 0 - padding, 1 + padding * 2f, 1 + padding, 0, 1 + padding},
			new int[]{0, 1, 3, 2, 3, 1},
			new float[]{0.6666666666f, 0, 1, 0, 1, 1, 0.6666666666f, 1}
		);
	}
	
	// ==================== //
	
	protected GUIFunctionality functionality;
	protected Runnable action;
//	private Color currentColor = new Color(Stuff.primaryDefaultColor);
//	private Color goalColor = new Color(Stuff.primaryDefaultColor);
	protected Color currentColor;
	protected Color goalColor;
	
	public GUIButton(float x, float y, float width, float height, GUIFunctionality functionality, Runnable action) {
		super(x, y, width, height);
		this.functionality = functionality;
		this.action = action;
		
		this.currentColor = new Color(this.functionality.defaultColor);
		this.currentColor.a = Stuff.disabledTransparency;
		this.goalColor = new Color(this.functionality.defaultColor);
		this.goalColor.a = Stuff.disabledTransparency;
	}
	
	@Override
	public void updateInput() {
		if (this.enabled == false) {
			this.goalColor.rgbaFrom(this.functionality.defaultColor);
			this.goalColor.a = Stuff.disabledTransparency;
		} else if (Util.aabb(Input.mouseX, Input.mouseY, this.x, this.y, this.x + this.width, this.y + this.height)) {
			if (Input.isLeftMouseButtonDownNow()) {
				this.click();
			}
			this.goalColor.rgbaFrom(this.functionality.hoverColor);
		} else {
			this.goalColor.rgbaFrom(this.functionality.defaultColor);
		}
	}
	
	@Override
	public void update() {
		this.currentColor.mixWithRGBA(this.goalColor, 0.2f);
	}
	
	@Override
	public void render(Matrix4f projectionMatrix, Matrix4f viewMatrix) {
		Shaders.bindColoredTextureGUI();
		Shaders.getCurrentlyBoundShader().passProjectionMatrix(projectionMatrix);
		Shaders.getCurrentlyBoundShader().passViewMatrix(viewMatrix);
		
		this.currentColor.bind();
		Textures.get("gui/button").bind();
		GUIButton.draw(this.x, this.y, this.width, this.height);
		
		Shaders.unbind();
	}
	
	public void click() {
		if (this.action != null && this.enabled == true) {
			this.action.run();
		}
	}
	
	private static void draw(float x, float y, float width, float height) {
		GUIButton.drawPart(GUIButton.blVAO, x, y, height, height);
		GUIButton.drawPart(GUIButton.bcVAO, x + height, y, width - 2 * height, height);
		GUIButton.drawPart(GUIButton.brVAO, x + width - height, y, height, height);
	}
	
	private static void drawPart(VAO2D vao, float x, float y, float width, float height) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		matrix.translate(new Vector2(x, y));
		matrix.scale(new Vector3f(width, height, 1));
		Shaders.getCurrentlyBoundShader().passTransformationMatrix(matrix);
		vao.renderTextured();
	}
	
}
