package gameCore;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gameCore.GameClass.STATE;
import gamePlayer_NPC.Ball;
import gamePlayer_NPC.ID;
import gamePlayer_NPC.Opponent;
import gamePlayer_NPC.Player;
import gamePlayer_NPC.Player2;

public class Menu extends MouseAdapter {
	
	
	private static final int w = GameClass.WIDTH;
	private static final int h = GameClass.HEIGHT;
	private static final int fieldHeight = (((int) ((int) (h / 30) * 16 - (h / 10.8))) / 2);
	private GameClass game;
	private Handler handler;
	private MouseInput input;

	public Menu(GameClass game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}

	private int mx;
	private int my;
	private static int basicWidth = (GameClass.WIDTH / 160) * 3;
	private static int basicHeight = GameClass.HEIGHT / 5;

	private int buttonHeight = (h - ((h / 120) * 52)) / 17 * 2;
	private int buttonWidth = w / 3;
	private int fontSize = (int) (buttonHeight * 0.75);
	private Color c = new Color(1, 1, 1, .1f);

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (game.gameState == STATE.Difficulty1) {
			if (mouseOver(mx, my, w / 2 - w / 6, h / 120 * 38, buttonWidth, buttonHeight)) {

				game.setHandler(1);
				game.gameState = STATE.GameClass;
				handler.addObject(new Player(64, h / 2 - (basicHeight / 2), ID.Player, handler));
				handler.addObject(new Ball(w / 2, h / 2, ID.Ball, handler));
				handler.addObject(new Opponent(w - (64 + basicWidth), h / 2 - (basicHeight / 2), ID.Opponent, handler));

			}
			if (mouseOver(mx, my, w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 3), buttonWidth, buttonHeight)) {

				game.setHandler(1);
				game.gameState = STATE.GameClass;
				handler.addObject(new Player(64, h / 2 - (basicHeight / 2), ID.Player, handler));
				handler.addObject(new Ball(w / 2, h / 2, ID.Ball, handler));
				handler.addObject(new Opponent(w - (64 + basicWidth), h / 2 - (basicHeight / 2), ID.Opponent, handler));

			}
			if (mouseOver(mx, my, w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 6), buttonWidth, buttonHeight)) {

				game.setHandler(1);
				game.gameState = STATE.GameClass;
				handler.addObject(new Player(64, h / 2 - (basicHeight / 2), ID.Player, handler));
				handler.addObject(new Ball(w / 2, h / 2, ID.Ball, handler));
				handler.addObject(new Opponent(w - (64 + basicWidth), h / 2 - (basicHeight / 2), ID.Opponent, handler));
			}

		}

		if (game.gameState == STATE.Menu) {

			// 1 player
			if (mouseOver(mx, my, w / 2 - w / 6, h / 120 * 38, buttonWidth, buttonHeight)) {
				game.gameState = STATE.Difficulty1;
			}

			// 2 players
			if (mouseOver(mx, my, w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 3), buttonWidth, buttonHeight)) {

				game.setHandler(1);
				game.gameState = STATE.GameClass;
				handler.addObject(new Player(64, h / 2 - (basicHeight / 2), ID.Player, handler));
				handler.addObject(new Ball(w / 2, h / 2, ID.Ball, handler));
				handler.addObject(new Opponent(w - (64 + basicWidth), h / 2 - (basicHeight / 2), ID.Opponent, handler));
			}

			// Leaderboard
			if (mouseOver(mx, my, w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 6), buttonWidth, buttonHeight)) {
				game.gameState = STATE.Leaderboard;
			}

			// settings
			if (mouseOver(mx, my, w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 9), buttonWidth, buttonHeight)) {
				game.gameState = STATE.Settings;
			}

			// exit
			if (mouseOver(mx, my, w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth,
					buttonHeight)) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(1);
			}

			// help
			if (mouseOver(mx, my, w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 12), buttonWidth,
					buttonHeight)) {
				game.gameState = STATE.Help;
			}
		}
		if (game.gameState == STATE.Leaderboard) {
			if (mouseOver(mx, my, w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth,
					buttonHeight)) {
				game.gameState = STATE.Menu;
			}
		}
		if (game.gameState == STATE.Help) {
			if (mouseOver(mx, my, w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth,
					buttonHeight)) {
				game.gameState = STATE.Menu;
			}
		}

		if (game.gameState == STATE.Settings) {
			if (mouseOver(mx, my, w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth,
					buttonHeight)) {
				game.gameState = STATE.Menu;
			}
			if (mouseOver(mx, my,(w / 32) * 5 + 1, (int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2),
					(w / 32) * 10, buttonHeight - 2)) {
				game.gameState = STATE.Menu;
			}
			if (mouseOver(mx, my,(w / 32) * 5 + 1, (int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2),
					(w / 32) * 10, buttonHeight - 2 + fieldHeight)) {
				game.gameState = STATE.Menu;
			}
			if (mouseOver(mx, my,(w / 32) * 17 + 1, (int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2),
					(w / 32) * 10, buttonHeight - 2)) {
				game.gameState = STATE.Menu;
			}
			if (mouseOver(mx, my,(w / 32) * 17 + 1, (int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2),
					(w / 32) * 10, buttonHeight - 2 + fieldHeight)) {
				game.gameState = STATE.Menu;
			}
		}
		if (game.gameState == STATE.Difficulty1) {
			if (mouseOver(mx, my, w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth,
					buttonHeight)) {
				game.gameState = STATE.Menu;
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

	}

	public void render(Graphics g) {

		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int pointerX = (int) b.getX();
		int pointerY = (int) b.getY();

		Font font2 = new Font("calibri light", 1, fontSize);
		Rectangle back = new Rectangle(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + 1,
				buttonWidth - 2, buttonHeight - 2);
		
		if (game.gameState == STATE.Settings) {
			
		}
		

		if (game.gameState == STATE.Menu) {

			// pong title
			Font font = new Font("calibri light", 1, 180);
			g.setFont(font);
			g.setColor(Color.WHITE);

			int widthPongTitle = g.getFontMetrics().stringWidth("PONG");
			g.drawString("PONG", (w - widthPongTitle) / 2, (h / 120 * 29));

			g.setFont(font2);
			g.setColor(Color.WHITE);

			// g.drawLine(w / 2, 0, w / 2, h);

			// table
			// g.drawRect(w/2 - w/6, h/120 * 38, w/3, h - ((h/120)*52));

			// 1 player
			Rectangle onePlayer = new Rectangle(w / 2 - w / 6, h / 120 * 38, w / 3, (h - ((h / 120) * 52)) / 17 * 2);

			if (onePlayer.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(w / 2 - w / 6, h / 120 * 38, w / 3, (h - ((h / 120) * 52)) / 17 * 2);
				g.setColor(Color.WHITE);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + 1, w / 3 - 2, (h - ((h / 120) * 52)) / 17 * 2 - 2);
				g.setColor(Color.BLACK);
				int widthOnePlayer = g.getFontMetrics().stringWidth("One player");
				g.drawString("One player", (w - widthOnePlayer) / 2, (h / 120 * 38) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(w / 2 - w / 6, h / 120 * 38, w / 3, (h - ((h / 120) * 52)) / 17 * 2);
				g.setColor(c);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + 1, w / 3 - 2, (h - ((h / 120) * 52)) / 17 * 2 - 2);
				g.setColor(Color.WHITE);
				int widthOnePlayer = g.getFontMetrics().stringWidth("One player");
				g.drawString("One player", (w - widthOnePlayer) / 2, (h / 120 * 38) + fontSize);
			}

			// 2 players
			Rectangle twoPlayer = new Rectangle(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 3), buttonWidth,
					buttonHeight);

			if (twoPlayer.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 3), buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 3) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.BLACK);
				int widthTwoPlayers = g.getFontMetrics().stringWidth("Two players");
				g.drawString("Two players", (w - widthTwoPlayers) / 2,
						h / 120 * 38 + (68 * (h / 120) / 17 * 3) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 3), buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 3) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.WHITE);
				int widthTwoPlayers = g.getFontMetrics().stringWidth("Two players");
				g.drawString("Two players", (w - widthTwoPlayers) / 2,
						h / 120 * 38 + (68 * (h / 120) / 17 * 3) + fontSize);
			}

			// leaderboard
			Rectangle leaderboard = new Rectangle(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 6) + 1,
					buttonWidth - 2, buttonHeight - 2);

			if (leaderboard.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 6), buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 6) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.BLACK);
				int widthLeaderboard = g.getFontMetrics().stringWidth("Leaderboard");
				g.drawString("Leaderboard", (w - widthLeaderboard) / 2,
						h / 120 * 38 + (68 * (h / 120) / 17 * 6) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 6), buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 6) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.WHITE);
				int widthLeaderboard = g.getFontMetrics().stringWidth("Leaderboard");
				g.drawString("Leaderboard", (w - widthLeaderboard) / 2,
						h / 120 * 38 + (68 * (h / 120) / 17 * 6) + fontSize);
			}

			// settings
			Rectangle settings = new Rectangle(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 9) + 1,
					buttonWidth - 2, buttonHeight - 2);

			if (settings.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 9), buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 9) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.BLACK);
				int widthSettings = g.getFontMetrics().stringWidth("Settings");
				g.drawString("Settings", (w - widthSettings) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 9) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 9), buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 9) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.WHITE);
				int widthSettings = g.getFontMetrics().stringWidth("Settings");
				g.drawString("Settings", (w - widthSettings) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 9) + fontSize);
			}

			// help
			Rectangle help = new Rectangle(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 12) + 1,
					buttonWidth - 2, buttonHeight - 2);

			if (help.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 12), buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 12) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.BLACK);
				int widthHelp = g.getFontMetrics().stringWidth("Help");
				g.drawString("Help", (w - widthHelp) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 12) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 12), buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 12) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.WHITE);
				int widthHelp = g.getFontMetrics().stringWidth("Help");
				g.drawString("Help", (w - widthHelp) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 12) + fontSize);
			}

			// quit
			Rectangle quit = new Rectangle(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + 1,
					buttonWidth - 2, buttonHeight - 2);

			if (quit.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.BLACK);
				int widthQuit = g.getFontMetrics().stringWidth("Quit");
				g.drawString("Quit", (w - widthQuit) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.WHITE);
				int widthQuit = g.getFontMetrics().stringWidth("Quit");
				g.drawString("Quit", (w - widthQuit) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + fontSize);
			}

			g.drawRect(w / 160, w / 160, w - (2 * (w / 160)), (w / 160) * 3);
			g.drawRect(w / 160, h - (4 * (w / 160)), w - (2 * (w / 160)), (w / 160) * 3);
			g.setColor(c);
			g.fillRect(w / 160, w / 160, w - (2 * (w / 160)), (w / 160) * 3);
			g.fillRect(w / 160, h - (4 * (w / 160)), w - (2 * (w / 160)), (w / 160) * 3);

		}

		g.setFont(font2);

		if (game.gameState == STATE.Help) {
			// font 180
			Font font = new Font("calibri light", 1, 180);
			g.setFont(font);
			g.setColor(Color.WHITE);
			int widthHelpTitle = g.getFontMetrics().stringWidth("Help");
			g.drawString("Help", (w - widthHelpTitle) / 2, (h / 120 * 29));

			g.setFont(font2);

			g.setColor(Color.WHITE);
			g.drawRect(w / 160, w / 160, w - (2 * (w / 160)), (w / 160) * 3);
			g.drawRect(w / 160, h - (4 * (w / 160)), w - (2 * (w / 160)), (w / 160) * 3);
			g.setColor(c);
			g.fillRect(w / 160, w / 160, w - (2 * (w / 160)), (w / 160) * 3);
			g.fillRect(w / 160, h - (4 * (w / 160)), w - (2 * (w / 160)), (w / 160) * 3);

			// back
			if (back.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.BLACK);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.setColor(Color.WHITE);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.WHITE);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + fontSize);
			}
		}
		if (game.gameState == STATE.Settings) {
			// volume/language values
			Rectangle apply1 = new Rectangle((w / 32) * 17,
					(int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2), (w / 32) * 10,
					buttonHeight);
			Rectangle apply2 = new Rectangle((w / 32) * 17,
					(int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2) + fieldHeight,
					(w / 32) * 10, buttonHeight);

			// font 180
			Font font = new Font("calibri light", 1, 180);
			g.setFont(font);
			g.setColor(Color.WHITE);
			int widthSettingsTitle = g.getFontMetrics().stringWidth("Settings");
			g.drawString("Settings", (w - widthSettingsTitle) / 2, (h / 120 * 29));

			// font 20
			int fontSize4 = (int) (fieldHeight * 0.15);
			Font font4 = new Font("calibri light", 1, fontSize4);
			g.setColor(Color.WHITE);
			g.setFont(font4);

			g.drawString("Music", (w / 32) * 5 + (w / 160),
					(int) (((h / 30) * 6.75) + (h / 10.8) + (((int) ((int) (h / 30) * 16 - (h / 10.8))) / 2)) + w / 54);
			g.drawString("Master volume", (w / 32) * 5 + (w / 160), (int) (((h / 30) * 6.75) + (h / 10.8)) + w / 54);
			g.drawString("English language", (w / 32) * 17 + (w / 160),
					(int) (((h / 30) * 6.75) + (h / 10.8) + (((int) ((int) (h / 30) * 16 - (h / 10.8))) / 2)) + w / 54);
			g.drawString("Czech language", (w / 32) * 17 + (w / 160), (int) (((h / 30) * 6.75) + (h / 10.8)) + w / 54);

			g.setColor(Color.WHITE);
			g.drawRect(w / 160, w / 160, w - (2 * (w / 160)), (w / 160) * 3);
			g.drawRect(w / 160, h - (4 * (w / 160)), w - (2 * (w / 160)), (w / 160) * 3);

			// guidelines
			/*
			 * g.drawRect((w / 32) * 5, (int) (((h / 30) * 6.75) + (h / 10.8)), (w / 32) *
			 * 10, (((int) ((int) (h / 30) * 16 - (h / 10.8))) / 2)); g.drawRect((w / 32) *
			 * 17, (int) (((h / 30) * 6.75) + (h / 10.8)), (w / 32) * 10, (((int) ((int) (h
			 * / 30) * 16 - (h / 10.8))) / 2));
			 * 
			 * g.drawRect((w / 32) * 5, (int) (((h / 30) * 6.75) + (h / 10.8) + (((int)
			 * ((int) (h / 30) * 16 - (h / 10.8))) / 2)), (w / 32) * 10, (((int) ((int) (h /
			 * 30) * 16 - (h / 10.8))) / 2)); g.drawRect((w / 32) * 17, (int) (((h / 30) *
			 * 6.75) + (h / 10.8) + (((int) ((int) (h / 30) * 16 - (h / 10.8))) / 2)), (w /
			 * 32) * 10, (((int) ((int) (h / 30) * 16 - (h / 10.8))) / 2));
			 */
			//

			g.setColor(c);
			g.fillRect(w / 160, w / 160, w - (2 * (w / 160)), (w / 160) * 3);
			g.fillRect(w / 160, h - (4 * (w / 160)), w - (2 * (w / 160)), (w / 160) * 3);

			// master volume
			g.setColor(Color.WHITE);
			g.drawRect((w / 32) * 5, (int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2),
					(w / 32) * 10, buttonHeight);
			g.setColor(c);
			g.fillRect((w / 32) * 5 + 1, (int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2),
					(w / 32) * 10, buttonHeight - 2);
			// music volume
			g.setColor(Color.WHITE);
			g.drawRect((w / 32) * 5,
					(int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2) + fieldHeight,
					(w / 32) * 10, buttonHeight);
			g.setColor(c);
			g.fillRect((w / 32) * 5 + 1,
					(int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2) + fieldHeight,
					(w / 32) * 10, buttonHeight - 2);
			
			

			// back
			if (back.contains(pointerX, pointerY)) {
				g.setFont(font2);
				g.setColor(c);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.BLACK);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.setFont(font2);
				g.setColor(Color.WHITE);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.WHITE);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + fontSize);
			}
			// apply1
			if (apply1.contains(pointerX, pointerY)) {
				g.setFont(font2);
				g.setColor(c);
				/*
				 * x = (w / 32) * 5 y = (int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight -
				 * buttonHeight)/2) width = (w / 32) * 10 height = buttonHeight
				 */
				g.drawRect((w / 32) * 17, (int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2),
						(w / 32) * 10, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect((w / 32) * 17 + 1,
						(int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2), (w / 32) * 10,
						buttonHeight - 2);
				g.setColor(Color.BLACK);
				int widthApply = g.getFontMetrics().stringWidth("Apply");
				g.drawString("Apply", (w / 32) * 17 + ((w / 32 * 10 - widthApply) / 2),
						(int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.setFont(font2);
				g.setColor(Color.WHITE);
				g.drawRect((w / 32) * 17, (int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2),
						(w / 32) * 10, buttonHeight);
				g.setColor(c);
				g.fillRect((w / 32) * 17 + 1,
						(int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2), (w / 32) * 10,
						buttonHeight - 2);
				g.setColor(Color.WHITE);
				int widthApply = g.getFontMetrics().stringWidth("Apply");
				g.drawString("Apply", (w / 32) * 17 + ((w / 32 * 10 - widthApply) / 2),
						(int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2) + fontSize);
			}
			// apply2
			if (apply2.contains(pointerX, pointerY)) {
				g.setFont(font2);
				g.setColor(c);
				g.drawRect((w / 32) * 17,
						(int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2) + fieldHeight,
						(w / 32) * 10, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect((w / 32) * 17 + 1,
						(int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2) + fieldHeight,
						(w / 32) * 10, buttonHeight - 2);
				g.setColor(Color.BLACK);
				int widthApply = g.getFontMetrics().stringWidth("Apply");
				g.drawString("Apply", (w / 32) * 17 + ((w / 32 * 10 - widthApply) / 2),
						(int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2) + fieldHeight
								+ fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect((w / 32) * 17,
						(int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2) + fieldHeight,
						(w / 32) * 10, buttonHeight);
				g.setColor(c);
				g.fillRect((w / 32) * 17 + 1,
						(int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2) + fieldHeight,
						(w / 32) * 10, buttonHeight - 2);
				g.setColor(Color.WHITE);
				int widthApply = g.getFontMetrics().stringWidth("Apply");
				g.drawString("Apply", (w / 32) * 17 + ((w / 32 * 10 - widthApply) / 2),
						(int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2) + fieldHeight
								+ fontSize);
			}

		}
		if (game.gameState == STATE.Leaderboard) {
			// font 180
			Font font = new Font("calibri light", 1, 180);
			g.setFont(font);
			g.setColor(Color.WHITE);
			int widthLeaderboardTitle = g.getFontMetrics().stringWidth("Leaderboard");
			g.drawString("Leaderboard", (w - widthLeaderboardTitle) / 2, (h / 120 * 29));

			g.setColor(Color.WHITE);
			g.drawRect(w / 160, w / 160, w - (2 * (w / 160)), (w / 160) * 3);
			g.drawRect(w / 160, h - (4 * (w / 160)), w - (2 * (w / 160)), (w / 160) * 3);
			g.setColor(c);
			g.fillRect(w / 160, w / 160, w - (2 * (w / 160)), (w / 160) * 3);
			g.fillRect(w / 160, h - (4 * (w / 160)), w - (2 * (w / 160)), (w / 160) * 3);
			
			g.setFont(font2);
			
			// back
			if (back.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.BLACK);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.setColor(Color.WHITE);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.WHITE);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + fontSize);
			}
		}
		if (game.gameState == STATE.Difficulty1) {

			Font font = new Font("calibri light", 1, 180);
			g.setFont(font);
			g.setColor(Color.WHITE);

			int widthPongTitle = g.getFontMetrics().stringWidth("Select game length");
			g.drawString("Select game length", (w - widthPongTitle) / 2, (h / 120 * 29));

			g.setColor(Color.WHITE);
			g.setFont(font2);

			// same like in one menu...
			Rectangle onePlayer = new Rectangle(w / 2 - w / 6, h / 120 * 38, w / 3, (h - ((h / 120) * 52)) / 17 * 2);

			if (onePlayer.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(w / 2 - w / 6, h / 120 * 38, w / 3, (h - ((h / 120) * 52)) / 17 * 2);
				g.setColor(Color.WHITE);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + 1, w / 3 - 2, (h - ((h / 120) * 52)) / 17 * 2 - 2);
				g.setColor(Color.BLACK);
				int widthOnePlayer = g.getFontMetrics().stringWidth("3 lives");
				g.drawString("3 lives", (w - widthOnePlayer) / 2, (h / 120 * 38) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(w / 2 - w / 6, h / 120 * 38, w / 3, (h - ((h / 120) * 52)) / 17 * 2);
				g.setColor(c);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + 1, w / 3 - 2, (h - ((h / 120) * 52)) / 17 * 2 - 2);
				g.setColor(Color.WHITE);
				int widthOnePlayer = g.getFontMetrics().stringWidth("3 lives");
				g.drawString("3 lives", (w - widthOnePlayer) / 2, (h / 120 * 38) + fontSize);
			}
			Rectangle twoPlayer = new Rectangle(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 3), buttonWidth,
					buttonHeight);

			if (twoPlayer.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 3), buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 3) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.BLACK);
				int widthTwoPlayers = g.getFontMetrics().stringWidth("5 lives");
				g.drawString("5 lives", (w - widthTwoPlayers) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 3) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 3), buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 3) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.WHITE);
				int widthTwoPlayers = g.getFontMetrics().stringWidth("5 lives");
				g.drawString("5 lives", (w - widthTwoPlayers) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 3) + fontSize);
			}
			Rectangle leaderboard = new Rectangle(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 6) + 1,
					buttonWidth - 2, buttonHeight - 2);

			if (leaderboard.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 6), buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 6) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.BLACK);
				int widthLeaderboard = g.getFontMetrics().stringWidth("7 lives");
				g.drawString("7 lives", (w - widthLeaderboard) / 2,
						h / 120 * 38 + (68 * (h / 120) / 17 * 6) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 6), buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 6) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.WHITE);
				int widthLeaderboard = g.getFontMetrics().stringWidth("7 lives");
				g.drawString("7 lives", (w - widthLeaderboard) / 2,
						h / 120 * 38 + (68 * (h / 120) / 17 * 6) + fontSize);
			}

			// back
			if (back.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.BLACK);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.setColor(Color.WHITE);
				g.drawRect(w / 2 - w / 6, h / 120 * 38 + (68 * (h / 120) / 17 * 15), buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(w / 2 - w / 6 + 1, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + 1, buttonWidth - 2,
						buttonHeight - 2);
				g.setColor(Color.WHITE);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, h / 120 * 38 + (68 * (h / 120) / 17 * 15) + fontSize);
			}

			g.drawRect(w / 160, w / 160, w - (2 * (w / 160)), (w / 160) * 3);
			g.drawRect(w / 160, h - (4 * (w / 160)), w - (2 * (w / 160)), (w / 160) * 3);
			g.setColor(c);
			g.fillRect(w / 160, w / 160, w - (2 * (w / 160)), (w / 160) * 3);
			g.fillRect(w / 160, h - (4 * (w / 160)), w - (2 * (w / 160)), (w / 160) * 3);

		}
	}
}
