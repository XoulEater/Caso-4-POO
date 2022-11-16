package robotwar.MainRobots;

import java.awt.Dimension;
import java.awt.Image;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import robotwar.Interfazes.EnergyBar;
import robotwar.Interfazes.GameInterface;
import robotwar.Interfazes.RobotController;
import robotwar.Traps.Acid;
import robotwar.Traps.Fire;
import robotwar.Traps.Saw;
import robotwar.Traps.Spike;
import robotwar.common.IConstants;
import robotwar.common.IVariables;
import robotwar.common.robotbase.*;
import robotwar.gamebasics.BlueRobot;
import robotwar.gamebasics.GreenRobot;
import robotwar.gamebasics.IRobotito;
import robotwar.weapons.*;

public class FactoryController {
	SelectInterface window;
	JFrame mainWindow;
	IRobotito nRobot = new GreenRobot();
	String playerName;

	FactoryController(JFrame pmain) {
		this.mainWindow = pmain;
	}

	public void setWindow(SelectInterface selectInterface) {
		this.window = selectInterface;

	}

	public void setRobot(String type) {
		switch (type) {
		case "Green":
			nRobot = new GreenRobot();
			updateData();
			break;
		case "Blue":
			nRobot = new BlueRobot();
			updateData();
			break;
		}

	}

	public void setHead(String type, int id) {
		if ("Green".equals(type) && "Green".equals(nRobot.getType())) {
			switch (id) {
			case 1:
				nRobot.addStrike(new GreenScope(nRobot));
				updateData();
				break;
			case 2:
				nRobot.addStrike(new GreenLaser(nRobot));
				updateData();
				break;
			}
		} else if ("Blue".equals(type) && "Blue".equals(nRobot.getType())) {
			switch (id) {
			case 1:
				nRobot.addStrike(new BlueShooter(nRobot));
				updateData();
				break;
			case 2:
				nRobot.addStrike(new BlueRocket(nRobot));
				updateData();
				break;
			}
		}

	}

	public void setWeapon(String type, int id) {
		if ("Green".equals(type) && "Green".equals(nRobot.getType())) {
			switch (id) {
			case 1:
				nRobot.addWeapon(new Warhammer(nRobot));
				updateData();
				break;
			case 2:
				nRobot.addWeapon(new ThunderBlade(nRobot));
				updateData();
				break;
			case 3:
				nRobot.addWeapon(new Hades(nRobot));
				updateData();
				break;
			}
		} else if ("Blue".equals(type) && "Blue".equals(nRobot.getType())) {
			switch (id) {
			case 1:
				nRobot.addWeapon(new LavaAxe(nRobot));
				updateData();
				break;
			case 2:
				nRobot.addWeapon(new Reaper(nRobot));
				updateData();
				break;
			case 3:
				nRobot.addWeapon(new PunchArm(nRobot));
				updateData();
				break;
			}
		}
	}

	public boolean confirm(String name) {
		boolean resul = false;
		System.out.println(name);
		if (nRobot != null && !"".equals(name)) {
			Stream<Weapon> armas = nRobot.getWeapons();
			nRobot.setName(name);
			if (armas.noneMatch((Objects::isNull))) {
				this.mainWindow.dispose();
				JFrame window2 = new JFrame();
				window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window2.setResizable(false);
				window2.setTitle("RobotWars");
				window2.setPreferredSize(new Dimension(IConstants.ARENA_WIDTH, IConstants.ARENA_HEIGTH + 40));
				EnergyBar enbar = new EnergyBar(nRobot, 0, 0);
				RobotController MainGame = new RobotController(nRobot);
				nRobot.getPlayerImage();
				GameInterface interfaz2 = new GameInterface(MainGame);
				interfaz2.robot1 = nRobot;
				
				JScrollPane scroll = new JScrollPane(interfaz2);
				scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

				
				window2.add(scroll);
				window2.pack();
				window2.setLocationRelativeTo(null);
				window2.setVisible(true);
				
				JViewport viewP = scroll.getViewport();
				interfaz2.setViewP(viewP);
				
				
				MainGame.startGameThread();

			}

		}
		return resul;
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
			Icon icon2 = new ImageIcon(iconW1.getImage().getScaledInstance(iconW1.getIconWidth(),
					iconW1.getIconHeight(), Image.SCALE_DEFAULT));
			window.arma1.setIcon(icon2);
			window.arma1.setVisible(true);
		} else {
			window.arma1.setVisible(false);
		}
		if (armas.get(2) != null) {
			ImageIcon iconW2 = new ImageIcon(getClass().getResource(armas.get(2).getImage()));
			Icon icon3 = new ImageIcon(iconW2.getImage().getScaledInstance(iconW2.getIconWidth(),
					iconW2.getIconHeight(), Image.SCALE_DEFAULT));
			window.arma2.setIcon(icon3);
			window.arma2.setVisible(true);
		} else {
			window.arma2.setVisible(false);
		}
	}
}