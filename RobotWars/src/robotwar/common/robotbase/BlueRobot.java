package robotwar.common.robotbase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlueRobot extends IRobot{

	public BlueRobot() { //
		super();
		int[] listX  = {300, 57, 190, 162};
		this.setBounds(listX);
		this.speed = 4;
	}


	public List<Integer> getLocation(String pDirection)
	{
		switch(pDirection) {
		case "right":
			lastBounds = new ArrayList<>();
			Collections.addAll(lastBounds, 0, 52, 120,110);
			break;
		case "left":
			lastBounds = new ArrayList<>();
			Collections.addAll(lastBounds,70, 52, 120, 110);
			break;
		}
		return lastBounds;
	}
	
	public String getImage(String dir) {
		switch(dir) {
		case "right":
			lastDir = "/robotwar/images/mekb.png";
			break;
		case "left":
			lastDir = "/robotwar/images/mekbI.png";
			break;
		}
		return lastDir;
	}
}

