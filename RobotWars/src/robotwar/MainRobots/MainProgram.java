package robotwar.MainRobots;

import javax.swing.JFrame;


import robotwar.Interfaces.*;

public class MainProgram {

	public static void main(String[] args)  {
		
		JFrame window =  new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("RobotWars");
		
		GameInterface gamePanel = new GameInterface();
		window.add(gamePanel);
		window.pack(); 
		
		window.setLocationRelativeTo(null);
		window.setVisible(true );
		
		gamePanel.startGameThread();
	}
}
