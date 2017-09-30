package com.jimdo.jjh4296.base.graphic.screens;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.jimdo.jjh4296.WaterWar;
import com.jimdo.jjh4296.base.graphic.world.World;
import com.jimdo.jjh4296.base.reference.Reference;
import com.jimdo.jjh4296.object.SpriteObject;

public class ScreenGame extends JPanel {

	private static final long serialVersionUID = 1L;
	World world;
	ArrayList<ArrayList<SpriteObject>> objects = new ArrayList<ArrayList<SpriteObject>>();
	
	@Override
	public void paintComponent(Graphics g) {
		// Clears the screen
		g.clearRect(0, 0, Reference.SCREEN_WIDTH, Reference.SCREEN_HEIGHT);

		// Renders background of screen
		renderBackground(g);

		// Renders main part of screen
		render(g);

		// Renders foreground of screen
		renderForeground(g);
	}
	
	public void setWorld(World world) {
		this.world = world;
		objects = world.getWorld();
	}

	private void renderBackground(Graphics g) {
		for (int x = 0; x < objects.size(); x++) {
			for (int y = 0; y < objects.get(x).size(); y++) {
				if(objects.get(x).get(y) == null) {
					continue;
				}
				g.drawImage(objects.get(x).get(y).getTexture(), 
						y * Reference.TILE_SIZE * Reference.PIXEL_SIZE,
						x * Reference.TILE_SIZE * Reference.PIXEL_SIZE, 
						Reference.TILE_SIZE * Reference.PIXEL_SIZE,
						Reference.TILE_SIZE * Reference.PIXEL_SIZE, null);
			}
		}
	}

	private void render(Graphics g) {

	}

	private void renderForeground(Graphics g) {
		resetString();
		drawString(g, "FPS: " + WaterWar.GAME.fps);
		drawString(g, "UPS: " + WaterWar.GAME.ups);
		drawString(g, "");
		drawString(g, "PressedKeyAmount: " + Reference.PRESSED_KEYS.size());
		drawList(g, toStringList("KeyPressed: ", Reference.PRESSED_KEYS));
		drawString(g, "");
		drawString(g, "MouseX: " + WaterWar.mouseMotionListener.mouseX);
		drawString(g, "MouseY: " + WaterWar.mouseMotionListener.mouseY);
	}

	int spaceY = 15;

	private void resetString() {
		spaceY = 15;
	}

	private List<String> toStringList(String pre, List list) {
		List<String> stringList = new ArrayList<String>();

		for (Object object : list) {
			stringList.add(pre + object.toString());
		}

		return stringList;
	}

	private void drawString(Graphics g, String text) {
		g.setColor(Color.BLACK);
		g.drawString(text, 10, spaceY);
		spaceY += 15;
	}

	private void drawList(Graphics g, java.util.List<String> list) {
		for (String text : list) {
			drawString(g, text);
		}
	}
}
