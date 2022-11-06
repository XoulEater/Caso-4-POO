package robotwar.common.robotbase;

import java.util.ArrayList;
import java.util.Collections;

public class BlueRobot extends IRobotito{
	
	public BlueRobot() { //
		super(ORIENTATION.EAST);
		Collections.addAll(panelBounds, 300, 57, 190, 162);
		this.speed = 4;
	}
	
	@Override
	public void UpdateImage()
	{
		switch(currentOrientation) {
		case EAST:
			image = "/robotwar/images/mekb.png";
			mekaBound = new ArrayList<>();
			Collections.addAll(mekaBound, 0, 52, 120,110);
			break;
		case WEST:
			image = "/robotwar/images/mekbI.png";
			mekaBound = new ArrayList<>();
			Collections.addAll(mekaBound,70, 52, 120, 110);
			break;
		case SOUTH:
			break;
		case NORTH:
			break;
		}
	}
}

