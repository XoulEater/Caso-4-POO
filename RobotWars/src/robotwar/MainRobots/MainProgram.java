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

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("RobotWars");
		window.setPreferredSize(new Dimension(IConstants.ARENA_WIDTH, IConstants.ARENA_HEIGTH));
		
		IVariables varS = IVariables.getInstance();

		varS.addTrap(new Spike(500, 0));
		varS.addTrap(new Fire(200, 0));
		varS.addTrap(new Acid(300, 300));
		varS.addTrap(new Saw(700, 0));

		FactoryController MainFactory = new FactoryController(window);
		SelectInterface interfaz = new SelectInterface(MainFactory);
		
		window.add(interfaz);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		




	}
}
