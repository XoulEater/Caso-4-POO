package robotwar.proyectiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import robotwar.common.robotbase.IRobotito;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class AxeSlam extends Proyectile{
	private BufferedImage image;
	private int counter = 10; 
	
	
	public AxeSlam (int pX, int pY, ORIENTATION sight, int pSpeed, IRobotito pRobot, int pLevel) {
		super(pX, pY, sight, pSpeed, pRobot, pLevel);

		String url = null;
		
		switch(sight) {
		case EAST:
			url = "/robotwar/images/megaS.png";
			break;
		case WEST:
			url ="/robotwar/images/megaSI.png";
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
			pGp.drawImage(image, PosX, PosY, 50, 70, null);
			--counter; 
		} else {
			outOfRange = true;
		}
	}
}