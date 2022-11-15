package robotwar.Interfaces;

import java.time.LocalTime;
import java.util.List;

import robotwar.common.IVariables;
import robotwar.common.robotbase.Arena;
import robotwar.common.robotbase.BlueRobot;
import robotwar.common.robotbase.IRobotito;
import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.Trap;
import robotwar.weapons.BlueShooter;
import robotwar.weapons.PunchArm;
import robotwar.weapons.Reaper;

public class RobotController implements Runnable {
	private GameInterface contolledFrame;
	private Arena currentArena;
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
		robot2.addStrike(new BlueShooter());
		robot2.addWeapon(new Reaper());
		robot2.addWeapon(new PunchArm());
		robot2.getPlayerImage();
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
