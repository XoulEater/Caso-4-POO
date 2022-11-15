package robotwar.proyectiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import robotwar.common.robotbase.IRobotito;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class BulletFire extends Proyectile{
	private BufferedImage image;
	public BulletFire(int pX, int pY, ORIENTATION sight, int pSpeed, IRobotito pRobot, int pLevel) {
		super(pX, pY, sight, pSpeed, pRobot, pLevel);
	try {
		image = ImageIO.read(getClass().getResource("/robotwar/images/B1.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	@Override
	public void setDraw(Graphics2D pGp) {
		
		pGp.drawImage(image, PosX-15, PosY-5, 20, 20, null);
		
	}
}
