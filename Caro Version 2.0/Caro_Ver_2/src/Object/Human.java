package Object;

public class Human extends Player{
	
	public Human(Board board) {
		super(board);
		symbol = 'O';
		inTurn = true;
	}
}
