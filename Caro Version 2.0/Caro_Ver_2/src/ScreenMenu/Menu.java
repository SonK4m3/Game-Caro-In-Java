package ScreenMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.*;

import Button.*;
import Control.*;
import Screen.*;
/*
 * 	class Menu extends class Screen
 * 
 * 	Menu Screen displays 3 button: 
 * 		{Button} playing button jumps to Playing Screen
 * 		{Button} setting button jumps to Setting Screen
 * 		{Button} exit button exits out of the game
 * 
 */

public class Menu extends Screen{
		
	Button exitButton;
	Button settingButton;
	Button playingButton;
	
	public Menu(GameControl gameControl) {
		super(gameControl);
	}
	
	@Override
	protected void setUp() {
		super.setUp();
		
		playingButton = new PlayingButton(100, 50, this);
		settingButton = new SettingButton(100, 200, this);
		exitButton = new ExitButton(100, 350, this);
		
		this.add(playingButton);
		this.add(exitButton);
		this.add(settingButton);	
	}
	
	/*
	 * @desc change the active state of the screens when button is pressed
	 * 
	 */
	@Override
	public void activ() {
		if(pressedButton() == 1) {
			//debug
			System.out.println("-------");
			System.out.println("Playing");
			
			gameControl.setPlayingIsActiv(true);
			gameControl.setMenuIsActiv(false);
		}
		
		if(pressedButton() == 2) {
			//debug
			System.out.println("-------");
			System.out.println("Setting");
			
			gameControl.setSettingIsActiv(true);
			gameControl.setMenuIsActiv(false);
		}
		
		if(pressedButton() == 3) {
			//debug
			System.out.println("---------");
			System.out.println("Exit Game");
			
			gameControl.exitGame();
		}
		repaint();
	}
	
	@Override
	protected int pressedButton() {
		if(playingButton.isPressed(xPos, yPos)) {
			return 1;
		}
		if(settingButton.isPressed(xPos, yPos)) {
			return 2;
		}
		if(exitButton.isPressed(xPos, yPos)) {
			return 3;
		}
		return super.pressedButton();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		//1. draw button
		playingButton.paint(g2d);
		settingButton.paint(g2d);
		exitButton.paint(g2d);
	}
}
