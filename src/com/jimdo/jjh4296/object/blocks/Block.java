package com.jimdo.jjh4296.object.blocks;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.jimdo.jjh4296.base.player.Player;
import com.jimdo.jjh4296.object.SpriteObject;

public class Block extends SpriteObject {
	
	public final String name;
	public final boolean canPassAway;
	public final boolean canBreak;
	public final int hardness;
	public final String ROOT_PATH = ROOT + "blocks/";
	
	public final Image texture;
	
	Block(String name, boolean canPassAway, boolean canBreak, int hardness) {
		super(name);
		this.name = name;
		this.canPassAway = canPassAway;
		this.canBreak = canBreak;
		this.hardness = hardness;
		texture = new ImageIcon(ROOT_PATH + name + EXTENSION).getImage();
		super.setTexture(texture);
	}
	
	void onStep(Player player, int x, int y) {}
	void onClick(Player player, int x, int y, int direction) {}
	void onBreak(Player player, int x, int y, int direction) {}
}
