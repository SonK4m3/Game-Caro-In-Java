package Display;

public class Player {
	String symbol;
	boolean inTurn;
	
	Player(){
		symbol = "";
		inTurn = false;
	}
	
	public void setInfor(String symbol, boolean inTurn) {
		this.symbol = symbol;
		this.inTurn = inTurn;
	}
	
	public void printInfor() {
		System.out.println(symbol +" " + inTurn);
	}
}
