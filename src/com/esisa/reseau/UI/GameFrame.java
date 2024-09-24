package com.esisa.reseau.UI;

import javax.swing.JFrame;

import com.esisa.reseau.tcp_udp.ClientUDP;

public class GameFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public GameFrame(ClientUDP c) {
		super("GAME!!");
		GamePanel p = new GamePanel(c);
		setSize(300, 300);
		setContentPane(p);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
