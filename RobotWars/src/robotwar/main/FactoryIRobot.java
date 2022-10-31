package robotwar.main;

import robotwar.common.robotbase.IRobot;
import robotwar.common.robotbase.Weapon;
import robotwar.common.IConstants;

public class FactoryIRobot implements IConstants{
	private IRobot robot;
	private Weapon weapon1;
	private Weapon weapon2;
	private Weapon strike1;
	
	public FactoryIRobot () {
		robot = null;
		weapon1 = null;
		weapon2 = null;
		strike1 = null;
	}
 
	public void setRobot(IRobot Probot) {
		this.robot = Probot;
		weapon1 = null;
		weapon2 = null;
		strike1 = null;
	}

	public void setWeapon1(Weapon Pweapon) {
		this.weapon1 = Pweapon;
	}
	
	public void setWeapon2(Weapon Pweapon) {
		this.weapon2 = Pweapon;
	}

	public void setStrike1(Weapon Pstrike) {
		this.strike1 = Pstrike;
	}
	public boolean sendRobot() {
		boolean resul = false;
		if (weapon1 != null && weapon2 != null && strike1 != null) {
			
		}
		return resul;
	}
	
}
