package com.esisa.reseau.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.esisa.listeners.ExitListener;
import com.esisa.reseau.tcp_udp.ClientUDP;

public class GamePanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JLabel notif;
	private ClientUDP c;
	PlayerInfoPanel infoPanel;
	
	public GamePanel(ClientUDP c) {
		this.c = c;
		int rows = c.getColsNumber();
		int cols = c.getColsNumber();
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 5, 5, 5));
		createNotificationBar();
		createButtons(rows, cols);
		createButtonsPanel();
		createPlayerInfo();
	}
	
	private void createPlayerInfo() {
		infoPanel = new PlayerInfoPanel(c.getPlayerName(), c.getBulletNumber());
		add("West", infoPanel);
	}
	
	private void createNotificationBar() {
		notif = new JLabel("PLAY!");
		notif.setFont(new Font("Arial", Font.BOLD, 20));
		notif.setHorizontalAlignment(JLabel.CENTER);
		add(notif, "North");
	}
	
	public void setNotif(String message) {
		notif.setText(message);
	}
	
	private void createButtons(int rows, int cols) {
		JPanel p = new JPanel();
		JButton b;
		p.setLayout(new GridLayout(rows, cols));
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				b = new JButton(i + ";" + j);
				b.addActionListener(this);
				p.add(b);
			}
		}
		add(p,"Center");
	}
	
	private void createButtonsPanel() {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton quitter = new JButton("Quitter");
		quitter.addActionListener(new ExitListener());
		p.add(quitter);
		add(p,"South");
	}

	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton)e.getSource();
		src.setBackground(Color.red);
		String[] info = src.getText().split(";");
		int i = Integer.parseInt(info[0]);
		int j = Integer.parseInt(info[1]);
		c.sendBullet(i, j);
		infoPanel.setBullets(c.getBulletNumber());
		if(c.getBulletNumber() == 0) {
			notif.setText(c.getGameResult());
		}
	}
}
