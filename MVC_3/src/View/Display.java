package View;

import Control.*;
import Model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Display extends JPanel{

	int Width = 720;
	int Height = 720;
	
	int row = 12;
	int col = 12;
	
	int rowPos = 60;
	int colPos = 60;
	
	
	Board board = new Board();
	Enemy enemy1 = new Enemy(board, 5, 6);
	Enemy enemy2 = new Enemy(board, 3, 2);

	Display(){
		JFrame frame = new JFrame();
		
		this.setPreferredSize(new Dimension(Width + 20, Height + 20));
		
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		enemy1.setEnemyHeadLeft();
		enemy2.setEnemyHeadRight();
	}
	
	public void loop() {
		while(true) {
			repaint();
			try {
				Thread.sleep(10);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Display display = new Display();
		display.loop();
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
				
		g2d.setColor(Color.black);
		
		for(int i = 0; i <= row; i++)
			g2d.drawLine(0, rowPos * i, Width, rowPos * i);
		
		for(int i = 0; i <= col; i++)
			g2d.drawLine(colPos * i, 0, colPos * i, Height);
				
		enemy1.paint(g2d);
		enemy2.paint(g2d);
		}

}
