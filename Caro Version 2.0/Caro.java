package Caro;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.*;

public class Caro extends Canvas{
	
	static int SCREEN_WIDTH = 900; // = row * sizeCell
	static int SCREEN_HEIGHT = 900;
	
//	int sizeCel = 60;
	
	int row = 15;
	int col = 15;
	
	int leftEdge = 0;
	int topEdge = 0;
	
	int mousePressX = -1;
	int mousePressY = -1;
	
	int cellHCentre = 0;
	int cellVCentre = 0;
	
	boolean enterPressed = false;
	boolean gameIsWin = false;
	boolean gameIsRunning = true;
		
	BufferStrategy strategy;

	Board board = new Board();
	
	public Caro() throws InterruptedException{
		
		// create frame
		JFrame frame = new JFrame("Caro");
		
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		panel.setLayout(null);
		
		this.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);	
		panel.add(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	

		
		//set pos of first row and col
		leftEdge = SCREEN_WIDTH/col;
		topEdge = SCREEN_HEIGHT/row;
		
		// set middle of cell
		cellHCentre = leftEdge/2;
		cellVCentre = topEdge/2;
		
		// set size boad
		board.setSize(row, col);
		
		// add mouse listener
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				// get position of cell
				mousePressX = e.getX();
				mousePressY = e.getY();
				
				int yPos = mousePressX / leftEdge;
				int xPos = mousePressY / topEdge;
				
				if(!gameIsWin)
					board.setBoard(xPos, yPos);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				//set default position
				mousePressX = -1;
				mousePressY = -1;
			}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		
		// add key listener
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// exit game
				if(e.getKeyChar() == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// reset game
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
					enterPressed = true;
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
					enterPressed = false;
			}
			
		});
		
		this.requestFocus();
		this.createBufferStrategy(2);
		strategy = this.getBufferStrategy();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		// draw board
		g2d.setColor(new Color(245, 245, 245));
		g2d.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		// draw col
		g2d.setColor(new Color(199, 199, 199));
		for(int i = 1; i <= col; i++) {
			g2d.drawLine(0, topEdge * i, SCREEN_WIDTH, topEdge * i);			
		}
		
		// draw row
		for(int i = 1; i <= row; i++) {
			g2d.drawLine(leftEdge * i, 0, leftEdge * i, SCREEN_HEIGHT);
		}
		
		// draw O X 
		g.setFont(new Font("Verdana", 0, 60));
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(board.mat[i][j] != -1) {
					int xPos = j*leftEdge+cellHCentre;
					int yPos = i*topEdge+cellVCentre;
					
					if(board.mat[i][j] == 1) {
						// draw x
						int strWidthOffset = g.getFontMetrics().stringWidth("X")/2;
						g.setColor(new Color(198, 113, 113));
						g.drawString("X", xPos - strWidthOffset, yPos + 25);
					}else {
						// draw o
						int strWidthOffset = g.getFontMetrics().stringWidth("O")/2;
						g.setColor(new Color(113, 198, 113));
						g.drawString("O", xPos - strWidthOffset, yPos + 25);
					}
				}
			}
		}
		
		g.setFont(new Font("Verdana", 0, 24));
		
		String output;
		int fontWidth;
		// check condition and draw notice
		if(board.maxO == board.condition) {
			g.setColor(new Color(245, 245, 245));
			g.fillRect(0, SCREEN_HEIGHT - 44, SCREEN_WIDTH, 44);
			g.setColor(new Color(255, 153, 18));
			output = "Player O wins! (Press enter to play again)";
			fontWidth = g.getFontMetrics().stringWidth(output);
			g.drawString(output, SCREEN_WIDTH/2 - fontWidth/2, SCREEN_HEIGHT-10);
			gameIsWin = true;
			if(enterPressed)
				newGame();
		}
		else if(board.maxX == board.condition) {
			g.setColor(new Color(245, 245, 245));
			g.fillRect(0, SCREEN_HEIGHT - 44, SCREEN_WIDTH, 44);
			g.setColor(new Color(255, 153, 18));
			output = "Player X wins! (Press enter to play again)";
			fontWidth = g.getFontMetrics().stringWidth(output);
			g.drawString(output, SCREEN_WIDTH/2 - fontWidth/2, SCREEN_HEIGHT-10);
			gameIsWin = true;
			if(enterPressed)
				newGame();
		}	
		else if(board.isFull()) {
			g.setColor(new Color(245, 245, 245));
			g.fillRect(0, SCREEN_HEIGHT - 44, SCREEN_WIDTH, 44);
			g.setColor(new Color(255, 153, 18));
			output = "Tie game! (Press enter to play again)";
			fontWidth = g.getFontMetrics().stringWidth(output);
			g.drawString(output, SCREEN_WIDTH/2 - fontWidth/2, SCREEN_HEIGHT-10);
			gameIsWin = true;
			if(enterPressed)
				newGame();
		}
	}
	
	public void proccess() {
		// set max x o to compare condition
		board.setMaxXO();
	}
	
	public void newGame() {
		board = new Board();
		board.setSize(row, col);
		gameIsWin = false;
		enterPressed = false;
		gameIsRunning = true;
	}
	
	public void gameLoop() {
		long delta = 0;
		long lastLoopTime = System.currentTimeMillis();
		while(gameIsRunning) {
			delta = System.currentTimeMillis() - lastLoopTime;
			lastLoopTime = System.currentTimeMillis();
			
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			paint(g);
			proccess();
			// repaint
			update(g, delta);
			
			try {
				//set fps
				Thread.sleep(10);
			}
			catch(Exception e) {}
		}
		
	}
	
	public void update(Graphics2D g, long delta) {
		g.dispose();
		strategy.show();
	}
	
	public static void main(String[] args) throws InterruptedException{
		Caro game = new Caro();
		
		game.gameLoop();
	}

}
