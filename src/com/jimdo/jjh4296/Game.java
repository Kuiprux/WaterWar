package com.jimdo.jjh4296;

import javax.swing.JFrame;

import com.jimdo.jjh4296.base.reference.Reference;

public class Game extends Thread {	
	public int fps = 0;
	public int ups = 0;
	
	JFrame frame;
	
	Game(JFrame frame) {
		this.frame = frame;
	}
	
	public void update() {
		
	}	

	@Override
	public void run() {
		long GAME_SKIP_TICKS = 1000 / Reference.UPDATES_PER_SECOND;
		long FRAME_SKIP_TICKS = 1000 / Reference.FRAMES_PER_SECOND;
		
		long nextGameTick = System.currentTimeMillis();
		long nextFrameTick = System.currentTimeMillis();
		long time = System.currentTimeMillis();

		int loops;
		
		int frames = 0;
		int updates = 0;
		
		while (true) {
			loops = 0;
			while (System.currentTimeMillis() > nextGameTick && loops < Reference.MAX_FRAMESKIP) {
				update();

				nextGameTick += GAME_SKIP_TICKS;
				updates++;
				loops++;
			}

			if (System.currentTimeMillis() > nextFrameTick) {
				nextFrameTick += FRAME_SKIP_TICKS;
				frame.repaint();
				frames++;
			}

			if (time + 1000 <= System.currentTimeMillis()) {
				time += 1000;

				fps = frames;
				ups = updates;
				updates = 0;
				frames = 0;
			}
		}
	}
}
