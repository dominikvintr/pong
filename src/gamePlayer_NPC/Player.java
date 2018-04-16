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
/**
 * Player class extending GameObject
 * Player is player one located on the left of the screen
 * @author dominikvintr
 *
 */
public class Player extends GameObject {

	Random r = new Random();
	Handler handler;
	private int offset = GameClass.WIDTH / 160;
	private int mode;
	
	// width and height
	private static int basicHeight = GameClass.HEIGHT/6;
	private static int basicWidth = (GameClass.WIDTH / 160) * 3;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param id
	 * @param handler
	 */
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	/**
	 * Gets rectangle bounds
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, basicWidth, basicHeight);
	}
	public void setMode(int i) {
		mode = i;
	}
	/**
	 * Tick method
	 */
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
	/**
	 * Render method
	 */
	@Override
	public void render(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(x, y, basicWidth, basicHeight);
	}
}
