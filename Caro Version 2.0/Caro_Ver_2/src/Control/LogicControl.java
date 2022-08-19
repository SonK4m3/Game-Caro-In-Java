package Control;

import java.util.Map;
import java.util.WeakHashMap;

import Object.AI;
import Object.Board;
import Object.Human;
/*
 * We using Minimax Algorithm to make an AI
 * 
 */

public class LogicControl {
	
	private Board board = new Board();
	private Human human = new Human(board);
	private AI ai = new AI(board);
	
	Map<Character, Integer> scores;
	
	boolean isCreateBoard = false;
		
	int xPos = -1;
	int yPos = -1;
	
	public LogicControl() {		
		scores = new WeakHashMap<Character, Integer>();
		scores.put('X', 10);
		scores.put('O', -10);
		scores.put('t', 0);
		
		bestMove();
	}
	
	// create a new game
	public void newGame() {
		// debug
		System.out.println("--------\nNew Game");
		board.initBoard();
	}
	
	// change mouse position to position on board
	private void changePosMouseToBoard() {
		xPos = (xPos - 100) / 100 + 1;
		yPos = (yPos - 100) / 100 + 1;
	}
	
	public void setPos(int x, int y) {
		xPos = y;
		yPos = x;
		
		changePosMouseToBoard();
	}
	
	//
	public int getPosX() {
		return xPos;
	}
	
	public int getPosY() {
		return yPos;
	}
	
	public void setIsCreateBoard(boolean isCreate) {
		isCreateBoard = isCreate;
	}
	
	public boolean getIsCreateBoard() {
		return isCreateBoard;
	}
	
	// check cell board is empty or not
	public boolean isCanMove() {
		if(board.getPosBoard(xPos, yPos) == '_') {
			return true;
		}
		return false;
	}
	
	public boolean equals3(char a, char b, char c) {
		return a == b && b == c && a != '_';
	}
	
	/*
	 * win conditions is the same symbol in horizontal or vertical or diagonal  
	 * 
	 */
	public char checkWinner() {
		char winner = 'n';
		
		// horizontal
		for(int i = 1; i <= 3; i++) {
			if(equals3(board.getPosBoard(i, 1), board.getPosBoard(i, 2), board.getPosBoard(i, 3))) {
				winner = board.getPosBoard(i, 1);
			}
		}
		
		//vertical
		for(int i = 1; i <= 3; i++) {
			if(equals3(board.getPosBoard(1, i), board.getPosBoard(2, i), board.getPosBoard(3, i))) {
				winner = board.getPosBoard(1, i);
			}
		}
		
		//diagonal
		if(equals3(board.getPosBoard(1, 1), board.getPosBoard(2, 2), board.getPosBoard(3, 3))) {
			winner = board.getPosBoard(1, 1);
		}
		if(equals3(board.getPosBoard(3, 1), board.getPosBoard(2, 2), board.getPosBoard(1, 3))) {
			winner = board.getPosBoard(3, 1);
		}	
		
		int openSpots = 0;
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j<= 3; j++) {
				openSpots ++;
			}
		}
		
		if(winner == 'n' && openSpots == 0) {
			return 't';
		}
		else 
			return winner;
	}
	
	/*
	 * function get best move for AI
	 */
	public void bestMove() {
		// AI to make its turn
		int bestScore = Integer.MIN_VALUE;
		int[] move = {0,0};
		
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 3; j++) {
				// Is the spot available?
				if(board.getPosBoard(i, j) == '_') {
					board.setPosBoard(i, j, ai.getSymbol());
					int score = minimax(0, false);
					board.setPosBoard(i, j, '_');
					if(score > bestScore) {
						bestScore = score;
						move[0] = i;
						move[1] = j;
					}
				}
			}
		}
		board.setPosBoard(move[0], move[1], ai.getSymbol());
		human.setInTurn(true);
	}
	
	public int minimax(int depth, boolean isMaximizing) {
		char result = checkWinner();
		if(result != 'n') {
			return scores.get(result);
		}
		
		if(isMaximizing) {
			int bestScore = Integer.MIN_VALUE;
			for(int i = 1; i <= 3; i++) {
				for(int j = 1; j <= 3; j++) {
					if(board.getPosBoard(i, j) == '_') {
						board.setPosBoard(i, j, ai.getSymbol());
						int score = minimax(depth + 1, false);
						board.setPosBoard(i, j, '_');
						bestScore = Math.max(score, bestScore);
					}
				}
			}
			return bestScore;
		}else {
			int bestScore = Integer.MAX_VALUE;
			for(int i = 1; i <= 3; i++) {
				for(int j = 1; j <= 3; j++) {
					if(board.getPosBoard(i, j) == '_') {
						board.setPosBoard(i, j, human.getSymbol());
						int score = minimax(depth + 1, true);
						board.setPosBoard(i, j, '_');
						bestScore = Math.min(score, bestScore);
					}
				}
			}
			return bestScore;
		}
	}

	/*
	 * player phase to play
	 * and phase of AI
	 */
	public void move() {
		if(human.getInTurn()) {
			// player move
			board.setPosBoard(xPos, yPos, human.getSymbol());
			human.setInTurn(false);
			// AI move
			bestMove();
		}
		
	}
	
	public void printStateComponents() {
		System.out.println("position pressed board: " + xPos + " " + yPos);
		board.printBoard();
	}
	
	// get Components
	public Board getBoard() {
		return board;
	}
}
