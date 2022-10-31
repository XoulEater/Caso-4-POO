package robotwar.Interfaces;

import robotwar.Interfaces.*;


import robotwar.common.robotbase.*;
import robotwar.main.*;




public class RobotController {
	private GameInterface contolledFrame;
	private Arena currentArena;
	private FactoryIRobot robot1, robot2;
	
	
	public RobotController()
	{	
		FactoryIRobot robot1 = new FactoryIRobot();
		FactoryIRobot robot2 = new FactoryIRobot();
		
	}
	public void createRobot(int pIndex) {
		if (pIndex == 1)
		{
			
		}
	}
	
	
	public void addRobot()
	{
	}

	public void setWindow(GameInterface pRobotmainFrame) { //Para interfaz
		contolledFrame = pRobotmainFrame;	
	}
	
	
}
