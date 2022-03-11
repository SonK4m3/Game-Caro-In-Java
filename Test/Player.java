package Test;

import java.util.Scanner;

public class Player {
	String symbol;
	boolean inturn;
	
	Player(){
		inturn = false;
	}
	
	public void setInput(String symbol, boolean inturn) {
		this.inturn = inturn;
		this.symbol = symbol;
	}
}
