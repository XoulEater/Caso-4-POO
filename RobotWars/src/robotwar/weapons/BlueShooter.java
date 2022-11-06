package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class BlueShooter extends Weapon{
	
	public BlueShooter(int pSpeed) {
		super(pSpeed);
		image = "/robotwar/images/ran_b2.png";
	}
	

	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}

	@Override
	public String getImage() {
		return image;
	}

	@Override
	public List<Integer> getLocation() {
		return weaponBound;
	}

	@Override
	public void UpdateImage(ORIENTATION pDirection) {
		switch(pDirection) {
		case EAST:
			image = "/robotwar/images/ran_b2.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 45,40, 50,35);
			break;
		case WEST:
			image = "/robotwar/images/ran_b2I.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 95,40, 50,35);
			break;
		case SOUTH:
			image = "/robotwar/images/ran_b2D.png";
			break;
		case NORTH:
			image = "/robotwar/images/ran_b2U.png";
			break;
		}
		
	}
	
}