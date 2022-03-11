package Test;

public class Board{
	int[][] mat;
	int n = 3;
	int condition;
	int remains;
	int[][] xMain;
	int[][] xSide;
	int[][] xRow;
	int[][] xCol;
	
	int[][] oMain;
	int[][] oSide;
	int[][] oRow;
	int[][] oCol;
	
	int maxX;
	int maxO;
	int last;	// var to check palyer's turn 

	Board() {
		initBoard();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				mat[i][j] = -1;
		}
	}
	
	public void initBoard() {
		this.mat = new int[3][3];
		this.xMain = new int[3][3];
		this.xSide = new int[3][3];
		this.xRow = new int[3][3];
		this.xCol = new int[3][3];
		this.oMain = new int[3][3];
		this.oSide = new int[3][3];
		this.oRow = new int[3][3];
		this.oCol = new int[3][3];
		this.maxX = 0;
		this.maxO = 0;
		this.last = 1;
		this.condition = n;
		this.remains = n * n;
	}
	
	public boolean isFull() {
		return (this.remains == 0);
	}
	
	public void setMain(){
		// set X main
		for(int i = n - 1; i >= 0 ; i--){
			int cnt = 0;
			int k = i;
			for(int j = 0; j < n - i; j ++){
				if(mat[k][j] == 1)
					cnt++;
				else 
					cnt = 0;
				xMain[k][j] = cnt;
				maxX = Math.max(maxX, cnt);
				k++;
			}
		}
		
		for(int j = 0; j < n; j++){
			int cnt = 0;
			int k = j;
			for(int i = 0; i < n - j; i++){
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
		for(int i = n - 1; i >= 0 ; i--){
			int cnt = 0;
			int k = i;
			for(int j = 0; j < n - i; j ++){
				if(mat[k][j] == 0)
					cnt++;
				else 
					cnt = 0;
				oMain[k][j] = cnt;
				maxO = Math.max(maxO, cnt);
				k++;
			}
		}
		
		for(int j = 0; j < n; j++){
			int cnt = 0;
			int k = j;
			for(int i = 0; i < n - j; i++){
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
		for(int i = n - 1; i >= 0 ; i--){
			int cnt = 0;
			int k = i;
			for(int j = n - 1; j >= i; j--){
				if(mat[k][j] == 1)
					cnt++;
				else 
					cnt = 0;
				xSide[k][j] = cnt;
				maxX = Math.max(maxX, cnt);
				k++;
			}
		}
		
		for(int j = 0; j < n; j++){
			int cnt = 0;
			int k = j;
			for(int i = 0; i <= n - j; i++){
				if(i < 0 || i > n - 1 || k < 0 || k > n - 1)
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
		for(int i = n - 1; i >= 0 ; i--){
			int cnt = 0;
			int k = i;
			for(int j = n - 1; j >= i; j --){
				if(mat[k][j] == 0)
					cnt++;
				else 
					cnt = 0;
				oSide[k][j] = cnt;
				maxO = Math.max(maxO, cnt);
				k++;
			}
		}
		
		for(int j = 0; j < n; j++){
			int cnt = 0;
			int k = j;
			for(int i = 0; i <= n - j; i++){
				if(i < 0 || i > n - 1 || k < 0 || k > n - 1)
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
		for(int i = 0; i < n; i ++){
			int cnt = 0;
			for(int j = 0; j < n; j ++){
				if(mat[i][j] == 1)
					cnt++;
				else 
					cnt = 0;
				xRow[i][j] = cnt;
				maxX = Math.max(maxX, cnt);
			}
		} 
		
		// set O row
		for(int i = 0; i < n; i ++){
			int cnt = 0;
			for(int j = 0; j < n; j ++){
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
		for(int j = 0; j < n; j ++){
			int cnt = 0;
			for(int i = 0; i < n; i ++){
				if(mat[i][j] == 1)
					cnt++;
				else 
					cnt = 0;
				xCol[i][j] = cnt;
				maxX = Math.max(maxX, cnt);
			}
		}	
		
		// set O col 
		for(int j = 0; j < n; j ++){
			int cnt = 0;
			for(int i = 0; i < n; i ++){
				if(mat[i][j] == 0)
					cnt++;
				else 
					cnt = 0;
				oCol[i][j] = cnt;
				maxO = Math.max(maxO, cnt);
			}
		}
	}
	
	public void setMaxXO() {
		setMain();
		setSide();
		setRow();
		setCol();
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
