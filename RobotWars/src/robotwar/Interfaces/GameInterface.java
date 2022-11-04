package robotwar.Interfaces;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import robotwar.common.*;
import robotwar.Interfaces.*;
import robotwar.common.robotbase.BlueRobot;
import robotwar.common.robotbase.GreenRobot;
import robotwar.common.robotbase.IRobot;
import robotwar.common.robotbase.IRobotito;
import robotwar.weapons.*;



public class GameInterface extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int originalSize = 25; //Defalt size of each panel 25x25
	private static final int scale = 4;
	public static final int tileSize = originalSize * scale; //Decides all ths screen sizes. 100x100
	private BackGround fondo = new BackGround(this);
	private RobotController controller;
	

	public GameInterface (RobotController controller)
	{
		this.setPreferredSize(new Dimension(IConstants.ARENA_WIDTH,IConstants.ARENA_HEIGTH));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.controller = controller;
		this.controller.setWindow(this); // Se le asigna al controller GamInterface
	}
	
	@Override
	public void paintComponent(Graphics g){ 
	
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		fondo.draw(g2);
	
		g2.dispose();
	}

}
