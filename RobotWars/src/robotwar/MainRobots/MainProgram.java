package robotwar.MainRobots;

import java.awt.Dimension;

import javax.swing.JFrame;

import robotwar.Traps.Acid;
import robotwar.Traps.Fire;
import robotwar.Traps.Saw;
import robotwar.Traps.Spike;
import robotwar.common.IConstants;
import robotwar.common.IVariables;

public class MainProgram {

	public static void startGame() {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setTitle("RobotWars");
		window.setPreferredSize(new Dimension(IConstants.ARENA_WIDTH, IConstants.ARENA_HEIGTH));

		IVariables varS = IVariables.getInstance();

		varS.addTrap(new Spike(1500, 0));
		varS.addTrap(new Fire(1200, 0));
		varS.addTrap(new Acid(300, 300));
		varS.addTrap(new Acid(700, 300));
		varS.addTrap(new Saw(700, 0));
		varS.addTrap(new Saw(700, 700));
		varS.addTrap(new Saw(800, 100));
		varS.addTrap(new Saw(800, 600));

		FactoryController MainFactory = new FactoryController(window);
		SelectInterface interfaz = new SelectInterface(MainFactory);

		window.add(interfaz);
		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

	public static void main(String[] args) {
		startGame();
	}
}
