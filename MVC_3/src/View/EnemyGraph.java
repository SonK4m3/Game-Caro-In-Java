package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Model.*;

public class EnemyGraph{
	
	BufferedImage imageLeft; 
	
	int xPos;
	int yPos;
	
	protected Board board;
	
	public EnemyGraph(Board board, int xPos, int yPos) {
		this.board = board;
		try {
			imageLeft = ImageIO.read(new File("pixil-frame-0.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(imageLeft, xPos, yPos, null);
	}
	
}
