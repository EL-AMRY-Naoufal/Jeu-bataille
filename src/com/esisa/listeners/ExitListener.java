package com.esisa.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {

	public ExitListener() {
	}

	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
