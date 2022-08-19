package Button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ExitButton extends Button{

	
	public ExitButton(int xPos, int yPos, JPanel panel) {
		super(xPos, yPos, panel);
	}
	
	@Override
	void setUp() {
		super.setUp();
		try {
			buttonImage = ImageIO.read(new File("res//exit_button.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.Width = 300;
		this.Height = 100;
		text = "EXIT";
		color = Color.green;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		Graphics2D g2d = (Graphics2D) g;
		
		g.drawImage(buttonImage, xPos, yPos, null);
		
	}

}
