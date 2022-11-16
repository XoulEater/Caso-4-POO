package robotwar.common.robotbase;

import java.util.List;

import robotwar.gamebasics.IRobotito;

public abstract class Weapon extends DamageLevel {
	protected int posX;
	protected int posY;
	protected int speed;
	protected int level;
	protected int attackDistance;
	protected String image;
	protected List<Integer> weaponBound;
	protected int slot;
	protected int cooldown;
	protected ORIENTATION lastDir = ORIENTATION.WEST;
	protected IRobotito robot;

	public Weapon(int pSpeed, int pLevel, int pAttackDistance, IRobotito pRobot) {
		this.speed = pSpeed;
		this.level = pLevel;
		this.attackDistance = pAttackDistance;
		this.robot = pRobot;
	}

	public void fire(int pPosX, int pPosY, ORIENTATION pDirection) {
		if (this.isEnabled()) {
			this.triggerWeapon(pPosX, pPosY, pDirection);
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

	public void decCooldown() {
		this.cooldown -= 1;
	}

	public int getCooldown() {
		return cooldown;
	}

}
