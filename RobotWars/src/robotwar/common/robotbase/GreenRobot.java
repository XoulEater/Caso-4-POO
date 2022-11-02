package robotwar.common.robotbase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreenRobot extends IRobot{


	public GreenRobot() { //
		super();
		int[] listX  = {0, 0, 190, 135};
		this.setBounds(listX);
	}

	public List<Integer> getLocation(String pDirection)
	{
		switch(pDirection) {
		case "right":
			lastBounds = new ArrayList<>();
			Collections.addAll(lastBounds, 0, 45, 120,90);
			break;
		case "left":
			lastBounds = new ArrayList<>();
			Collections.addAll(lastBounds, 66, 45, 120,90);
			break;
		}
		return lastBounds;
	}
	
	public String getImage(String dir) {
		switch(dir) {
		case "right":
			lastDir = "/robotwar/images/gmeg.png";
			break;
		case "left":
			lastDir = "/robotwar/images/gmegI.png";
			break;
		}
		return lastDir;
	}
}



