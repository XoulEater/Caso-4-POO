package robotwar.MeleSlam;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import robotwar.common.robotbase.ORIENTATION;

public class BigSlam extends Slam{
	private BufferedImage image;
	
	public BigSlam (int pX, int pY, ORIENTATION sight, int pSpeed) {
		super(pX, pY, sight, pSpeed);
		try {	
			image = ImageIO.read(getClass().getResource("/robotwar/images/BulletSun.png"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}	

	@Override
	public void setDraw(Graphics2D pGp) {
		pGp.drawImage(image, PosX, PosY, 40, 40, null);
	}
	
}
