package com.esisa.reseau.tcp_udp;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.esisa.reseau.UI.GameFrame;
import com.esisa.reseau.UI.LogInFrame;

public class TestC2 {
	public static void main(String[] args) {
		int ports = 12345;
		int numberOf1 = 2;
		InetAddress ips;
		try {
			ips = InetAddress.getByName("localhost");
			//ClientUDP c2 = new ClientUDP(ips, ports, "p2");
			//GameFrame f = new GameFrame(c2);
			LogInFrame f1 = new LogInFrame();
		} catch (UnknownHostException e) {
			System.out.println("Errour:" + e.getMessage());
		}
	}
}
