package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.IVariables;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;
import robotwar.gamebasics.IRobotito;
import robotwar.proyectiles.AxeSlam;

public class LavaAxe extends Weapon {

	public LavaAxe(IRobotito pRobot) {
		super(1, 6, 15, pRobot);
		image = "/robotwar/images/mel_b1.png";
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
				varS.addProyectile(new AxeSlam(pPosX + 50, pPosY - 20, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.EAST;
				break;
			case WEST:
				varS.addProyectile(new AxeSlam(pPosX + 45, pPosY - 20, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.WEST;
				break;
			}
		} else {
			switch (pDirection) {
			case EAST:
				varS.addProyectile(new AxeSlam(pPosX + 5, pPosY - 20, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.EAST;
				break;
			case WEST:
				varS.addProyectile(new AxeSlam(pPosX + 0, pPosY - 20, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.WEST;
				break;
			}
		}
		double consumo = 0.3 * this.level;
		consumo += consumo * 0.10 * 20 / 20;
		this.robot.energy -= consumo;
		cooldown = 20;
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
			image = "/robotwar/images/mel_b1.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 14, 0, 40, 100);
			if (slot == 1) {
				weaponBound.set(0, weaponBound.get(0) + 77);
			}
			break;
		case WEST:
			image = "/robotwar/images/mel_b1I.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 60, 0, 40, 100);
			if (slot == 1) {
				weaponBound.set(0, weaponBound.get(0) + 77);
			}
			break;
		case SOUTH:
			break;
		case NORTH:
			break;
		}

	}

}
