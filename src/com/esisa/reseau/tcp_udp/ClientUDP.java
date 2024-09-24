package com.esisa.reseau.tcp_udp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientUDP {
	private boolean isGameOver = false;
	private InetAddress ips;
	private int ports;
	private int portr;
	private Terrain t;
	private int bulletNumber;
	private String playerName;
	private String gameResult;
	
	Socket outGoingCall;
	PrintWriter microPhone;
	BufferedReader hautParleur;
	String messageInfo;
	String[] info;
	InetAddress ipEnemy;
	int portEnemy;
	DatagramSocket bal;
	WorkerUDP worker;
	
	public ClientUDP(InetAddress ips, int ports, String playerName) {
		try {
			//TCP connexion with the server
			this.playerName = playerName;
			this.ips = ips;
			this.ports = ports;
			outGoingCall = new Socket(ips, ports);
			System.out.println("Connexion a etablie avec le serveur");
			microPhone = new PrintWriter(new BufferedWriter( new OutputStreamWriter(outGoingCall.getOutputStream())),true);
			hautParleur = new BufferedReader( new InputStreamReader(outGoingCall.getInputStream()));
			microPhone.println(playerName);
			messageInfo = hautParleur.readLine();
			info = messageInfo.split(";");
			ipEnemy = InetAddress.getByName(info[0].substring(1)); 
			portEnemy = Integer.parseInt(info[1]);
			this.bulletNumber = Integer.parseInt(info[2]);
			int numberOf1 = Integer.parseInt(info[3]);
			int rows = Integer.parseInt(info[4]);
			int cols = Integer.parseInt(info[5]);
			System.out.println(rows + ";" + cols + ";"+ numberOf1);
			this.t = new Terrain(rows, cols, numberOf1);
			//UDP connexion with the other player
			this.portr = outGoingCall.getLocalPort();
			//Receiving
			bal = new DatagramSocket(portr);
			worker = new WorkerUDP(playerName, bal, this.t);
			worker.start();			
		} catch (Exception e) {
			System.out.println("Erreur:" + e.getMessage());
		}
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public int getBulletNumber() {
		return bulletNumber;
	}
	
	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
	
	public String getGameResult() {
		return gameResult;
	}

	public void sendBullet(int i, int j) {
		try {
			if(bulletNumber > 0) {
//				Scanner scanner = new Scanner( System.in );
				//System.out.print( "Veuillez saisir un premier entier : " );
	            //int a = scanner.nextInt();
	            
	            //System.out.print( "Veuillez saisir un second entier : " );
	            //int b = scanner.nextInt();
	            
	            String message  = i + ";" + j + ";";
	            byte[] papier = new byte[1024];
	            papier = message.getBytes();
	            DatagramPacket enveloppe = new DatagramPacket(papier, papier.length, ipEnemy, portEnemy);
	            bal.send(enveloppe);
	            bulletNumber--;
	            
	            if(bulletNumber == 0) {
	            	System.out.println("Waiting for game result xd");
					
					microPhone.println(t.getNumberOf1());
					gameResult = hautParleur.readLine();
					isGameOver = true;
	            }
	            
			}
			else {
				System.out.println("its Over");
				/*
				microPhone.println(t.getNumberOf1());
				gameResult = hautParleur.readLine();
				isGameOver = true;*/
			}
		} catch (Exception e) {
			System.out.println("Err :" + e.getMessage());
		}
		
	}
	
	public int getRowsNumber() {
		return t.getLineNumber();
	}
	
	public int getColsNumber() {
		return t.getColNumber();
	}
	
}
