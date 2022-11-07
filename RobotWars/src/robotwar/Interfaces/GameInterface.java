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
	private static final int scale = 4;
	public static final int tileSize = originalSize * scale; // Decides all ths screen sizes. 100x100
	private BackGround fondo = new BackGround("/robotwar/images/floor1.jpg");
	
	public IRobotito robot1;

	private RobotController controller;

	public GameInterface(RobotController controller) {
		this.setPreferredSize(new Dimension(IConstants.ARENA_WIDTH, IConstants.ARENA_HEIGTH));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.setFocusable(true);

		
		Key control = new KeyBoard();
		this.addKeyListener(control);
		this.setFocusable(true);
		this.controller = controller;
		this.controller.setWindow(this); // Se le asigna al controller GamInterface
		this.controller.setControl(control);
	}

	

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		fondo.draw(g2);
		IVariables varS = IVariables.getInstance();
		List<Trap> arrayTraps = varS.getArrayTraps();
		List<Proyectile> arrayProy = varS.getArrayProyectiles();
				
		arrayTraps.stream().forEach(k -> k.draw(g2));
		arrayProy.stream().forEach(k -> k.draw(g2));
		//arrayProy.stream().filter(Proyectile::isOutOfRange).forEach(k -> arrayProy.remove(k.getIndex()));

		robot1.draw(null, this.controller.time, g2);

		g2.dispose();
	}

}
