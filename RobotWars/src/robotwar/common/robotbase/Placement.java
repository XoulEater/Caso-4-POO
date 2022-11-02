package robotwar.common.robotbase;

import java.util.*;

// Posicion dentro del panel
public class Placement {
	int posY, posX, lenght, width;
	
	public Placement() {
		posY = posX = lenght = width = 0;
	}
	
	public void setSize(int plenght, int pwidth) {
		this.lenght = plenght;
		this.width = pwidth;
	}
	
	public void setPos(int pposX, int pposY) {
		this.posX = pposX;
		this.posY = pposY;
	}
	
	public List<Integer> getPlacements() {
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list, posX, posX, lenght,width);
		return list;
	}
	
	
}
