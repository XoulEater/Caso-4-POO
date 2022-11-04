package robotwar.Interfaces;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.ORIENTATION;

public class KeyBoard extends Key{
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W)
		{
			this.currentMovement = MOVEMENT.UP;
		}
		else if (code == KeyEvent.VK_S)
		{
			this.currentMovement = MOVEMENT.DOWN;
		}
		else if (code == KeyEvent.VK_D)
		{
			this.currentMovement = MOVEMENT.RIGHT;
		}
		else if (code == KeyEvent.VK_A)
		{
			this.currentMovement = MOVEMENT.LEFT;
		}
		if (code == KeyEvent.VK_UP)
		{
			this.currentOrientation= ORIENTATION.NORTH;
		}
		else if (code == KeyEvent.VK_DOWN)
		{
			this.currentOrientation= ORIENTATION.SOUTH;
		}
		else if (code == KeyEvent.VK_RIGHT)
		{
			this.currentOrientation= ORIENTATION.WEST;
		}
		else if (code == KeyEvent.VK_LEFT)
		{
			this.currentOrientation= ORIENTATION.EAST;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if ((code == KeyEvent.VK_W) || (code == KeyEvent.VK_S) || (code == KeyEvent.VK_D) || (code == KeyEvent.VK_A))
		{
			this.currentMovement = MOVEMENT.NONE;
		}
	}
}
