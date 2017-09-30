package com.jimdo.jjh4296;

import java.awt.Toolkit;
import java.util.List;

import javax.swing.SwingUtilities;

import com.jimdo.jjh4296.base.graphic.GameFrame;
import com.jimdo.jjh4296.base.graphic.screens.ScreenGame;
import com.jimdo.jjh4296.base.graphic.screens.ScreenMain;
import com.jimdo.jjh4296.base.graphic.world.World;
import com.jimdo.jjh4296.base.graphic.world.WorldLoader;
import com.jimdo.jjh4296.base.listeners.KeyBoard;
import com.jimdo.jjh4296.base.listeners.Mouse;
import com.jimdo.jjh4296.base.listeners.MouseMotion;
import com.jimdo.jjh4296.base.reference.Reference;
import com.jimdo.jjh4296.object.blocks.Blocks;

public class WaterWar {
	
	public static KeyBoard keyListener = new KeyBoard();
	public static Mouse mouseListener = new Mouse();
	public static MouseMotion mouseMotionListener = new MouseMotion();
	public static WorldLoader worldLoader = new WorldLoader();
	public static List<World> worldList = worldLoader.getWorldList();

	//Screens
	public static ScreenGame gameScreen = new ScreenGame();
	public static ScreenMain mainScreen = new ScreenMain();
	
	public static Game GAME;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new WaterWar();
			}
		});
	}
	
	public WaterWar() {

		//You can customize the screen size under References
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		if(Reference.SCREEN_WIDTH == 0) {
			Reference.SCREEN_WIDTH = toolkit.getScreenSize().width;
		}
		if(Reference.SCREEN_HEIGHT == 0) {
			Reference.SCREEN_HEIGHT = toolkit.getScreenSize().height;
		}
		
		//Creates a Window
		GameFrame frame = new GameFrame();
		
		frame.addKeyListener(keyListener);
		frame.addMouseListener(mouseListener);
		frame.addMouseMotionListener(mouseMotionListener);
		
		//Game object
		GAME = new Game(frame);
		GAME.start();
		
		Blocks.register();
		worldLoader.load();
		
		gameScreen.setWorld(worldList.get(0));
		frame.setContentPane(mainScreen);
		//Makes the window visible
		frame.setVisible(true);
	}
}
