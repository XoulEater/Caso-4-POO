package robotwar.MainRobots;

import java.awt.Image;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import robotwar.common.robotbase.*;
import robotwar.weapons.*;

public class FactoryController {
	SelectInterface window;
	IRobotito nRobot = new GreenRobot();
	String playerName;

	public void setWindow(SelectInterface selectInterface) {
		this.window = selectInterface;

	}

	public void setRobot(String type) {
		switch (type) {
		case "Green":
			System.out.println("Creando robot verde");
			nRobot = new GreenRobot();
			updateData();
			break;
		case "Blue":
			System.out.println("Creando robot azul");
			nRobot = new BlueRobot();
			updateData();
			break;
		}

	}

	public void setHead(String type, int id) {
		if ("Green".equals(type) && "Green".equals(nRobot.getType())) {
			switch (id) {
			case 1:
				System.out.println("Creando GreenScope");
				nRobot.addStrike(new GreenScope(0));
				updateData();
				break;
			case 2:
				System.out.println("Creando GreenLaser");
				nRobot.addStrike(new GreenLaser(0));
				updateData();
				break;
			}
		} else if ("Blue".equals(type) && "Blue".equals(nRobot.getType())) {
			switch (id) {
			case 1:
				System.out.println("Creando BlueShooter");
				nRobot.addStrike(new BlueShooter(0));
				updateData();
				break;
			case 2:
				System.out.println("Creando BlueRocket");
				nRobot.addStrike(new BlueRocket(0));
				updateData();
				break;
			}
		}

	}

	public void setWeapon(String type, int id) {
		if ("Green".equals(type) && "Green".equals(nRobot.getType())) {
			switch (id) {
			case 1:
				System.out.println("Creando Warhammer");
				nRobot.addWeapon(new Warhammer(0));
				updateData();
				break;
			case 2:
				System.out.println("Creando ThunderBlade");
				nRobot.addWeapon(new ThunderBlade(0));
				updateData();
				break;
			case 3:
				System.out.println("Creando Hades");
				nRobot.addWeapon(new Hades(0));
				updateData();
				break;
			}
		} else if ("Blue".equals(type) && "Blue".equals(nRobot.getType())) {
			switch (id) {
			case 1:
				System.out.println("Creando LavaAxe");
				nRobot.addWeapon(new LavaAxe(0));
				updateData();
				break;
			case 2:
				System.out.println("Creando Reaper");
				nRobot.addWeapon(new Reaper(0));
				updateData();
				break;
			case 3:
				System.out.println("Creando PunchArm");
				nRobot.addWeapon(new PunchArm(0));
				updateData();
				break;
			}
		}
	}

	public boolean confirm() {
		boolean resul = false;
		if (nRobot != null) {
			Stream<Weapon> armas = nRobot.getWeapons();

			if (armas.noneMatch((x -> x == null))) {
				System.out.println("Rodrigo valida este robot");
				this.window.setVisible(false);
				resul = true;
			
			}

		}
		return resul;
	}

	public IRobotito getRobot() {
		return confirm() ? nRobot : null;
	}


	public void updateData() {
		ImageIcon iconR = new ImageIcon(getClass().getResource(nRobot.getImage()));
		Icon icon0 = new ImageIcon(
				iconR.getImage().getScaledInstance(iconR.getIconWidth(), iconR.getIconHeight(), Image.SCALE_DEFAULT));
		window.robot.setIcon(icon0);

		List<Weapon> armas = nRobot.getWeapons().toList();

		
		if (armas.get(0) != null) {
			ImageIcon iconH = new ImageIcon(getClass().getResource(armas.get(0).getImage()));
			Icon icon1 = new ImageIcon(iconH.getImage().getScaledInstance(iconH.getIconWidth(), iconH.getIconHeight(),
					Image.SCALE_DEFAULT));
			window.head.setIcon(icon1);
			window.head.setVisible(true);
		} else {
			window.head.setVisible(false);
		}
		if (armas.get(1) != null) {
			ImageIcon iconW1 = new ImageIcon(getClass().getResource(armas.get(1).getImage()));
			Icon icon2 = new ImageIcon(iconW1.getImage().getScaledInstance(iconW1.getIconWidth(), iconW1.getIconHeight(),
					Image.SCALE_DEFAULT));
			window.arma1.setIcon(icon2);
			window.arma1.setVisible(true);
		} else {
			window.arma1.setVisible(false);
		}
		if (armas.get(2) != null) {
			ImageIcon iconW2 = new ImageIcon(getClass().getResource(armas.get(2).getImage()));
			Icon icon3 = new ImageIcon(iconW2.getImage().getScaledInstance(iconW2.getIconWidth(), iconW2.getIconHeight(),
					Image.SCALE_DEFAULT));
			window.arma2.setIcon(icon3);
			window.arma2.setVisible(true);
		} else {
			window.arma2.setVisible(false);
		}
	}
}