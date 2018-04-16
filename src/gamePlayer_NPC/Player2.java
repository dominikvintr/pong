package gamePlayer_NPC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import gameCore.GameClass;
import gameCore.Handler;
/**
 * Player2 class extending GameObject
 * Player1 is player two located on the right of the screen
 * @author dominikvintr
 *
 */
public class Player2 extends GameObject {
	public Player2(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	Random r = new Random();
	Handler handler;
	private int offset = GameClass.WIDTH / 160;
	
	// width and height
	private static int basicHeight = GameClass.HEIGHT/6;
	private static int basicWidth = (GameClass.WIDTH / 160) * 3;

	/**
	 * Gets rectangle bounds
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, basicWidth, basicHeight);
	}
	/**
	 * Tick method
	 */
	@Override
	public void tick() {

		x += velX;
		y += velY;

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
