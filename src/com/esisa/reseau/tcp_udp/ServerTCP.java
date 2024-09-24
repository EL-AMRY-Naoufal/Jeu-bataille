package com.esisa.reseau.tcp_udp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
	private int port;
	private ServerSocket service;
	private int bulletNumber;
	private int nulberOf1;
	
	public ServerTCP(int port, int bulletNumber, int numberOf1, int rows, int cols) {
		try {
			this.port = port;
			this.bulletNumber = bulletNumber;
			this.nulberOf1 = numberOf1;
			this.service = new ServerSocket(port);
			//--------PLAYER 1 INFO----------
			System.out.println("Attender joueur 1....");
			Socket inCommingCall1 = service.accept();
			BufferedReader hautParleur1 = new BufferedReader( new InputStreamReader(inCommingCall1.getInputStream()));
			PrintWriter microPhone1 = new PrintWriter(new BufferedWriter( new OutputStreamWriter(inCommingCall1.getOutputStream())),true);
			System.out.println("Connexion a etablie avec joueur 1");
			InetAddress ipP1 = inCommingCall1.getInetAddress();
			int portP1 = inCommingCall1.getPort();
			String player1 = hautParleur1.readLine();
			System.out.println("client port " + portP1);
			
			//--------PLAYER 2 INFO----------
			System.out.println("Attender joueur 2....");
			Socket inCommingCall2 = service.accept();
			BufferedReader hautParleur2 = new BufferedReader( new InputStreamReader(inCommingCall2.getInputStream()));
			PrintWriter microPhone2 = new PrintWriter(new BufferedWriter( new OutputStreamWriter(inCommingCall2.getOutputStream())),true);
			System.out.println("Connexion a etablie avec joueur 2");
			InetAddress ipP2 = inCommingCall2.getInetAddress();
			int portP2 = inCommingCall2.getPort();
			String player2 = hautParleur2.readLine();
			//-------Transferer les donner du joueur 1 au joueur 2---------
			String info1 = ipP1 + ";" + portP1 + ";" + bulletNumber + ";" + numberOf1 + ";" + rows + ";" + cols;
			microPhone2.println(info1);
			//-------Transferer les donner du joueur 2 au joueur 1---------
			String info2 = ipP2.toString() + ";" + portP2 + ";" + bulletNumber + ";" + numberOf1 + ";" + rows + ";" + cols;
			microPhone1.println(info2);
			//Attender les 2 joueur pour terminer
			int m1 = Integer.parseInt(hautParleur1.readLine());
			int m2 = Integer.parseInt(hautParleur2.readLine());
			System.out.println(player1  +" result:" + m1);
			System.out.println(player2 + " result:" + m2);
			String result1 = "";
			String result2 = "";
			if(m1 > m2) {
				result1 = "YOU LOST !";
				result2 = "YOU WON !";
			}
			else if(m1 < m2) {
				result1 = "YOU WON !";
				result2 = "YOU LOST !";
			}
			else {
				result1 = "NO WINNER IT'S A DRAW !";
				result2 = "NO WINNER IT'S A DRAW !";
			}
			
			microPhone1.println(result1);
			microPhone2.println(result2);
			
		} catch (Exception e) {
			System.out.println("Erreur:" + e.getMessage());
		}
	}
}
