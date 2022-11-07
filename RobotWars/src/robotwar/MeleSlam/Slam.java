package robotwar.MeleSlam;

import java.awt.Graphics2D;

import robotwar.common.IConstants;
import robotwar.common.robotbase.ORIENTATION;

public abstract class Slam {
	protected int PosX, PosY;
	protected int speed;
	protected int index;
	protected boolean outOfRange;
	protected ORIENTATION sight;
	
	protected Slam(int pX, int pY, ORIENTATION pSight, int pSpeed) {

		this.PosX = pX;
		this.PosY = pY;
		this.outOfRange = false;
		this.sight = pSight;
		this.speed = pSpeed;
	}
	
	public void setIndex(int pIndex) {
		this.index = pIndex;
	}

	public int getIndex() {
		return this.index;
	}

	public void draw(Graphics2D pGp) {
		setDraw(pGp);
	}

public abstract void setDraw(Graphics2D pGp);
	
}
