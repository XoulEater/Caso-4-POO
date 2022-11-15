package robotwar.proyectiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import robotwar.common.IConstants;
import robotwar.common.robotbase.IRobotito;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public abstract class Proyectile {
	protected int PosX, PosY;
	protected int speed;
	protected int index;
	protected boolean outOfRange;
	protected ORIENTATION sight;
	protected IRobotito triggeredBy;
	protected int level;

	protected Proyectile(int pX, int pY, ORIENTATION pSight, int pSpeed, IRobotito pRobot, int pLevel) {
		this.level = pLevel;
		this.PosX = pX;
		this.PosY = pY;
		this.outOfRange = false;
		this.sight = pSight;
		this.speed = pSpeed;
		this.triggeredBy = pRobot;
	}

	public void setIndex(int pIndex) {
		this.index = pIndex;
	}

	public int getIndex() {
		return this.index;
	}

	public void draw(Graphics2D pGp) {
		switch (sight) {
		case EAST:
			this.PosX += speed;
			if (IConstants.ARENA_WIDTH * 2 < PosX) {
				outOfRange = true;
			}
			break;
		case NORTH:
			this.PosY -= speed;
			if (0 > PosY) {
				outOfRange = true;
			}
			break;
		case SOUTH:
			this.PosY += speed;
			if (IConstants.ARENA_HEIGTH < PosY) {
				outOfRange = true;
			}
			break;
		case WEST:
			this.PosX -= speed;
			if (0 > PosX) {
				outOfRange = true;
			}
			break;
		}
		setDraw(pGp);
	}

	public abstract void setDraw(Graphics2D pGp);

	public boolean isOutOfRange() {
		return outOfRange;
	}

	public int getPosX() {
		return PosX;
	}

	public int getPosY() {
		return PosY;
	}
	
	public IRobotito getRobot() {
		return this.triggeredBy;
	}

	public void setInvalid() {
		this.outOfRange = true;
	}

	public int getLevel() {
		return level;
	}
	
}
