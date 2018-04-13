package gamePlayer_NPC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import gameCore.GameClass;
import gameCore.Handler;

public class Opponent extends GameObject {

	Random r = new Random();
	Handler handler;
	
	
	private int centerY;
	// width and height
	public static int basicHeight = GameClass.HEIGHT/6; 

	public Opponent(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y - 5, 32, basicHeight + 5);

	}

	private int Y(int centerY) {
		this.centerY = centerY;
		for (int i = 0; i < handler.getObject().size(); i++) {

			GameObject tempObject = handler.getObject().get(i);

			if (tempObject.getId() == ID.Ball) {

				centerY = (int) tempObject.getBounds().getCenterY();
			}
		}
		return centerY;
	}

	@Override
	public void tick() {

		x += velX;
		y = Y(centerY) - ((getBounds().height)/2);

		//x = GameClass.clamp(x, 0, GameClass.WIDTH);
		y = GameClass.clamp(y, 0, GameClass.HEIGHT - basicHeight);

	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(x, y, 32, basicHeight);
	}

	public static int getBasicHeight() {
		
		return basicHeight;
	}
}
