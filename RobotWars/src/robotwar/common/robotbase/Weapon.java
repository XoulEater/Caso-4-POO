package robotwar.common.robotbase;

import java.util.List;

public abstract class Weapon extends DamageLevel {

	protected int speed;
	protected Placement position;
	protected String lastDir ;
	protected List<Integer> lastPlace;
	
	public Weapon(int pSpeed) {
		this.speed = pSpeed;
		position = new Placement();
//		position.setPos(5, 12);
//		position.setSize(2, 4);	
	}
	public void fire(int pPosX, int pPosY, ORIENTATION pDirection) {
		if (this.isEnabled()) {
			triggerWeapon(pPosX, pPosY, pDirection);
		}
	}
	
	public void setPlacement (int a, int b, int c, int d)
	{
		position.setPos(a, b);
		position.setSize(c, d);
	}
	
	
	public List<Integer> getPosition()
	{
		return position.getPlacements();
		
	}
	
	public abstract String getImage(String dir);
	
	public abstract List<Integer> getLocation(String dir);

		
	protected abstract void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection);
}
