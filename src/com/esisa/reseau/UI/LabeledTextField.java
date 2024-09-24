package com.esisa.reseau.UI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LabeledTextField extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final int LEFT = 0;
	public static final int TOP = 1;
	
	public LabeledTextField(String label, int size) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		if (!label.contains(":")) {
			label = label + " : ";
		}
		add(new JLabel(label));
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		p.add(new JTextField(size));
		add(p);
	}

	public LabeledTextField(String label, int size, int labelWidth) {
		this(label, size);
		
		JLabel l = (JLabel)getComponent(0);
		l.setPreferredSize(new Dimension(labelWidth, l.getPreferredSize().height));
	}

	public LabeledTextField(int style, String label, int size) {
		this(label, size);
		setStyle(style);
	}
	
	public void setStyle(int style) {
		if (style == LEFT) {
			setLayout(new FlowLayout(FlowLayout.LEFT));
		}
		else if (style == TOP) {
			setLayout(new GridLayout(2, 1));
		}
	}
	
	public void setValue(Object value) {
		JPanel p = (JPanel)getComponent(1);
		JTextField t = (JTextField)p.getComponent(0);
		t.setText("" + value);
	}
	
	public String getValue() {
		JPanel p = (JPanel)getComponent(1);
		JTextField t = (JTextField)p.getComponent(0);
		return t.getText();
	}
}
