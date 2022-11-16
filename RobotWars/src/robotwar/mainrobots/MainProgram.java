package robotwar.mainrobots;

import java.awt.Dimension;

import javax.swing.JFrame;

import robotwar.common.IConstants;
import robotwar.common.IVariables;
import robotwar.interfazes.FactoryController;
import robotwar.interfazes.SelectInterface;
import robotwar.traps.Acid;
import robotwar.traps.Fire;
import robotwar.traps.Saw;
import robotwar.traps.Spike;

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

		FactoryController mainFactory = new FactoryController(window);
		SelectInterface interfaz = new SelectInterface(mainFactory);

		window.add(interfaz);
		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

	public static void main(String[] args) {
		startGame();
	}
}
