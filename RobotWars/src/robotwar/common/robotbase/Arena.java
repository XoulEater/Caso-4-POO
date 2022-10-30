package robotwar.common.robotbase;

import java.util.ArrayList;
import robotwar.common.robotbase.*;
import java.time.LocalTime;

public class Arena {
	private IRobot robot1;
	private IRobot robot2;
	private ArrayList Tramps;
	private String bgImage;
	private MOVEMENT mov;
	
	public Arena(IRobot pRobot1, IRobot pRobot2)
	{
		this.robot1 = pRobot1;
		this.robot2 = pRobot2;
	}
	

	
	public void moveRobot (int pMovement, int pIndex)
	{
		if (pIndex == 0)
		{
			robot1.move(null, null, null);
		}
		robot2.move(null, null, null);
	}


}

