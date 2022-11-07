package robotwar.proyectiles;

import java.io.IOException;

import javax.imageio.ImageIO;

import robotwar.common.robotbase.ORIENTATION;

public class BulletFire extends Proyectile{

	public BulletFire(int pX, int pY, ORIENTATION sight, int pSpeed) {
		// Creo que se toma del singelton
		super(pX, pY, sight, pSpeed);
		try {
			image = ImageIO.read(getClass().getResource("/robotwar/images/B1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}