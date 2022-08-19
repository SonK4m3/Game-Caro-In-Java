package Button;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ResetGameButton extends Button{

	public ResetGameButton(int xPos, int yPos, JPanel panel) {
		super(xPos, yPos, panel);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void setUp() {
		// TODO Auto-generated method stub
		super.setUp();
		this.Width = 100;
		this.Height = 50;
		
		try {
			buttonImage = ImageIO.read(new File("res//reset_game_button.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		g.drawImage(buttonImage, xPos, yPos, null);
	}
}
