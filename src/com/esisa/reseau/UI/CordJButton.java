package com.esisa.reseau.UI;

import javax.swing.JButton;

public class CordJButton extends JButton{
	private static final long serialVersionUID = 1L;
	
	private int i;
	private int j;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getX() {
		return i;
	}

	public int getY() {
		return j;
	}

	public CordJButton(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
