package robotwar.Interfaces;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener{
	public boolean upPressed, downPressed, leftPressed, rightPressed, upSight, downSight, leftSight, rightSight;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W)
		{
			upPressed = true;
		}
		
		if (code == KeyEvent.VK_S)
		{
			downPressed = true;
		}
		
		if (code == KeyEvent.VK_D)
		{
			rightPressed = true;
		}
		
		if (code == KeyEvent.VK_A)
		{
			leftPressed = true;
		}
		if (code == KeyEvent.VK_UP)
		{
			upSight = true;
		}
		
		if (code == KeyEvent.VK_DOWN)
		{
			downSight = true;
		}
		
		if (code == KeyEvent.VK_RIGHT)
		{
			rightSight = true;
		}
		
		if (code == KeyEvent.VK_LEFT)
		{
			leftSight = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W)
		{
			upPressed = false;
		}
		
		if (code == KeyEvent.VK_S)
		{
			downPressed = false;
		}
		
		if (code == KeyEvent.VK_D)
		{
			rightPressed = false;
		}
		
		if (code == KeyEvent.VK_A)
		{
			leftPressed = false;
		}
		if (code == KeyEvent.VK_UP)
		{
			upSight = false;
		}
		
		if (code == KeyEvent.VK_DOWN)
		{
			downSight = false;
		}
		
		if (code == KeyEvent.VK_RIGHT)
		{
			rightSight = false;
		}
		
		if (code == KeyEvent.VK_LEFT)
		{
			leftSight = false;
		}
		
	}

}
