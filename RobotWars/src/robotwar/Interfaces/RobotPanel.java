package robotwar.Interfaces;

import robotwar.weapons.*;
import java.awt.Color;



import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import robotwar.Interfaces.*;
import robotwar.common.robotbase.BlueRobot;
import robotwar.common.robotbase.GreenRobot;
import robotwar.common.robotbase.Placement;
import robotwar.common.robotbase.Weapon;

public class RobotPanel{ //Se haria el extends de IROBOT
	GameInterface gp;  
	KeyBoard keyType;
	GreenRobot green;
	BlueRobot blue;

	int dir = 0;
	
	public RobotPanel(GameInterface pGp, KeyBoard pBoard)
	{
		this.gp = pGp;
		this.keyType = pBoard;
		green = new GreenRobot();
		blue = new BlueRobot();
		
//		Warhammer hammer = new Warhammer(0);
//		ThunderBlade blade = new ThunderBlade(0);
//		GreenScope head = new GreenScope(0);
		
		LavaAxe axe = new LavaAxe(0);
		Reaper arm = new Reaper(0);
		BlueShooter rocket = new BlueShooter(0);
		
		blue.addWeapon(axe);
		blue.addWeapon(arm);
		blue.addStrike(rocket);
		
		setDefaulValues();
		getPlayerImage();
	}
	
	public void setDefaulValues()
	{
//		green.setPosX(100);
//		green.setPosY(100);
//		green.setSpeed(4);
//		green.setDirection("right");
		
		blue.setPosX(100);
		blue.setPosY(100);
		blue.setSpeed(4);
		blue.setDirection("right");
		dir = 0;
	}

	public void getPlayerImage()
	{
//		green.rightR = setGreen("right");
//		green.upR = setGreen("up");
//		green.downR = setGreen("down");
//		green.leftR = setGreen("left");
//		green.rightL = setGreen("right");
//		green.upL = setGreen("up");
//		green.downL = setGreen("down");
//		green.leftL = setGreen("left");
		
		blue.rightR = setBlue("right");
		blue.upR = setBlue("up");
		blue.downR = setBlue("down");
		blue.leftR = setBlue("left");
		blue.rightL = setBlue("right");
		blue.upL = setBlue("up");
		blue.downL = setBlue("down");
		blue.leftL = setBlue("left");
	}
	public BufferedImage setGreen(String sight) {
		JPanel panelg = new JPanel();
		panelg.setOpaque(false);
		
		int[] bounds = green.getBounds(); // 300, 57, 190, 135
		
		panelg.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);

		
		Weapon weapon1 = green.getWeapons()[0];
		Weapon weapon2 = green.getWeapons()[1];
		Weapon head = green.getStrikes()[0];
		
		JLabel Meka  = new JLabel();
		JLabel Mele1 = new JLabel();
		JLabel Mele2 = new JLabel();
		JLabel range = new JLabel();
		
		List<Integer> robot = green.getLocation(sight);
		List<Integer> posWeapon1 = weapon1.getLocation(sight);
		List<Integer> posWeapon2 = weapon2.getLocation(sight);
		List<Integer> rangeWeapon = head.getLocation(sight);
		
		Meka.setBounds(robot.get(0),robot.get(1),robot.get(2),robot.get(3));
		Mele1.setBounds(posWeapon1.get(0),posWeapon1.get(1),posWeapon1.get(2),posWeapon1.get(3)); // Right hand + 72
		Mele2.setBounds(posWeapon2.get(0),posWeapon2.get(1),posWeapon2.get(2),posWeapon2.get(3)); // Left hand - 70
		range.setBounds(rangeWeapon.get(0),rangeWeapon.get(1),rangeWeapon.get(2),rangeWeapon.get(3));
			
		
		setImage(range, head.getImage(sight));
		
		panelg.add(range);
		
		// Melee Slot 1
		setImage(Mele1, weapon1.getImage(sight));
		
		setImage(Mele2, weapon2.getImage(sight));
		
		setImage(Meka, green.getImage(sight));
		
		if (dir == 0)
		{
			panelg.add(Mele1);
			panelg.add(Meka);
			panelg.add(Mele2);
		}
		else 
		{
		panelg.add(Mele2);
		panelg.add(Meka);
		panelg.add(Mele1);
		}
		
		panelg.setLayout(null);
		return createImage(panelg);
	}
	
	public BufferedImage setBlue(String sight) {
		JPanel panelg = new JPanel();
		panelg.setOpaque(false);
		
		int[] bounds = blue.getBounds(); // 300, 57, 190, 135
		
		panelg.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);

		Weapon weapon1 = blue.getWeapons()[0];
		Weapon weapon2 = blue.getWeapons()[1];
		Weapon head = blue.getStrikes()[0];
		
		JLabel Meka  = new JLabel();
		JLabel Mele1 = new JLabel();
		JLabel Mele2 = new JLabel();
		JLabel range = new JLabel();
		
		List<Integer> robot = blue.getLocation(sight);
		List<Integer> posWeapon1 = weapon1.getLocation(sight);
		List<Integer> posWeapon2 = weapon2.getLocation(sight);
		List<Integer> rangeWeapon = head.getLocation(sight);
		
		Meka.setBounds(robot.get(0),robot.get(1),robot.get(2),robot.get(3));
		Mele1.setBounds(posWeapon1.get(0),posWeapon1.get(1),posWeapon1.get(2),posWeapon1.get(3)); // Right hand + 72
		Mele2.setBounds(posWeapon2.get(0),posWeapon2.get(1),posWeapon2.get(2),posWeapon2.get(3)); // Left hand - 70
		range.setBounds(rangeWeapon.get(0),rangeWeapon.get(1),rangeWeapon.get(2),rangeWeapon.get(3));
			
		setImage(range, head.getImage(sight));
		
		panelg.add(range);
		
		// Melee Slot 1
		setImage(Mele1, weapon1.getImage(sight));
		
		setImage(Mele2, weapon2.getImage(sight));
		
		setImage(Meka, blue.getImage(sight));
		
		if (dir == 0)
		{
			panelg.add(Mele1);
			panelg.add(Meka);
			panelg.add(Mele2);
		}
		else 
		{
			panelg.add(Mele2);
			panelg.add(Meka);
			panelg.add(Mele1);
		}
		
		panelg.setLayout(null);
		return createImage(panelg);
	}
	
	public BufferedImage createImage(JPanel panel) {
	    int w = panel.getWidth();
	    int h = panel.getHeight();
	    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = bi.createGraphics();
	    g.setBackground(null);
	    panel.paint(g);
	    g.dispose();
	    return bi;
	}
	
	public JLabel setImage(JLabel pLabel, String ruta) {
		ImageIcon image = new ImageIcon(getClass().getResource(ruta));
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(pLabel.getWidth(), pLabel.getHeight(), Image.SCALE_DEFAULT));
		pLabel.setIcon(icon);
        return pLabel;
    }
	
	public void update()
	{
		
		if (keyType.downPressed)
		{
			blue.setPosY(blue.getPosY() + blue.getSpeed());
		}
		else if (keyType.upPressed)
		{
			
			blue.setPosY(blue.getPosY() - blue.getSpeed());
		}
		else if (keyType.rightPressed)
		{
			blue.setPosX(blue.getPosX() + blue.getSpeed());
		}
		else if (keyType.leftPressed)
		{
			blue.setPosX(blue.getPosX() - blue.getSpeed());
		} 
		else if (keyType.downSight) 
		{
			blue.direction = "down";
		} 
		else if (keyType.upSight) 
		{
			blue.direction = "up";
		} 
		else if (keyType.rightSight) 
		{
			dir = 0;
			blue.direction = "right";
		} 
		else if (keyType.leftSight) 
		{
			dir = 1;
			blue.direction = "left";
		}
		
	}
	public void draw(Graphics2D pG2)
	{
		BufferedImage image = null;
		switch(blue.direction)
		{
		case "up":
			image = blue.upL;
			if (dir == 0)
				image = blue.upR;
			break;
		case "down":
			image = blue.downL;
			if (dir == 0)
				image = blue.downR;
			break;
		case "right":
			image = blue.rightL;
			if (dir == 0)
				image = blue.rightR;
			break;
		case "left":
			image = blue.leftL;
			if (dir == 0)
				image = blue.leftR;
			break;
		}
		pG2.drawImage(image, blue.getPosX(), blue.getPosY(), gp.tileSize, gp.tileSize, null);
			
	}
	
}
