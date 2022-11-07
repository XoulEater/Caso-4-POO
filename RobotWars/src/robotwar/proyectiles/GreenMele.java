package robotwar.proyectiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import robotwar.common.robotbase.ORIENTATION;

public class GreenMele extends Proyectile{
	private BufferedImage image;
	public GreenMele(int pX, int pY, ORIENTATION sight, int pSpeed) {
		
		super(pX, pY, sight, pSpeed);
		try {	
			image = ImageIO.read(getClass().getResource("/robotwar/images/BulletSun.png"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	@Override
	public void setDraw(Graphics2D pGp) {
		pGp.drawImage(image, PosX-10, PosY-10, 20, 20, null);
		
	}
}
