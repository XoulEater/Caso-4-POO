package robotwar.proyectiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import robotwar.common.robotbase.IRobotito;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class BulletRocket extends Proyectile {
	ImageIcon imageGif; 
	public BulletRocket(int pX, int pY, ORIENTATION sight, int pSpeed, IRobotito pRobot, int pLevel) {
		super(pX, pY, sight, pSpeed, pRobot, pLevel);
		String url = null;
		
		switch(sight) {
		case EAST:
			url = "/robotwar/images/BulletRocket.gif";
			break;
		case WEST:
			url ="/robotwar/images/BulletRocketI.gif";
			break;
		case SOUTH:
			url = "/robotwar/images/BulletRocketD.gif";
			break;
		case NORTH:
			url = "/robotwar/images/BulletRocketU.gif";
			break;
		}
		imageGif = new ImageIcon(getClass().getResource(url));
	}
	@Override
	public void setDraw(Graphics2D pGp) {
		pGp.drawImage(imageGif.getImage(), PosX, PosY - 10, 30, 20, null);
		
	}
}
