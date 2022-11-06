package robotwar.Traps;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import robotwar.Interfaces.GameInterface;
import robotwar.common.robotbase.*;

public class Saw extends Trap {

	public Saw(int pX, int pY) {
		super(pX, pY);
	}

	@Override
	public void draw(Graphics2D pGp) { // "/robotwar/images/sierra.gif"
		ImageIcon imageGif = new ImageIcon(getClass().getResource("/robotwar/images/sierra.gif"));
		pGp.drawImage(imageGif.getImage(), posX, posY, 100, 100, null);
	}

}
