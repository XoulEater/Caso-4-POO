package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class GreenScope extends Weapon{
	
	public GreenScope(int pSpeed) {
		super(pSpeed);
		image = "/robotwar/images/ran_g1.png";
	}
	
	@Override
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
			image = "/robotwar/images/ran_g1.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 45,35, 50,35);
			break;
		case WEST:
			image = "/robotwar/images/ran_g1I.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 95,35, 50,35);
			break;
		case SOUTH:
			image = "/robotwar/images/ran_g1D.png";
			break;
		case NORTH:
			image = "/robotwar/images/ran_g1U.png";
			break;
		}
		
	}
	
}