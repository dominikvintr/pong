package gameCore;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;


public class Screen {
	
	
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	
	public int getScreenWidth() {
		
		int width = gd.getDisplayMode().getWidth();
		return width;
		
	}
	
	public int getScreenHeight() {
		
		int height = gd.getDisplayMode().getHeight();
		return height;
		
	}
	
	public int windowsSize() {
		
		Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		int winHeight = (int) winSize.getHeight();
		return winHeight;
	}
}
