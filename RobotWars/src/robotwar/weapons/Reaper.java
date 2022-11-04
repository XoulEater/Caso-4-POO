package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class Reaper extends Weapon{
	
	public Reaper(int pSpeed) {
		super(pSpeed);
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
			image = "/robotwar/images/mel_b2.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 90, 77, 100, 50);
			if (slot == 0) {
				weaponBound.set(0, weaponBound.get(0) - 72);
			}
			break;
		case WEST:
			image = "/robotwar/images/mel_b2I.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 73, 77, 100, 50);
			if (slot == 0) {
				weaponBound.set(0, weaponBound.get(0) - 72);
			}
			break;
		case SOUTH:
			break;
		case NORTH:
			break;
		}
		
	}
	
}