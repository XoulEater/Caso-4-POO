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
	}
	
	public void getPlayerImage()
	{
		green.up1 = righGreen(0);
		green.down1 = righGreen(1);
		green.left1 = righGreen(3);
		green.right1 = righGreen(2);
	}
	
	public BufferedImage righGreen(int pIndex) {
		JPanel panelg = new JPanel();
		panelg.setOpaque(false);
		panelg.setBounds(300, 57, 190, 135);

		
		JLabel MekaGreen  = new JLabel();
		MekaGreen.setBounds(0, 45, 120,90);
		
		JLabel ThunderBlade = new JLabel();
		ThunderBlade.setBounds(90, 75, 100,30); // Right hand + 72
		
		JLabel WarHammer = new JLabel();
		WarHammer.setBounds(0, 0, 50,100); // Left hand - 70
		
		JLabel Hades = new JLabel();
		Hades.setBounds(90, 64, 90,60); // Left hand - 65
		
		JLabel range = new JLabel();
		range.setBounds(45,35, 50,35);
		
		setImage(WarHammer, "/robotwar/images/mel_g1.png");
		panelg.add(WarHammer);
	
		//setImage(range, "/robotwar/images/ran_g2.png");
		
		
		if (pIndex == 0) {
			setImage(range, "/robotwar/images/ran_g1U.png");
		} else if (pIndex == 1) {
			setImage(range, "/robotwar/images/ran_g1D.png");
		} else if (pIndex == 2) {
			setImage(range, "/robotwar/images/ran_g1.png");
		} else {
			setImage(range, "/robotwar/images/ran_g1I.png");
		}
		panelg.add(range);
		
		setImage(MekaGreen, "/robotwar/images/mekg.png");
		panelg.add(MekaGreen);
		
		//setImage(Hades, "/robotwar/images/mel_g3.png");
		//panelg.add(Hades);
	
		
		setImage(ThunderBlade, "/robotwar/images/mel_g3.png");
		panelg.add(ThunderBlade);
	
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
			green.direction = "down";
			green.setPosY(green.getPosY() + green.getSpeed());
		}
		else if (keyType.upPressed)
		{
			green.direction = "up";
			green.setPosY(green.getPosY() - green.getSpeed());
		}
		else if (keyType.rightPressed)
		{
			green.direction = "right";
			green.setPosX(green.getPosX() + green.getSpeed());
		}
		else if (keyType.leftPressed)
		{
			green.direction = "left";
			green.setPosX(green.getPosX() - green.getSpeed());
		}
	}
	public void draw(Graphics2D pG2)
	{
		BufferedImage image = null;
		//JPanel panel = new JPanel();
		switch(green.direction)
		{
		case "up":
			image = green.up1;
			break;
		case "down":
			image = green.down1;
			break;
		case "right":
			image = green.right1;
			break;
		case "left":
			image = green.left1;
			break;
		}
		pG2.drawImage(image, green.getPosX(), green.getPosY(), gp.tileSize, gp.tileSize, null);

		
			
	}
	
}
