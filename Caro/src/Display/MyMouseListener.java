package Display;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter{
	Cell cell;
	int i;
	int j;
	Board board;
	
	
	MyMouseListener(Cell cell, int i, int j, Board board){
		this.cell = cell;
		this.i = i;
		this.j = j;
		this.board = board;
	}
	
    public void mousePressed(MouseEvent pressed) {
    	System.out.println(i + " " + j);
    }
}
