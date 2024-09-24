package com.esisa.reseau.UI;

import javax.swing.JFrame;

public class LogInFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public LogInFrame() {
		LoginPanel p = new LoginPanel();
		setContentPane(p);
		//setResizable(false);
		pack();
		setTitle("Composants Swing Réutilisables");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
