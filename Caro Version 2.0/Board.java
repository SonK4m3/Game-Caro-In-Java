package Caro;

public class Board {
	
	final int MAX = 15;
	int[][] mat = new int[MAX][MAX];
	int row;
	int col;
	int condition = 5;
	int remains;
	int[][] xMain;
	int[][] xSide;
	int[][] xRow;
	int[][] xCol;
	
	int[][] oMain;
	int[][] oSide;
	int[][] oRow;
	int[][] oCol;
	
	int maxX = 0;
	int maxO = 0;
	boolean lastX = false;
	
	Board(){
		initBoard();
		for(int i = 0; i < MAX; i ++) {
			for(int j = 0; j < MAX; j++)
				mat[i][j] = -1;
		}
	}
	
	private void initBoard() {
		this.mat = new int[MAX][MAX];
		this.xMain = new int[MAX][MAX];
		this.xSide = new int[MAX][MAX];
		this.xRow = new int[MAX][MAX];
		this.xCol = new int[MAX][MAX];
		this.oMain = new int[MAX][MAX];
		this.oSide = new int[MAX][MAX];
		this.oRow = new int[MAX][MAX];
		this.oCol = new int[MAX][MAX];
		this.remains = MAX * MAX;
	}
	
	public boolean isFull() {
		return (this.remains == 0);
	}
	
	public void setSize(int row, int col) {
		this.row = row;
		this.col = col;
		this.remains = row * col;
	}
	
	public void setBoard(int xPos, int yPos) {
		if(!lastX && mat[xPos][yPos] == -1) {
			mat[xPos][yPos] = 1;
			lastX = true;
			remains --;
		}
		else if(lastX && mat[xPos][yPos] == -1){
			mat[xPos][yPos] = 0;
			lastX = false;
			remains --;
		}
	}
	
	public void setMain(){
		// set X main
		for(int i = row - 1; i >= 0 ; i--){
			int cnt = 0;
			int k = i;
			for(int j = 0; j < col - i; j ++){
				if(k < 0 || k > row - 1|| j < 0 || j > col - 1)
					continue;
				
				if(mat[k][j] == 1)
					cnt++;
				else 
					cnt = 0;
				xMain[k][j] = cnt;
				maxX = Math.max(maxX, cnt);
				k++;
			}
		}
		
		for(int j = 0; j < col; j++){
			int cnt = 0;
			int k = j;
			for(int i = 0; i < col - j; i++){
				if(i < 0 || i > row - 1|| k < 0 || k > col - 1)
					continue;
				
				if(mat[i][k] == 1)
					cnt++;
				else 
					cnt = 0;
				xMain[i][k] = cnt;
				maxX = Math.max(maxX, cnt);
				k++;
			}
		}
		
		// set O main
		for(int i = row - 1; i >= 0 ; i--){
			int cnt = 0;
			int k = i;
			for(int j = 0; j < col - i; j ++){
				if(k < 0 || k > row - 1|| j < 0 || j > col - 1)
					continue;
				
				if(mat[k][j] == 0)
					cnt++;
				else 
					cnt = 0;
				oMain[k][j] = cnt;
				maxO = Math.max(maxO, cnt);
				k++;
			}
		}
		
		for(int j = 0; j < col; j++){
			int cnt = 0;
			int k = j;
			for(int i = 0; i < col - j; i++){
				if(i < 0 || i > row - 1|| k < 0 || k > col - 1)
					continue;
				
				if(mat[i][k] == 0)
					cnt++;
				else 
					cnt = 0;
				oMain[i][k] = cnt;
				maxO = Math.max(maxO, cnt);
				k++;
			}
		}	
	}
	
	public void setSide(){
		// set X side
		for(int i = row - 1; i >= 0 ; i--){
			int cnt = 0;
			int k = i;
			for(int j = col - 1; j >= i; j--){
				if(k < 0 || k > row || j < 0 || j > col)
					continue;
				
				if(mat[k][j] == 1)
					cnt++;
				else 
					cnt = 0;
				xSide[k][j] = cnt;
				maxX = Math.max(maxX, cnt);
				k++;
			}
		}
		
		for(int j = 0; j < col; j++){
			int cnt = 0;
			int k = j;
			for(int i = 0; i < row; i++){
				if(i < 0 || i > row || k < 0 || k > col)
					continue;
			
				if(mat[i][k] == 1)
					cnt ++;
				else
					cnt = 0;
				xSide[i][k] = cnt;
				maxX = Math.max(maxX, cnt);
				k--;
			}
		}
		
		// set O side
		for(int i = row - 1; i >= 0 ; i--){
			int cnt = 0;
			int k = i;
			for(int j = col - 1; j >= i; j --){
				if(k < 0 || k > row|| j < 0 || j > col)
					continue;
				
				if(mat[k][j] == 0)
					cnt++;
				else 
					cnt = 0;
				oSide[k][j] = cnt;
				maxO = Math.max(maxO, cnt);
				k++;
			}
		}
		
		for(int j = 0; j < col; j++){
			int cnt = 0;
			int k = j;
			for(int i = 0; i < row; i++){
				if(i < 0 || i > row|| k < 0 || k > col)
					continue;
				
				if(mat[i][k] == 0)
					cnt ++;
				else
					cnt = 0;
				oSide[i][k] = cnt;
				maxO = Math.max(maxO, cnt);
				k--;
			}
		}
	}
	
	public void setRow(){		
		// set X row 
		for(int i = 0; i < row; i ++){
			int cnt = 0;
			for(int j = 0; j < col; j ++){
				if(i < 0 || i > row - 1|| j < 0 || j > col - 1)
					continue;
				if(mat[i][j] == 1)
					cnt++;
				else 
					cnt = 0;
				xRow[i][j] = cnt;
				maxX = Math.max(maxX, cnt);
			}
		} 
		
		// set O row
		for(int i = 0; i < row; i ++){
			int cnt = 0;
			for(int j = 0; j < col; j ++){
				if(i < 0 || i > row - 1|| j < 0 || j > col - 1)
					continue;
				if(mat[i][j] == 0)
					cnt++;
				else 
					cnt = 0;
				oRow[i][j] = cnt;
				maxO = Math.max(maxO, cnt);
			}
		} 		
	}

	public void setCol(){
		// set X col 
		for(int j = 0; j < col; j ++){
			int cnt = 0;
			for(int i = 0; i < row; i ++){
				if(i < 0 || i > row - 1|| j < 0 || j > col - 1)
					continue;
				
				if(mat[i][j] == 1)
					cnt++;
				else 
					cnt = 0;
				xCol[i][j] = cnt;
				maxX = Math.max(maxX, cnt);
			}
		}	
		
		// set O col 
		for(int j = 0; j < col; j ++){
			int cnt = 0;
			for(int i = 0; i < row; i ++){
				if(i < 0 || i > row - 1|| j < 0 || j > col - 1)
					continue;
				
				if(mat[i][j] == 0)
					cnt++;
				else 
					cnt = 0;
				oCol[i][j] = cnt;
				maxO = Math.max(maxO, cnt);
			}
		}
	}
	
	public void printMax() {
		System.out.println(maxX + " " + maxO);
	}
	
	public void setMaxXO() {
		setMain();
		setSide();
		setRow();
		setCol();
	}
	
	public void print() {
		System.out.println("Board:");
		if(row != 0 && col != 0) {
			for(int i = 0; i < row; i ++) {
				for(int j = 0; j < col; j++)
					System.out.print(mat[i][j] + " ");
				System.out.println();
			}	
		}
		else {
			for(int i = 0; i < MAX; i ++) {
				for(int j = 0; j < MAX; j++)
					System.out.print(mat[i][j] + " ");
				System.out.println();
			}	
		}
	}
	
}
