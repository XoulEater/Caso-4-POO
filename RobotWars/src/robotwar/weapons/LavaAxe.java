package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class LavaAxe extends Weapon{
	
	public LavaAxe(int pSpeed) {
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
			image = "/robotwar/images/mel_b1.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 14, 0, 40, 100);
			if (slot == 0) {
				weaponBound.set(0, weaponBound.get(0) + 77);
			}
			break;
		case WEST:
			image = "/robotwar/images/mel_b1I.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 60, 0, 40, 100);
			if (slot == 0) {
				weaponBound.set(0, weaponBound.get(0) + 77);
			}
			break;
		case SOUTH:
			break;
		case NORTH:
			break;
		}
		
	}
	
}
