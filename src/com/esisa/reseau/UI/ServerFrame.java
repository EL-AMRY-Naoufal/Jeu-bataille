package com.esisa.reseau.UI;

import javax.swing.JFrame;

public class ServerFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public ServerFrame() {
		super("Game Server setting");
		ServerPanel p = new ServerPanel();
		//setSize(300, 300);
		setContentPane(p);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
