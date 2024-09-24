package com.esisa.reseau.tcp_udp;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import com.esisa.reseau.UI.GameFrame;
import com.esisa.reseau.UI.LogInFrame;

public class TestC1 {
	public static void main(String[] args) {
		
		int ports = 12345;
		int numberOf1 = 2;
		InetAddress ips;
		try {
			ips = InetAddress.getByName("localhost");
			//ClientUDP c1 = new ClientUDP(ips, ports, "p1");
			//GameFrame f1 = new GameFrame(c1);
			LogInFrame f = new LogInFrame();
		} catch (UnknownHostException e) {
			System.out.println("Errour:" + e.getMessage());
		}
	}
}
