package robotwar.proyectiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import robotwar.common.robotbase.ORIENTATION;

public class RoundSlam extends Proyectile{
	private BufferedImage image;
	
	
	public RoundSlam (int pX, int pY, ORIENTATION sight, int pSpeed) {
		super(pX, pY, sight, pSpeed);

		String url = null;
		
		switch(sight) {
		case EAST:
			url = "/robotwar/images/punchSD.png";
			break;
		case WEST:
			url ="/robotwar/images/punchSD.png";
			break;
		case SOUTH:
			url = "/robotwar/images/punchSD.png";
			break;
		case NORTH:
			url = "/robotwar/images/punchSD.png";
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
		pGp.drawImage(image, PosX, PosY, 60, 60, null);
	}
	
}
