package com.esisa.reseau.tcp_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class WorkerUDP extends Thread{
	
	private boolean gameOver = false;
	private DatagramSocket bal;
	private Terrain t;
	
	public WorkerUDP(String name,DatagramSocket bal, Terrain t) {
		super(name);
		this.bal = bal;
		this.t = t;
		System.out.println("worker \n"+ name + "\n" + t);
	}
	public void run() {
		try {
			while(gameOver == false) 
			{
				byte [] buffer =new byte[1024];
				DatagramPacket enveloppe=new DatagramPacket(buffer, buffer.length);
				bal.receive(enveloppe);
				String cord = new String(enveloppe.getData());
				String[] info = cord.split(";");
				int i = Integer.parseInt(info[0]);
				int j = Integer.parseInt(info[1]);
				t.setPos(i, j);
				System.out.println("worker \n" + "\n" + t);
				gameOver = t.isLost();
			}
		} catch (Exception e) {
			System.out.println("Erreur:" + e.getMessage());
		}
		
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
}
