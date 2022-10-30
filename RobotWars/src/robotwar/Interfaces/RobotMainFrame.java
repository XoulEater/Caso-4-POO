package robotwar.Interfaces;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import robotwar.common.*;

import robotwar.Interfaces.RobotController;



public class RobotMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private RobotController controller;
	private JPanel panelg;
	private JPanel panelb;
	private int panel2xMax = IConstants.ARENA_WIDTH, panel2yMax = IConstants.ARENA_HEIGTH;
	public int direcction = 0;
		
	public RobotMainFrame(RobotController pController)
	{
		controller = pController;
		controller.setWindow(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(0, 0, panel2xMax, panel2yMax);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(panel2xMax*2, panel2yMax*2));
		this.setLayout(null); //Un metodo para acomodar automaticamente
		this.setBackground(Color.white);
		this.initComponents();
		this.setVisible(true);	
		
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
	
	int moveImage(JPanel panel1, JButton button1, JButton button2, JButton button3, JButton button4, JButton button5, int dir) {
		return dir;	
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
		
		//ImageIcon imagen  = new ImageIcon();

   
}

