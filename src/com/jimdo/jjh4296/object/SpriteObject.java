package com.jimdo.jjh4296.object;

import java.awt.Image;

public class SpriteObject {
	
	private String name = "empty";
	protected final String ROOT = "res/textures/";
	protected final String EXTENSION = ".png";
	private Image texture;
	
	public SpriteObject(String name) {
		this.name = name;
	}
	
	protected void setTexture(Image image) {
		this.texture = image;
	}

	public Image getTexture() {
		return texture;
	}
	
	public String getName() {
		return name;
	}
}
