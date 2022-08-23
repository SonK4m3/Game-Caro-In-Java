package Model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/*	board has size 10 * 10
 * 	matrix present board has size is 11 * 11
 * 
 * 
 */

public class Board {

	static final int Size = 10;
	
	int[][] mat = new int[Size + 1][Size + 1];
	
	final int Width = 600;
	final int Height = 600;
	
	final int row = 10;
	final int col = 10;
	
	final int stroke = 1;
	
	
//	Map<> mp = new Map<>();
	
	// constructor
	public Board() {
		//1. initialization
		initBoard();
	}
	
	// board
	public void initBoard() {
		for(int i = 1; i <= Size; i++)
			for(int j = 1; j <= Size; j++)
				mat[i][j] = 0;
	}
	
	public void setBoad(int y, int x, int val) {
		if(x >= 1 && x <= Size && y >= 1 && y <= Size)
			mat[x][y] = val;
	}
	
	public int getVal(int y, int x) {
		if(x >= 1 && x <= Size && y >= 1 && y <= Size)
			return mat[x][y];
		return -1;
	}
	
	// size
	public int getSize() {
		return Size;
	}
	
	// print board
	public void print() {
		System.out.println("-------------------\nBoard:");
		for(int i = 1; i <= Size; i++) {
			for(int j = 1; j <= Size; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		int rowPos = 60;
		int colPos = 60;
				
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, Width, Height);
		
		// draw board
		g2d.setColor(Color.black);
		for(int i = 0; i <= row; i++) {
			g2d.drawLine(0, rowPos * i, Width, rowPos * i);
		}
		for(int i = 0; i <= col; i++) {
			g2d.drawLine(colPos * i, 0, colPos * i, Height);
		}
	}
}
