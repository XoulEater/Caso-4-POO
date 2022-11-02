package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Placement;
import robotwar.common.robotbase.Weapon;

public class GreenScope extends Weapon{
	
	public GreenScope(int pSpeed) {
		super(pSpeed);
	}
	
	public String getImage(String dir) {
		switch(dir) {
		case "right":
			lastDir = "/robotwar/images/ran_g1.png";
			break;
		case "left":
			lastDir = "/robotwar/images/ran_g1I.png";
			break;
		case "up":
			lastDir = "/robotwar/images/ran_g1U.png";
			break;
		case "down":
			lastDir = "/robotwar/images/ran_g1D.png";
			break;
		}

		return lastDir;
	}
	
	public List<Integer> getLocation(String dir)
	{
		switch(dir) {
		case "right":
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace,45,35, 50,35);
			break;
		case "left":
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace,45,35, 50,35);
			break;
			
		case "up":
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace,95,35, 50,35);
			break;
			
		case "down":
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace,95,35, 50,35);
			break;
		}
		
		return lastPlace;
	}

	@Override
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}

}