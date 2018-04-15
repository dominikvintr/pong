package gamePlayer_NPC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import gameCore.GameClass;
import gameCore.Handler;
import gameCore.Sounds;

public class Ball extends GameObject {

	// Random random = new Random(-1);

	public static int basicHeight = GameClass.HEIGHT / 6;
	private Handler handler;
	BounceAngle bounce;
	private int offset = GameClass.WIDTH / 160;

	public Ball(int x, int y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;
		this.getBounds();
		this.getY();

		velX = 10; // Ball automatically starts it's movement to the right of the screen
		velY = 10; // Ball chooses direction(up and down) randomly

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	@Override
	public void tick() {
		velX = collision(velX);
		velY = collision2(velY);
		x += velX;
		y = (int) (y + velY);
		if (y <= (4 * (offset)) || y >= GameClass.HEIGHT - 32 - (4 * (offset)))
			velY *= -1;
		if (x <= 0 || x >= GameClass.WIDTH - 32)
			velX *= -1;

		// handler.addObject(new Trail(x, y, ID.Trail, handler, Color.red, 32, 32,
		// 0.1f));
	}

	private int collision(int velX) {
		this.velX = velX;
		for (int i = 0; i < handler.getObject().size(); i++) {

			GameObject tempObject = handler.getObject().get(i);

			if (tempObject.getId() == ID.Player || tempObject.getId() == ID.Opponent
					|| tempObject.getId() == ID.Player2) {

				if (getBounds().intersects(tempObject.getBounds())) {
					velX *= -1;
					Sounds soundType = new Sounds();
					soundType.play("impact");
				}
			}
		}
		return velX;
	}

	private int collision2(double velY) {
		for (int i = 0; i < handler.getObject().size(); i++) {
			GameObject tempObject = handler.getObject().get(i);
			if (tempObject.getId() == ID.Player 
					|| tempObject.getId() == ID.Opponent
					|| tempObject.getId() == ID.Player2) {

				if (getBounds().intersects(tempObject.getBounds())) {
					System.out.println(Ball.this.getY());
					System.out.println(tempObject.getY());
					if (Ball.this.getY() <= (tempObject.getY() + basicHeight / 5)) {
						velY = -10;
					} else if (Ball.this.getY() <= tempObject.getY() + (basicHeight / 5)*2 && Ball.this.getY() >= tempObject.getY() + basicHeight / 5) {
						velY = -5;
					} else if (Ball.this.getY() <= tempObject.getY() + (basicHeight / 5)*3 && Ball.this.getY() >= tempObject.getY() + (basicHeight / 5)*2) {
						velY = 1;
					} else if (Ball.this.getY() <= tempObject.getY() + (basicHeight / 5)*4 && Ball.this.getY() >= tempObject.getY() + (basicHeight / 5)*3) {
						velY = 5;
					} else if (Ball.this.getY() <= tempObject.getY() + basicHeight && Ball.this.getY() >= tempObject.getY() + (basicHeight / 5)*4) {
						velY = 10;
					}
					
				}
			}
		}
		System.out.println(velY);
		return (int) velY;
	} 

	@Override
	public void render(Graphics g) {
		if (GameClass.paused == true) {
		} else {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, 32, 32);
		}
	}

	public static int getHeight() {
		return 32;
	}
}
