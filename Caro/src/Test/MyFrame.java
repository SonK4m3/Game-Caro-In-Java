package Test;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.Border;

public class MyFrame{
	
	Board board;
	Player player1;
	Player player2;
	
	JFrame frame;
	JPanel panel;
	JLabel[][] labels;
	
	int xPos;
	int yPos;
	
	MyFrame(Board board, Player player1, Player player2){		
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
		
		frame = new JFrame();
		panel = new JPanel();
		labels = new JLabel[3][3];

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500,500));
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		
		panel.setBounds(0, 0, 300, 300);
		panel.setLayout(null);
		
		// create cell
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
				
				YourMouseListener mouse =  new YourMouseListener(frame, panel, labels[i][j], i, j, board, player1, player2);
				
				labels[i][j].addMouseListener(mouse);
			}
		}
		
		frame.add(panel);
		frame.setVisible(true);
	}	
}

class YourMouseListener extends MouseAdapter {
    JFrame frame;
    JPanel panel;
	JLabel label;
    int i;
    int j;
    Board board;
    Player player1;
    Player player2;
    
    boolean gameStop = false;
    
    YourMouseListener(JFrame frame, JPanel panel, JLabel label, int i, int j, Board board, Player player1, Player player2) {
    	this.frame = frame;
    	this.panel = panel;
    	this.label = label;
        this.i = i;
        this.j = j;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public void process() {
    	board.setMaxXO();
    	
    	if(board.maxO == board.condition) {
    		if(player1.symbol.equals("O")){
    			JOptionPane.showMessageDialog(null,"player1 win", "title", JOptionPane.INFORMATION_MESSAGE);
    		}
    		else {
    			JOptionPane.showMessageDialog(null,"player2 win", "title", JOptionPane.INFORMATION_MESSAGE);
    		}
    		gameStop = true;
    		return;
    	}
    	
    	if(board.maxX == board.condition) {
    		if(player1.symbol.equals("X")){
    			JOptionPane.showMessageDialog(null,"player1 win", "title", JOptionPane.INFORMATION_MESSAGE);
    		}
    		else {
    			
    			JOptionPane.showMessageDialog(null,"player2 win", "title", JOptionPane.INFORMATION_MESSAGE);
    		}
    		gameStop = true;
    		return;
    	}
    	
    	if(board.isFull()) {
			JOptionPane.showMessageDialog(null,"draw", "title", JOptionPane.INFORMATION_MESSAGE);
    		gameStop = true;
    		return;
    	}
    }
    
    public void mousePressed(MouseEvent pressed) {
    	if(pressed.getSource() == label) {
    		if(board.mat[i][j] == -1 && player1.inturn == true) {
        		String sym = player1.symbol;
        		label.setText(sym);
//        		label.setBackground(Color.red);
        		board.mat[i][j] = (sym == "X") ? 1 : 0;
        		player1.inturn = false;
        		player2.inturn = true;
        		board.remains --;  
        	}
        	else if(board.mat[i][j] == -1 && player2.inturn == true){    
        		String sym = player2.symbol;
        		label.setText(sym);
//        		label.setBackground(Color.blue);
        		board.mat[i][j] = (sym == "X") ? 1 : 0;
        		player2.inturn = false;
        		player1.inturn = true;
        		board.remains --;  
        	}
        	  	
        	process();
        	
        	if(gameStop == true) {
        		int answer = JOptionPane.showConfirmDialog(null, "Exit?", "Caro", JOptionPane.YES_NO_OPTION);
        		if(answer == 0) {
        			System.exit(0);
        		}
        		else {
//        			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        			frame.dispose();
            		new PlayerInputFrame();
        		}
        	}
        	// debug
//    		board.print();
    	}
    }
}
