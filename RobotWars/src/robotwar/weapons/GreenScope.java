package robotwar.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import robotwar.common.IVariables;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;
import robotwar.proyectiles.BulletFire;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%####(/(&@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@#%%%%%%%%%%%%%%%%%%%%%%%%%%#@@@&&%%#//*,*((#@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@############################@@@%%%%%**, .**(@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@&%%###&@@@@@@&%%###@@@@&@@@&&&%%##/,*#%&@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@%%#(#@@@@@@@@%%#(#@@@@@@@@@@@@@@@&%%@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&@@@@@@@@&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&&&&&&&%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@&&&####################(((///****(&%@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@&%%%%&&&%%%%%#####################(((/(##(*******%@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@%%%%&&&%%%%%%%%%%%%%%%%%%%%%%%%&&%%#**(%%*****/////%&&&&&&&&&&&&&&&&&&%&@@@@@
//@@@&&&&&&&%%%%%%%%%%%%%&&&&&&&&&&@@@%%#**(%%**///#####################((**/%&&@@
//@@@&&&&&&&&%%%%%%%%%%%%&&&&&&&&&&@@@%%#**(%%**(%%%%%%%%%%%%%%%%%%%%%%#/*,,,**#@@
//@@@@@@@@@@&%%%%%%%%%%%%@@@@@@@@@@@@@%%#**(%%**(%%%%%%%%%%%%%%%%%%%%%%#//,,,//#@@
//@@@@@@@@@@&%%%%%%%%%%%%%%%%%%%%%%%%%%%#**(%%*****%&&&&&&&&&&&&&&&&&&&&&&(*(@@@@@
//@@@@@@@@@@&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#////#@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@&%%%%%%%%%%%%#(#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@&%%%%%##%%%%%#(#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@%%%%%%%%%%%%%((%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@%%%%%###%%%%%((%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@%%%%%%%%%%%%%((%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

public class GreenScope extends Weapon{
	
	public GreenScope() {
		super(15, 5, 300);
		image = "/robotwar/images/ran_g1.png";
	}
	
	@Override
	public void triggerWeapon(int pPosX, int pPosY, ORIENTATION pDirection) {
		System.out.println("Disparando2");
		IVariables varS = IVariables.getInstance();
		varS.addProyectile(new BulletFire(pPosX + weaponBound.get(0), pPosY + weaponBound.get(1), pDirection, this.speed));
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
			image = "/robotwar/images/ran_g1.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 45,35, 50,35);
			break;
		case WEST:
			image = "/robotwar/images/ran_g1I.png";
			weaponBound = new ArrayList<>();
			Collections.addAll(weaponBound, 95,35, 50,35);
			break;
		case SOUTH:
			image = "/robotwar/images/ran_g1D.png";
			break;
		case NORTH:
			image = "/robotwar/images/ran_g1U.png";
			break;
		}
		
	}
	
}