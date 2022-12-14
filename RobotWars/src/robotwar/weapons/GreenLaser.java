package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.IVariables;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;
import robotwar.gamebasics.IRobotito;
import robotwar.proyectiles.BulletLaser;

public class GreenLaser extends Weapon {

	public GreenLaser(IRobotito pRobot) {
		super(15, 1, 200, pRobot);
		image = "/robotwar/images/ran_g2.png";
	}

	@Override
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		IVariables varS = IVariables.getInstance();
		if (pDirection == ORIENTATION.EAST || pDirection == ORIENTATION.WEST) {
			lastDir = pDirection;
		}
		switch (lastDir) {
		case EAST:
			varS.addProyectile(new BulletLaser(pPosX + 30, pPosY + 28, pDirection, this.speed, this.robot, this.level));
			lastDir = ORIENTATION.EAST;
			break;
		case WEST:
			varS.addProyectile(new BulletLaser(pPosX + 45, pPosY + 28, pDirection, this.speed, this.robot, this.level));
			lastDir = ORIENTATION.WEST;
			break;
		}
		cooldown = 5;
		double consumo = 0.2 * this.level;
		consumo += consumo * 0.15 * 200 / 100;
		this.robot.energy -= consumo;
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
			image = "/robotwar/images/ran_g2.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 45, 35, 50, 35);
			break;
		case WEST:
			image = "/robotwar/images/ran_g2I.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 95, 35, 50, 35);
			break;
		case SOUTH:
			image = "/robotwar/images/ran_g2D.png";
			break;
		case NORTH:
			image = "/robotwar/images/ran_g2U.png";
			break;
		}

	}

}