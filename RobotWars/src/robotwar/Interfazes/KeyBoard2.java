package robotwar.Interfazes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalTime;

import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.ORIENTATION;

public class KeyBoard2 extends Key{
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_Y)
		{
			this.currentMovement = MOVEMENT.UP;
			this.pulsation = LocalTime.now();
		}
		else if (code == KeyEvent.VK_H)
		{
			this.currentMovement = MOVEMENT.DOWN;
			this.pulsation = LocalTime.now();
		}
		else if (code == KeyEvent.VK_J)
		{
			this.currentMovement = MOVEMENT.RIGHT;
			this.pulsation = LocalTime.now();
		}
		else if (code == KeyEvent.VK_G)
		{
			this.currentMovement = MOVEMENT.LEFT;
			this.pulsation = LocalTime.now();
		}
		if (code == KeyEvent.VK_O)
		{
			this.currentOrientation= ORIENTATION.NORTH;
		}
		else if (code == KeyEvent.VK_L)
		{
			this.currentOrientation= ORIENTATION.SOUTH;
		}
		else if (code == KeyEvent.VK_P)
		{
			this.currentOrientation= ORIENTATION.EAST;
			this.side = ORIENTATION.EAST;
		}
		else if (code == KeyEvent.VK_K)
		{
			this.currentOrientation= ORIENTATION.WEST;
			this.side = ORIENTATION.WEST;
		}
		if (code == KeyEvent.VK_ENTER) {
			this.shot = true;
		}
		if (code == KeyEvent.VK_T) {
			this.mele1 = true;
		}
		if (code == KeyEvent.VK_U) {
			this.mele2= true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if ((code == KeyEvent.VK_Y) && (currentMovement == MOVEMENT.UP))
		{
			this.currentMovement = MOVEMENT.NONE;
		}
		else if ((code == KeyEvent.VK_H) && (currentMovement == MOVEMENT.DOWN))
		{
			this.currentMovement = MOVEMENT.NONE;
		}
		else if ((code == KeyEvent.VK_J) && (currentMovement == MOVEMENT.RIGHT))
		{
			this.currentMovement = MOVEMENT.NONE;
		}
		else if ((code == KeyEvent.VK_G) && (currentMovement == MOVEMENT.LEFT))
		{
			this.currentMovement = MOVEMENT.NONE;
		}
	}
}