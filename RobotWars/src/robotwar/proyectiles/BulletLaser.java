package robotwar.proyectiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import robotwar.common.robotbase.ORIENTATION;

public class BulletLaser extends Proyectile {
	private BufferedImage image;
	public BulletLaser(int pX, int pY, ORIENTATION sight, int pSpeed) {
		
		super(pX, pY, sight, pSpeed);
		String url = null;
		
		switch(sight) {
		case EAST:
			url = "/robotwar/images/lazer.png";
			break;
		case WEST:
			url = "/robotwar/images/lazerI.png";
			break;
	case SOUTH:
			url = "/robotwar/images/lazerD.png";
			break;
	case NORTH:
		url = "/robotwar/images/lazerU.png";
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
		pGp.drawImage(image, PosX-40, PosY-10, 20, 20, null);
		
	}
}
