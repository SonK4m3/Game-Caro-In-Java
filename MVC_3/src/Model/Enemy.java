package Model;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import View.*;
public class Enemy{

	private Board board;	// board
	
	static int numberEnemy = 0;
	int order = 0;
	
	State state = new State(this);	// state of flight

	// head position
	int headX = -1;
	int headY = -1;
	
	int[][] swings = new int[8][2];	// swings position
	
	boolean isStick = false;		// var to check flight is place or not
	// Image	
	BufferedImage imageLeft = null; 
	BufferedImage imageRight = null; 
	BufferedImage imageTop = null; 
	BufferedImage imageBot = null; 

	int xPos;
	int yPos;
	
	public Enemy(Board board) {
		this.board = board;
		//1. Initialization
		initSwing();
		
		numberEnemy ++;
		order = numberEnemy;
		
		//2. get Image left, right, top, bot
		try {
			imageLeft = ImageIO.read(new File("res//left.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}	
		
		try {
			imageRight = ImageIO.read(new File("res//right.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			imageTop = ImageIO.read(new File("res//top.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			imageBot = ImageIO.read(new File("res//bot.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// swing
	void initSwing() {
		for(int i = 0; i < 8; i++) {
			swings[i][0] = swings[i][1] = -1;
		}
	}
	
	public void setSwing(int[][] mat) {
		for(int i = 0; i < 8; i++) {
			this.swings[i][0] = headY + mat[i][0];
			this.swings[i][1] = headX + mat[i][1];
		}
	}
	
	public int getSwingX(int x) {
		return swings[x][0];
	}
	
	public int getSwingY(int y) {
		return swings[y][1];
	}
	
	//head
	public void setHeadPos(int x, int y) {
		if(x >= 1 && x <= board.getSize() && y >= 1 && y <= board.getSize()) {			
			this.headX = x;
			this.headY = y;  
			xPos = 60 * headY;
			yPos = 60 * headX;
		}
	}
	
	public int getHeadX() {
		return headX;
	}
	
	public int getHeadY() {
		return headY;
	}
	
	//stick
	public void setIsStick(boolean stick) {
		this.isStick = stick;
	}
	
	public boolean getIsStick() {
		return isStick;
	}
	
	public void stickEnemy() {
		for(int i = 0; i < 8; i++)
			board.setBoad(swings[i][0], swings[i][1], order);
	}
	
	// state
	public State getState() {
		return state;
	}
	
	//remove
	public void removeEnemy() {
		for(int i = 0; i < 8; i++)
			if(board.getVal(swings[i][0], swings[i][1]) == order)
				board.setBoad(swings[i][0], swings[i][1], 0);
	}
	//board
	public Board getBoard() {
		return board;
	}
	// state
	public void setState() {
		state.setStateFlight();
	}
	
	public void changeState() {
		state.changeState();
	}
	// function condition check
	public boolean isOutOfBoard() {
		for(int i = 0;i < 8; i++) {
			// check position of plane is out of board or not
			if(swings[i][0] < 1 || swings[i][1] < 1 || swings[i][0] > board.getSize() || swings[i][1] > board.getSize()) 
				return true;
		}
		return false;
	}
	
	public boolean canStickOnBoard() {
		for(int i = 0; i < 8; i++) {
			if(board.getVal(swings[i][0], swings[i][1]) != 0) {
				return false;
			}
		}
		return true;
	}
	
	
	public void reset() {
		isStick = false;
		state.reset();
		removeEnemy();
		initSwing();
		headX = -1;
		headY = -1;
	}

	// print enemy
	public void print() {
		System.out.println("--------");
		System.out.println("Enemy " + order + " of " + numberEnemy + " : " + headX + " " + headY);
		state.print();
	}
	
	public void paint(Graphics g) {	
		Graphics2D g2d = (Graphics2D) g;
		int stt = state.getStateNumber();
		if(stt == 1)
			g2d.drawImage(imageLeft, xPos - 60, yPos - 120, null);	
		else if(stt == 2)
			g2d.drawImage(imageTop, xPos  - 120, yPos - 60, null);	
		else if(stt == 3)
			g2d.drawImage(imageRight, xPos - 240, yPos - 120, null);	
		else if(stt == 4)
			g2d.drawImage(imageBot, xPos - 120, yPos - 240, null);	
	}
}
