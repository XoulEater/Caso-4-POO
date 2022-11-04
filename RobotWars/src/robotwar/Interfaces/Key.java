package robotwar.Interfaces;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.ORIENTATION;

public abstract class Key implements KeyListener{
	public ORIENTATION currentOrientation;
	public MOVEMENT currentMovement;
}