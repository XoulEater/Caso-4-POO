package robotwar.common.robotbase;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import robotwar.common.IConstants;

public abstract class IRobot implements IConstants {
	public int energy = 100;
	protected int posX;
	protected int posY;
	protected int strikeIndex;
	protected int weaponIndex;
	protected Weapon weapons[];
	protected Weapon strikes[];
	protected DamageLevel directionsdamage[];
	protected ORIENTATION currentOrientation;
	protected MOVEMENT currentMovement = MOVEMENT.NONE;

	protected int displacement = 0;
	protected int speed = 16;

	public IRobot() {
		this(ORIENTATION.EAST);
	}

	public IRobot(ORIENTATION pOrientation) {
		directionsdamage = new DamageLevel[MOVEMENT.values().length];
		directionsdamage[0] = new DamageLevel();
		directionsdamage[1] = new DamageLevel();
		directionsdamage[2] = new DamageLevel();
		directionsdamage[3] = new DamageLevel();

		weapons = new Weapon[WEAPONS_PER_ROBOT];
		strikes = new Weapon[STRIKES_PER_ROBOT];

		this.currentOrientation = pOrientation;

		strikeIndex = 0;
		weaponIndex = 0;
	}

	/*
	 * el move es la dirección que el jugador está presionando, con eso y la hora
	 * del accion versus la hora actual se sabe cuanto tiempo ha transcurrido por
	 * ende dada la velocidad del robot, se puede saber cuanto hay que desplazarlo,
	 * a que velocidad lo desplazo, actualizo el X, Y reduzco la energía refresco la
	 * pantalla con el graphics
	 */
	public void move(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {

		LocalTime time2 = LocalTime.now();

		double lapso = pActionTime.until(time2, ChronoUnit.NANOS);

		lapso /= 100000000.0;

		double movement = speed;

		double movX = 0;
		double movY = 0;

		switch (currentMovement) {
		case DOWN:
			if (posY < 700 && directionsdamage[0].getDamageLevel() != 0)
				movY = movement;
			break;
		case LEFT:
			if (posX > 0 && directionsdamage[1].getDamageLevel() != 0) {
				movX = -1.0 * movement;
			}
			break;
		case RIGHT:
			if (posX < 1100 && directionsdamage[2].getDamageLevel() != 0)
				movX = movement;
			break;
		case UP:
			if (posY > 0 && directionsdamage[3].getDamageLevel() != 0) {
				movY = -1.0 * movement;
			}
		case NONE:
			break;
		}

		posY += movY;
		posX += movX;

		displacement += Math.abs(movY) + Math.abs(movX);
		if (displacement >= 1000) {
			energy -= 1;
			displacement %= 1000;
		}

		BufferedImage newimage = setImage();
		g.drawImage(newimage, posX, posY, 100, 100, null);
	}

	protected abstract BufferedImage setImage();

	public void hit(int pStrikeId, LocalTime pActionTime, Graphics g) {
		this.strikes[pStrikeId].fire(this.posX, this.posY, this.currentOrientation);
	}

	public void fire(int pWeaponId, LocalTime pActionTime, Graphics g) {
		this.weapons[pWeaponId].fire(this.posX, this.posY, this.currentOrientation);
	}

	/*
	 * @pLevel, número del nivel del arma que le acertó este es el nivel del arma o
	 * golpe que le acertó a este robot entonces ahora hay que dado el nivel escoger
	 * la regla que aplica actualizar el damage respectivo
	 */
	public void damage(int pLevel) {
		Random rand = new Random();
		List<DamageLevel> damageableList = Stream.concat(Stream.concat(Arrays.stream(strikes), Arrays.stream(weapons)), Arrays.stream(directionsdamage)).toList();
		DamageLevel toDamage = damageableList.get(rand.nextInt(STRIKES_PER_ROBOT + WEAPONS_PER_ROBOT + 4));
		System.out.println(toDamage.getDamageLevel());
		toDamage.hitDamage(pLevel);
	}

	public void addStrike(Weapon pStrike) {
		strikes[strikeIndex] = pStrike;
		strikeIndex = ++strikeIndex % STRIKES_PER_ROBOT;
	}

	public void addWeapon(Weapon pStrike) {
		pStrike.setSlot(weaponIndex);
		weapons[weaponIndex] = pStrike;
		weaponIndex = ++weaponIndex % WEAPONS_PER_ROBOT;
	}

	public void setCurrentOrientation(ORIENTATION pcurrentOrientation) {
		this.currentOrientation = pcurrentOrientation;
	}

	public void setCurrentMovement(MOVEMENT currentMovement) {
		this.currentMovement = currentMovement;
	}

}
