package Display;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyMouseListener extends MouseAdapter{
	
	JFrame frame;
	Cell cell;
	int i;
	int j;
	Board board;
	Player player1, player2;
	
	boolean gameStop = false;
	
	MyMouseListener(JFrame frame, Cell cell, int i, int j, Board board, Player player1, Player player2){
		this.frame = frame;
		this.cell = cell;
		this.i = i;
		this.j = j;
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
	}
	
	void process() {
		board.setMaxXO();
				
		if(board.maxO == board.condition) {
    		if(player1.symbol.equals("O")){
    			JOptionPane.showMessageDialog(null,"player1 win", "title", JOptionPane.INFORMATION_MESSAGE);
    		}
    		else {
    			JOptionPane.showMessageDialog(null,"player2 win", "title", JOptionPane.INFORMATION_MESSAGE);
    		}
    		gameStop = true;
    		return;
    	}
    	
    	if(board.maxX == board.condition) {
    		if(player1.symbol.equals("X")){
    			JOptionPane.showMessageDialog(null,"player1 win", "title", JOptionPane.INFORMATION_MESSAGE);
    		}
    		else {
    			
    			JOptionPane.showMessageDialog(null,"player2 win", "title", JOptionPane.INFORMATION_MESSAGE);
    		}
    		gameStop = true;
    		return;
    	}
    	
    	if(board.isFull()) {
			JOptionPane.showMessageDialog(null,"draw", "title", JOptionPane.INFORMATION_MESSAGE);
    		gameStop = true;
    		return;
    	}
	}
	
    public void mousePressed(MouseEvent e) {
    	
    	if(e.getSource() == cell) {
    		if(board.mat[i][j] == -1 && player1.inTurn == true) {
    			cell.setForeground(Color.blue);
        		cell.setText(player1.symbol);
        		player1.inTurn = false;
        		player2.inTurn = true;
        		
        		board.mat[i][j] = (player1.symbol == "X") ? 1 : 0;
        		board.remains -= 1;

    		}
    		else if(board.mat[i][j] == -1 && player2.inTurn == true) {
    			cell.setForeground(Color.red);
        		cell.setText(player2.symbol);
        		player2.inTurn = false;
        		player1.inTurn = true;
        		
        		board.mat[i][j] = (player2.symbol == "X") ? 1 : 0;
        		board.remains -= 1;
    		}
    	}
    	
    	process();
    	
    	if(gameStop == true) {
    		int answer = JOptionPane.showConfirmDialog(null, "Exit?", "Caro", JOptionPane.YES_NO_OPTION);
    		if(answer == 0) {
    			System.exit(0);
    		}
    		else {
    			frame.dispose();
    			new PlayerDisplay();
    		}
    	}
    	
    }
}
