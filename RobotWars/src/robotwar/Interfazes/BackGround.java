package robotwar.Interfazes;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackGround {
	BufferedImage image1;
	BufferedImage image2;

	public BackGround(String ruta1, String ruta2) {
		try {
			image2 = ImageIO.read(getClass().getResource(ruta2));
			image1 = ImageIO.read(getClass().getResource(ruta1));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BackGround(String ruta1) {
		try {
			image1 = ImageIO.read(getClass().getResource(ruta1));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g2) {
		g2.drawImage(image1, 0, 0, 1200, 800, null);
		g2.drawImage(image2, 1200, 0, 1200, 800, null);
	}
}
