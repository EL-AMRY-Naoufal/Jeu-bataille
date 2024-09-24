package com.esisa.reseau.UI;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerInfoPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JLabel playerName;
	private JLabel bullets;
	public PlayerInfoPanel(String name, int  nbr) {
		playerName = new JLabel("Name: " + name);
		playerName.setFont(new Font("Verdana", Font.PLAIN, 18));
		bullets = new JLabel("Bullets :" + nbr);
		bullets.setFont(new Font("Verdana", Font.PLAIN, 18));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(playerName);
		add(bullets);
	}
	
	public void setBullets(int n) {
		bullets.setText("Bullets:" + n);
	}
	
	public void setPlayerName(String name) {
		playerName.setText("Name: " + name);
	}
	
}
