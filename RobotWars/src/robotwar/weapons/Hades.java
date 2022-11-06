package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class Hades extends Weapon{
	
	public Hades(int pSpeed) {
		super(pSpeed);
		image = "/robotwar/images/mel_b2.png";
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
			image = "/robotwar/images/mel_g2.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 92, 63, 90, 60);
			if (slot == 0) {
				weaponBound.set(0, weaponBound.get(0) - 72);
			}
			break;
		case WEST:
			image = "/robotwar/images/mel_g2I.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 79, 63, 90, 60);
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