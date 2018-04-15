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
	
	public MouseInput(GameClass game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
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
	
	public void mouseReleased(MouseEvent e) {

	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx >= x && mx <= x + width) {
			if (my >= y && my <= y + height) {
				return true;
			} else
				return false;
		} else
			return false;

	}

	public void tick() {
		score = hud.getScore();
		System.out.println(score);
	}

	public void render(Graphics g) {
	}
	public void setOption(int opt) {
		option = opt;
	}
	

}
