package gameCore;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

/**
 * Class which gets values of current screen
 * @author dominikvintr
 *
 */
public class Screen {
	
	
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	/**
	 * Screen width
	 * @return
	 */
	public int getScreenWidth() {
		
		int width = gd.getDisplayMode().getWidth();
		return width;
		
	}
	/**
	 * Screen height
	 * @return
	 */
	public int getScreenHeight() {
		
		int height = gd.getDisplayMode().getHeight();
		return height;
		
	}
	/**
	 * Window size
	 * @return
	 */
	public int windowsSize() {
		
		Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		int winHeight = (int) winSize.getHeight();
		return winHeight;
	}
}
