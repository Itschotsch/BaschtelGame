package main.screens;

import org.lwjgl.util.vector.Matrix4f;

import main.engine.graphics.Graphics;
import main.engine.screens.Screen;
import main.engine.util.Util;
import main.general.S;
import main.general.gui.GUIButton;
import main.general.gui.GUIElementSet;
import main.general.gui.GUIFunctionality;
import main.general.gui.GUIList;
import main.general.gui.GUIListElement;
import main.general.gui.GUIListSingleSelection;
import main.general.gui.GUIListTextElement;

public class MainScreen extends Screen {
	
	GUIElementSet elementSet;
	
	@Override
	public void init() {
		S.init();
		
		this.elementSet = new GUIElementSet();
		
		GUIListSingleSelection list1 = new GUIListSingleSelection(S.uY(0.1f), S.uY(0.25f), S.uY(0.3f), S.uY(0.65f));
		list1.add("e1", new GUIListTextElement("Eintrag 1"));
		list1.add("e2", new GUIListTextElement("Eintrag 2"));
		list1.add("e3", new GUIListTextElement("Eintrag 3"));
		list1.add("e4", new GUIListTextElement("Eintrag 4"));
		list1.add("e5", new GUIListTextElement("Eintrag 5"));
		this.elementSet.add("testlist1", list1);
		
		GUIListSingleSelection list2 = new GUIListSingleSelection(S.uY(0.45f), S.uY(0.25f), S.uY(0.3f), S.uY(0.65f));
		
		this.elementSet.add("testlist2", list2);
		
		this.elementSet.add("testbutton", new GUIButton(S.uY(0.1f), S.uY(0.1f), S.uY(0.3f), S.uY(0.1f), GUIFunctionality.PRIMARY, new Runnable() {
			@Override
			public void run() {
				GUIListElement selectedElement = list1.selectedElement;
				if (selectedElement != null) {
					list2.add(Util.randomString(10), new GUIListTextElement(selectedElement.getValues()[0]));
				}
			}
		}));
	}
	
	@Override
	public void updateInput() {
		this.elementSet.updateInput();
	}
	
	@Override
	public void update() {
		this.elementSet.update();
	}
	
	@Override
	public void render() {
		Graphics.prepareRender(true, false);
		this.elementSet.render();
	}
	
	@Override
	public void stop() {
		
	}
	
}
