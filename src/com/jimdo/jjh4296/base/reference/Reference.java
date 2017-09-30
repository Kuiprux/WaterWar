package com.jimdo.jjh4296.base.reference;

import java.util.ArrayList;
import java.util.List;

public class Reference {
	// MAIN
	public static final String TITLE = "Game Development - by ScratchForFun";
	public static int SCREEN_WIDTH;
	public static int SCREEN_HEIGHT;  // SCREEN
	
	//SCREEN
	public static int PIXEL_SIZE = 5; // TODO: Change this to scale!
	public static int TILE_SIZE = 16;  // GAME THREAD

	//GAME THREAD
	public static int UPDATES_PER_SECOND = 50;
	public static int FRAMES_PER_SECOND = 100;
	public static long MAX_FRAMESKIP = 5;
	
	// LISTENER
	public static List<Integer> PRESSED_KEYS = new ArrayList<Integer>();
	public static int MOUSE_X;
	public static int MOUSE_Y;
	
	//CHUNK
	public static final int TILE_AMOUNT_X = 16;
	public static final int TILE_AMOUNT_y = 16;
}
