package Button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Control.*;

public class Button extends JLabel{
	
	int Width = 100;
	int Height = 100;
	
	int xPos = -1;
	int yPos = -1;
	
	String text = "Button";
	
	BufferedImage buttonImage;
	
	Color color = Color.DARK_GRAY;
	
	protected JPanel currentScreen;
	
	protected MyMouseListener mouseListener;
	
	public Button(int xPos, int yPos, JPanel panel){
		setUp();
		this.currentScreen = panel;
		this.xPos = xPos;
		this.yPos = yPos;
		this.setBounds(xPos, yPos, Width, Height);
		this.setBackground(color);
		this.setOpaque(true);
	}
	
	public void print(Graphics g) {	
	}
	
	void setUp() {
		try {
			buttonImage = ImageIO.read(new File("res//button.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// debug
//		System.out.println("create a " + text);
	}
	
	// check event press on the button
	public boolean isPressed(int x, int y) {
		if(x >= xPos && x <= xPos + Width && y >= yPos && y <= yPos + Height)
			return true;
		return false;
	}
	
	public void pressedMouseAction() {
//		debug
		System.out.println(text);
	}
	
	public void releasedMouseAction() {
		
	}

}
