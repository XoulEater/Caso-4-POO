package robotwar.Interfaces;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import robotwar.common.*;

import robotwar.Interfaces.*;



public class RobotMainFrame extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	private RobotController controller;

	private JPanel panelg;
	private JPanel panelb;
	
	public RobotMainFrame (RobotController pController)
	{
		this.controller = pController;
	}

	private void crearPanelPersonaje1() {//Crea panel con robot verde
		JPanel panelg = new JPanel();
		panelb.setOpaque(false);
		panelg.setBounds(300, 57, 190, 135);
		panelg.setMaximumSize(new Dimension (60,50));
		
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
		setImage(range, "/robotwar/images/ran_g1.png");
		panelg.add(range);
		
		setImage(MekaGreen, "/robotwar/images/mekg.png");
		panelg.add(MekaGreen);
		
		//setImage(Hades, "/robotwar/images/mel_g3.png");
		//panelg.add(Hades);
	
		
		setImage(ThunderBlade, "/robotwar/images/mel_g3.png");
		panelg.add(ThunderBlade);
	
		panelg.setLayout(null);
		this.panelg = panelg;
	}
	private void crearPanelPersonaje2() {//Crea panel con robot verde
		JPanel panelb = new JPanel();
		panelb.setOpaque(false);
		panelb.setBounds(30, 30, 190, 162);
		panelb.setMaximumSize(new Dimension (60,50));
		
		JLabel MekaBlue = new JLabel();
		MekaBlue.setBounds(0, 52, 120,110);
		
		JLabel WarAxe = new JLabel();
		WarAxe.setBounds(14, 0, 40, 100); // Right hand + 77
		
		JLabel Reaper = new JLabel();
		Reaper.setBounds(90, 77, 100, 50); // Left hand -73
		
		JLabel Punch = new JLabel();
		Punch.setBounds(90, 80, 100, 32); // Left hand -70
		
		JLabel range = new JLabel();
		range.setBounds(35, 55, 65, 30);

		setImage(WarAxe, "/robotwar/images/mel_b1.png");
		panelb.add(WarAxe);
		
		//setImage(range, "/robotwar/images/ran_b2.png");
		setImage(range, "/robotwar/images/ran_b1.png");
		panelb.add(range);
		
		setImage(MekaBlue, "/robotwar/images/mekb.png");
		panelb.add(MekaBlue);
		
		//setImage(Reaper, "/robotwar/images/mel_b2.png");
		//panelb.add(Reaper);
		
		setImage(Punch, "/robotwar/images/mel_b3.png");
		panelb.add(Punch);
		

		panelb.setLayout(null);
		this.panelb = panelb;

	}
	
	public JLabel setImage(JLabel pLabel, String ruta) {
		ImageIcon image = new ImageIcon(getClass().getResource(ruta));
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(pLabel.getWidth(), pLabel.getHeight(), Image.SCALE_DEFAULT));
		pLabel.setIcon(icon);
        return pLabel;
    }
	
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W' || e.getExtendedKeyCode() == KeyEvent.VK_UP)
		{
			panelb.setLocation(panelg.getX(), panelg.getY()-5);
		}
		if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A' || e.getExtendedKeyCode() == KeyEvent.VK_LEFT)
		{
			panelg.setLocation(panelg.getX()-5, panelg.getY());
		}
		if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D' || e.getExtendedKeyCode() == KeyEvent.VK_RIGHT)
		{
			panelg.setLocation(panelg.getX()+5, panelg.getY());
		}
		if (e.getKeyChar() == 's' || e.getKeyChar() == 'S' || e.getExtendedKeyCode() == KeyEvent.VK_DOWN)
		{
			panelg.setLocation(panelg.getX(), panelg.getY()+5);
		}
		this.repaint();
	}

	private void initComponents() {
		crearPanelPersonaje2();
		crearPanelPersonaje1();
		this.add(panelb);
		this.add(panelg);
	}
	
	public void moveblue() {
		panelb.setLocation(panelb.getLocation().x + 15, panelb.getLocation().y);
		panelb.repaint();
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		
	}
 
}


