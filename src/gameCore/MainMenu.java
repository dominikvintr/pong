package gameCore;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class MainMenu {
	/*
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(GameClass.WIDTH/2 - 10, 0, 20, GameClass.HEIGHT/10 - 1);
		
		// main position for the options of the main menu
		rectangle mm = g.drawRect((GameClass.WIDTH/48)*16, (GameClass.HEIGHT/48)*5, (GameClass.WIDTH/48)*16, (GameClass.HEIGHT/48)*4);
		
		System.out.println(GameClass.WIDTH);
		System.out.println(GameClass.HEIGHT);
	}
	*/
	
	private int Y;
	private int X;
	
	

	//data for Single Player Option
	public int singlePY = (GameClass.HEIGHT/48)*5;
	public int singlePX = (GameClass.WIDTH/48)*16;
	public int singlePWidth = (GameClass.WIDTH/48)*16;
	public int singlePHeight = (GameClass.HEIGHT/48)*4;
	
	
	public void render(Graphics g) {
		
		// meta for every rectangle
		g.setColor(Color.BLUE);
		
		g.drawRect(singlePX, singlePY, singlePWidth, singlePHeight);
	}
		
	
	
	
	public void setOption(int valueX, int valueY) {
		X = valueX;
		Y = valueY;
	}
		
	public int getOption() {
		
		int option = 0;
		System.out.println(X + " " +Y);
		
		for (int x = singlePX; x <= (singlePX + singlePWidth); x++) {
			
			if (x == X) {
				
				for (int y = singlePY; y <= (singlePY + singlePHeight); y++ ) {
					
					if (y == Y) {
						option = 1;
					}
					
				}
				
			}
		}
		
		return option;
	}
	
	public void tick() {
		
	}

}
