package robotwar.weapons;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import robotwar.common.IVariables;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;
import robotwar.proyectiles.SplitSlam;

public class Reaper extends Weapon{
	
	public Reaper() {
		super(1, 5, 20);
		image = "/robotwar/images/mel_b2.png";
	}
	
	@Override
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		IVariables varS = IVariables.getInstance();
		if (pDirection == ORIENTATION.SOUTH || pDirection == ORIENTATION.NORTH) {
			pDirection = lastDir;
		}
		if (slot == 1) {
			switch (pDirection) {
			case EAST:
				varS.addProyectile(new SplitSlam(pPosX + 90, pPosY + 37, pDirection, this.speed));
				lastDir = ORIENTATION.EAST;
				break;
			case WEST:
				varS.addProyectile(new SplitSlam(pPosX + 15, pPosY + 37, pDirection, this.speed));
				lastDir = ORIENTATION.WEST;
				break;
			}
		} else {
			switch (pDirection) {
			case EAST:
				varS.addProyectile(new SplitSlam(pPosX + 50, pPosY + 37, pDirection, this.speed));
				lastDir = ORIENTATION.EAST;
				break;
			case WEST:
				varS.addProyectile(new SplitSlam(pPosX - 40, pPosY + 37, pDirection, this.speed));
				lastDir = ORIENTATION.WEST;
				break;
			}
		}
		cooldown = 20;
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
			image = "/robotwar/images/mel_b2.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 90, 77, 100, 50);
			if (slot == 0) {
				weaponBound.set(0, weaponBound.get(0) - 72);
			}
			break;
		case WEST:
			image = "/robotwar/images/mel_b2I.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 73, 77, 100, 50);
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