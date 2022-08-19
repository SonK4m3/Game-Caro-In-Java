package Screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

import Button.PlayingButton;
import Control.*;

/*
 * 	Class Screen extends JPanel
 * 	
 *@desc Display screen
 *@Contructer 
 *@func	
 *	{void} setUp()
 *	{void} setXYPos(x, y)
 *	{void} activ()
 *	{int} pressedButton()
 *	{void} paint(g)
 * 
 */

public class Screen extends JPanel{
	
	protected GameControl gameControl;
	
	protected int Width = 500;
	protected int Height = 500;
	
	protected int xPos = -1;
	protected int yPos = -1;
	
	public Screen(GameControl gameControl) {
		this.gameControl = gameControl;
		// 1. set up class properties 
		setUp();
	}
	
	// setting properties
	protected void setUp() {
		//1. setting size of sreen
		setPreferredSize(new Dimension(Width, Height));

	}
	
	/*
	 * get position pressed mouse on this screen
	 * x = xPos
	 * y = yPos
	 */
	public void setPos(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	// event action in screen
	public void activ() {
		
	}
	
	/*
	 * TODO: create new interface
	 */
	// state pressed component on this screen
	protected int pressedButton() {
		return 0;
	}
	
	
	public void paint(Graphics g) {
		//1. draw background
		g.setColor(Color.white);
		g.fillRect(0, 0, Width, Height);
	}
}