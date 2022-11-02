package robotwar.Interfaces;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import robotwar.common.*;
import robotwar.common.robotbase.GreenRobot;
import robotwar.common.robotbase.IRobot;
import robotwar.weapons.*;


public class GameInterface extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	
	final int originalSize = 25; //Defalt size of each panel 25x25
	final int scale = 4;
	public final int tileSize = originalSize * scale; //Decides all ths screen sizes. 100x100
	final int maxScreenCol = 16; //
	final int maxSceenRow = 12;
	final int screenWidghht = tileSize * maxScreenCol; //1600 pixels
	final int screeenHeight = tileSize * maxSceenRow; //1200 pixels
	
	
	int FPS = 30;
	
	BackGround fondo = new BackGround(this);
	KeyBoard keyType = new KeyBoard();
	Thread gameThread;
	
	IRobot meka;
	RobotPanel player;
	
	public GameInterface ()
	{
		this.setPreferredSize(new Dimension(IConstants.ARENA_WIDTH,IConstants.ARENA_HEIGTH));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyType);//Se le agrega las keys al frame 
		this.setFocusable(true);
		
		meka = new GreenRobot();
		
		GreenScope head1 = new GreenScope(0);
		GreenLaser head2 = new GreenLaser(0);
		
		Warhammer hammer = new Warhammer(0);
		ThunderBlade blade = new ThunderBlade(0);
		Hades hades = new Hades(0);

		meka.addWeapon(blade);
		meka.addWeapon(hades);
		meka.addStrike(head1);
		
		player = new RobotPanel(this, keyType, meka);
		
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
		// Trampas
	}
	
	public void paintComponent(Graphics g) //Aca se pueden crear los robots. 
	{
		super.paintComponent(g);//The parent is the frame 
		
		Graphics2D g2 = (Graphics2D)g;
		
		fondo.draw(g2);
		
		player.draw(g2);
		
		g2.dispose();
	}
	
	}

