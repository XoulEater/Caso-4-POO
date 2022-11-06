package robotwar.common.robotbase;

import java.util.List;

public abstract class Weapon extends DamageLevel {

	private int posX;
	private int posY;
	private int level;
	protected int speed;
	
	protected String image;
	protected List<Integer> weaponBound;
	protected int slot;
	
	public Weapon(int pSpeed) {
		this.speed = pSpeed;
//		position.setPos(5, 12);
//		position.setSize(2, 4);	
	}
	public void fire(int pPosX, int pPosY, ORIENTATION pDirection) {
		if (this.isEnabled()) {
			triggerWeapon(pPosX, pPosY, pDirection);
		}
	}
	protected abstract void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection);
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public abstract String getImage();
	
	public abstract List<Integer> getLocation();

	public abstract void UpdateImage(ORIENTATION pDirection);
	
}
