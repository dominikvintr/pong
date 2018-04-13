package gameCore;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.JFrame;

public class HUD {

//	public static int HEALTH = 100;

//	private int greenValue = 255;
	
	private int counter = 0;

	private int score = 0;
	private int level = 1;
	
	private int w = GameClass.WIDTH;
	private int h = GameClass.HEIGHT;
	
	ImageObserver observer;

	public void tick() {
//		HEALTH = GameClass.clamp(HEALTH, 0, 100);
//		greenValue = GameClass.clamp(greenValue, 0, 255);

//		greenValue = HEALTH * 2;

		score++;

	}
	

	public void render(Graphics g) {
//		g.setColor(Color.gray);
//		g.fillRect(15, 15, 200, 32);
//		g.setColor(new Color(75, greenValue, 0));
//		g.fillRect(15, 15, HEALTH * 2, 32);
//		g.setColor(Color.white);
//		g.drawRect(15, 15, 200, 32);

		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);
		
		
		Color c = new Color(1, 1, 1, .1f);
		g.setColor(c);
		g.drawRect(GameClass.WIDTH/2 - 10, 0, 20, GameClass.HEIGHT - 1);
		
		
		g.drawRect(w / 160, w / 160, w - (2 * (w / 160)), (w / 160) * 3);
		g.drawRect(w / 160, h - (4 * (w / 160)), w - (2 * (w / 160)), (w / 160) * 3);
		g.setColor(c);
		g.fillRect(w / 160, w / 160, w - (2 * (w / 160)), (w / 160) * 3);
		g.fillRect(w / 160, h - (4 * (w / 160)), w - (2 * (w / 160)), (w / 160) * 3);
		
		// player score
//		Polygon polygon = new Polygon();
//		polygon.addPoint(250, 50);
//		polygon.addPoint(350, 50);
//		polygon.addPoint(450, 150);
//		polygon.addPoint(350, 150);
//		g.setClip(polygon);
		//g.drawImage("score.png",GameClass.WIDTH/2 - 50 , 50, null);
	}

	public void score(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
//	public int getHealth() {
//		return HEALTH;
//	}

}
