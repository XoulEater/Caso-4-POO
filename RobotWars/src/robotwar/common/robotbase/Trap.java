package robotwar.common.robotbase;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import robotwar.Interfaces.GameInterface;

public abstract class Trap {
	protected int posX, posY;
	protected String imageLink;
	protected Graphics2D pgp3;
	protected int level;
	protected int widht, lenght; 
	
	public Trap (int pX, int pY)
	{
		this.posX = pX;
		this.posY = pY;
	}

	public abstract void draw (Graphics2D pgp3) ;

	public int getWidht() {
		return widht;
	}

	public int getLenght() {
		return lenght;
	}
	
}
