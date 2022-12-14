package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import robotwar.common.IVariables;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;
import robotwar.gamebasics.IRobotito;
import robotwar.proyectiles.SplitSlam;

public class Reaper extends Weapon {

	public Reaper(IRobotito pRobot) {
		super(1, 5, 20, pRobot);
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
				varS.addProyectile(
						new SplitSlam(pPosX + 90, pPosY + 37, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.EAST;
				break;
			case WEST:
				varS.addProyectile(new SplitSlam(pPosX, pPosY + 37, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.WEST;
				break;
			}
		} else {
			switch (pDirection) {
			case EAST:
				varS.addProyectile(
						new SplitSlam(pPosX + 50, pPosY + 37, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.EAST;
				break;
			case WEST:

				varS.addProyectile(
						new SplitSlam(pPosX - 40, pPosY + 37, pDirection, this.speed, this.robot, this.level));

				lastDir = ORIENTATION.WEST;
				break;
			}
		}
		double consumo = 0.3 * this.level;
		consumo += consumo * 0.10 * 50 / 20;
		this.robot.energy -= consumo;
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