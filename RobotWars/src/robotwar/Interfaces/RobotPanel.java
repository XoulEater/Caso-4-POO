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
import robotwar.common.robotbase.IRobot;
import robotwar.common.robotbase.Placement;
import robotwar.common.robotbase.Weapon;

public class RobotPanel{ //Se haria el extends de IROBOT
	GameInterface gp;  
	KeyBoard keyType;
	IRobot meka;


	int dir = 0;
	
	public RobotPanel(GameInterface pGp, KeyBoard pBoard, IRobot pmeka)
	{
		this.gp = pGp;
		this.keyType = pBoard;
	
		meka = pmeka;
		
		setDefaulValues();
		getPlayerImage();
	}
	
	public void setDefaulValues()
	{
		meka.setPosX(100);
		meka.setPosY(100);
		meka.setSpeed(4);
		meka.setDirection("right");
		dir = 0;
	}

	public void getPlayerImage()
	{	
		meka.rightR = setMeka("right");
		meka.upR = setMeka("up");
		meka.downR = setMeka("down");
		meka.leftR = setMeka("left");
		dir = 1;
		meka.leftL = setMeka("left");
		meka.upL = setMeka("up");
		meka.downL = setMeka("down");
		meka.rightL = setMeka("right");
		dir = 0;
	}
	public BufferedImage setMeka(String sight) {
		JPanel panelg = new JPanel();
		panelg.setOpaque(false);
		
		int[] bounds = meka.getBounds(); // 300, 57, 190, 135
		
		panelg.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);

		
		Weapon weapon1 = meka.getWeapons()[0];
		Weapon weapon2 = meka.getWeapons()[1];
		Weapon head = meka.getStrikes()[0];
		
		JLabel Meka  = new JLabel();
		JLabel Mele1 = new JLabel();
		JLabel Mele2 = new JLabel();
		JLabel range = new JLabel();
		
		List<Integer> robot = meka.getLocation(sight);
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
		
		setImage(Meka, meka.getImage(sight));
		
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
			if (meka.getPosY() < 700) {
			meka.setPosY(meka.getPosY() + meka.getSpeed());
			}
		}
		else if (keyType.upPressed)
		{
			if (meka.getPosY() > -28) {
				meka.setPosY(meka.getPosY() - meka.getSpeed());	
			}
		}
		if (keyType.rightPressed)
		{
			if (meka.getPosX() < 1105) {
				meka.setPosX(meka.getPosX() + meka.getSpeed());
			}
		}
		else if (keyType.leftPressed)
		{
			if (meka.getPosX() > 0) {
				meka.setPosX(meka.getPosX() - meka.getSpeed());
			}
		} 
		if (keyType.downSight) 
		{
			meka.setDirection("down");
		} 
		else if (keyType.upSight) 
		{
			meka.setDirection("up");
		} 
		if (keyType.rightSight) 
		{
			dir = 0;
			meka.setDirection("right");
		} 
		else if (keyType.leftSight) 
		{
			dir = 1;
			meka.setDirection("left");
		}
		
	}
	public void draw(Graphics2D pG2)
	{
		BufferedImage image = null;
		switch(meka.getDirection())
		{
		case "up":
			image = meka.upL;
			if (dir == 0)
				image = meka.upR;
			break;
		case "down":
			image = meka.downL;
			if (dir == 0)
				image = meka.downR;
			break;
		case "right":
			image = meka.rightL;
			if (dir == 0)
				image = meka.rightR;
			break;
		case "left":
			image = meka.leftL;
			if (dir == 0)
				image = meka.leftR;
			break;
		}
		pG2.drawImage(image, meka.getPosX(), meka.getPosY(), gp.tileSize, gp.tileSize, null);
			
	}
	
}
