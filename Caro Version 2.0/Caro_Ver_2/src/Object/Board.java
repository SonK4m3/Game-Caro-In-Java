package Object;

public class Board {
	
	private final int SIZE = 3;
	
	private char[][] matBoard = new char[SIZE + 1][SIZE + 1];
	
	public Board() {

	}
	
	public void initBoard() {
		for(int i = 1;i <= SIZE; i++) {
			for(int j = 1; j <= SIZE; j++) {
				matBoard[i][j] = '_';
			}
		}
	}
	
	
	public void setPosBoard(int x, int y, char val) {
		if(x >= 1 && x <= SIZE && y >= 1 && y <= SIZE)
			this.matBoard[x][y] = val;
	}

	public char getPosBoard(int x, int y) {
		if(x >= 1 && x <= SIZE && y >= 1 && y <= SIZE)
			return matBoard[x][y];
		else
			return '@';
	}
	
	public void printBoard() {
		for(int i = 1; i <= SIZE; i++) {
			for(int j = 1; j <= SIZE; j++) {
				System.out.print(matBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
}
