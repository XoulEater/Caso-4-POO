package robotwar.common.robotbase;

public abstract class Weapon extends DamageLevel {

	private int speed;
	
	public Weapon(int pSpeed) {
		this.speed = pSpeed;
	}
	
	public void fire(int pPosX, int pPosY, ORIENTATION pDirection) {
		if (this.isEnabled()) {
			triggerWeapon(pPosX, pPosY, pDirection);
		}
	}
	
	protected abstract void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection);
}
