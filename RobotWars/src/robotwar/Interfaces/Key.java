package robotwar.Interfaces;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class Key implements KeyListener{
	public boolean upPressed, downPressed, leftPressed, rightPressed, upSight, downSight, leftSight, rightSight;
}