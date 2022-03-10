package Test;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

public class MyFrame{
	
	Board board;
	
	JFrame frame;
	JPanel panel;
	JLabel[][] labels;
	
	int xPos;
	int yPos;
	
	MyFrame(){		
		board = new Board();
		
		panel = new JPanel();
		panel.setBounds(0, 0, 300, 300);
		panel.setLayout(null);
		
		// create cell
		labels = new JLabel[3][3];
		Border border = BorderFactory.createLineBorder(Color.gray, 2);

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				labels[i][j] = new JLabel();
				labels[i][j].setBounds(i * 90 + 2, j * 90 + 2, 90, 90);
				labels[i][j].setBorder(border);
				labels[i][j].setOpaque(true);
				labels[i][j].setFont(new Font("Controlas", Font.PLAIN, 35));
				labels[i][j].setVerticalAlignment(JLabel.CENTER);
				labels[i][j].setHorizontalAlignment(JLabel.CENTER);
				panel.add(labels[i][j]);
				
				YourMouseListener mouse =  new YourMouseListener(labels[i][j], i, j, board);
				
				labels[i][j].addMouseListener(mouse);
			}
		}
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(null);
		
		frame.add(panel);
		frame.setVisible(true);
	}	
}

class YourMouseListener extends MouseAdapter {
    JLabel label;
    int i;
    int j;
    Board board;
    YourMouseListener(JLabel label, int i, int j, Board board) {
        this.label = label;
        this.i = i;
        this.j = j;
        this.board = board;
    }
    
    public void mousePressed(MouseEvent e) {
	
    	if(board.mat[i][j] == 0 && board.last == 1) {
    		label.setText("X");
    		label.setBackground(Color.red);
    		board.mat[i][j] = 1;
    		board.last = 2;
    	}
    	else if(board.mat[i][j] == 0 && board.last == 2){    
    		label.setText("O");
    		label.setBackground(Color.blue);
    		board.mat[i][j] = 2;
    		board.last = 1;
    	}
    	// debug
    	board.print();
    }
}
