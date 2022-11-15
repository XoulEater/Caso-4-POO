package robotwar.proyectiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import robotwar.common.robotbase.IRobotito;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class HammerSlam extends Proyectile{
	private BufferedImage image;
	private int counter = 10; 
	
	
	public HammerSlam (int pX, int pY, ORIENTATION sight, int pSpeed, IRobotito pRobot, int pLevel) {
		super(pX, pY, sight, pSpeed, pRobot, pLevel);
		String url = "/robotwar/images/megaSU.png";
	}

	@Override
	public void setDraw(Graphics2D pGp) {
		if (counter != 0) {
			pGp.drawImage(image, PosX, PosY, 50, 50, null);
			--counter; 
		} else {
			outOfRange = true;
		}
	}
}
