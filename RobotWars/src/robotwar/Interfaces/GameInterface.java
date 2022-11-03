package robotwar.Interfaces;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import robotwar.common.*;
import robotwar.common.robotbase.BlueRobot;
import robotwar.common.robotbase.GreenRobot;
import robotwar.common.robotbase.IRobot;
import robotwar.weapons.*;


public class GameInterface extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	private static final int originalSize = 25; //Defalt size of each panel 25x25
	private static final int scale = 4;
	public static final int tileSize = originalSize * scale; //Decides all ths screen sizes. 100x100

	private double FPS = 30;
	private BackGround fondo = new BackGround(this);
	private Key keyType2 = new KeyBoard2();
	private Key keyType = new KeyBoard();
	private Thread gameThread;
	private RobotPanel player;
	private RobotPanel player2;
	
	

	public GameInterface (IRobot meka, IRobot meka2)
	{
		this.setPreferredSize(new Dimension(IConstants.ARENA_WIDTH,IConstants.ARENA_HEIGTH));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyType);//Se le agrega las keys al frame 
		this.addKeyListener(keyType2);//Se le agrega las keys al frame 
		this.setFocusable(true);
		
		player = new RobotPanel(this, keyType, meka);
		player2 = new RobotPanel(this, keyType2, meka2);
		
	}
	
	public void startGameThread()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}


	@Override
	public void run() { //Se nesesita saber cuanto tiempo paso para hacer los frames
		
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while (gameThread != null)
		{
			update();
			
			repaint();
			
			try
			{
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;//Se divide el tiempo pq el tread es en milis
				
				if (remainingTime < 0)
				{
					remainingTime = 0;
				}
				Thread.sleep((long)remainingTime); //Pausa el loop hasta que remainingTime termine
				
				nextDrawTime += drawInterval;
			}catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
      }
	
	public void update()
	{
		player.update();
		player2.update();
		// Trampas
	}
	
	@Override
	public void paintComponent(Graphics g) //Aca se pueden crear los robots. 
	{
		super.paintComponent(g);//The parent is the frame 
		
		Graphics2D g2 = (Graphics2D)g;
		
		fondo.draw(g2);
		
		player.draw(g2);
		
		player2.draw(g2);
		
		g2.dispose();
	}
	
	}

