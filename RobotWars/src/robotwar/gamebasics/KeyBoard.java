package robotwar.gamebasics;

import java.awt.event.KeyEvent;
import java.time.LocalTime;

import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.ORIENTATION;

public class KeyBoard extends Key {
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) {
			this.currentMovement = MOVEMENT.UP;
			this.pulsation = LocalTime.now();
		} else if (code == KeyEvent.VK_S) {
			this.currentMovement = MOVEMENT.DOWN;
			this.pulsation = LocalTime.now();
		} else if (code == KeyEvent.VK_D) {
			this.currentMovement = MOVEMENT.RIGHT;
			this.pulsation = LocalTime.now();
		} else if (code == KeyEvent.VK_A) {
			this.currentMovement = MOVEMENT.LEFT;
			this.pulsation = LocalTime.now();
		}
		if (code == KeyEvent.VK_F) {
			this.currentOrientation = ORIENTATION.NORTH;
		} else if (code == KeyEvent.VK_V) {
			this.currentOrientation = ORIENTATION.SOUTH;
		} else if (code == KeyEvent.VK_B) {
			this.currentOrientation = ORIENTATION.EAST;
			this.side = ORIENTATION.EAST;
		} else if (code == KeyEvent.VK_C) {
			this.currentOrientation = ORIENTATION.WEST;
			this.side = ORIENTATION.WEST;
		}
		if (code == KeyEvent.VK_SPACE) {
			this.shot = true;
		}
		if (code == KeyEvent.VK_E) {
			this.mele1 = true;
		}
		if (code == KeyEvent.VK_Q) {
			this.mele2 = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if ((code == KeyEvent.VK_W) && (currentMovement == MOVEMENT.UP)) {
			this.currentMovement = MOVEMENT.NONE;
		} else if ((code == KeyEvent.VK_S) && (currentMovement == MOVEMENT.DOWN)) {
			this.currentMovement = MOVEMENT.NONE;
		} else if ((code == KeyEvent.VK_D) && (currentMovement == MOVEMENT.RIGHT)) {
			this.currentMovement = MOVEMENT.NONE;
		} else if ((code == KeyEvent.VK_A) && (currentMovement == MOVEMENT.LEFT)) {
			this.currentMovement = MOVEMENT.NONE;
		}
	}
}
