package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.IVariables;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;
import robotwar.gamebasics.IRobotito;
import robotwar.proyectiles.BulletRocket;

public class BlueRocket extends Weapon {

	public BlueRocket(IRobotito pRobot) {
		super(30, 3, 150, pRobot);
		image = "/robotwar/images/ran_b1.png";
	}

	@Override
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		IVariables varS = IVariables.getInstance();
		varS.addProyectile(new BulletRocket(pPosX + weaponBound.get(0), pPosY + weaponBound.get(1), pDirection,
				this.speed, this.robot, this.level));
		cooldown = 40;
		double consumo = 0.2 * this.level;
		consumo += consumo * 0.15 * 600 / 100;
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
			image = "/robotwar/images/ran_b1.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 45, 40, 50, 35);
			break;
		case WEST:
			image = "/robotwar/images/ran_b1I.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 95, 40, 50, 35);
			break;
		case SOUTH:
			image = "/robotwar/images/ran_b1D.png";
			break;
		case NORTH:
			image = "/robotwar/images/ran_b1U.png";
			break;
		}
	}
}