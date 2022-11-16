package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.IVariables;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;
import robotwar.gamebasics.IRobotito;
import robotwar.proyectiles.BigSlam;
import robotwar.proyectiles.BulletRocket;
import robotwar.proyectiles.ReaperSlam;

public class Hades extends Weapon {

	public Hades(IRobotito pRobot) {
		super(1, 8, 20, pRobot);
		image = "/robotwar/images/mel_g2.png";
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
						new ReaperSlam(pPosX + 90, pPosY + 37, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.EAST;
				break;
			case WEST:
				varS.addProyectile(
						new ReaperSlam(pPosX + 0, pPosY + 37, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.WEST;
				break;
			}
		} else {
			switch (pDirection) {
			case EAST:
				varS.addProyectile(
						new ReaperSlam(pPosX + 50, pPosY + 37, pDirection, this.speed, this.robot, this.level));
				lastDir = ORIENTATION.EAST;
				break;
			case WEST:
				varS.addProyectile(
						new ReaperSlam(pPosX - 40, pPosY + 37, pDirection, this.speed, this.robot, this.level));
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
			image = "/robotwar/images/mel_g2.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 92, 63, 90, 60);
			if (slot == 0) {
				weaponBound.set(0, weaponBound.get(0) - 72);
			}
			break;
		case WEST:
			image = "/robotwar/images/mel_g2I.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 79, 63, 90, 60);
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