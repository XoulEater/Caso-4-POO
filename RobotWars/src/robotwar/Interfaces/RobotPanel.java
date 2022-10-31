package robotwar.Interfaces;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import robotwar.Interfaces.*;
import robotwar.common.robotbase.GreenRobot;

public class RobotPanel{ //Se haria el extends de IROBOT
	GameInterface gp;  
	KeyBoard keyType;
	GreenRobot green;
	int dir = 0;
	
	public RobotPanel(GameInterface pGp, KeyBoard pBoard)
	{
		this.gp = pGp;
		this.keyType = pBoard;
		green = new GreenRobot();
		setDefaulValues();
		getPlayerImage();
	}
	
	public void setDefaulValues()
	{
		green.setPosX(100);
		green.setPosY(100);
		green.setSpeed(4);
		green.setDirection("right");
		dir = 0;
	}
	
	public void getPlayerImage()
	{
		green.rightR = setRBlue("right");
		green.upR = setRBlue("up");
		green.downR = setRBlue("down");
		green.leftR = setRBlue("left");
		green.rightL = setLBlue("right");
		green.upL = setLBlue("up");
		green.downL = setLBlue("down");
		green.leftL = setLBlue("left");
	}
	
	public BufferedImage setRGreen(String sight) {
		JPanel panelg = new JPanel();
		panelg.setOpaque(false);
		panelg.setBounds(300, 57, 190, 135);

		JLabel MekaGreen  = new JLabel();
		JLabel ThunderBlade = new JLabel();
		JLabel WarHammer = new JLabel();
		JLabel Hades = new JLabel();
		JLabel range = new JLabel();
		
		MekaGreen.setBounds(0, 45, 120,90);
		ThunderBlade.setBounds(90, 75, 100,30); // Right hand + 72
		WarHammer.setBounds(0, 0, 50,100); // Left hand - 70
		Hades.setBounds(90, 64, 90,60); // Left hand - 65
		range.setBounds(45,35, 50,35);
			
		
		switch(sight) {
		case "right":
			setImage(range, "/robotwar/images/ran_g1.png");
			break;
		case "left":
			setImage(range, "/robotwar/images/ran_g1I.png");
			break;
		case "down":
			setImage(range, "/robotwar/images/ran_g1D.png");
			break;
		case "up":
			setImage(range, "/robotwar/images/ran_g1U.png");
			break;
		}
		panelg.add(range);
		
		// Melee Slot 1
		setImage(WarHammer, "/robotwar/images/mel_g1.png");
		panelg.add(WarHammer);
		
		setImage(MekaGreen, "/robotwar/images/mekg.png");
		panelg.add(MekaGreen);
		
		//setImage(Hades, "/robotwar/images/mel_g3.png");
		//panelg.add(Hades);

		// Melee Slot 2
		setImage(ThunderBlade, "/robotwar/images/mel_g3.png");
		panelg.add(ThunderBlade);
		
		panelg.setLayout(null);
		return createImage(panelg);
	}
	
	public BufferedImage setLGreen(String sight) {
		JPanel panelg = new JPanel();
		panelg.setOpaque(false);
		panelg.setBounds(300, 57, 190, 135);

		JLabel MekaGreen  = new JLabel();
		JLabel ThunderBlade = new JLabel();
		JLabel WarHammer = new JLabel();
		JLabel Hades = new JLabel();
		JLabel range = new JLabel();
		
		MekaGreen.setBounds(66, 45, 120,90);
		ThunderBlade.setBounds(71, 75, 100,30); // Right hand + 72
		WarHammer.setBounds(68, 0, 50,100); // Left hand - 70
		Hades.setBounds(78, 64, 90,60); // Left hand - 65
		range.setBounds(95,35, 50,35);
			
		
		switch(sight) {
		case "right":
			setImage(range, "/robotwar/images/ran_g1.png");
			break;
		case "left":
			setImage(range, "/robotwar/images/ran_g1I.png");
			break;
		case "down":
			setImage(range, "/robotwar/images/ran_g1D.png");
			break;
		case "up":
			setImage(range, "/robotwar/images/ran_g1U.png");
			break;
		}
		panelg.add(range);
		
		// Melee Slot 2
		setImage(ThunderBlade, "/robotwar/images/mel_g3I.png");
		panelg.add(ThunderBlade);
		
		setImage(MekaGreen, "/robotwar/images/gmegI.png");
		panelg.add(MekaGreen);
		
		// Melee Slot 1
		setImage(WarHammer, "/robotwar/images/mel_g1.png");
		panelg.add(WarHammer);
		//setImage(Hades, "/robotwar/images/mel_g3.png");
		//panelg.add(Hades);

		
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
	
	public BufferedImage setRBlue(String sight) {
        JPanel panelb = new JPanel();
        panelb.setOpaque(false);
        panelb.setBounds(30, 30, 190, 162);

        // meka 
        JLabel MekaBlue  = new JLabel();
        
        // slot melee 1
        JLabel WarAxe = new JLabel();
        
        // slot melee 2
        JLabel Punch = new JLabel();
        //JLabel Reaper = new JLabel();
        
        // slot head
        JLabel range = new JLabel();

        //bounds = meka.getbouds
        MekaBlue.setBounds(0, 52, 120,110);
        
        //bounds meka.getweapons()[0].getbouds
        WarAxe.setBounds(14, 0, 40, 100); // Right hand + 72
        //Reaper.setBounds(90, 77, 100, 50); // Left hand - 70
        Punch.setBounds(90, 80, 100, 32); // Left hand - 65

        switch(sight) {
        case "right":
        	range.setBounds(35, 55, 65, 30);
            setImage(range, "/robotwar/images/ran_b1.png");
            break;
        case "left":
        	range.setBounds(35, 55, 65, 30);
            setImage(range, "/robotwar/images/ran_b1I.png");
            break;
        case "down":
        	range.setBounds(49, 33, 30, 65);
            setImage(range, "/robotwar/images/ran_b1D.png");
            break;
        case "up":
        	range.setBounds(49, 33,30,65);
            setImage(range, "/robotwar/images/ran_b1U.png");
            break;
        }
        panelb.add(range);

        setImage(WarAxe, "/robotwar/images/mel_b1.png");
        panelb.add(WarAxe);

        setImage(MekaBlue, "/robotwar/images/mekb.png");
        panelb.add(MekaBlue);

        //setImage(Hades, "/robotwar/images/mel_b2.png");
        //panelg.add(Hades);

        setImage(Punch, "/robotwar/images/mel_b3.png");
        panelb.add(Punch);

        panelb.setLayout(null);
        return createImage(panelb);
    }
	

	public BufferedImage setLBlue(String sight) {
		JPanel panelg = new JPanel();
		panelg.setOpaque(false);
		panelg.setBounds(30, 30, 190, 162);

		JLabel MekaBlue  = new JLabel();
        JLabel WarAxe = new JLabel();
        JLabel Reaper = new JLabel();
        JLabel Punch = new JLabel();
        JLabel range = new JLabel();
		
		MekaBlue.setBounds(70, 52, 120, 110);
	    WarAxe.setBounds(60, 0, 40, 100); // Right hand + 72
	    Reaper.setBounds(70, 77, 100, 50); // Left hand - 70
	    Punch.setBounds(70, 80, 100, 32); // Left hand - 65
		
		switch(sight) {
		case "right":
			range.setBounds(80, 50, 65, 30);
			setImage(range, "/robotwar/images/ran_b1.png");
			break;
		case "left":
			range.setBounds(80, 50, 65, 30);
			setImage(range, "/robotwar/images/ran_b1I.png");
			break;
		case "down":
			range.setBounds(100, 33, 30, 65);
			setImage(range, "/robotwar/images/ran_b1D.png");
			break;
		case "up":
			range.setBounds(100, 33, 30, 65);
			setImage(range, "/robotwar/images/ran_b1U.png");
			break;
		}
		panelg.add(range);
		
		// Melee Slot 1
		setImage(Punch, "/robotwar/images/mel_b3I.png");
		panelg.add(Punch);
		
		setImage(MekaBlue, "/robotwar/images/mekbI.png");
		panelg.add(MekaBlue);
		
		//setImage(Hades, "/robotwar/images/mel_b3.png");
		//panelg.add(Hades);
		
		// Melee Slot 2
		setImage(WarAxe, "/robotwar/images/mel_b1I.png");
		panelg.add(WarAxe);

		panelg.setLayout(null);
		return createImage(panelg);
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
			green.setPosY(green.getPosY() + green.getSpeed());
		}
		else if (keyType.upPressed)
		{
			
			green.setPosY(green.getPosY() - green.getSpeed());
		}
		else if (keyType.rightPressed)
		{
			green.setPosX(green.getPosX() + green.getSpeed());
		}
		else if (keyType.leftPressed)
		{
			green.setPosX(green.getPosX() - green.getSpeed());
		} 
		else if (keyType.downSight) 
		{
			green.direction = "down";
		} 
		else if (keyType.upSight) 
		{
			green.direction = "up";
		} 
		else if (keyType.rightSight) 
		{
			dir = 0;
			green.direction = "right";
		} 
		else if (keyType.leftSight) 
		{
			dir = 1;
			green.direction = "left";
		}
		
		
	}
	public void draw(Graphics2D pG2)
	{
		BufferedImage image = null;
		//JPanel panel = new JPanel();
		switch(green.direction)
		{
		case "up":
			image = green.upL;
			if (dir == 0)
				image = green.upR;
			break;
		case "down":
			image = green.downL;
			if (dir == 0)
				image = green.downR;
			break;
		case "right":
			image = green.rightL;
			if (dir == 0)
				image = green.rightR;
			break;
		case "left":
			image = green.leftL;
			if (dir == 0)
				image = green.leftR;
			break;
		}
		pG2.drawImage(image, green.getPosX(), green.getPosY(), gp.tileSize, gp.tileSize, null);

		
			
	}
	
}
