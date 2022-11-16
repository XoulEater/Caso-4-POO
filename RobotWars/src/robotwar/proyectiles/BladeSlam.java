package robotwar.proyectiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;
import robotwar.gamebasics.IRobotito;

public class BladeSlam extends Proyectile{
	private BufferedImage image;
	private int counter = 10; 
	
	
	public BladeSlam (int pX, int pY, ORIENTATION sight, int pSpeed, IRobotito pRobot, int pLevel) {
		super(pX, pY, sight, pSpeed, pRobot, pLevel);

		String url = null;
		
		switch(sight) {
		case EAST:
			url = "/robotwar/images/largeSI.png";
			break;
		case WEST:
			url ="/robotwar/images/largeS.png";
			break;
		}
		try {	
			this.image = ImageIO.read(getClass().getResource(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void setDraw(Graphics2D pGp) {
		if (counter != 0) {
			pGp.drawImage(image, PosX, PosY, 70, 30, null);
			--counter; 
		} else {
			outOfRange = true;
		}
	}
}