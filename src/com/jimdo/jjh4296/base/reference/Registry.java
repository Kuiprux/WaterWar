package com.jimdo.jjh4296.base.reference;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

import com.jimdo.jjh4296.object.blocks.Block;
import com.jimdo.jjh4296.object.items.Item;

public class Registry {

	public static final String ROOT = "res/textures/";

	private static Map<String, Block> blocks = new HashMap<String, Block>();
	private static Map<String, Item> items = new HashMap<String, Item>();
	
	public static final Image GRASS = new ImageIcon(ROOT + "blocks/grass.png").getImage();
	
	public static void addBlock(Block block) {
		blocks.put(block.name, block);
	}

	public static void addItem(String name, Item item) {
		items.put(item.name, item);
	}
	
	public static Block getBlock(String key) {
		return blocks.get(key);
	}
	
	public static Item getItem(String key) {
		return items.get(key);
	}
	
	public static boolean hasBlock(String key) {
		return blocks.containsKey(key);
	}
	
	public static boolean hasItem(String key) {
		return items.containsKey(key);
	}
}
