package gamePlayer_NPC;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.util.Random;

import gameCore.GameClass;
import gameCore.Handler;

public class Player extends GameObject {

	Random r = new Random();
	Handler handler;
	private int offset = GameClass.WIDTH / 160;
	
	// width and height
	private static int basicHeight = GameClass.HEIGHT/6;
	private static int basicWidth = (GameClass.WIDTH / 160) * 3;
	

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, basicWidth, basicHeight);
	}

	@Override
	public void tick() {
		
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		
		x += velX;
		y = (int) b.getY();

		//x = GameClass.clamp(x, 0, GameClass.WIDTH);
		//y = GameClass.clamp(y, 0, GameClass.HEIGHT - basicHeight);
		y = GameClass.clamp(y, (4 * (offset)), GameClass.HEIGHT - (4 * (offset)) -basicHeight);
	}
	
	@Override
	public void render(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(x, y, basicWidth, basicHeight);
	}
}
