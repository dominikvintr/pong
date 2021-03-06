package gameCore;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

import gamePlayer_NPC.Ball;
/**
 * Class for heads up display
 * @author dominikvintr
 *
 */
public class HUD {

	private int w = GameClass.WIDTH;
	private int h = GameClass.HEIGHT;

	GameClass game;
	Menu menu;
	Ball ball;
	Handler handler;

	private int score = 0;
	private int level = 1;
	private int buttonHeight = (w / 160) * 3;
	private int fontSize = (int) (buttonHeight * 0.75);
	private int frames;
	private int option;
	/**
	 * Retrieves current frames per second from GameClass class
	 * @param fps
	 */
	public void setFrames(int fps) {
		frames = fps;
	}
	/**
	 * Sets game mode
	 * @param opt
	 */
	public void setOption(int opt) {
		option = opt;
	}

	ImageObserver observer;
	private int modifier;
	/**
	 * Tick method
	 */
	public void tick() {

		score++;
		if (score < 1000)
			level = 1;
		if (score % 1000 == 0)
			level = level + 1;
	}
	/**
	 * Render method for HUD
	 * @param g
	 */
	public void render(Graphics g) {
		Font font = new Font("calibri light", 1, 90);
		g.setFont(font);
		g.setColor(Color.WHITE);

		if (GameClass.paused == true) {
		} else {
			if (option == 2) {
				int widthSettingsTitle = g.getFontMetrics().stringWidth("0:0");
				g.drawString("0:0", (w - widthSettingsTitle) / 2, (h / 7));
			}
			if (option == 11) {
				modifier = 0;
				int widthSettingsTitle = g.getFontMetrics().stringWidth("Lives: " + (3 - modifier));
				g.drawString("Lives: " + (3 - modifier), (w - widthSettingsTitle) / 2, (h / 7));
			}
			if (option == 12) {
				int widthSettingsTitle = g.getFontMetrics().stringWidth("Lives: 5");
				g.drawString("Lives: 5", (w - widthSettingsTitle) / 2, (h / 7));
			}
			if (option == 13) {
				int widthSettingsTitle = g.getFontMetrics().stringWidth("Lives: 7");
				g.drawString("Lives: 7", (w - widthSettingsTitle) / 2, (h / 7));
			}
		}

		Color c = new Color(1, 1, 1, .1f);
		Font font2 = new Font("calibri light", 1, fontSize);

		g.setFont(font2);
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
		g.drawString("Level " + level, w / 2 - (widthLevel / 2), w / 160 + fontSize);

	}
	/**
	 * Setter for score
	 * @param
	 */
	public void score(int score) {
		this.score = score;
	}
	/**
	 * Getter for score
	 * @return
	 */
	public int getScore() {
		return score;
	}
	/**
	 * Getter for level
	 * @return
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * Setter for level
	 * @param level
	 */
	public void setLevel(int level) {
		this.level = level;
	}
}
