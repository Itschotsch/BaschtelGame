package main.general;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import main.engine.graphics.Color;
import main.engine.graphics.Textures;
import main.engine.graphics.font.Font;
import main.engine.graphics.font.FontGlow;
import main.engine.graphics.font.FontWeight;
import main.engine.graphics.geometry.Vector2;
import main.general.gui.GUIButton;

public class S {
	
	public static final String version = "V0.1";
	public static final Color
		primaryDefaultColor = Color.from255(20, 59, 109),
		primaryHoverColor = Color.from255(24, 71, 131),
		warningDefaultColor = Color.from255(132, 114, 20),
		warningHoverColor = Color.from255(156, 134, 23),
		dangerDefaultColor = Color.from255(109, 26, 20),
		dangerHoverColor = Color.from255(131, 31, 24);
	public static final Color
		backgroundColor1 = Color.from255(8, 24, 44),
		backgroundColor2 = Color.from255(4, 12, 22),
		foregroundColor1 = Color.from255(12, 36, 66),
		foregroundColor2 = Color.from255(14, 42, 77),
		foregroundColor3 = Color.from255(16, 48, 87),
		foregroundColor4 = Color.from255(18, 54, 97),
		darkenColor = Color.from255(0, 0, 0, 127);
	public static final float disabledTransparency = 0.25f;
	
	public static void init() {
		Font.loadFontType("bebas-neue");
		
		Textures.load("gui/logo", false, false);
		Textures.load("gui/button", false, false);
		Textures.load("gui/background", false, false);
		Textures.load("gui/barrierCorner", false, false);
		
		GUIButton.init();
	}
	
	private static final float fontCharacterSpacing = 0.7f;
	
	public static void drawSmallStringCenteredX(String text, float x, float y) {
		S.drawSmallString(text, x - (S.getSmallStringWidth(text) / 2f), y);
	}
	
	public static void drawLargeStringCenteredX(String text, float x, float y) {
		S.drawLargeString(text, x - (S.getLargeStringWidth(text) / 2f), y);
	}
	
	public static void drawSmallStringCenteredY(String text, float x, float y) {
		S.drawSmallString(text, x, y + (S.getSmallStringHeight() / 2f));
	}
	
	public static void drawLargeStringCentereXY(String text, float x, float y) {
		S.drawLargeString(text, x, y + (S.getLargeStringHeight() / 2f));
	}
	
	public static void drawSmallStringCenteredXY(String text, float x, float y) {
		S.drawSmallString(text, x - (S.getSmallStringWidth(text) / 2f), y + (S.getSmallStringHeight() / 2f));
	}
	
	public static void drawLargeStringCenteredXY(String text, float x, float y) {
		S.drawLargeString(text, x - (S.getLargeStringWidth(text) / 2f), y + (S.getLargeStringHeight() / 2f));
	}
	
	public static void drawSmallStringCenteredX(String text, float x, float y, float alpha) {
		S.drawSmallString(text, x - (S.getSmallStringWidth(text) / 2f), y, alpha);
	}
	
	public static void drawLargeStringCenteredX(String text, float x, float y, float alpha) {
		S.drawLargeString(text, x - (S.getLargeStringWidth(text) / 2f), y, alpha);
	}
	
	public static void drawSmallString(String text, float x, float y) {
		Font.drawString(text, new Vector2(x, y), S.getSmallStringHeight(), S.fontCharacterSpacing, Color.white, FontWeight.W0225, FontGlow.G01, Color.white, "bebas-neue");
	}
	
	public static void drawLargeString(String text, float x, float y) {
		Font.drawString(text, new Vector2(x, y), S.getLargeStringHeight(), S.fontCharacterSpacing, Color.white, FontWeight.W0225, FontGlow.G0075, Color.white, "bebas-neue");
	}
	
	public static void drawSmallString(String text, float x, float y, float a) {
		Font.drawString(text, new Vector2(x, y), S.getSmallStringHeight(), S.fontCharacterSpacing, Color.white.alpha(a), FontWeight.W0225, FontGlow.G01, Color.white, "bebas-neue");
	}
	
	public static void drawLargeString(String text, float x, float y, float a) {
		Font.drawString(text, new Vector2(x, y), S.getLargeStringHeight(), S.fontCharacterSpacing, Color.white.alpha(a), FontWeight.W0225, FontGlow.G0075, Color.white, "bebas-neue");
	}
	
	public static float getSmallStringWidth(String text) {
		return Font.getWidth(text, S.getSmallStringHeight(), S.fontCharacterSpacing, "bebas-neue");
	}
	
	public final static float getSmallStringHeight() {
		return 40;
	}
	
	public final static float getLargeStringHeight() {
		return 60;
	}
	
	public static float getLargeStringWidth(String text) {
		return Font.getWidth(text, S.getLargeStringHeight(), S.fontCharacterSpacing, "bebas-neue");
	}
	
	public static final int uX(float f) {
		return (int) (Display.getWidth() * f);
	}
	
	public static final int uY(float f) {
		return (int) (Display.getHeight() * f);
	}
	
	public static void startScissor(float x, float y, float width, float height) {
		GL11.glEnable(GL11.GL_SCISSOR_TEST);
		GL11.glScissor((int) x, Display.getHeight() - (int) y - (int) height, (int) width, (int) height);
	}
	
	public static void stopScissor() {
		GL11.glDisable(GL11.GL_SCISSOR_TEST);
	}

}
