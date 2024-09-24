package com.esisa.reseau.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.esisa.reseau.tcp_udp.ServerTCP;

public class ServerPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private LabeledTextField port;
	private LabeledTextField bulletNumber;
	private LabeledTextField numberOf1;
	private LabeledTextField rows;
	private LabeledTextField cols;

	public ServerPanel() {
		port = new LabeledTextField("Port", 20);
		bulletNumber = new LabeledTextField("Bullet number :", 15);
		numberOf1 = new LabeledTextField("Number of one :", 15);
		rows = new LabeledTextField("Rows number :", 15);
		cols = new LabeledTextField("Cols number", 10);
		JButton b = new JButton("Confirmer");
		b.addActionListener(this);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(port);
		add(bulletNumber);
		add(numberOf1);
		add(rows);
		add(cols);
		add(b);
	}
	
	public void actionPerformed(ActionEvent e) {
		int portNbr = Integer.parseInt(port.getValue());
		int ammo = Integer.parseInt(bulletNumber.getValue());
		int ones = Integer.parseInt(numberOf1.getValue());
		int row = Integer.parseInt(rows.getValue());
		int col = Integer.parseInt(cols.getValue());
		
		ServerTCP ser = new ServerTCP(portNbr, ammo, ones, row, col);
		JFrame f = (JFrame) SwingUtilities.getWindowAncestor(this);
		f.dispose();
	}
	
}
