package robotwar.gamebasics;

import java.awt.Graphics2D;

public abstract class Trap {
	protected int posX, posY;
	protected String imageLink;
	protected Graphics2D pgp3;
	protected int level;
	protected int widht, lenght;

	public Trap(int pX, int pY) {
		this.posX = pX;
		this.posY = pY;
	}

	public abstract void draw(Graphics2D pgp3);

	public int getWidht() {
		return widht;
	}

	public int getLenght() {
		return lenght;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
