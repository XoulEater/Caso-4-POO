package robotwar.Interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import robotwar.common.IConstants;
import robotwar.common.IVariables;
import robotwar.common.robotbase.IRobotito;
import robotwar.common.robotbase.Trap;
import robotwar.proyectiles.Proyectile;

public class GameInterface extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int originalSize = 25; // Defalt size of each panel 25x25
	private static final int scale = 1;
	public static final int tileSize = originalSize * scale; // Decides all ths screen sizes. 100x100
	private BackGround fondo = new BackGround("/robotwar/images/floor1.jpg");
	
	public IRobotito robot1;
	public IRobotito robot2;

	private RobotController controller;

	public GameInterface(RobotController controller) {
		this.setPreferredSize(new Dimension(IConstants.ARENA_WIDTH, IConstants.ARENA_HEIGTH));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.setFocusable(true);

		Key control = new KeyBoard();
		Key control2 = new KeyBoard2();
		this.addKeyListener(control);
		this.addKeyListener(control2);
		this.setFocusable(true);
		this.controller = controller;
		this.controller.setWindow(this); // Se le asigna al controller GamInterface
		this.controller.setControl(control);
		controller.control2 = control2;
		robot2 = controller.robot2;
	}

	

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		fondo.draw(g2);
		IVariables varS = IVariables.getInstance();
		List<Trap> arrayTraps = varS.getArrayTraps();
		List<Proyectile> arrayProy = varS.getArrayProyectiles();
				
		robot2.draw(null, this.controller.time, g2);
		robot1.draw(null, this.controller.time, g2);
		arrayTraps.stream().forEach(k -> k.draw(g2));
		arrayProy.stream().filter(k -> !k.isOutOfRange()).forEach(k -> k.draw(g2));

		
//		System.out.print("Robot 1 " + robot1.energy);
//		System.out.println(" Robot 2 " + robot2.energy);


		g2.dispose();
	}

}
