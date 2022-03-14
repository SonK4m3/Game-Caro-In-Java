package Display;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class SettingDisplay extends JFrame implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel panel;
	JButton buttonTwoPlayer, buttonOnePlayer;
	JButton exitButton;
	
	public SettingDisplay() {
		frame = new JFrame();
		panel = new JPanel();
		buttonTwoPlayer = new JButton();
		buttonOnePlayer = new JButton();
		exitButton = new JButton();
		
		// panel
		panel.setBounds(100, 50, 400, 150);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setOpaque(true);
		panel.setLayout(null);
		panel.add(buttonTwoPlayer);
		panel.add(buttonOnePlayer);
		panel.add(exitButton);
		
		// buttonOnePlayer
		buttonOnePlayer.setBounds(0, 50, 400, 50);
		buttonOnePlayer.setText("1 PLAYER");
		buttonOnePlayer.setFont(new Font("Colsolas", Font.PLAIN, 25));
		
		// buttonTwoPlayer
		buttonTwoPlayer.setBounds(0, 0, 400, 50);
		buttonTwoPlayer.setText("2 PLAYER");
		buttonTwoPlayer.setFont(new Font("Colsolas", Font.PLAIN, 25));
		buttonTwoPlayer.addMouseListener(this);
		
		// exitButton
		exitButton.setBounds(0, 100, 400, 50);
		exitButton.setText("EXIT");
		exitButton.setFont(new Font("Colsolas", Font.PLAIN, 25));
		exitButton.addMouseListener(this);
		
//		 frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600, 400));
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == exitButton) {
			System.exit(0);
		}
		
		if(e.getSource() == buttonTwoPlayer) {
			frame.dispose();
			new PlayerDisplay();
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
}
