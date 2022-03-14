package Display;
import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

public class BoardDisplay{
	
	int MAX = 15;
	
	Board board;
	Player player1, player2;
	Cell [][] cells;
	JFrame frame;
	int xSize, ySize;
	
	BoardDisplay(Board board, Player player1, Player player2){
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
		frame = new JFrame();
		cells = new Cell[MAX][MAX];
		Border border = BorderFactory.createLineBorder(Color.gray, 2);

		xSize = board.row;
		ySize = board.col;
		
		for(int i = 0; i < xSize; i++) {
			for(int j = 0; j < ySize; j++) {
				cells[i][j] = new Cell();
				cells[i][j].setBounds(i * 50 + 2, j * 50 + 2, 50, 50);
				cells[i][j].setBorder(border);
				
				cells[i][j].addMouseListener(new MyMouseListener(cells[i][j], i, j, board));
				frame.add(cells[i][j]);
			}
		}
		
		player1.printInfor();
		player2.printInfor();
		System.out.println(xSize + " " + ySize);
		
		// board
//		board.print();
		
		
		
		// frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(xSize * 54, ySize * 54 + 25));
		frame.setLayout(null);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void getSize(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
	}
}
