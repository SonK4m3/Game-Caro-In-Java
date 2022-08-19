package GameLoop;

import Control.*;
import Game.*;
import Object.Board;
import ScreenMenu.*;
import ScreenPlaying.*;
/*
 * GameLoop controls the active events
 */
public class GameLoop {

	private GameControl gameControl;
	private LogicControl logicControl;
	
	public GameLoop(GameControl gameControl, LogicControl logicControl) {
		this.gameControl = gameControl;
		this.logicControl = logicControl;
	}

	public void runGame() {
		while(gameControl.getGameIsRunning()) {
			// debug
			// print state of all component
			if(gameControl.getPressedMouse()) {
				gameControl.printStateComponent();
			}
			
			/*Event Action
			 * 1. Menu Screen -> Setting Screen - Playing Screen - Exit
			 * 2. Setting Screen -> Back
			 * 3. Playing Screen -> New Game - Continue - Back
			 * 4. Screen Board -> Reset - Back
			 * 
			 * if the screen is activ, we display it
			 */
			if(gameControl.getMenuIsActiv()) {
				gameControl.displayMenuScreen();
			}
			else if(gameControl.getSettingIsActiv()) {
				gameControl.displaySettingScreen();
			}
			else if(gameControl.getPlayingIsActiv()) {
				if(!gameControl.getScreenBoardIsActiv()) {
					gameControl.displayPlayingScreen();					
				}else{
					gameControl.displayScreenBoard();
					
					// pressed New Game Button
					if(gameControl.getNewGame()) {
						logicControl.newGame();
						logicControl.setIsCreateBoard(true);
						gameControl.setNewGame(false);
						gameControl.setContinueGame(true);
					}
					// pressed continue button but board haven't created
					// we create new board
					if(!logicControl.getIsCreateBoard()) {
						logicControl.newGame();
						logicControl.setIsCreateBoard(true);
					}else {
						if(gameControl.getPressedMouse() && logicControl.getIsCreateBoard()) {
							gameStart();
						}
					}
				}
			}
			 
			// set FPS
			try {
				Thread.sleep(10);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		// exit game
		System.exit(0);
	} 
	
	/*
	 * start the game turns
	 * game logic is handled by logicControl
	 */
	public void gameStart() {
		// 1. get position from pressed mouse  
		logicControl.setPos(gameControl.getPosX(), gameControl.getPosY());
		// 2. move 
		if(logicControl.getBoard().getPosBoard(logicControl.getPosX(), logicControl.getPosY()) == '_' && gameControl.getCanMove()) {
			logicControl.move();
			gameControl.setCanMove(false);
		}
		// debug
		// print position current pressed cell board and board
		logicControl.printStateComponents();
	}
	
}
