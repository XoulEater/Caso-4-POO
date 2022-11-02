package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Placement;
import robotwar.common.robotbase.Weapon;

public class Warhammer extends Weapon{
	
	public Warhammer(int pSpeed) {
		super(pSpeed);
	}
	
	public String getImage(String dir) {
		return "/robotwar/images/mel_g1.png";
		
	}
	
	public List<Integer> getLocation(String dir)
	{
		switch(dir) {
		case "right":
			
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace, 0, 0, 50,100);
			if (slot == 1) {
				lastPlace.set(0, lastPlace.get(0) + 72);
			}
			break;
		case "left":
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace, 68, 0, 50,100);
			if (slot == 1) {
				lastPlace.set(0, lastPlace.get(0) + 72);
			}
			break;
		}

			
		return lastPlace;
	}
	
	@Override
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
}
