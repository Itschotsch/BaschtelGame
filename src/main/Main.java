package main;

import main.engine.Engine;
import main.general.S;
import main.screens.MainScreen;

public class Main {
	
	public static void main(String[] args) {
		Engine.initWindowed(Main.class, 1280, 720, "BaschtelGame " + S.version, true);
		Engine.start(new MainScreen());
	}
	
}
