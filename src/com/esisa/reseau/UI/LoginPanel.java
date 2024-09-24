package com.esisa.reseau.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.esisa.listeners.ExitListener;
import com.esisa.reseau.tcp_udp.ClientUDP;

public class LoginPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private LabeledTextField ipL;
	private LabeledTextField portL;
	private LabeledTextField playerNameL;
	
	
	public LoginPanel() {
		setLayout(new BorderLayout());
		setLabels();
		setButtons();
	}
	
	private void setLabels() {
		ipL = new LabeledTextField("Adresse IP :", 30);
		portL = new LabeledTextField("Numero du port :", 20);
		playerNameL = new LabeledTextField("Name :", 20);
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(ipL);
		p.add(portL);
		p.add(playerNameL);
		add(p,"Center");
	}
	
	private void setButtons() {
		JButton logIn = new JButton("LogIn");
		logIn.addActionListener(this);
		JButton quit = new JButton("Exit");
		quit.addActionListener(new ExitListener());
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(quit);
		p.add(logIn);
		add(p, "South");
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			InetAddress ips = InetAddress.getByName(ipL.getValue());
			int ports = Integer.parseInt(portL.getValue());
			String playerName = playerNameL.getValue();
			ClientUDP c = new ClientUDP(ips, ports, playerName);
			GameFrame g = new GameFrame(c);
			g.setSize(500, 200);
			g.setResizable(false);
			g.setTitle("Composants Swing Réutilisables");
			g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			g.setVisible(true);
			System.out.println("game frame cree");
		} catch (Exception er) {
			System.out.println("Errour :" + er.getMessage());
		}
	}
	
}
