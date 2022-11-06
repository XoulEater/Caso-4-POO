package robotwar.MainRobots;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import robotwar.Interfaces.BackGround;
import robotwar.common.IConstants;
import robotwar.common.robotbase.IRobotito;

public class SelectInterface extends JPanel {
	private static final int originalSize = 25; // Defalt size of each panel 25x25
	private static final int scale = 4;
	public static final int tileSize = originalSize * scale; // Decides all ths screen sizes. 100x100
	private BackGround fondo = new BackGround("/robotwar/images/menu.jpg");
	private FactoryController controller;
	public IRobotito robot1;
	private static final long serialVersionUID = 1L;
	
	public JLabel robot;
	public JLabel arma1;
	public JLabel arma2;
	public JLabel head;
	private JButton confirmButton;

	public SelectInterface(FactoryController mainFactory) {
		this.controller = mainFactory;
		this.controller.setWindow(this);
		initComponents();
		this.setPreferredSize(new Dimension(IConstants.ARENA_WIDTH, IConstants.ARENA_HEIGTH));
		this.setLayout(null); // this allows this frame to locate the components with freedom in the screen
		this.setBackground(Color.white);
		this.initComponents();
		this.setVisible(true);
		
	}

	private void initComponents() {
		JButton gRobot = new JButton();
		gRobot.setBounds(61, 527, 147, 138);
		gRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setRobot("Green");
			}
		});
		gRobot.setOpaque(false);
		gRobot.setContentAreaFilled(false);
		gRobot.setBorderPainted(false);
		this.add(gRobot);

		JButton bRobot = new JButton();
		bRobot.setBounds(61, 261, 147, 138);
		bRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setRobot("Blue");
			}
		});
		bRobot.setOpaque(false);
		bRobot.setContentAreaFilled(false);
		bRobot.setBorderPainted(false);
		this.add(bRobot);

		JButton bHead1 = new JButton();
		bHead1.setBounds(304, 248, 95, 45);
		bHead1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setHead("Blue", 1);
			}
		});
		bHead1.setOpaque(false);
		bHead1.setContentAreaFilled(false);
		bHead1.setBorderPainted(false);
		this.add(bHead1);

		JButton bHead2 = new JButton();
		bHead2.setBounds(424, 250, 95, 45);
		bHead2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setHead("Blue", 2);
			}
		});
		bHead2.setOpaque(false);
		bHead2.setContentAreaFilled(false);
		bHead2.setBorderPainted(false);
		this.add(bHead2);

		JButton gHead1 = new JButton();
		gHead1.setBounds(318, 500, 94, 67);
		gHead1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setHead("Green", 1);
			}
		});
		gHead1.setOpaque(false);
		gHead1.setContentAreaFilled(false);
		gHead1.setBorderPainted(false);
		this.add(gHead1);

		JButton gHead2 = new JButton();
		gHead2.setBounds(452, 507, 83, 65);
		gHead2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setHead("Green", 2);
			}
		});
		gHead2.setOpaque(false);
		gHead2.setContentAreaFilled(false);
		gHead2.setBorderPainted(false);
		this.add(gHead2);

		JButton gWeapon1 = new JButton();
		gWeapon1.setBounds(300, 614, 33, 71);
		gWeapon1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setWeapon("Green", 1);
			}
		});
		gWeapon1.setOpaque(false);
		gWeapon1.setContentAreaFilled(false);
		gWeapon1.setBorderPainted(false);
		this.add(gWeapon1);

		JButton gWeapon2 = new JButton();
		gWeapon2.setBounds(360, 635, 100, 27);
		gWeapon2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setWeapon("Green", 2);
			}
		});
		gWeapon2.setOpaque(false);
		gWeapon2.setContentAreaFilled(false);
		gWeapon2.setBorderPainted(false);
		this.add(gWeapon2);

		JButton gWeapon3 = new JButton();
		gWeapon3.setBounds(488, 618, 65, 53);
		gWeapon3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setWeapon("Green", 3);
			}
		});
		gWeapon3.setOpaque(false);
		gWeapon3.setContentAreaFilled(false);
		gWeapon3.setBorderPainted(false);
		this.add(gWeapon3);

		JButton bWeapon1 = new JButton();
		bWeapon1.setBounds(295, 335, 36, 88);
		bWeapon1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setWeapon("Blue", 1);
			}
		});
		bWeapon1.setOpaque(false);
		bWeapon1.setContentAreaFilled(false);
		bWeapon1.setBorderPainted(false);
		this.add(bWeapon1);

		JButton bWeapon2 = new JButton();
		bWeapon2.setBounds(365, 360, 87, 49);
		bWeapon2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setWeapon("Blue", 2);
			}
		});
		bWeapon2.setOpaque(false);
		bWeapon2.setContentAreaFilled(false);
		bWeapon2.setBorderPainted(false);
		this.add(bWeapon2);

		JButton bWeapon3 = new JButton();
		bWeapon3.setBounds(484, 362, 80, 39);
		bWeapon3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setWeapon("Blue", 3);
			}
		});
		bWeapon3.setOpaque(false);
		bWeapon3.setContentAreaFilled(false);
		bWeapon3.setBorderPainted(false);
		this.add(bWeapon3);

		JTextField playerName = new JTextField();

		confirmButton = new JButton("Confirmar");
		confirmButton.setBounds(800, 560, 235, 110);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.confirm();
			}
		});
		this.add(confirmButton);
		
		robot = new JLabel();
		robot.setBounds(730, 120, 147, 138);
		robot.setBackground(Color.red);
		//robot.setOpaque(false);
		this.add(robot);
		
		head = new JLabel();
		head.setBounds(986, 165, 143, 78);
		head.setBackground(Color.red);
		//arma1.setOpaque(false);
		this.add(head);
		
		arma1 = new JLabel();
		arma1.setBounds(802, 353, 120, 120);
		robot.setBackground(Color.red);
		//arma2.setOpaque(false);
		this.add(arma1);
		
		arma2 = new JLabel();
		arma2.setBounds(947, 353, 120, 120);
		arma2.setBackground(Color.red);
		//head.setOpaque(false);
		this.add(arma2);
		


	}
	
	

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		fondo.draw(g2);
		confirmButton.repaint();
		//arma1.repaint();


		//g2.dispose();
	}
}
