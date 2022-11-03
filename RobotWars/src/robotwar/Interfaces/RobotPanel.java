package robotwar.Interfaces;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import robotwar.common.robotbase.IRobot;
import robotwar.common.robotbase.Weapon;

public class RobotPanel{ //Se haria el extends de IROBOT
	GameInterface gp;  
	Key keyType;
	IRobot meka;
	int dir = 0;
	
	public RobotPanel(GameInterface pGp, Key pBoard, IRobot pmeka)
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
		
		JLabel lmeka  = new JLabel();
		JLabel lmele1 = new JLabel();
		JLabel lmele2 = new JLabel();
		JLabel lrange = new JLabel();
		
		List<Integer> robot = meka.getLocation(sight);
		List<Integer> posWeapon1 = weapon1.getLocation(sight);
		List<Integer> posWeapon2 = weapon2.getLocation(sight);
		List<Integer> rangeWeapon = head.getLocation(sight);
		
		lmeka.setBounds(robot.get(0),robot.get(1),robot.get(2),robot.get(3));
		lmele1.setBounds(posWeapon1.get(0),posWeapon1.get(1),posWeapon1.get(2),posWeapon1.get(3)); // Right hand + 72
		lmele2.setBounds(posWeapon2.get(0),posWeapon2.get(1),posWeapon2.get(2),posWeapon2.get(3)); // Left hand - 70
		lrange.setBounds(rangeWeapon.get(0),rangeWeapon.get(1),rangeWeapon.get(2),rangeWeapon.get(3));
			
		
		setImage(lrange, head.getImage(sight));
		panelg.add(lrange);
		
		// Melee Slot 1
		setImage(lmele1, weapon1.getImage(sight));
		
		setImage(lmele2, weapon2.getImage(sight));
		
		setImage(lmeka, meka.getImage(sight));
		
		if (dir == 0)
		{
			panelg.add(lmele1);
			panelg.add(lmeka);
			panelg.add(lmele2);
		}
		else 
		{
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
		ImageIcon image = new ImageIcon(getClass().getResource(ruta));
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(pLabel.getWidth(), pLabel.getHeight(), Image.SCALE_DEFAULT));
		pLabel.setIcon(icon);
        return pLabel;
    }
	
	public void update()
	{
		
		if (keyType.downPressed && (meka.getPosY() < 700))
		{
			meka.setPosY(meka.getPosY() + meka.getSpeed());
		}
		else if (keyType.upPressed && (meka.getPosY() > -28)) 
		{ 
			meka.setPosY(meka.getPosY() - meka.getSpeed());	
		}
		if (keyType.rightPressed && (meka.getPosX() < 1105))
		{
			meka.setPosX(meka.getPosX() + meka.getSpeed());
		}
		else if (keyType.leftPressed && (meka.getPosX() > 0))
		{
		    meka.setPosX(meka.getPosX() - meka.getSpeed());
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
