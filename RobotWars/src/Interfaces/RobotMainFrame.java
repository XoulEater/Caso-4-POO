package Interfaces;

import java.awt.Color;
import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Interfaces.RobotController;
import robotwar.common.*;

public class RobotMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private RobotController controller;
	private JLabel lblLastNumber;
	private JLabel lblHistory;
	private JTextField txtAmount;
	private JTextField txtNumbers;
	private JPanel panelC;
	private int panel2xMax = IConstants.ARENA_WIDTH, panel2yMax = IConstants.ARENA_HEIGTH;
	
	private void crearNuevoPanelController() {//Crea panel con planta
		JPanel panelc = new JPanel();
		panelc.setBackground(Color.gray);
		panelc.setBounds(750, 0, 250, 650);
		panelc.setMaximumSize(new Dimension (60,50));
		int x = (int) panelc.getBounds().getMaxX();
		int y = (int) panelc.getBounds().getMaxY();
		this.panel2xMax = x -750;
		this.panel2yMax = y;
		panelc.setLayout(null);
		this.panelC = panelc;

	}
	public void initComponents() {
		crearNuevoPanelController();
		this.add(panelC);
		
		//ImageIcon imagen  = new ImageIcon();

    	
}
}
