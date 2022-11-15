package robotwar.proyectiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import robotwar.common.robotbase.ORIENTATION;

public class SplitSlam extends Proyectile{

	private BufferedImage image;
	private int counter = 10; 
	
	
	public SplitSlam (int pX, int pY, ORIENTATION sight, int pSpeed) {
		super(pX, pY, sight, pSpeed);

		String url = null;
		
		switch(sight) {
		case EAST:
			url = "/robotwar/images/reaperS.png";
			break;
		case WEST:
			url ="/robotwar/images/reaperSI.png";
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
			pGp.drawImage(image, PosX, PosY, 50, 50, null);
			--counter; 
		} else {
			outOfRange = true;
		}
	}
}