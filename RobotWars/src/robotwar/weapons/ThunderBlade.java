package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Placement;
import robotwar.common.robotbase.Weapon;


public class ThunderBlade extends Weapon{
	private int pSpeed;
	
	public ThunderBlade(int pSpeed) {
		super(pSpeed);
	}
	
	public String getImage(String dir) {
		switch(dir) {
		case "right":
			lastDir = "/robotwar/images/mel_g3.png";
			break;
		case "left":
			lastDir = "/robotwar/images/mel_g3I.png";
			break;
		}
		return lastDir;
		
	}
	
	public List<Integer> getLocation(String dir)
	{
		switch(dir) {
		case "right":
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace, 90, 75, 100,30);
			break;
		case "left":
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace, 71, 75, 100,30);
			break;
		}
		
		return lastPlace;
	}


	@Override
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
	
}
