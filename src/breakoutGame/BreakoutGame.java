package breakoutGame;

import java.awt.event.*;
import javax.swing.*;

public class BreakoutGame implements ActionListener {
	
	// Constructor for the BreakoutGame class
	public BreakoutGame()
	{
		JFrame startFrame = new JFrame("Welcome to Breakout Game!");
		JLabel lbl;
		JButton start;
		
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		startFrame.setLocationRelativeTo(null);
		
		lbl = new JLabel("Welcome to Breakout Game", JLabel.CENTER);
		
		start = new JButton ("START");
		
		lbl.setBounds(150, 200, 300, 100);
		start.setBounds(50, 250, 100, 75);
		
		start.addActionListener(this);
		
		startFrame.add(lbl);
		startFrame.add(start);
		
		startFrame.setSize(500, 700);
		startFrame.setVisible(true);
				
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}

	public static void main(String[] args) {
		
		new BreakoutGame();
	}

}
