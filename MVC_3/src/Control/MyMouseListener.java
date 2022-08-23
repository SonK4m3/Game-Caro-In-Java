package Control;
import View.*;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import View.*;
public class MyMouseListener implements MouseListener{
	
	private PlayerBoard playerBoard;
	private GameLoop gameLoop;
	
	int xPos = -1;
	int yPos = -1; 
	
	public MyMouseListener(GameLoop gameLoop, PlayerBoard playerBoard) {
		this.gameLoop = gameLoop;
		this.playerBoard = playerBoard;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//1. get mouse pressed position
		int mouse_x=MouseInfo.getPointerInfo().getLocation().x- playerBoard.getLocationOnScreen().x;
		int mouse_y=MouseInfo.getPointerInfo().getLocation().y- playerBoard.getLocationOnScreen().y;
		
		//2. get mouse pressed position of cell
		xPos = mouse_y / 60 + 1;
		yPos = mouse_x / 60 + 1;
		
		// debug
//		System.out.println("Pressed mouse position: " + xPos + " " + yPos);
		if(e.getButton() == MouseEvent.BUTTON1)
			gameLoop.setPressedButton1(true);
		else if(e.getButton() == MouseEvent.BUTTON3)
			gameLoop.setPressedButton3(true);
		gameLoop.setXYPos(xPos, yPos);
		gameLoop.setIsPressed(true);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		xPos = -1;
		yPos = -1;
	
		gameLoop.setIsPressed(false);
		gameLoop.setPressedButton1(false);
		gameLoop.setPressedButton3(false);
		gameLoop.setXYPos(xPos, yPos);
		// debug
//		gameLoop.getEnemy1().print();
//		gameLoop.getEnemy2().print();
//		gameLoop.getBoard().print();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	

}
