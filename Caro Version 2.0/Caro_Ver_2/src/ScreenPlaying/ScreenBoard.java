package ScreenPlaying;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import Button.*;
import Control.GameControl;
import Control.LogicControl;
import Screen.Screen;
/*
 * 	class ScreenBoard extends class Screen
 * 
 * 	Screen displays: 
 * 		{Button} reset game button reset current state game to new game
 * 		{Button} back button backs to the Playing Screen
 * 		{Board} board 
 * 
 */
public class ScreenBoard extends Screen{

	private LogicControl logicControl;
	
	Button backButton;
	Button resetGameButton;
	
	BufferedImage imageBoard = null;
	BufferedImage imageX = null;
	BufferedImage imageO = null;
	
	public ScreenBoard(GameControl gameControl, LogicControl logicControl){
		super(gameControl);
		this.logicControl = logicControl;
		
		//1. get board X O image
		try {
			imageBoard = ImageIO.read(new File("res/board.png"));			
			imageX = ImageIO.read(new File("res/X.png"));
			imageO = ImageIO.read(new File("res/O.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void setUp() {
		super.setUp();

		//1. initialization back button
		backButton = new BackButton(100, 425, this);
		this.add(backButton);
		
		//2. initialization reset game button
		resetGameButton = new ResetGameButton(200, 20, this);
		this.add(resetGameButton);
	}
	
	@Override
	public void activ() {
		if(pressedButton() == 1) {
			//debug 
			System.out.println("Reset Game");
			
			gameControl.setNewGame(true);
		}
		
		if(pressedButton() == 2) {
			//debug
			System.out.println("Back to Playing Screen");
			
			gameControl.setScreenBoardIsActiv(false);
		}
		
		if(pressedButton() == -1) {
			gameControl.setCanMove(true);
		}
		
		repaint();
	}
	
	@Override
	protected int pressedButton() {
		if(resetGameButton.isPressed(xPos, yPos))
			return 1;
		
		if(backButton.isPressed(xPos, yPos))
			return 2;
		
		//pressed on Board
		if(xPos >= 100 && xPos <= 400 && yPos >= 100 && yPos <= 400)
			return -1;
		return super.pressedButton();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		// draw board
		g2d.drawImage(imageBoard, null, gameControl);
		
		// draw symbol
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 3; j++) {
				if(logicControl.getBoard().getPosBoard(j, i) == 'X')
					g2d.drawImage(imageX, (i - 1) * 100 + 100, (j - 1) * 100 + 100, null);
				else if(logicControl.getBoard().getPosBoard(j, i) == 'O') {
					g2d.drawImage(imageO, (i - 1) * 100 + 100, (j - 1) * 100 + 100, null);
				}	
			}
		}
		
		//draw back button 
		backButton.paint(g2d);
		
		// reset button
		resetGameButton.paint(g2d);
	}
	
}
