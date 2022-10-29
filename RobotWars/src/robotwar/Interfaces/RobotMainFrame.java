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
	private JPanel panelC;
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
	
	private void crearPanelPersonaje() {//Crea panel con planta
		JPanel panelc = new JPanel();
		panelc.setBackground(Color.green);
		panelc.setBounds(10, 10, 1000, 1000);
		panelc.setMaximumSize(new Dimension (60,50));
		
		JLabel personaje = new JLabel("image");
		personaje.setBounds(10, 10, 120,120);
	
		setImage(personaje, "/robotwar/images/sunset.png");
		panelc.add(personaje);
	
		panelc.setLayout(null);
		this.panelC = panelc;
	}
	
	public JLabel setImage(JLabel pLabel, String ruta) {
		ImageIcon image = new ImageIcon(getClass().getResource("/robotwar/images/Mecha_pong_pong.png"));
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(pLabel.getWidth(), pLabel.getHeight(), Image.SCALE_DEFAULT));
		pLabel.setIcon(icon);
        
        return pLabel;
    }
	
	int moveImage(JPanel panel1, JButton button1, JButton button2, JButton button3, JButton button4, JButton button5, int dir) {
		return dir;	
	}
	private void initComponents() {
		crearPanelPersonaje();
		
		this.add(panelC);
		
		//ImageIcon imagen  = new ImageIcon();

   
}
}
