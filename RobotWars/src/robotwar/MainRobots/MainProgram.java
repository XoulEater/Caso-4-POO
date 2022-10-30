package robotwar.MainRobots;

import robotwar.Interfaces.*;


public class MainProgram {

	public static void main(String[] args) {
		RobotController mainController = new RobotController();
		RobotMainFrame mainFrame = new RobotMainFrame(mainController);
		
		mainController.setWindow(mainFrame);
		
		
		
	}

}
