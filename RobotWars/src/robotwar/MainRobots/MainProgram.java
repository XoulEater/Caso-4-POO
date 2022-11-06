package robotwar.MainRobots;

import java.awt.Dimension;

import javax.swing.JFrame;


import robotwar.Interfaces.*;
import robotwar.common.IConstants;
import robotwar.common.robotbase.BlueRobot;
import robotwar.common.robotbase.GreenRobot;
import robotwar.weapons.BlueRocket;
import robotwar.weapons.BlueShooter;
import robotwar.weapons.GreenLaser;
import robotwar.weapons.GreenScope;
import robotwar.weapons.Hades;
import robotwar.weapons.LavaAxe;
import robotwar.weapons.PunchArm;
import robotwar.weapons.Reaper;
import robotwar.weapons.ThunderBlade;
import robotwar.weapons.Warhammer;

public class MainProgram {

	public static void main(String[] args)  {
		
		JFrame window =  new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("RobotWars");
		window.setPreferredSize(new Dimension(IConstants.ARENA_WIDTH,IConstants.ARENA_HEIGTH));
		
		GreenRobot meka = new GreenRobot();
		
		GreenScope head1 = new GreenScope(0);
		GreenLaser head2 = new GreenLaser(0);
		Warhammer hammer = new Warhammer(0);
		ThunderBlade blade = new ThunderBlade(0);
		Hades hades = new Hades(0);
		meka.addWeapon(blade);
		meka.addWeapon(hades);
		meka.addStrike(head1);
		meka.getPlayerImage();
	
		BlueRobot meka2 = new BlueRobot();
		
		BlueRocket head3 = new BlueRocket(0);
		BlueShooter head4 = new BlueShooter(0);
		
		PunchArm arm = new PunchArm(0);
		LavaAxe axe = new LavaAxe(0);
		Reaper reaper = new Reaper(0);

		meka2.addWeapon(axe);
		meka2.addWeapon(arm);
		meka2.addStrike(head3);
		meka2.getPlayerImage();
		
		RobotController MainGame = new RobotController(meka);
		GameInterface interfaz = new GameInterface(MainGame);
		interfaz.robot1 = meka;
		
		window.add(interfaz);
		window.pack(); 

		window.setLocationRelativeTo(null);
		window.setVisible(true );
		
		MainGame.startGameThread();
	
	}
}
