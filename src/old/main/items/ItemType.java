package main.items;

import main.engine.graphics.Texture;
import main.engine.graphics.Textures;

public enum ItemType {
	
	BLADE("blade", "Klinge"),
	BOW("bow", "Bogen"),
	GRASS("grass", "Gras"),
	KOALA("koala", "Koala"),
	;
	
	public String name, displayName;
	
	public Texture texture;
	
	ItemType(String name, String displayName) {
		this.name = name;
		this.displayName = displayName;
		this.texture = Textures.get(name);
	}
	
}
