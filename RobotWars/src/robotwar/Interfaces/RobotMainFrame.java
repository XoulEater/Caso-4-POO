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
	private JPanel panelC;
	private boolean simulacion = true;
	private int panel2xMax = IConstants.ARENA_WIDTH, panel2yMax = IConstants.ARENA_HEIGTH;

		
	public RobotMainFrame(RobotController controller)
	{
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(0, 0, panel2xMax, panel2yMax);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(panel2xMax*2, panel2yMax*2));
		this.setLayout(null);
		this.setBackground(Color.white);
		addKeyListener(this);
		setFocusable(true);
		this.setVisible(true);	
		
		this.initComponents();	
	
	}
	


	private void crearPanelPersonaje(int x, int y) {//Crea panel con planta
		JPanel panelc = new JPanel();
		panelc.setBackground(Color.green);
		panelc.setBounds(10, 10, x, y);
		panelc.setMaximumSize(new Dimension (500,500));
		panelc.setLayout(null);
		
		JLabel personaje = new JLabel("image");
		personaje.setBounds(10, 10, x,y);
	
		setImage(personaje, "/robotwar/images/sunset.png");
		panelc.add(personaje);

		
		this.panelC = panelc;
	}
	
	public JLabel setImage(JLabel pLabel, String ruta) {
		ImageIcon image = new ImageIcon(getClass().getResource("/robotwar/images/Mecha_pong_pong.png"));
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(pLabel.getWidth(), pLabel.getHeight(), Image.SCALE_DEFAULT));
		pLabel.setIcon(icon);
        
        return pLabel;
    }

	private void initComponents() {
		crearPanelPersonaje(200,200);
		
		this.add(panelC);		
		panelC.repaint();
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W' || e.getExtendedKeyCode() == KeyEvent.VK_UP)
		{
			panelC.setLocation(panelC.getX(), panelC.getY()-5);
		}
		if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A' || e.getExtendedKeyCode() == KeyEvent.VK_LEFT)
		{
			panelC.setLocation(panelC.getX()-5, panelC.getY());
		}
		if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D' || e.getExtendedKeyCode() == KeyEvent.VK_RIGHT)
		{
			panelC.setLocation(panelC.getX()+5, panelC.getY());
		}
		if (e.getKeyChar() == 's' || e.getKeyChar() == 'S' || e.getExtendedKeyCode() == KeyEvent.VK_DOWN)
		{
			panelC.setLocation(panelC.getX(), panelC.getY()+5);
		}
		this.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
