package robotwar.Interfaces;

import java.time.LocalTime;

import robotwar.Interfaces.*;
import robotwar.common.robotbase.*;

import robotwar.common.robotbase.*;
import robotwar.main.*;

public class RobotController implements Runnable {
	private GameInterface contolledFrame;
	private Arena currentArena;
	private IRobotito robot1;
	public Key control;
	public LocalTime time;
	private MOVEMENT mov;
	private Thread gameThread;
	
	public RobotController(IRobotito robot)
	{	
		robot1 = robot;
		
	}
	
	public void createRobot(int pIndex) {
	}
	
	public void setControl(Key pControl) {
		this.control = pControl;
	}
	
	
	public void addRobot()
	{
	}

	public void setWindow(GameInterface pRobotmainFrame) { //Para interfaz
		contolledFrame = pRobotmainFrame;	
	}
	
	public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

	@Override
	public void run() 
		{
		double drawInterval = 1000000000/30;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
			while (gameThread != null)
			{
				robot1.setCurrentOrientation(control.currentOrientation);
				robot1.setCurrentMovement(control.currentMovement);
				robot1.setSide(control.side);
				
				
				
				
				time = control.pulsation;
				contolledFrame.repaint();
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
}
