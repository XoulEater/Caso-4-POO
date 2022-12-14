package robotwar.proyectiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;
import robotwar.gamebasics.IRobotito;

public class BulletLaser extends Proyectile {
	private BufferedImage image;
	private int counter = 13; 
	public BulletLaser(int pX, int pY, ORIENTATION sight, int pSpeed, IRobotito pRobot, int pLevel) {
		super(pX, pY, sight, pSpeed, pRobot, pLevel);
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
		if (counter != 0) {
			pGp.drawImage(image, PosX, PosY, 20, 20, null);
			--counter; 
		} else {
			outOfRange = true;
		}
		
	}
}
