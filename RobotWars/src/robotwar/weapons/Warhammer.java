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
		switch(dir) {
		case "right":
			lastDir = "/robotwar/images/mel_g1.png";
			break;
		case "left":
			lastDir = "/robotwar/images/mel_g1.png";
			break;
		}

		return lastDir;
		
	}
	
	public List<Integer> getLocation(String dir)
	{
		switch(dir) {
		case "right":
			
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace, 0, 0, 50,100);
			break;
		case "left":
			lastPlace = new ArrayList<>();
			Collections.addAll(lastPlace, 68, 0, 50,100);
			break;
		}
		
		return lastPlace;
	}
	
	@Override
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		
	}
}
