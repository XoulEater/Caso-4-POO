package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Placement;
import robotwar.common.robotbase.Weapon;

public class LavaAxe extends Weapon{
	
	public LavaAxe(int pSpeed) {
		super(pSpeed);
	}
	
	public String getImage(String dir) {
		switch(dir) {
		case "right":
			lastDir = "/robotwar/images/mel_b1.png";
			break;
		case "left":
			lastDir = "/robotwar/images/mel_b1I.png";
			break;
		}
		return lastDir;
		
	}
	
	public List<Integer> getLocation(String dir)
	{
		switch(dir) {
		case "right":
			
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace, 14, 0, 40, 100);
			break;
		case "left":
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace, 60, 0, 40, 100);
			break;
		}
		return lastPlace;
	}
	
	@Override
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
}
