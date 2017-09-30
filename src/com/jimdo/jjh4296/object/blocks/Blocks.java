package com.jimdo.jjh4296.object.blocks;

import com.jimdo.jjh4296.base.reference.Registry;

public class Blocks {
	public static final Block GRASS = new Block("grass", false, true, 1);
	public static final Block STONE = new Block("stone", false, true, 5);
	
	public static void register() {
		Registry.addBlock(GRASS);
		Registry.addBlock(STONE);
	}
}
