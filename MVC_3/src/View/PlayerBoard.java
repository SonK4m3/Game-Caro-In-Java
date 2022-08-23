package View;
import Control.*;
import Model.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class PlayerBoard extends JPanel{
	
	final int Width = 600;
	final int Height = 600;
	
	private Board board;
	private Enemy enemy1;
	private Enemy enemy2;

	public PlayerBoard(Board board, Enemy enemy1, Enemy enemy2) {
		this.board = board;
		this.enemy1 = enemy1;
		this.enemy2 = enemy2;
		initPlayerBoard();
	}
	
	public void initPlayerBoard() {
		this.setPreferredSize(new Dimension(Width, Height));
	}
	
	public void loop() {
		repaint();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		board.paint(g2d);
		enemy1.paint(g2d);	
		enemy2.paint(g2d);
	}
}
