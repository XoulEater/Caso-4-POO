package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Placement;
import robotwar.common.robotbase.Weapon;

public class Hades extends Weapon{
	
	public Hades(int pSpeed) {
		super(pSpeed);
	}
	
	public String getImage(String dir) {
		switch(dir) {
		case "right":
			lastDir = "/robotwar/images/mel_g2.png";
			break;
		case "left":
			lastDir = "/robotwar/images/mel_g2I.png";
			break;
		}

		return lastDir;
	}
	
	public List<Integer> getLocation(String dir)
	{
		switch(dir) {
		case "right":
			
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace,92, 63, 90, 60);
			
			if (slot == 0) {
				lastPlace.set(0, lastPlace.get(0) - 72);
			}
			break;
		case "left":
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace,79, 63, 90, 60);
			
			if (slot == 0) {
				lastPlace.set(0, lastPlace.get(0) - 72);
			}
			break;
		}

		
		return lastPlace;
	}
	
	@Override
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
}