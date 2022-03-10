package Test;

public class Board{
	int[][] mat = new int[3][3];
	int last;	// var to check palyer's turn 

	Board() {
		last = 1;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				mat[i][j] = 0;
		}
	}
	
	public void display() {
		
	}
	
	public void print() {
		System.out.println("Board: ");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				System.out.print(mat[i][j] +" ");
		System.out.println();
		}
	}
}
