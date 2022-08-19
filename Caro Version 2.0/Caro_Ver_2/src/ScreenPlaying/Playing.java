package ScreenPlaying;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

import Button.*;
import Control.*;
import Screen.*;
/*
 * 	class Menu extends class Screen
 * 
 * 	Screen displays 3 button: 
 * 		{Button} new game button jumps to Screen Board and create a new game
 * 		{Button} continue game button jumps to Screen Board and continue game or create new game
 * 		{Button} backs button backs to Menu Screen
 * 
 */
public class Playing extends Screen{
	
	Button backButton;
	Button newGameButton;
	Button continueGameButton;
	
	public Playing(GameControl gameControl) {
		super(gameControl);	
	}
	
	@Override
	protected void setUp() {
		super.setUp();
		
		newGameButton = new NewGameButton(100, 100, this);
		continueGameButton = new ContinueGameButton(100, 250, this);
		backButton = new BackButton(100, 400, this);
		
		this.add(newGameButton);
		this.add(continueGameButton);
		this.add(backButton);
	}
	
	@Override
	public void activ() {
		if(pressedButton() == 1) {
			//debug
			System.out.println("----------");
			System.out.println("New Game");

			gameControl.setScreenBoardIsActiv(true);
			gameControl.setNewGame(true);
		}
		
		if(pressedButton() == 2) {
			//debug
			System.out.println("----------");
			System.out.println("Continue Game");

			gameControl.setScreenBoardIsActiv(true);
			gameControl.setContinueGame(true);
		}
		
		if(pressedButton() == 3) {
			//debug
			System.out.println("------------");
			System.out.println("Back to Menu");
			
			gameControl.setMenuIsActiv(true);
			gameControl.setPlayingIsActiv(false);
			gameControl.setScreenBoardIsActiv(false);
		}
		
		repaint();
	}
	
	@Override
	protected int pressedButton() {
		if(newGameButton.isPressed(xPos, yPos)) {
			return 1;
		}
		
		if(continueGameButton.isPressed(xPos, yPos)) {
			return 2;
		}
		
		if(backButton.isPressed(xPos, yPos)) {
			return 3;
		}
		return super.pressedButton();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		//1. draw button
		// new Game button
		newGameButton.paint(g2d);
		// continue button
		continueGameButton.paint(g2d);
		// back button
		backButton.paint(g2d);
	}
	
}
