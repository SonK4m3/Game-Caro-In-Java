package Test;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class PlayerInputFrame {
	JFrame frame;
	JPanel panel;
	JLabel label;
	JButton xButton;
	JButton oButton;
	ImageIcon xIcon;
	ImageIcon oIcon;
	
	Player player1;
	Player player2;
	Board board;
	
	PlayerInputFrame(){
		
		this.board = new Board();
		this.player1 = new Player();
		this.player2 = new Player();
		
		frame = new JFrame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500,500));
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		
		xIcon = new ImageIcon("D:\\Java\\Study\\Image\\xBox.png");
		oIcon = new ImageIcon("D:\\Java\\Study\\Image\\CheckBox.png");
		

		xButton = new JButton();
		oButton = new JButton();
		
		YourMouse mouse = new YourMouse(frame, xButton, oButton, board, player1, player2);
		
		xButton.setIcon(xIcon);
		oButton.setIcon(oIcon);
		
		xButton.addMouseListener(mouse);
		oButton.addMouseListener(mouse);
		
		label = new JLabel();
		label.setText("Player 1 choose: ");
//		label.setBounds(0,0, 100, 200);
		
		panel = new JPanel();
		panel.setBounds(0,0, 500, 500);
		panel.setLayout(new FlowLayout());
		panel.add(label);
		panel.add(xButton);
		panel.add(oButton);	
		frame.add(panel);
		frame.setVisible(true);
	}
	
}

class YourMouse extends MouseAdapter {
    JFrame frame;
    JButton x;
    JButton o;
    Player player1;
	Player player2;
	Board board;
	
    YourMouse(JFrame frame, JButton x, JButton o, Board board, Player player1, Player player2) {
    	this.board = board;
    	this.player1 = player1;
    	this.player2 = player2;
        this.frame = frame;
    	this.x = x;
        this.o = o;
    }
    
    public void mousePressed(MouseEvent e) {
    	if(e.getSource() == x) {
//    		System.out.println("player1: X\nplayer2: O");
    		player1.setInput("X", true);
    		player2.setInput("O", false);
    	}
    		
    	else if(e.getSource() == o){
//    		System.out.println("player1: O\nplayer2: X");
    		player1.setInput("O", true);
    		player2.setInput("X", false);
    	}
    		
    	frame.dispose();
    	new MyFrame(board, player1, player2);
    }
}