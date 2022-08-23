import Model.*;
import Control.*;
import View.*;

public class SkyGame {

	final static int Size = 10;
	
	static Board board = new Board();
	static Enemy enemy1 = new Enemy(board);
	static Enemy enemy2 = new Enemy(board); 
	
	static GameLoop gameLoop = new GameLoop(board, enemy1, enemy2);
	
	static Screen screen = new Screen(gameLoop);
	
	static public void debug() {
		board.print();
		enemy1.setHeadPos(3, 5);
		enemy1.setSwing(enemy1.getState().getStateLeft());
		enemy1.stickEnemy();
		enemy1.print();
		board.print();
	}
	
	public static void main(String[] args) {
//		debug();
		screen.loop();
	}

}
