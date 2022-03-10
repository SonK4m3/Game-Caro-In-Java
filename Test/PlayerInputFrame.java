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
	
	PlayerInputFrame(){
		
		frame = new JFrame(); 
		xIcon = new ImageIcon("D:\\Java\\Study\\Image\\xBox.png");
		oIcon = new ImageIcon("D:\\Java\\Study\\Image\\CheckBox.png");
		

		xButton = new JButton();
		oButton = new JButton();
		
		YourMouse mouse = new YourMouse(frame, xButton, oButton);
		
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
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		
		
		frame.add(panel);
		frame.setVisible(true);
	}
}

class YourMouse extends MouseAdapter {
    JFrame frame;
    JButton x;
    JButton o;
    YourMouse(JFrame frame, JButton x, JButton o) {
        this.frame = frame;
    	this.x = x;
        this.o = o;
    }
    
    public void mousePressed(MouseEvent e) {
    	if(e.getSource() == x)
    		System.out.println("x");
    	else
    		System.out.println("o");
    	frame.dispose();
    	new MyFrame();
    }
}