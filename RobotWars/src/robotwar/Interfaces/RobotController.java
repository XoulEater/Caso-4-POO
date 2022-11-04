package robotwar.Interfaces;

import java.time.LocalTime;

import robotwar.Interfaces.*;
import robotwar.common.robotbase.*;

import robotwar.common.robotbase.*;
import robotwar.main.*;

public class RobotController {
	private GameInterface contolledFrame;
	private IRobot robotFather;
	private Arena currentArena;
	private FactoryIRobot robot1, robot2;
	private MOVEMENT sight;
	
	
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
	
	public void execute ()
	{
		int cont = 0;

		while (0 != 10)
		{
			//No se como llamar el keyboard
			
			int numero = (cont % 3);
			this.sight = MOVEMENT.values()[numero];
			LocalTime tiempo = LocalTime.now();
			
			
			
			robotFather.move(sight, tiempo, );
			
			
			
			//contolledFrame.paintComponent(null);

			cont +=1;
		}
	}
	
	
}
