package gameCore;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class HUD {

	private int w = GameClass.WIDTH;
	private int h = GameClass.HEIGHT;

	private int score = 0;
	private int level = 1;
	private int buttonHeight = (w / 160) * 3;
	private int fontSize = (int) (buttonHeight * 0.75);
	private int frames;

	public void setFrames(int fps) {
		frames = fps;
	}

	ImageObserver observer;

	public void tick() {

		score++;
		if (score < 1000) {
			level = 1;
		}
		
		if (score%1000 == 0) {
			level = level +1;
		}

	}

	public void render(Graphics g) {

		Color c = new Color(1, 1, 1, .1f);
		Font font = new Font("calibri light", 1, fontSize);
		g.setFont(font);
		g.setColor(c);

		g.setColor(Color.WHITE);
		g.drawRect(w / 160, w / 160, w - (2 * (w / 160)), (w / 160) * 3);
		g.drawRect(w / 160, h - (4 * (w / 160)), w - (2 * (w / 160)), (w / 160) * 3);
		g.setColor(c);
		g.fillRect(w / 160, w / 160, w - (2 * (w / 160)), (w / 160) * 3);
		g.fillRect(w / 160, h - (4 * (w / 160)), w - (2 * (w / 160)), (w / 160) * 3);

		g.setColor(Color.WHITE);
		int widthFrames = g.getFontMetrics().stringWidth("FPS: 100");
		g.drawString("Score: " + score, 2 * (w / 160), w / 160 + fontSize);
		g.drawString("FPS: " + frames, w - (2 * (w / 160)) - widthFrames, w / 160 + fontSize);

		int widthLevel = g.getFontMetrics().stringWidth("Level " + level);
		g.drawString("Level " + level, w / 2 - (widthLevel/2), w / 160 + fontSize);

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
}
