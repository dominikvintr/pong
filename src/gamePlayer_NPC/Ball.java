package gamePlayer_NPC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import gameCore.GameClass;
import gameCore.Handler;
import gameCore.Sounds;

public class Ball extends GameObject {
	
	//Random random = new Random(-1);
	
	private Handler handler;
	BounceAngle bounce;
	
	public Ball(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		this.getBounds();

		velX = 10;		// Ball automatically starts it's movement to the right of the screen
		velY = 10;		// Ball chooses direction(up and down) randomly
		
	}
	
	 public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	@Override
	public void tick() {
		x += velX;
		y += velY;
		if (y <= 0 || y >= GameClass.HEIGHT - 32)
			velY *= -1;
		if (x <= 0 || x >= GameClass.WIDTH - 32)
			velX *= -1;
		
		//handler.addObject(new Trail(x, y, ID.Trail, handler, Color.red, 32, 32, 0.1f));
		
		velX = collision(velY, velX);
	}
	
	private int collision(double velY, int velX) {
		this.velY = velY;
		this.velX = velX;
		for (int i = 0; i < handler.getObject().size(); i++) {

			GameObject tempObject = handler.getObject().get(i);

			if (tempObject.getId() == ID.Player || tempObject.getId() == ID.Opponent || tempObject.getId() == ID.Player2) {
					
				if (getBounds().intersects(tempObject.getBounds())) {
					velX *= -1;
					Sounds soundType = new Sounds();
					soundType.play("impact");
				}
			}
		}
		return velX;
	}
	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 32, 32);
	}

	public static int getHeight() {
		return 32;
	}
}
