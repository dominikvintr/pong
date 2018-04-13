package gamePlayer_NPC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import gameCore.GameClass;
import gameCore.Handler;

public class Player2 extends GameObject {
	public Player2(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	Random r = new Random();
	Handler handler;
	
	// width and height
	private int basicHeight = GameClass.HEIGHT/6; 


	public Rectangle getBounds() {
		return new Rectangle(x, y - 5, 32, basicHeight + 5);
	}

	@Override
	public void tick() {

		x += velX;
		y += velY;

		//x = GameClass.clamp(x, 0, GameClass.WIDTH);
		y = GameClass.clamp(y, 0, GameClass.HEIGHT - basicHeight);

		//collision();

	}
	
	/*
	 * We need some sort of mechanism which would change the movement
	 * 
	 */

	/* We don't need this since when player collides with so called enemy, then it doesn't affect any health at all
	 * Keep this void for future, just in case
	 * 
		private void collision() {
			for (int i = 0; i < handler.getObject().size(); i++) {
	
				GameObject tempObject = handler.getObject().get(i);
	
				if (tempObject.getId() == ID.BasicEnemy) {
						
					if (getBounds().intersects(tempObject.getBounds())) {
						// collision code
						HUD.HEALTH -=2;
					}
				}
			}
		}
	*/
	@Override
	public void render(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(x, y, 32, basicHeight);
	}
}
