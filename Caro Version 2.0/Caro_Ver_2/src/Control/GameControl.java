package Control;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GameLoop.*;
import ScreenMenu.*;
import ScreenPlaying.*;
import ScreenSetting.*;

public class GameControl extends JFrame{
	private Menu menu = new Menu(this);
	private Setting setting = new Setting(this);
	private Playing playing = new Playing(this);
	private ScreenBoard screenBoard;
	private LogicControl logicControl;
	private MyMouseListener myMouseListener = new MyMouseListener(this);
	
	final int WidthPlaying = 800;
	final int HeightPlaying = 800;
	
	private boolean pressedMouse = false;
	private boolean gameIsRunning = true;	
	private boolean menuIsActiv = true;
	private boolean settingIsActiv = false;
	private boolean playingIsActiv = false;
	private boolean screenBoardIsActiv = false;
	
	private boolean newGame = false;
	private boolean continueGame = false;
	private boolean canMove = false;
	
	int xPos = -1;
	int yPos = -1;
	
		
	public GameControl(LogicControl logicControl) {
		this.logicControl = logicControl;
		initScreen();
	}
	
	// Initialize screen
	void initScreen() {
		this.setTitle("Caro_Ver_2");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.add(menu);
		this.addMouseListener(myMouseListener);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	// event 
	/*
	 * we remove previous screen and add new screen
	 * we set thread sleep to wait screen is draw fully
	 */
	public void displayMenuScreen() {
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.add(menu);
		this.revalidate();
		menu.setPos(xPos, yPos);
		menu.activ();
	}
	
	public void displaySettingScreen() {
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.remove(menu);
		this.add(setting);
		this.revalidate();
		setting.setPos(xPos, yPos);
		setting.activ();
	}
	
	public void displayPlayingScreen() {
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.remove(menu);
		this.add(playing);
		this.revalidate();
		playing.setPos(xPos, yPos);
		playing.activ();
	}
	
	public void displayScreenBoard() {
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//1. create new board
		screenBoard = new ScreenBoard(this, logicControl);
		this.remove(playing);
		this.add(screenBoard);
		this.revalidate();
		screenBoard.setPos(xPos, yPos);
		screenBoard.activ();
	}
	
	// set and get variable to check game running and activity
	//  gameIsRunning
	public boolean getGameIsRunning() {
		return gameIsRunning;
	}
	
	public void setGameuIsRunning(boolean isActiv) {
		gameIsRunning = isActiv;
	}
	// menuIsActiv
	public boolean getMenuIsActiv() {
		return menuIsActiv;
	}
	
	public void setMenuIsActiv(boolean isActiv) {
		menuIsActiv = isActiv; 
	}
	// settingIsActiv
	public boolean getSettingIsActiv() {
		return settingIsActiv;
	}
	
	public void setSettingIsActiv(boolean isActiv) {
		settingIsActiv = isActiv;
	}
	// playingIsActiv
	public boolean getPlayingIsActiv() {
		return playingIsActiv;
	}
	
	public void setPlayingIsActiv(boolean isActiv) {
		playingIsActiv = isActiv;
	}
	// screenBoardIsActiv
	public boolean getScreenBoardIsActiv() {
		return screenBoardIsActiv;
	}
	
	public void setScreenBoardIsActiv(boolean isActiv) {
		screenBoardIsActiv = isActiv;
	}
	
	public boolean getNewGame() {
		return newGame;
	}
	
	public void setNewGame(boolean isOn) {
		newGame = isOn;
	}
	
	public boolean getContinueGame() {
		return continueGame;
	}
	
	public void setContinueGame(boolean isOn) {
		continueGame = isOn;
	}
	
	public boolean getCanMove() {
		return canMove;
	}
	
	public void setCanMove(boolean isOn) {
		canMove = isOn;
	}
	
	/*
	 * set all screen is off
	 */
	public void exitGame() {
		playingIsActiv = false;
		settingIsActiv = false;
		menuIsActiv = false;
		gameIsRunning = false;
	}
	
	/*
	 * check is pressed mouse now or not
	 */
	public boolean getPressedMouse() {
		return pressedMouse;
	}
	
	public void setPressedMouse(boolean bool) {
		pressedMouse = bool;
	}
	
	// set and get position pressed mouse
	public void setPos(int x, int y) {
		xPos = x;
		yPos = y;
	}

	public int getPosX() {
		return xPos;
	}
	
	public int getPosY() {
		return yPos;
	}
	
	// print state of component
	public void printStateComponent() {
//		System.out.println("-------------------------");
//		System.out.println("gameIsRunning: " + gameIsRunning);
//		System.out.println("menuIsActiv: " + menuIsActiv);
//		System.out.println("settingIsActiv: " + settingIsActiv);
//		System.out.println("playingIsActiv: " + playingIsActiv);
//		System.out.println("screenBoarIsActiv: " + screenBoardIsActiv) ;
		System.out.println("position pressed mouse: " + xPos + " " + yPos);
	}
	
	// get component
	public Menu getMenu() {
		return menu;
	}
	
	public Playing getPlaying() {
		return playing;
	}
}
