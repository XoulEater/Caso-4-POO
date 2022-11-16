package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import robotwar.common.IVariables;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;
import robotwar.gamebasics.IRobotito;
import robotwar.proyectiles.BladeSlam;

public class ThunderBlade extends Weapon {
	public ThunderBlade(IRobotito pRobot) {
		super(1, 10, 13, pRobot);
		image = "/robotwar/images/mel_g3.png";

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
				varS.addProyectile(
						new BladeSlam(pPosX + 90, pPosY + 53, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.EAST;
				break;
			case WEST:

				varS.addProyectile(
						new BladeSlam(pPosX - 20, pPosY + 53, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.WEST;
				break;
			}
		} else {
			switch (pDirection) {
			case EAST:
				varS.addProyectile(
						new BladeSlam(pPosX + 60, pPosY + 53, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.EAST;
				break;
			case WEST:
				varS.addProyectile(
						new BladeSlam(pPosX - 60, pPosY + 53, pDirection, this.speed, this.robot, this.level));
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
		switch (pDirection) {
		case EAST:
			image = "/robotwar/images/mel_g3.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 90, 75, 100, 30);
			if (slot == 0) {
				weaponBound.set(0, weaponBound.get(0) - 70);
			}
			break;
		case WEST:
			image = "/robotwar/images/mel_g3I.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 70, 75, 100, 30);
			if (slot == 0) {
				weaponBound.set(0, weaponBound.get(0) - 70);
			}
			break;
		case SOUTH:
			break;
		case NORTH:
			break;
		}

	}

}
