package robotwar.Interfazes;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import robotwar.common.IVariables;
import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.Trap;
import robotwar.gamebasics.BlueRobot;
import robotwar.gamebasics.IRobotito;
import robotwar.proyectiles.Proyectile;
import robotwar.weapons.BlueShooter;
import robotwar.weapons.PunchArm;
import robotwar.weapons.Reaper;

public class RobotController implements Runnable {
	private GameInterface contolledFrame;
	private IRobotito robot1;
	public IRobotito robot2;
	public Key control;
	public Key control2;
	public LocalTime time;
	private MOVEMENT mov;
	private Thread gameThread;

	public RobotController(IRobotito robot) {
		robot1 = robot;
		robot2 = new BlueRobot();
		robot2.addStrike(new BlueShooter(robot2));
		robot2.addWeapon(new Reaper(robot2));
		robot2.addWeapon(new PunchArm(robot2));
		robot2.getPlayerImage();
		EnergyBar enbar = new EnergyBar(robot2, 1200 - 280, 0);
	}

	public void setControl(Key pControl) {
		this.control = pControl;
	}

	public void setWindow(GameInterface pRobotmainFrame) { // Para interfaz
		contolledFrame = pRobotmainFrame;
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	private void updateRobots() {
		robot1.setCurrentOrientation(control.currentOrientation);
		robot1.setCurrentMovement(control.currentMovement);
		robot1.setSide(control.side);
		robot1.setIfShot(control.shot, control.mele1, control.mele2);
		control.shot = false;
		control.mele1 = false;
		control.mele2 = false;
		
		if (robot2.getPosX() >= 1200) {
			this.contolledFrame.rightSide();
		} else {
			this.contolledFrame.leftSide();
		}

		robot2.setCurrentOrientation(control2.currentOrientation);
		robot2.setCurrentMovement(control2.currentMovement);
		robot2.setSide(control2.side);
		robot2.setIfShot(control2.shot, control2.mele1, control2.mele2);
		control2.shot = false;
		control2.mele1 = false;
		control2.mele2 = false;
	}

	private void validateColitions() {
		IVariables varS = IVariables.getInstance();
		List<Trap> arrayTraps = varS.getArrayTraps();
		List<IRobotito> arrayRobots = new ArrayList<>();
		List<Proyectile> arrayProy = varS.getArrayProyectiles();
		Collections.addAll(arrayRobots, robot1, robot2);

		int robX1, robY1, robX2, robY2;

		for (IRobotito robot : arrayRobots) {
			robX1 = robot.getPosX();
			robX2 = robX1 + 100;
			robY1 = robot.getPosY();
			robY2 = robY1 + 100;
			Stream<Proyectile> validProys = arrayProy.stream().filter(x -> !x.isOutOfRange())
					.filter(k -> (k.getPosX() < robot.getPosX() + 100) && (k.getPosX() > robot.getPosX())
							&& (k.getPosY() < robot.getPosY() + 100) && (k.getPosY() > robot.getPosY()))
					.filter(k -> k.getRobot() != robot);
			
			validProys.forEach(k -> robot.damage(k.getLevel()));
			
			validProys = arrayProy.stream().filter(x -> !x.isOutOfRange())
					.filter(k -> (k.getPosX() < robot.getPosX() + 100) && (k.getPosX() > robot.getPosX())
							&& (k.getPosY() < robot.getPosY() + 100) && (k.getPosY() > robot.getPosY()))
					.filter(k -> k.getRobot() != robot);
			validProys.forEach(k -> k.setInvalid());
			

			// System.out.println();
			// System.out.println("Robot1 " + robX2 + " " + robY1);
			for (Trap trampa : arrayTraps) {
				int trampX1 = trampa.getPosX();
				int trampY1 = trampa.getPosY();
				int trampX2 = trampX1 + trampa.getWidht();
				int trampY2 = trampY1 + trampa.getLenght();

				// System.out.println("T" + " " + trampX1 + " " + trampX2 + " " + trampY1 + " "
				// +trampY2 );
				if ((robX1 < trampX2) && (robX1 > trampX1) && (robY1 < trampY2) && (robY1 > trampY1)) {
					robot.intDamage(5);
				} else if ((robX2 < trampX2) && (robX2 > trampX1) && (robY1 < trampY2) && (robY1 > trampY1)) {
					robot.intDamage(5);
				} else if ((robX1 < trampX2) && (robX1 > trampX1) && (robY2 < trampY2) && (robY2 > trampY1)) {
					robot.intDamage(5);
				} else if ((robX2 < trampX2) && (robX2 > trampX1) && (robY2 < trampY2) && (robY2 > trampY1)) {
					robot.intDamage(5);
				}
			}
		}
	
	}

	@Override
	public void run() {
		double drawInterval = 1000000000 / 30;
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (gameThread != null) {

			updateRobots();
			validateColitions();
			
			

			time = control.pulsation;
			contolledFrame.repaint();
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;// Se divide el tiempo pq el tread es en milis

				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime); // Pausa el loop hasta que remainingTime termine

				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
