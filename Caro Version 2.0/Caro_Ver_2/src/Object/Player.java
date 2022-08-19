package Object;

public class Player {
	
	private Board board;
	
	char symbol = ' ';
	boolean inTurn = false;
	
	public Player(Board board) {
		this.board = board;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public void setInTurn(boolean isOn) {
		inTurn = isOn;
	}
	
	public boolean getInTurn() {
		return inTurn;
	}
}
