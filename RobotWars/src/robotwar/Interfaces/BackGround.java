package robotwar.Interfaces;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackGround {
	GameInterface gp;
	Tile[] tile;

	public BackGround (GameInterface pGp)
	{
		this.gp = pGp;
		
		tile = new Tile[10];
		
		getTileImage();
	}
	
	public void getTileImage()
	{
		try {
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResource("/robotwar/images/metalBg_1.png"));
			
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}	
	}
	public void draw(Graphics2D g2)
	{
		g2.drawImage(tile[1].image, 0,0 ,1200,800, null);
		
	}
	

	
	 
}
