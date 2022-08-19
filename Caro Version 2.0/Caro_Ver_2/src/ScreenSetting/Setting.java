package ScreenSetting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;
import Button.*;
import Control.*;
import Screen.Screen;
/*
 * 	class ScreenSetting extends class Screen
 * 
 * 	Screen displays 1 button: 
 * 		{Button} back button backs to Menu Screen
 * 
 */
public class Setting extends Screen{
	
	Button backButton;
	
	public Setting(GameControl gameControl) {
		super(gameControl);	
	}
	
	@Override
	protected void setUp() {
		super.setUp();
		
		backButton = new BackButton(100, 400, this);
		
		this.add(backButton);
	}
	
	@Override
	public void activ() {
		if(pressedButton() == 1) {
			//debug
			System.out.println("------------");
			System.out.println("Back to Menu");
			
			gameControl.setMenuIsActiv(true);
			gameControl.setSettingIsActiv(false);
		}
		
		repaint();
	}
	
	@Override
	protected int pressedButton() {
		if(backButton.isPressed(xPos, yPos)) {
			return 1;
		}
		return super.pressedButton();
	}
		
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		//1. draw button
		backButton.paint(g2d);
	}
}
