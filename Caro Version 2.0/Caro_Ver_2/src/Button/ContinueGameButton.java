package Button;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ContinueGameButton extends Button{
	public ContinueGameButton(int xPos, int yPos, JPanel panel) {
		super(xPos, yPos, panel);
		// TODO Auto-generated constructor stub
	}

	@Override
	void setUp() {
		// TODO Auto-generated method stub
		super.setUp();
		try {
			buttonImage = ImageIO.read(new File("res//continue_button.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.Width = 300;
		this.Height = 100;
		this.text = "Continue Game Button";
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(buttonImage, xPos, yPos, null);
	}
}
