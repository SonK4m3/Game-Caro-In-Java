package Button;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackButton extends Button{

	public BackButton(int xPos, int yPos, JPanel panel) {
		super(xPos, yPos, panel);
	}
	
	@Override
	void setUp() {
		super.setUp();
		try {
			this.buttonImage = ImageIO.read(new File("res//back_button.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.Width = 300;
		this.Height = 50;
		this.text = "Back Button";
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(buttonImage, xPos, yPos, null);
	}
}
