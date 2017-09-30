package com.jimdo.jjh4296.base.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.jimdo.jjh4296.base.reference.Reference;

public class KeyBoard implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(!Reference.PRESSED_KEYS.contains(e.getKeyCode())) {
			Reference.PRESSED_KEYS.add(e.getKeyCode());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Reference.PRESSED_KEYS.remove((Integer) e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
