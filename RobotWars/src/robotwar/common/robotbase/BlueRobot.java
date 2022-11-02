package robotwar.common.robotbase;

import java.awt.image.BufferedImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class BlueRobot extends IRobot{

	public int indexLink;
	
	public BufferedImage leftL, upL, downL, rightL, leftR, upR, downR, rightR;
	
	public String direction;
	
	public BlueRobot() { //
		super();
		int[] listX  = {300, 57, 190, 135};
		this.setBounds(listX);
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public List<Integer> getLocation(String pDirection)
	{
		switch(pDirection) {
		case "right":
			lastBounds = new ArrayList<>();
			Collections.addAll(lastBounds, 0, 22, 120,110);
			break;
		case "left":
			lastBounds = new ArrayList<>();
			Collections.addAll(lastBounds,70, 22, 120, 110);
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

