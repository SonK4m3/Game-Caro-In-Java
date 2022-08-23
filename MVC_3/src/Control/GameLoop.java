package Control;
import java.awt.Graphics;

import Model.*;


public class GameLoop {
	
	private Board board;
	private Enemy enemy1;
	private Enemy enemy2;
	
	private boolean isPressed = false;
	private boolean pressedButton1 = false;
	private boolean pressedButton3 = false;
	
	private int xPos = -1;
	private int yPos = -1;
	
	public GameLoop(Board board, Enemy enemy1, Enemy enemy2) {
		this.board = board;
		this.enemy1 = enemy1;
		this.enemy2 = enemy2;
	}
	
	public void init() {
		
	}
	
	public void setStateAndStick(Enemy enemy) {
		if(enemy.getState().getStateNumber() == 1) {
			enemy.setSwing(enemy.getState().getStateLeft());
		}
		else if(enemy.getState().getStateNumber() == 2) {
			enemy.setSwing(enemy.getState().getStateTop());
		}
		else if(enemy.getState().getStateNumber() == 3) {
			enemy.setSwing(enemy.getState().getStateRight());
		}
		else if(enemy.getState().getStateNumber() == 4) {
			enemy.setSwing(enemy.getState().getStateBot());
		}
		enemy.stickEnemy();
	}
	
	public void loop() {
		//1. check mouse is pressed or not
		if(isPressed) {
			//2. set new flight or change flight's state 
			if(enemy1.getIsStick() == false) {
				// flight is not stick and pressed left mouse
				if(pressedButton1 && checkPosFlight1(enemy2))
					setFlight(enemy1);
			}
			else if(enemy1.getIsStick() == true){
				// flight is stick 
				// pressed left mouse to change state
				// or pressed right mouse to delete flight
				if(xPos == enemy1.getHeadX() && yPos == enemy1.getHeadY()) {
					if(pressedButton1) {
						enemy1.changeState();
						enemy1.removeEnemy(); 
						// debug
//						System.out.println("1");
					}
					else if(pressedButton3) {
						enemy1.reset();
						//debug
//						System.out.println("3");
					}
				}
			}
			// stick enemy2
			if(enemy2.getIsStick() == false) {
				if(pressedButton1 && checkPosFlight1(enemy1)) {
					setFlight(enemy2);
				}
			}
			else if(enemy2.getIsStick() == true) {
				if(xPos == enemy2.getHeadX() && yPos == enemy2.getHeadY()) {
					if(pressedButton1) {
						enemy2.changeState();
						enemy2.removeEnemy(); 
						// debug
//					System.out.println("1");
					}
					else if(pressedButton3) {
						enemy2.reset();
						//debug
//					System.out.println("3");
					}
				}
			}
			
			setStateAndStick(enemy1);
			setStateAndStick(enemy2);
			isPressed = false;
		}
	}
	
	// function set variable is check MouseEvent
	public void setIsPressed(boolean bool) {
		this.isPressed = bool;
	}
	
	public void setPressedButton1(boolean bool) {
		this.pressedButton1 = bool;
	}
	
	public void setPressedButton3(boolean bool) {
		this.pressedButton3 = bool;
	}
	
	public void setFlight(Enemy enemy) {
		if(enemy.getIsStick() == false) {
			enemy.setHeadPos(xPos, yPos);
			enemy.setState();
			if(enemy.getState().isEmpty() == false) {
				enemy.setIsStick(true);
			//debug
//			System.out.println("set new flight is successful");
			}
		}
	}

	public void setXYPos(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public Enemy getEnemy1() {
		return enemy1;
	}
	
	public Enemy getEnemy2() {
		return enemy2;
	}
	
	public boolean checkPosFlight1(Enemy enemy) {
		for(int i = 0; i < 8; i++) {
			if(yPos == enemy.getSwingX(i) && xPos == enemy.getSwingY(i))
				return false;
		}
		return true;
	}
	
}

