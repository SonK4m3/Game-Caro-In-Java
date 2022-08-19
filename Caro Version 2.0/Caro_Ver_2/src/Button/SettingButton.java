package Button;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SettingButton extends Button{

	public SettingButton(int xPos, int yPos, JPanel panel) {
		super(xPos, yPos, panel);
	}
	
	@Override
	void setUp() {
		super.setUp();
		try {
			buttonImage = ImageIO.read(new File("res//setting_button.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.Width = 300;
		this.Height = 100;
		text = "Setting Button";
		color = Color.green;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(buttonImage, xPos, yPos, null);
	}
}
