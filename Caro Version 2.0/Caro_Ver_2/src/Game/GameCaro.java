package Game;

import Control.*;
import GameLoop.*;
import ScreenMenu.*;
import ScreenPlaying.*;
/*
 * Game Caro Ver 2.0
 * 
 * 
 * Caro game has a game mode with AI, 
 * you can choose to play new or continue to play.
 * 
 * There is no function to edit, save history, game screen information.
 * 
 * 
 * Main function includes 3 class:
 * @param {GameLoop} gameLoop is the loop that runs the program, handling the program states.
 * @param {GameControl} gameControl is the class that manages the objects in the game.
 * @param {LogicControl} logicControl is the class that handles the logic that occurs in the game.
 * 
 * 
 */
public class GameCaro {

	private static LogicControl logicControl = new LogicControl();
	private static GameControl gameControl = new GameControl(logicControl);
	private static GameLoop gameLoop = new GameLoop(gameControl, logicControl);
	
	public static void main(String[] args) {
		gameLoop.runGame();	// run game
	}

}
