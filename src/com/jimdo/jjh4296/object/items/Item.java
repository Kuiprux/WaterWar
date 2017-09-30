package com.jimdo.jjh4296.object.items;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.jimdo.jjh4296.object.SpriteObject;

public class Item extends SpriteObject {

	public final String name;
	public final String ROOT_PATH = ROOT + "items/";
	
	public final Image texture; 
	
	public Item(String name) {
		super(name);
		this.name = name;
		texture = new ImageIcon(ROOT_PATH + name + EXTENSION).getImage();
		super.setTexture(texture);
	}
}
