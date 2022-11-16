package robotwar.Interfazes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.LocalTime;

import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.ORIENTATION;

public abstract class Key implements KeyListener{
	public ORIENTATION currentOrientation = ORIENTATION.EAST;
	public MOVEMENT currentMovement = MOVEMENT.NONE;
	public ORIENTATION side = ORIENTATION.EAST;
	public LocalTime pulsation = LocalTime.now();
	public boolean shot = false;
	public boolean mele1 = false;
	public boolean mele2 = false;
}