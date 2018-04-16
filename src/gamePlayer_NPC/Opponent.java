package gamePlayer_NPC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import gameCore.GameClass;
import gameCore.Handler;
/**
 * Opponent class extending GameObject
 * @author dominikvintr
 *
 */
public class Opponent extends GameObject {

	Random r = new Random();
	Handler handler;
	
	
	
	
	private int centerY;
	// width and height
	public static int basicHeight = GameClass.HEIGHT/6;
	private static int basicWidth = (GameClass.WIDTH / 160) * 3;
	private int offset = GameClass.WIDTH / 160;
	/**
	 * Creates opponent (opponent is computer)
	 * @param x
	 * @param y
	 * @param id
	 * @param handler
	 */
	public Opponent(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	/**
	 * Gets bounds of a rectangle
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, basicWidth, basicHeight);

	}
	/**
	 * Returns y coordinate which makes ball's and opponents rectangle centers to be aligned 
	 * @param centerY
	 * @return
	 */
	private int Y(int centerY) {
		this.centerY = centerY;
		for (int i = 0; i < handler.getObject().size(); i++) {
			
			GameObject tempObject = handler.getObject().get(i);

			if (tempObject.getId() == ID.Ball) {
				if (tempObject.getX() > (GameClass.WIDTH - (64 + basicWidth) - 42)) {
					int value = r.nextInt((((getBounds().height)/2) - (-((getBounds().height)/2))) + 1) -((getBounds().height)/2);
					
					centerY = (int) tempObject.getBounds().getCenterY() + value;
				} else {
					centerY = (int) tempObject.getBounds().getCenterY();
				}
			}
		}
		return centerY;
	}
	
	
	
	/**
	 * Tick method
	 */
	@Override
	public void tick() {
		
		x += velX;
		y = Y(centerY) - ((getBounds().height)/2);
		
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
	/**
	 * Gets rectangle height
	 * @return
	 */
	public static int getBasicHeight() {
		
		return basicHeight;
	}
}
