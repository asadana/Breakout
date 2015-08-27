package breakoutGame;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;


public class BreakoutGame {
	
	static int timeLeft = 70;
	
	// Constructor for the BreakoutGame class
	public BreakoutGame()
	{
		// Creating two JFrames for the Clock and Game
		JFrame clockFrame = new JFrame("Clock");
		JFrame gameFrame = new JFrame("Breakout Game");
		
		JLabel clockLabel, livesLabel, scoreLabel; 
		
		clockFrame.setBackground(Color.BLACK);
		clockFrame.setSize(400, 200);
		gameFrame.setBackground(Color.white);
		gameFrame.setSize(600, 800);
		
		clockLabel = new JLabel("0", JLabel.CENTER);
		livesLabel = new JLabel("3");
		scoreLabel = new JLabel("0");
		
		clockLabel.setBackground(Color.BLACK);
		
	    clockLabel.setMinimumSize(new Dimension(30,180));
	    clockLabel.setPreferredSize(new Dimension(30,180));
	    clockLabel.setMaximumSize(new Dimension(30,180));
	    
	    clockFrame.add(clockLabel);
		
	    //To-do Add Lives near the top and score at the bottom of gameFrame
		gameFrame.add(livesLabel);
		gameFrame.add(scoreLabel);
		
		
		
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
