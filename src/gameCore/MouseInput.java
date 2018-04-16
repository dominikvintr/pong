package gameCore;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gameCore.GameClass.STATE;
import gamePlayer_NPC.GameObject;
import gamePlayer_NPC.ID;
/**
 * Class which reads mouse input
 * @author dominikvintr
 *
 */
public class MouseInput extends MouseAdapter {
	
	private GameClass game;
	private Handler handler;
	HUD hud;
	
	private int mx;
	private int my;
	
	private int pointerX;
	private int pointerY;
	
	private int w = GameClass.WIDTH;
	private int h = GameClass.HEIGHT;
	
	private int buttonHeight = (h - ((h / 120) * 52)) / 17 * 2;
	private int buttonWidth = w / 3;
	
	Sounds soundType = new Sounds();
	private int option;
	private int score;
	/**
	 * 
	 * @param game
	 * @param handler
	 */
	public MouseInput(GameClass game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	/**
	 * Observes when and where is mouse pressed
	 */
	public void mousePressed(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		
		if (game.gameState == STATE.GameClass || game.gameState == STATE.Leaderboard) {
			if (GameClass.paused == true) {
				if(mouseOver(mx, my, w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 3), buttonWidth, buttonHeight)) {
					soundType.play("click");
					GameClass.paused = false;
				}
				if (mouseOver(mx, my,w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 6), buttonWidth, buttonHeight)) {
					soundType.play("click");
					game.setHandler(0);
					game.gameState = STATE.Menu;
					GameClass.paused = false;
				}
				
				
			}
		}
	}
	/**
	 * Observes when mouse is released
	 */
	public void mouseReleased(MouseEvent e) {

	}
	/**
	 * Finds if mouse cursor position is within given rectangle
	 * @param mx
	 * @param my
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx >= x && mx <= x + width) {
			if (my >= y && my <= y + height) {
				return true;
			} else
				return false;
		} else
			return false;

	}
	/**
	 * Tick method
	 */
	public void tick() {
		score = hud.getScore();
		System.out.println(score);
	}
	/**
	 * Render method
	 * @param g
	 */
	public void render(Graphics g) {
	}
	/**
	 * Sets game option
	 * @param opt
	 */
	public void setOption(int opt) {
		option = opt;
	}
	

}
