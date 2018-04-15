package gamePlayer_NPC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import gameCore.GameClass;
import gameCore.HUD;
import gameCore.Handler;
import gameCore.Sounds;
import gameCore.Values;

public class Ball extends GameObject {

	Random rand = new Random();
	int value = rand.nextInt((1 - (-1)) + 1) -1;

	public static int basicHeight = GameClass.HEIGHT / 6;
	private Handler handler;
	GameClass game;
	Values val;
	private int offset = GameClass.WIDTH / 160;

	public Ball(int x, int y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;
		this.getBounds();
		this.getY();
		this.getX();

		velX = 10;
		velY = 10*value;

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
			velX *= 1;
		if (x < 0) {
			//val.setBallX(Ball.this.getX());
			//game.setX(10);
			//hud.setX(10);
		}
		
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
					//System.out.println(Ball.this.getY());
					//System.out.println(tempObject.getY());
					if (Ball.this.getY() + 16 <= (tempObject.getY() + basicHeight / 5)) {
						velY = -10;
					} else if (Ball.this.getY() <= tempObject.getY() + (basicHeight / 5)*2 && Ball.this.getY() + 16 >= tempObject.getY() + basicHeight / 5) {
						velY = -5;
					} else if (Ball.this.getY() + 16 <= tempObject.getY() + (basicHeight / 5)*3 && Ball.this.getY() + 16 >= tempObject.getY() + (basicHeight / 5)*2) {
						velY = 1;
					} else if (Ball.this.getY() + 16 <= tempObject.getY() + (basicHeight / 5)*4 && Ball.this.getY() + 16 >= tempObject.getY() + (basicHeight / 5)*3) {
						velY = 5;
					} else if (Ball.this.getY() + 16 <= tempObject.getY() + basicHeight && Ball.this.getY() + 16 >= tempObject.getY() + (basicHeight / 5)*4) {
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
			if (x<= -600 || x >= GameClass.WIDTH + 600) {
				x = GameClass.WIDTH/2;
				g.fillRect(x, y, 32, 32);
				//hud.setLives(-1);
			} else {
				g.fillRect(x, y, 32, 32);
				//hud.setLives(1);
			}
		}
	}

	public static int getHeight() {
		return 32;
	}
}
