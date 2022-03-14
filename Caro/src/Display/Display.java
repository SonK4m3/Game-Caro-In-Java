package Display;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Display implements MouseListener{
	JFrame frame;
	Cell[] panelsCell;
	int numbers = 5; 
	int cellSize = 90;
	int boardSize;
	int boardCell;
	int xCell = 0;
	int yCell = 0;
	public Display(){
		boardCell = numbers * numbers;
		boardSize = cellSize * numbers;
		panelsCell = new Cell[boardCell];
				
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(numbers, numbers, 0, 0));
		frame.setSize(boardSize, boardSize);
		frame.setResizable(false);
		
		for(Cell panel : panelsCell) {
			panel = new Cell();
			panel.addMouseListener(this);
			Border border = BorderFactory.createLineBorder(Color.gray, 3);
			panel.setXY(xCell/numbers, yCell/numbers);
			panel.setBounds(xCell, yCell, cellSize, cellSize);
			panel.setBorder(border);
			if(xCell == boardSize)
				yCell += cellSize;
			xCell += cellSize;
			frame.add(panel);
		}
			
		frame.addMouseListener(this);
		frame.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		e.getComponent().setBackground(Color.red);
		System.out.println(e.getComponent().getX()/cellSize + " " + e.getComponent().getY()/cellSize);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		e.getComponent().setBackground(Color.red);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
//		e.getComponent().setBackground(Color.red);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println(e.getComponent().getName());
//		e.getComponent().setBackground(Color.white);
	}
}
