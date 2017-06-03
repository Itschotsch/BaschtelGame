package main;

import main.engine.Engine;

public class Main {


	public static void main(String[] args) {

		Engine.initWindowed(Main.class , 800, 800, "BaschtelGame", true);
		
		Engine.start(new MainScreen());
		
		
	}

}
