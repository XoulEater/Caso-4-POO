package robotwar.Interfaces;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyBoard extends JPanel implements KeyListener{
	private JLabel prueba = new JLabel("holaMundo");
	
	public KeyBoard() {
		addKeyListener(this);
		setFocusable(true);
		add(prueba);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W' || e.getExtendedKeyCode() == KeyEvent.VK_UP)
		{
			prueba.setLocation(prueba.getX(), prueba.getY()-5);
		}
		if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A' || e.getExtendedKeyCode() == KeyEvent.VK_LEFT)
		{
			prueba.setLocation(prueba.getX()-5, prueba.getY());
		}
		if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D' || e.getExtendedKeyCode() == KeyEvent.VK_RIGHT)
		{
			prueba.setLocation(prueba.getX()+5, prueba.getY());
		}
		if (e.getKeyChar() == 's' || e.getKeyChar() == 'S' || e.getExtendedKeyCode() == KeyEvent.VK_DOWN)
		{
			prueba.setLocation(prueba.getX(), prueba.getY()+5);
		}
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
