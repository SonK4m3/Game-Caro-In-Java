package Display;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PlayerDisplay extends JFrame implements MouseListener, ChangeListener{
	
	Board board;
	Player player1, player2;
	
	JFrame frame;
	JPanel panel;
	Border border1, border2;
	JButton buttonX, buttonO, backFrame, buttonFinish;
	JLabel label, labelSlider;	
	JSlider sliderX, sliderY;
	
	public PlayerDisplay(){
		board = new Board();
		player1 = new Player();
		player2 = new Player();
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		labelSlider = new JLabel();
		buttonX = new JButton("X");
		buttonO = new JButton("O");
		backFrame = new JButton("Back");
		buttonFinish = new JButton("Finish");
		sliderX = new JSlider(5, 15, 10);
		sliderY = new JSlider(5, 15, 10);
		border1 = BorderFactory.createLineBorder(Color.red, 3);
		border2 = BorderFactory.createLineBorder(Color.blue, 3);


		// label
		label.setBounds(100, 200, 200, 50);
		label.setBackground(Color.cyan);
		label.setOpaque(true);
		label.setText("NULL");
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		//------------------------------
		
		// labelSlider
		labelSlider.setBounds(100, 250, 200, 50);
		labelSlider.setBackground(Color.yellow );
		labelSlider.setOpaque(true);
		labelSlider.setVerticalAlignment(JLabel.CENTER);
		labelSlider.setHorizontalAlignment(JLabel.CENTER);
		
		// slider
		sliderX.setBounds(100, 0, 200, 50);
		sliderX.setPaintTicks(true);
		sliderX.setMinorTickSpacing(1);
		sliderX.setPaintTicks(true);
		sliderX.setMajorTickSpacing(5);
		sliderX.setPaintLabels(true);
		sliderX.addChangeListener(this);
		
		sliderY.setBounds(100, 50, 200, 50);
		sliderY.setPaintTicks(true);
		sliderY.setMinorTickSpacing(1);
		sliderY.setPaintTicks(true);
		sliderY.setMajorTickSpacing(5);
		sliderY.setPaintLabels(true);
		sliderY.addChangeListener(this);
		// panel
		panel.setBounds(100, 50, 400, 300);
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setOpaque(true);
		panel.add(sliderX);
		panel.add(sliderY);
		panel.add(buttonO);
		panel.add(buttonX);
		panel.add(backFrame);
		panel.add(buttonFinish);
		panel.add(label);
		panel.add(labelSlider);
		
		// buttonO
		buttonO.setBounds(100, 100, 100, 100);
		buttonO.addMouseListener(this);
		// buttonX
		buttonX.setBounds(200, 100, 100, 100);
		buttonX.addMouseListener(this);
		// button backFrame
		backFrame.setBounds(0, 250, 100, 50);
		backFrame.addMouseListener(this);
		
		// buttonFinish
		buttonFinish.setBounds(300, 250, 100, 50);
		buttonFinish.addMouseListener(this);
		
		// frame 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(new Dimension(600,400));
		frame.setLocationRelativeTo(null);
		
		frame.add(panel);
		frame.setVisible(true);
		//------------------------------
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == backFrame) {
			frame.dispose();
			new SettingDisplay();
		}
		
		if(e.getSource() == buttonX) {
			player1.setInfor("X", true);
			player2.setInfor("O", false);

			buttonX.setBorder(border1);
			buttonX.setEnabled(false);
			buttonO.setBorder(border2);
			buttonO.setEnabled(true);
			label.setText("Player1   X - O   Player2");
		}
		
		if(e.getSource() == buttonO) {
			player1.setInfor("O", true);
			player2.setInfor("X", false);

			buttonO.setBorder(border1);
			buttonO.setEnabled(false);
			buttonX.setBorder(border2);
			buttonX.setEnabled(true);
			label.setText("Player1   O - X   Player2");
		}
		
		if(e.getSource() == buttonFinish) {
			frame.dispose();
			new BoardDisplay(board, player1, player2);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int x = sliderX.getValue();
		int y = sliderY.getValue();
		labelSlider.setText("Board size: " + x + "x" + y);
		board.setSize(x, y);
	}
	
}
