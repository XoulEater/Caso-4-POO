package robotwar.common.robotbase;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GreenRobot extends IRobot{

	
	public GreenRobot() {
		super();

	}

	public BufferedImage leftL, upL, downL, rightL, leftR, upR, downR, rightR;
	
	public String direction;

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}
