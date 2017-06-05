package main.general.gui;

import java.util.HashMap;

import org.lwjgl.util.vector.Matrix4f;

import main.engine.graphics.geometry.G;
import main.engine.graphics.shaders.Shaders;
import main.engine.input.Input;
import main.engine.util.Util;
import main.general.Stuff;

public class GUIList extends GUIElement {
	
	HashMap<String, GUIListElement> listElements;
	private float yOffset = 0, yOffsetVelocity = 0, lastTotalElementsHeight = 0;
	
	public GUIList(float x, float y, float width, float height) {
		super(x, y, width, height);
		this.listElements = new HashMap<String, GUIListElement>();
	}
	
	@Override
	public void updateInput() {
		if (Util.aabb(Input.mouseX, Input.mouseY, this.x, this.y, this.x + this.width, this.y + this.height)) {
			if (Input.scrolled() < 0) {
				this.yOffsetVelocity += Input.scrolledAmount / 5f;
			} else if (Input.scrolled() > 0) {
				this.yOffsetVelocity += Input.scrolledAmount / 5f;
			}
			
			if (Input.isLeftMouseButtonDownNow()) {
				this.click(Input.mouseX - this.x, Input.mouseY - this.y);
			}
			
			int i = 0;
			for (GUIListElement element : this.listElements.values()) {
				element.updateInput(i);
				i ++;
			}
		}
	}
	
	private void click(float localX, float localY) {
		int i = 0;
		float y = this.yOffset;
		for (GUIListElement element : this.listElements.values()) {
			float height = element.getHeight();
			if (Util.aabb(localX, localY, 0, y, this.width, y + height)) {
				this.click(element, i, localX, localY - y);
				return;
			}
			y += height;
			i ++;
		}
	}
	
	public void click(GUIListElement element, int i, float localX, float localY) {
		element.click(i, localX, localY - y);
	}
	
	@Override
	public void update() {
		this.yOffset += this.yOffsetVelocity;
		if (this.yOffset > 0) {
			this.yOffset = 0;
		} else if (this.lastTotalElementsHeight <= this.height) {
			this.yOffset = 0;
		} else if (this.yOffset < -this.lastTotalElementsHeight + this.height) {
			this.yOffset = -this.lastTotalElementsHeight + this.height;
		}
		this.yOffsetVelocity /= 1.2f;
		
		int i = 0;
		for (GUIListElement element : this.listElements.values()) {
			element.update(i);
			i ++;
		}
	}
	
	@Override
	public void render(Matrix4f projectionMatrix, Matrix4f viewMatrix) {
		Shaders.bindColorGUI();
		Shaders.getCurrentlyBoundShader().passProjectionMatrix(projectionMatrix);
		Shaders.getCurrentlyBoundShader().passViewMatrix(viewMatrix);
		
		Stuff.backgroundColor2.bind();
		G.drawColoredQuad(this.x, this.y, this.width, this.height);
		
		Shaders.unbind();
		
		int i = 0;
		float y = this.yOffset;
		Stuff.startScissor(this.x, this.y, this.width, this.height);
		for (GUIListElement element : this.listElements.values()) {
			float height = element.getHeight();
			element.render(i, this.x, this.y + y, this.width, height, projectionMatrix, viewMatrix);
			y += height;
			i ++;
		}
		Stuff.stopScissor();
		this.lastTotalElementsHeight = y - this.yOffset;
	}
	
	public void add(String name, GUIListElement listElement) {
		this.listElements.put(name, listElement);
		listElement.name = name;
	}
	
	public void remove(String name) {
		this.listElements.remove(name);
	}
	
	public void set(HashMap<String, ?> hashMap, GUIListElement element) {
		this.listElements.clear();
		for (String key : hashMap.keySet()) {
			GUIListElement changedElement = element.copy();
			changedElement.name = key;
			changedElement.setValues(hashMap.get(key));
			this.listElements.put(key, changedElement);
		}
	}
	
	public void clear() {
		this.listElements.clear();
	}
	
}
