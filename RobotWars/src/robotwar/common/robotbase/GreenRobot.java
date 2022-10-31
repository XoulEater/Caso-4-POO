package robotwar.common.robotbase;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GreenRobot extends IRobot{

	
	public GreenRobot(Weapon pdirections, DamageLevel pweapons) {
		super(pdirections, pweapons);

	}
	
	public int getPosX()
	{
		return posX;
	}
	
	public int getPosY()
	{
		return posY;
	}
	
	public int getSpeed()
	{
		return speed;
	}

	public BufferedImage left1, up1, right1, down1;
	
	public String direction;
}
