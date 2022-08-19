package Control;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GameLoop.GameLoop;

public class MyMouseListener implements MouseListener{
	private GameControl gameControl;
	
	public MyMouseListener(GameControl gameControl) {
		this.gameControl = gameControl;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			//1. get position pressed mouse
			// pointerInfor - panel
			int mouse_x = MouseInfo.getPointerInfo().getLocation().x - gameControl.getContentPane().getLocationOnScreen().x;
			int mouse_y = MouseInfo.getPointerInfo().getLocation().y - gameControl.getContentPane().getLocationOnScreen().y;
			
			//2. set position to gameControl
			gameControl.setPos(mouse_x, mouse_y);
			gameControl.setPressedMouse(true);
			//debug
			// print position pressed mouse
//		System.out.println(mouse_x + " " + mouse_y);		
		}

	}
 
	@Override
	public void mouseReleased(MouseEvent e) {
		//1. remove to default mouse
		gameControl.setPos(-1, -1);
		gameControl.setPressedMouse(false);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
