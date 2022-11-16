package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.IVariables;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;
import robotwar.gamebasics.IRobotito;
import robotwar.proyectiles.RoundSlam;

public class PunchArm extends Weapon {

	public PunchArm(IRobotito pRobot) {
		super(1, 8, 35, pRobot);

		image = "/robotwar/images/mel_b3.png";
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
						new RoundSlam(pPosX + 80, pPosY + 30, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.EAST;
				break;
			case WEST:
				varS.addProyectile(
						new RoundSlam(pPosX + 10, pPosY + 30, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.WEST;
				break;
			}
		} else {
			switch (pDirection) {
			case EAST:
				varS.addProyectile(
						new RoundSlam(pPosX + 40, pPosY + 30, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.EAST;
				break;
			case WEST:
				varS.addProyectile(
						new RoundSlam(pPosX - 20, pPosY + 30, pDirection, this.speed, this.robot, this.level));
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
			image = "/robotwar/images/mel_b3.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 90, 80, 100, 32);
			if (slot == 0) {
				weaponBound.set(0, weaponBound.get(0) - 70);
			}
			break;
		case WEST:
			image = "/robotwar/images/mel_b3I.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 70, 80, 100, 32);
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