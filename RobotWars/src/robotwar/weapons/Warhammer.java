package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import robotwar.common.IVariables;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;
import robotwar.gamebasics.IRobotito;
import robotwar.proyectiles.HammerSlam;

public class Warhammer extends Weapon {

	public Warhammer(IRobotito pRobot) {
		super(1, 6, 15, pRobot);

		image = "/robotwar/images/mel_g1.png";
	}

	public String getImage(String dir) {
		return image;
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
						new HammerSlam(pPosX + 20, pPosY - 20, ORIENTATION.NORTH, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.EAST;
				break;
			case WEST:
				varS.addProyectile(
						new HammerSlam(pPosX + 60, pPosY - 20, ORIENTATION.NORTH, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.WEST;
				break;
			}
		} else {
			switch (pDirection) {
			case EAST:
				varS.addProyectile(
						new HammerSlam(pPosX - 15, pPosY - 20, ORIENTATION.NORTH, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.EAST;
				break;
			case WEST:
				varS.addProyectile(
						new HammerSlam(pPosX + 20, pPosY - 20, ORIENTATION.NORTH, this.speed, this.robot, this.level));
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
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 0, 0, 50, 100);
			if (slot == 1) {
				weaponBound.set(0, weaponBound.get(0) + 72);
			}
			break;
		case WEST:

			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 68, 0, 50, 100);
			if (slot == 1) {
				weaponBound.set(0, weaponBound.get(0) + 72);
			}
			break;
		case SOUTH:
			break;
		case NORTH:
			break;
		}

	}

}