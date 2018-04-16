package gameCore;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import gameCore.GameClass.STATE;
import gameCore.Menu;
/**
 * Class for the game window
 * @author dominikvintr
 *
 */
public class Window extends Canvas {
	
	Menu menu;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3960454836806068271L;
	private int blank = 0;

	public void blank(int bl) {
		blank  = bl;
	}
	
/**
 * Creates instance of a JFrame window
 * Window is always maximized
 * @param width
 * @param height
 * @param title
 * @param game
 * @throws InterruptedException
 */
	public Window(int width, int height, String title, GameClass game) throws InterruptedException {
		JFrame frame = new JFrame(title);
		
		
		// frame.setPreferredSize(new Dimension(width, height));
		// frame.setMaximumSize(new Dimension(width, height));
		// frame.setMinimumSize(new Dimension(wid th, height));
		// if (frame.getHeight() == height)
		// frame.getContentPane().addMouseListener(new ClickListener());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);

		Toolkit tool = Toolkit.getDefaultToolkit();
		int x = (int) tool.getScreenSize().getWidth();
		int y = (int) tool.getScreenSize().getHeight();
		frame.setSize(x, y);
		
		game.start();

	}
}
