package com.jimdo.jjh4296.base.graphic.screens;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScreenMain extends JPanel {
	private static final long serialVersionUID = 1L;

	ImageIcon image = new ImageIcon(new ImageIcon("res/logo.png").getImage().getScaledInstance(910, 600, Image.SCALE_SMOOTH));
	JLabel logo = new JLabel(image);
	
	JButton startButton = new JButton("START!");
	
	public ScreenMain() {
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		this.add(logo);
		this.add(startButton);
	}
}
