package com.jimdo.jjh4296.base.graphic;

import javax.swing.JFrame;

import com.jimdo.jjh4296.base.reference.Reference;

public class GameFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public GameFrame() {
		this.setTitle(Reference.TITLE);
		this.setSize(Reference.SCREEN_WIDTH, Reference.SCREEN_HEIGHT);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

}
