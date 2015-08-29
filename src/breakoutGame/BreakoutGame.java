package breakoutGame;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;


public class BreakoutGame {
	
	// Variable to store the time left on the countdown clock
	static int timeLeft = 180;
	
	// Constructor for the BreakoutGame class
	public BreakoutGame()
	{
		// Creating two JFrames for the Clock and Game
		JFrame clockFrame = new JFrame("Clock");
		JFrame gameFrame = new JFrame("Breakout Game");
		
		// Creating labels for both frames
		JLabel clockLabel;		//, scoreLabel; 

		// To-do add score to the game
		
		clockFrame.setSize(300, 200);
		clockFrame.setResizable(false);
		gameFrame.setBackground(Color.white);
		gameFrame.setSize(600, 800);
		gameFrame.setResizable(false);
		
		// Intializing all labels
		clockLabel = new JLabel("0", JLabel.CENTER);
//		scoreLabel = new JLabel("SCORE: 0", JLabel.RIGHT);
	
		//Customizing the clock
		clockLabel.setFont(new Font("Times New Roman", 1, 50));
		clockLabel.setOpaque(true);
		clockLabel.setBackground(Color.black);
		clockLabel.setForeground(Color.red);
	    
		/*
		scoreLabel.setFont(new Font("Times New Roman", 3, 14));
		scoreLabel.setAlignmentY(gameFrame.getHeight()-20);
		//scoreLabel.setBounds(gameFrame.getWidth()-20, gameFrame.getHeight()-10, 20, 10);
		*/
		
	    clockFrame.add(clockLabel);	    
//		gameFrame.add(scoreLabel);
		
		
		//Adjusting frame position on screen
		gameFrame.setLocationRelativeTo(null);
		// Setting location of clockFrame on the left side of gameFrame
		clockFrame.setLocation(gameFrame.getX()-300, gameFrame.getY()*2);
		clockFrame.setVisible(true);
		gameFrame.setVisible(true);
		
		
		// Clock initialize
		Timer timerVar = new Timer(1000, new ActionListener(){
			
			//Overriding actionPerformed
			public void actionPerformed(ActionEvent e)
			{
				timeLeft--;
				
				// Converting seconds into minutes
				long minutes = TimeUnit.SECONDS.toMinutes(timeLeft)
                        - (TimeUnit.SECONDS.toHours(timeLeft) * 60);
                long seconds = TimeUnit.SECONDS.toSeconds(timeLeft)
                        - (TimeUnit.SECONDS.toMinutes(timeLeft) * 60);
                clockLabel.setText(minutes + " : " + seconds);
                
                // Notifying the user that time ran out
                if (timeLeft == 0) {
                    JOptionPane.showMessageDialog(null, "Time is up!\n\nSorry, You Lost.", "Game Over", JOptionPane.WARNING_MESSAGE);
                    
                }
			}
		});
		
		timerVar.start();
		
		gameFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		gameFrame.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		    	
		    	//ADD OPTION TO PAUSE THE GAME
		    	
		    	// Timer is paused when user gets a closing confirmation
		    	timerVar.stop();
		    	
		        String options[] = {"Yes","No"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to leave the game?","Breakout Game",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,options,options[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		        else
		        {
		        	//RESUME THE GAME
		        	timerVar.start();
		        }
		    }
		});
	
	}

	public static void main(String[] args) {
		
		new BreakoutGame();
	}

}
