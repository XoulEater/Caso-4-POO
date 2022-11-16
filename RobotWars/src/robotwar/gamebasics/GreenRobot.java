package robotwar.gamebasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import robotwar.common.robotbase.ORIENTATION;

public class GreenRobot extends IRobotito{
	
	public GreenRobot() { //
		super(ORIENTATION.EAST);
		Collections.addAll(panelBounds, 0, 0, 190, 135);
		this.speed = 4;
		this.type = "Green";
	}
	

	@Override
	public void UpdateImage() 
	{
		switch(currentOrientation) {
		case EAST:
			image = "/robotwar/images/gmeg.png";
			mekaBound = new ArrayList<>();
			Collections.addAll(mekaBound, 0, 45, 120,90);
			break;
		case WEST:
			image = "/robotwar/images/gmegI.png";
			mekaBound = new ArrayList<>();
			Collections.addAll(mekaBound, 66, 45, 120,90);
			break;
		case SOUTH:
			break;
		case NORTH:
			break;
		}
	}
}



