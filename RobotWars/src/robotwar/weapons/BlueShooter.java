package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Placement;
import robotwar.common.robotbase.Weapon;

public class BlueShooter extends Weapon{
	
	public BlueShooter(int pSpeed) {
		super(pSpeed);
	}
	
	public String getImage(String dir) {
		switch(dir) {
		case "right":
			lastDir = "/robotwar/images/ran_b2.png";
			break;
		case "left":
			lastDir = "/robotwar/images/ran_b2I.png";
			break;
		case "up":
			lastDir = "/robotwar/images/ran_b2U.png";
			break;
		case "down":
			lastDir = "/robotwar/images/ran_b2D.png";
			break;
		}

		return lastDir;
	}
	
	public List<Integer> getLocation(String dir)
	{
		switch(dir) {
		case "right":
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace,60, 30, 65, 30);
			break;
		case "left":
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace,60, 30, 65, 30);
			break;
			
		case "up":
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace,60, 13, 30, 65);
			break;
			
		case "down":
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace,60, 13, 30, 65);
			break;
		}
		return lastPlace;
	}


	@Override
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
}