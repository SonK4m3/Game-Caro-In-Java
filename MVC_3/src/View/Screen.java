package View;
import Control.*;
import Model.*;
import javax.swing.*;

public class Screen extends JFrame{
	
	private MenuDisplay menuDisplay;
	private PlayerBoard playerBoard;
	private TacticBoard tacticBoard;
	private GameLoop gameLoop;
	private MyMouseListener myMouseListener;
	
	public Screen(GameLoop gameLoop) {
		this.gameLoop = gameLoop;
		playerBoard = new PlayerBoard(gameLoop.getBoard(), gameLoop.getEnemy1(), gameLoop.getEnemy2()); 
		myMouseListener = new MyMouseListener(gameLoop, playerBoard);
		initScreen();
	}
	
	public void initScreen() {
		this.setTitle("SkyGame");
		
		// add component
		this.addMouseListener(myMouseListener);
		this.add(playerBoard);
	
		//setting frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public PlayerBoard getPlayerBoard() {
		return this.playerBoard;
	}
	
	public GameLoop getGameLoop() {
		return gameLoop;
	}
	
	public void loop() {
		while(true){
			gameLoop.loop();
			playerBoard.loop();
			// debug
			gameLoop.getEnemy1().print();
			gameLoop.getEnemy2().print();
			System.out.println(gameLoop.checkPosFlight1(gameLoop.getEnemy1()));
			System.out.println(gameLoop.checkPosFlight1(gameLoop.getEnemy2()));
			gameLoop.getBoard().print();
			
			try {
				Thread.sleep(10);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
