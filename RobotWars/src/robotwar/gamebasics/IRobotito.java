package robotwar.gamebasics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import robotwar.common.robotbase.IRobot;
import robotwar.common.robotbase.MOVEMENT;
import robotwar.common.robotbase.ORIENTATION;
import robotwar.common.robotbase.Weapon;

public abstract class IRobotito extends IRobot {
	protected String type;
	protected List<Integer> panelBounds;
	protected List<Integer> mekaBound;
	protected int speed;
	protected ORIENTATION side;
	protected String image;
	protected String direction;
	protected String name;
	public BufferedImage leftL, upL, downL, upR, downR, rightR;
	protected boolean shot, melee1, melee2, dead;
	protected int damageCap;

	public IRobotito(ORIENTATION pOrientation) {
		super(pOrientation);
		mekaBound = new ArrayList<>();
		panelBounds = new ArrayList<>();
		posX = 100;
		posY = 100;
	}

	public void getPlayerImage() {
		side = ORIENTATION.WEST;
		leftL = setMeka(ORIENTATION.WEST);
		upL = setMeka(ORIENTATION.NORTH);
		downL = setMeka(ORIENTATION.SOUTH);

		side = ORIENTATION.EAST;
		rightR = setMeka(ORIENTATION.EAST);
		upR = setMeka(ORIENTATION.NORTH);
		downR = setMeka(ORIENTATION.SOUTH);

	}

	public BufferedImage setMeka(ORIENTATION sight) {
		JPanel panelg = new JPanel();
		panelg.setOpaque(false);

		panelg.setBounds(panelBounds.get(0), panelBounds.get(1), panelBounds.get(2), panelBounds.get(3));

		Weapon weapon1 = weapons[0];
		Weapon weapon2 = weapons[1];
		Weapon head = strikes[0];

		JLabel lname = new JLabel(name);
		lname.setBounds(52, 18, 79, 16);
		lname.setFont(lname.getFont().deriveFont(Font.BOLD, 20F));
		lname.setForeground(Color.white);
		panelg.add(lname);

		JLabel lmeka = new JLabel();
		JLabel lmele1 = new JLabel();
		JLabel lmele2 = new JLabel();
		JLabel lrange = new JLabel();

		currentOrientation = sight;
		UpdateImage();
		weapon1.UpdateImage(sight);
		weapon2.UpdateImage(sight);
		head.UpdateImage(sight);

		List<Integer> robot = mekaBound;
		List<Integer> posWeapon1 = weapon1.getLocation();
		List<Integer> posWeapon2 = weapon2.getLocation();
		List<Integer> rangeWeapon = head.getLocation();

		lmeka.setBounds(robot.get(0), robot.get(1), robot.get(2), robot.get(3));
		lmele1.setBounds(posWeapon1.get(0), posWeapon1.get(1), posWeapon1.get(2), posWeapon1.get(3));
		lmele2.setBounds(posWeapon2.get(0), posWeapon2.get(1), posWeapon2.get(2), posWeapon2.get(3));
		lrange.setBounds(rangeWeapon.get(0), rangeWeapon.get(1), rangeWeapon.get(2), rangeWeapon.get(3));

		setImage(lrange, head.getImage());
		setImage(lmele1, weapon1.getImage());
		setImage(lmele2, weapon2.getImage());
		setImage(lmeka, image);
		panelg.add(lrange);

		if (side == ORIENTATION.EAST) {
			panelg.add(lmele1);
			panelg.add(lmeka);
			panelg.add(lmele2);
		} else {
			panelg.add(lmele2);
			panelg.add(lmeka);
			panelg.add(lmele1);
		}

		panelg.setLayout(null);
		return createImage(panelg);
	}

	public BufferedImage createImage(JPanel panel) {
		int w = panel.getWidth();
		int h = panel.getHeight();
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		panel.paint(g);
		g.dispose();
		return bi;
	}

	public JLabel setImage(JLabel pLabel, String ruta) {
		ImageIcon newimage = new ImageIcon(getClass().getResource(ruta));
		Icon icon = new ImageIcon(
				newimage.getImage().getScaledInstance(pLabel.getWidth(), pLabel.getHeight(), Image.SCALE_DEFAULT));
		pLabel.setIcon(icon);
		return pLabel;
	}

	public BufferedImage setImage() {
		BufferedImage newimage = null;
		switch (currentOrientation) {
		case NORTH:
			newimage = upL;
			if (side == ORIENTATION.EAST)
				newimage = upR;
			break;
		case SOUTH:
			newimage = downL;
			if (side == ORIENTATION.EAST)
				newimage = downR;
			break;
		case WEST:
			newimage = leftL;
			break;
		case EAST:
			newimage = rightR;
			break;
		}
		return newimage;
	}

	public abstract void UpdateImage();

	public void setSide(ORIENTATION side) {
		this.side = side;
	}

	public Stream<Weapon> getWeapons() {
		return Stream.concat(Arrays.stream(strikes), Arrays.stream(weapons)); // Denme puntos extra
	}

	public String getType() {
		return type;
	}

	public String getImage() {
		UpdateImage();
		return image;
	}

	public void setName(String pname) {
		this.name = pname;
	}

	public void setIfShot(boolean pShot, boolean pMelee1, boolean pMelee2) {
		this.shot = pShot;
		this.melee1 = pMelee1;
		this.melee2 = pMelee2;
	}

	public void draw(MOVEMENT pMove, LocalTime pActionTime, Graphics g) {
		Stream<Weapon> streamW = Stream.concat(Arrays.stream(weapons), Arrays.stream(strikes));
		streamW.forEach(k -> k.decCooldown());
		--damageCap;

		if (energy > 0) {
			this.move(pMove, pActionTime, g);
			if (shot && strikes[0].getCooldown() < 0) {

				this.hit(0, pActionTime, g);
			}
			if (melee1 && weapons[0].getCooldown() < 0) {

				this.fire(0, pActionTime, g);
			}
			if (melee2 && weapons[1].getCooldown() < 0) {

				this.fire(1, pActionTime, g);
			}
		} else {
			
			try {
				BufferedImage deadimage = ImageIO.read(getClass().getResource("/robotwar/images/dead.png"));
				g.drawImage(deadimage, posX, posY, 70, 70, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Integer> getBound() {
		return panelBounds;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void intDamage(int pDamage) {
		if (damageCap < 0) {
			this.energy -= pDamage;
			damageCap = 9;
		}
	}
}
