package robotwar.traps;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import robotwar.gamebasics.Trap;

public class Spike extends Trap {

	public Spike(int pX, int pY) {
		super(pX, pY);
		this.widht = 100;
		this.lenght = 100;
	}

	@Override
	public void draw(Graphics2D pGp) { // "/robotwar/images/sierra.gif"
		ImageIcon imageGif = new ImageIcon(getClass().getResource("/robotwar/images/spike.gif"));
		pGp.drawImage(imageGif.getImage(), posX, posY, 80, 80, null);
	}

}