package robotwar.proyectiles;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import robotwar.common.robotbase.ORIENTATION;

public class BigSlam extends Proyectile {
	private BufferedImage image;
	private int counter = 10;

	public BigSlam(int pX, int pY, ORIENTATION sight, int pSpeed) {
		super(pX, pY, sight, pSpeed);

		String url = null;

		switch (sight) {
		case EAST:
			url = "/robotwar/images/hadesS.png";
			break;
		case WEST:
			url = "/robotwar/images/hadesSI.png";
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
			pGp.drawImage(image, PosX, PosY, 70, 70, null);
			--counter;
		} else {
			outOfRange = true;
		}
	}

}
