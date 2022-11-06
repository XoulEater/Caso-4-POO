package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public class Warhammer extends Weapon{
	
	public Warhammer(int pSpeed) {
		super(pSpeed);
		image = "/robotwar/images/mel_g1.png";
	}
	
	public String getImage(String dir) {
		return image;
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
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 0, 0, 50,100);
			if (slot == 1) {
				weaponBound.set(0, weaponBound.get(0) + 72);
			}
			break;
		case WEST:
			
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 68, 0, 50,100);
			if (slot == 1) {
				weaponBound.set(0, weaponBound.get(0) + 72);
			}
			break;
		case SOUTH:
			break;
		case NORTH:
			break;
		}
		
	}
	
}