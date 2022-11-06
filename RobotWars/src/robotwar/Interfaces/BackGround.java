package robotwar.Interfaces;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BackGround {
    BufferedImage image;
    

    public BackGround(String ruta) {
    	
        try {
			image = ImageIO.read(getClass().getResource(ruta));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    public void draw(Graphics2D g2) {
        g2.drawImage(image, 0, 0, 1200, 800, null);

    }

}