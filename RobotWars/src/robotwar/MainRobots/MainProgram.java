package robotwar.MainRobots;

import robotwar.Interfaces.*;


public class MainProgram {

	public static void main(String[] args) throws InterruptedException {
		RobotController mainController = new RobotController();
		RobotMainFrame mainFrame = new RobotMainFrame(mainController);
		
		int count = 10;
		while (count != 0) {
			mainFrame.moveblue();
			count -= 1;
			Thread.sleep(1000);
		}

}
