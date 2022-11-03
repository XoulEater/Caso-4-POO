package robotwar.Interfaces;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard2 extends Key{
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_T)
		{
			upPressed = true;
		}
		
		if (code == KeyEvent.VK_G)
		{
			downPressed = true;
		}
		
		if (code == KeyEvent.VK_H)
		{
			rightPressed = true;
		}
		
		if (code == KeyEvent.VK_F)
		{
			leftPressed = true;
		}
		if (code == KeyEvent.VK_I)
		{
			upSight = true;
		}
		
		if (code == KeyEvent.VK_K)
		{
			downSight = true;
		}
		
		if (code == KeyEvent.VK_L)
		{
			rightSight = true;
		}
		
		if (code == KeyEvent.VK_J)
		{
			leftSight = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_T)
		{
			upPressed = false;
		}
		
		if (code == KeyEvent.VK_G)
		{
			downPressed = false;
		}
		
		if (code == KeyEvent.VK_H)
		{
			rightPressed = false;
		}
		
		if (code == KeyEvent.VK_F)
		{
			leftPressed = false;
		}
		if (code == KeyEvent.VK_I)
		{
			upSight = false;
		}
		
		if (code == KeyEvent.VK_K)
		{
			downSight = false;
		}
		
		if (code == KeyEvent.VK_L)
		{
			rightSight = false;
		}
		
		if (code == KeyEvent.VK_J)
		{
			leftSight = false;
		}
		
	}

}
