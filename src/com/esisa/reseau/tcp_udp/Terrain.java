package com.esisa.reseau.tcp_udp;

public class Terrain {
	private int lineNumber;
	private int colNumber;
	private int data[][];
	private int numberOf1;
	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getColNumber() {
		return colNumber;
	}

	public int[][] getData() {
		return data;
	}

	public void setNumberOf1(int numberOf1) {
		this.numberOf1 = numberOf1;
	}
	
	public int getNumberOf1() {
		return numberOf1;
	}

	public Terrain(int lineNumber, int colNumber, int numberOf1) {
		this.colNumber = colNumber;
		this.lineNumber = lineNumber;
		this.numberOf1 = numberOf1;
		data = new int[lineNumber][colNumber];
		
		for (int i = 0; i < lineNumber; i++) {
			for (int j = 0; j < colNumber; j++) {
				data[i][j] = 0;
			}
		}
		
		int n = this.numberOf1;
		
		while(n > 0) {
			for (int i = 0; i < lineNumber; i++) {
				for (int j = 0; j < colNumber; j++) {
					double a = Math.random();
					if(a > 0.5 && data[i][j] != 1 && n != 0) {
						data[i][j] = 1;
						n--;
					}
				}
			}
		}
		System.out.println(this.toString());
	}
	
	public int getPos(int i, int j) {
		return data[i][j];
	}
	
	public boolean isLost() {
		if(numberOf1 <= 0) {
			return true;
		}
		else return false;
	}
	
	public void setPos(int i, int j) {
		if(data[i][j] == 1) {
			data[i][j] = 0;
			numberOf1--;
		}
	}
	
	
	
	public String toString() {
		String s = "";
		for (int i = 0; i < lineNumber; i++) {
			for (int j = 0; j < colNumber; j++) {
				s +=  data[i][j] + "|";
			}
			s += "\n";
		}
		return s;
	}
}
