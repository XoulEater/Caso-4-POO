package robotwar.Interfazes;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import robotwar.common.IVariables;
import robotwar.gamebasics.IRobotito;

public class EnergyBar {
	private List<String> images;
	private IRobotito robot;
	private int posX, posY;

	public EnergyBar(IRobotito pRobot, int pPosX, int pPosY) {
		this.robot = pRobot;
		this.posX = pPosX;
		this.posY = pPosY;
		images = new ArrayList<>();
		Collections.addAll(images, "/robotwar/images/en0.png", "/robotwar/images/en1.png", "/robotwar/images/en2.png",
				"/robotwar/images/en3.png", "/robotwar/images/en4.png", "/robotwar/images/en5.png",
				"/robotwar/images/en6.png", "/robotwar/images/en7.png", "/robotwar/images/en8.png",
				"/robotwar/images/en9.png", "/robotwar/images/en10.png");
		IVariables varS = IVariables.getInstance();
		varS.addEnergyBar(this);
	}
	public void draw(Graphics2D pGp) { // "/robotwar/images/sierra.gif"
		BufferedImage image;
		try {
			if (robot.energy < 0) {
				image = ImageIO.read(getClass().getResource(images.get(0)));
			} else {
				image = ImageIO.read(getClass().getResource(images.get(robot.energy / 10)));
			}
			pGp.drawImage(image, posX, posY, 280, 70, null);
			pGp.drawImage(image, posX+1200, posY, 280, 70, null);
		} catch (IOException e) {

		}
	}
}
