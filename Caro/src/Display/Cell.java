package Display;

import javax.swing.*;

public class Cell extends JLabel{
	
	String symbol;
	int value;
	int xPos;
	int yPos;
	
	public Cell() {
		this.setSize(50, 50);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
	}
	
	public void setXY(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public void setCell(int xPos, int yPos, String symbol) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.symbol = symbol;
	}
	
	public void printXY() {
		System.out.println(xPos + " " + yPos);
	}
}
