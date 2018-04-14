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
	
	private GameClass game;
	private Handler handler;
	
	public Menu(GameClass game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	// game width and height
	private static final int w = GameClass.WIDTH;
	private static final int h = GameClass.HEIGHT;
	private static final int basicWidth = (GameClass.WIDTH / 160) * 3;
	private static final int basicHeight = GameClass.HEIGHT / 5;
	private static final int fieldHeight = (((int) ((int) (h / 30) * 16 - (h / 10.8))) / 2);
	private int offset = w / 160;
	
	// buttons
	private int buttonHeight = (h - ((h / 120) * 52)) / 17 * 2;
	private int buttonWidth = w / 3;
	private int fontSize = (int) (buttonHeight * 0.75);

	private int centerButton1Y = h / 120 * 38;
	private int centerButton2Y = centerButton1Y + (68 * (h / 120) / 17 * 3);
	private int centerButton3Y = centerButton1Y + (68 * (h / 120) / 17 * 6);
	private int centerButton4Y = centerButton1Y + (68 * (h / 120) / 17 * 9);
	private int centerButton5Y = centerButton1Y + (68 * (h / 120) / 17 * 12);;
	private int centerButton6Y = centerButton1Y + (68 * (h / 120) / 17 * 15);
	private int centerButtonX = w / 2 - w / 6;
	private int rightButtonY = (int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2);
	private int rightButtonWidth = (w / 32) * 10;
	private int rightButtonX = (w / 32) * 17;
	private int leftButtonX = (w / 32) * 5;
	
	// phase
	private boolean phase = false;
	private boolean phase2 = false;
	
	//volume
	private int currentMasterVolume;
	private int currentMusicVolume;
	
	// color&fonts
	private Color c = new Color(1, 1, 1, .1f);
	int fontSize4 = (int) (fieldHeight * 0.15);
	Font font = new Font("calibri light", 1, 180);
	Font font2 = new Font("calibri light", 1, fontSize);
	Font font4 = new Font("calibri light", 1, fontSize4);
	
	// rectangles
	Rectangle back = new Rectangle(centerButtonX, centerButton6Y, buttonWidth, buttonHeight);
	Rectangle onePlayer = new Rectangle(centerButtonX, centerButton1Y, buttonWidth, buttonHeight);
	Rectangle twoPlayer = new Rectangle(centerButtonX, centerButton2Y, buttonWidth,buttonHeight);
	Rectangle leaderboard = new Rectangle(centerButtonX, centerButton3Y,buttonWidth, buttonHeight);
	Rectangle settings = new Rectangle(centerButtonX, centerButton4Y,buttonWidth, buttonHeight);
	Rectangle help = new Rectangle(centerButtonX, centerButton5Y,buttonWidth, buttonHeight);
	Rectangle quit = new Rectangle(centerButtonX, centerButton6Y,buttonWidth, buttonHeight);
	Rectangle apply1 = new Rectangle(rightButtonX,rightButtonY, rightButtonWidth,buttonHeight);
	Rectangle apply2 = new Rectangle(rightButtonX,rightButtonY + fieldHeight,rightButtonWidth, buttonHeight);
	
	// mouse pointer
	int pointerX;
	int pointerY;

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

//DIFFICULTY 1/////////////////////////////////DIFFICULTY 1////////////////////////////////////DIFFICULTY 1//
		if (game.gameState == STATE.Difficulty1) {
				// 3 lives
			if (mouseOver(mx, my, centerButtonX, centerButton1Y, buttonWidth, buttonHeight)) {
				game.setHandler(1);
				game.gameState = STATE.GameClass;
				handler.addObject(new Player(64, h / 2 - (basicHeight / 2), ID.Player, handler));
				handler.addObject(new Ball(w / 2, h / 2, ID.Ball, handler));
				handler.addObject(new Opponent(w - (64 + basicWidth), h / 2 - (basicHeight / 2), ID.Opponent, handler));
			}	// 5 lives
			if (mouseOver(mx, my, centerButtonX, centerButton2Y, buttonWidth, buttonHeight)) {
				game.setHandler(1);
				game.gameState = STATE.GameClass;
				handler.addObject(new Player(64, h / 2 - (basicHeight / 2), ID.Player, handler));
				handler.addObject(new Ball(w / 2, h / 2, ID.Ball, handler));
				handler.addObject(new Opponent(w - (64 + basicWidth), h / 2 - (basicHeight / 2), ID.Opponent, handler));
			}	// 7 lives
			if (mouseOver(mx, my, centerButtonX, centerButton3Y, buttonWidth, buttonHeight)) {
				game.setHandler(1);
				game.gameState = STATE.GameClass;
				handler.addObject(new Player(64, h / 2 - (basicHeight / 2), ID.Player, handler));
				handler.addObject(new Ball(w / 2, h / 2, ID.Ball, handler));
				handler.addObject(new Opponent(w - (64 + basicWidth), h / 2 - (basicHeight / 2), ID.Opponent, handler));
			}
		}
//MENU//////////////////////////////////////////////MENU///////////////////////////////////////////////MENU//
		if (game.gameState == STATE.Menu) {
				// 1 player
			if (mouseOver(mx, my, centerButtonX, centerButton1Y, buttonWidth, buttonHeight)) {
				game.gameState = STATE.Difficulty1;
			}	// 2 players
			if (mouseOver(mx, my, centerButtonX, centerButton2Y, buttonWidth, buttonHeight)) {
				game.setHandler(1);
				game.gameState = STATE.GameClass;
				handler.addObject(new Player(64, h / 2 - (basicHeight / 2), ID.Player, handler));
				handler.addObject(new Ball(w / 2, h / 2, ID.Ball, handler));
				handler.addObject(new Player2(w - (64 + basicWidth), h / 2 - (basicHeight / 2), ID.Player2, handler));
			}	// Leaderboard
			if (mouseOver(mx, my, centerButtonX, centerButton3Y, buttonWidth, buttonHeight)) {
				game.gameState = STATE.Leaderboard;
			}	// Settings
			if (mouseOver(mx, my, centerButtonX, centerButton4Y, buttonWidth, buttonHeight)) {
				game.gameState = STATE.Settings;
			}	// exit
			if (mouseOver(mx, my, centerButtonX, centerButton6Y , buttonWidth, buttonHeight)) {
				try {Thread.sleep(500);} catch (InterruptedException e1) {e1.printStackTrace();}
				System.exit(1);
			}	// help
			if (mouseOver(mx, my, centerButtonX, centerButton5Y, buttonWidth,buttonHeight)) {
				game.gameState = STATE.Help;
			}
		}
//SETTINGS////////////////////////////////////////SETTINGS/////////////////////////////////////////SETTINGS//
		if (game.gameState == STATE.Settings) {
				// back
			if (mouseOver(mx, my, centerButtonX, centerButton6Y, buttonWidth,buttonHeight)) {
				game.gameState = STATE.Menu;
			}	// master volume
			if (mouseOver(mx, my, leftButtonX,rightButtonY, rightButtonWidth,buttonHeight)) {
				phase = true;
				int mxTable = mx - ((w/32)*5);
				currentMasterVolume = mxTable;
			}	// music volume
			if (mouseOver(mx, my, leftButtonX,rightButtonY + fieldHeight, rightButtonWidth,buttonHeight)) {
				phase2 = true;
				int mxTable2 = mx - ((w/32)*5);
				currentMusicVolume = mxTable2;
			}	// czech language
			if (mouseOver(mx, my, rightButtonX,rightButtonY, rightButtonWidth,buttonHeight)) {
				game.gameState = STATE.Menu;
			}	// english language
			if (mouseOver(mx, my, rightButtonX,rightButtonY, rightButtonWidth,buttonHeight + fieldHeight)) {
				game.gameState = STATE.Menu;
			}
		}		
//LEADERBOAD/////////////////////////////////////LEADEBOARD/////////////////////////////////////LEADERBOARD//
		if (game.gameState == STATE.Leaderboard) {
			if (mouseOver(mx, my, centerButtonX, centerButton6Y, buttonWidth,buttonHeight)) {
				game.gameState = STATE.Menu;
			}
		}
//HELP//////////////////////////////////////////////HELP///////////////////////////////////////////////HELP//
		if (game.gameState == STATE.Help) {
			if (mouseOver(mx, my, centerButtonX, centerButton6Y, buttonWidth,buttonHeight)) {
				game.gameState = STATE.Menu;
			}
		}
//DIFFICULTY 1//////////////////////////////////DIFFICULTY 1///////////////////////////////////DIFFICULTY 1//
		if (game.gameState == STATE.Difficulty1) {
			if (mouseOver(mx, my, centerButtonX, centerButton6Y, buttonWidth,buttonHeight)) {
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
		
		Rectangle onePlayer = new Rectangle(centerButtonX, centerButton1Y, w / 3, buttonHeight);

		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		pointerX = (int) b.getX();
		pointerY = (int) b.getY();
//////////////////////////////////////////////////SETTINGS///////////////////////////////////////////////////
		if (game.gameState == STATE.Settings) {
			// title
			g.setFont(font);
			g.setColor(Color.WHITE);
			int widthSettingsTitle = g.getFontMetrics().stringWidth("Settings");
			g.drawString("Settings", (w - widthSettingsTitle) / 2, (h / 120 * 29));
			g.setColor(Color.WHITE);
			g.setFont(font4);
			g.drawString("Music", leftButtonX + (offset),
					(int) (((h / 30) * 6.75) + (h / 10.8) + (((int) ((int) (h / 30) * 16 - (h / 10.8))) / 2)) + w / 54);
			g.drawString("Master volume", leftButtonX + (offset), (int) (((h / 30) * 6.75) + (h / 10.8)) + w / 54);
			g.drawString("English language", rightButtonX + (offset),
					(int) (((h / 30) * 6.75) + (h / 10.8) + (((int) ((int) (h / 30) * 16 - (h / 10.8))) / 2)) + w / 54);
			g.drawString("Czech language", rightButtonX + (offset), (int) (((h / 30) * 6.75) + (h / 10.8)) + w / 54);
			g.drawRect(offset, offset, w - (2 * (offset)), (offset) * 3);
			g.drawRect(offset, h - (4 * (offset)), w - (2 * (offset)), (offset) * 3);
			g.setColor(c);
			g.fillRect(offset, offset, w - (2 * (offset)), (offset) * 3);
			g.fillRect(offset, h - (4 * (offset)), w - (2 * (offset)), (offset) * 3);
				// master volume
			g.setColor(Color.WHITE);
			g.drawRect(leftButtonX, rightButtonY,rightButtonWidth, buttonHeight);
			g.setColor(c);
			if (phase==false) {
				g.setColor(Color.WHITE);
				g.fillRect(leftButtonX, (int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2),
						(w/32)*10, buttonHeight);
			} else if(phase==true){
				g.setColor(Color.WHITE);
				if (currentMasterVolume <= rightButtonWidth/20) {
					g.fillRect(leftButtonX, (int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2),
							0, buttonHeight);
				} else if (currentMasterVolume >= (rightButtonWidth/20)*19){ 
					g.fillRect(leftButtonX, (int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2),
							rightButtonWidth, buttonHeight);
				} else {
				g.fillRect(leftButtonX, (int) (((h / 30) * 6.75) + (h / 10.8)) + ((fieldHeight - buttonHeight) / 2),
						currentMasterVolume, buttonHeight);
				}
			}	// music volume
			g.setColor(Color.WHITE);
			g.drawRect(leftButtonX,rightButtonY + fieldHeight,rightButtonWidth, buttonHeight);
			g.setColor(c);
			if (phase2==false) {
				g.setColor(Color.WHITE);
				g.fillRect(leftButtonX ,rightButtonY + fieldHeight,rightButtonWidth, buttonHeight);
			} else if(phase2 == true){
				g.setColor(Color.WHITE);
				if (currentMusicVolume <= rightButtonWidth/20) {
					g.fillRect(leftButtonX ,rightButtonY + fieldHeight,0, buttonHeight);
				} else if (currentMusicVolume >= (rightButtonWidth/20)*19){ 
					g.fillRect(leftButtonX ,rightButtonY + fieldHeight,rightButtonWidth, buttonHeight);
				} else {
				g.fillRect(leftButtonX ,rightButtonY + fieldHeight,
						currentMusicVolume, buttonHeight);
				}
			}	// back
			if (back.contains(pointerX, pointerY)) {
				g.setFont(font2);
				g.setColor(c);
				g.drawRect(centerButtonX, centerButton6Y, buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(centerButtonX, centerButton6Y, buttonWidth,buttonHeight);
				g.setColor(Color.BLACK);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, centerButton6Y + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.setFont(font2);
				g.setColor(Color.WHITE);
				g.drawRect(centerButtonX, centerButton6Y, buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(centerButtonX, centerButton6Y, buttonWidth,buttonHeight);
				g.setColor(Color.WHITE);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, centerButton6Y + fontSize);
			}	// apply1
			if (apply1.contains(pointerX, pointerY)) {
				g.setFont(font2);
				g.setColor(c);
				g.drawRect(rightButtonX, rightButtonY,rightButtonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(rightButtonX,rightButtonY, rightButtonWidth,buttonHeight);
				g.setColor(Color.BLACK);
				int widthApply = g.getFontMetrics().stringWidth("Apply");
				g.drawString("Apply", rightButtonX + ((w / 32 * 10 - widthApply) / 2),rightButtonY + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.setFont(font2);
				g.setColor(Color.WHITE);
				g.drawRect(rightButtonX, rightButtonY,rightButtonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(rightButtonX,rightButtonY, rightButtonWidth,buttonHeight);
				g.setColor(Color.WHITE);
				int widthApply = g.getFontMetrics().stringWidth("Apply");
				g.drawString("Apply", rightButtonX + ((w / 32 * 10 - widthApply) / 2),rightButtonY + fontSize);
			}	// apply2
			if (apply2.contains(pointerX, pointerY)) {
				g.setFont(font2);
				g.setColor(c);
				g.drawRect(rightButtonX,rightButtonY + fieldHeight,rightButtonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(rightButtonX,rightButtonY + fieldHeight,rightButtonWidth, buttonHeight);
				g.setColor(Color.BLACK);
				int widthApply = g.getFontMetrics().stringWidth("Apply");
				g.drawString("Apply", rightButtonX + ((w / 32 * 10 - widthApply) / 2),rightButtonY + fieldHeight+ fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(rightButtonX,rightButtonY + fieldHeight,rightButtonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(rightButtonX,rightButtonY + fieldHeight,rightButtonWidth , buttonHeight);
				g.setColor(Color.WHITE);
				int widthApply = g.getFontMetrics().stringWidth("Apply");
				g.drawString("Apply", rightButtonX + ((w / 32 * 10 - widthApply) / 2),rightButtonY  + fieldHeight+ fontSize);
			}
		}	
		
//MENU//////////////////////////////////////////////MENU///////////////////////////////////////////////MENU//
		if (game.gameState == STATE.Menu) {
			// pong title
			g.setFont(font);
			g.setColor(Color.WHITE);
			int widthPongTitle = g.getFontMetrics().stringWidth("PONG");
			g.drawString("PONG", (w - widthPongTitle) / 2, (h / 120 * 29));
			g.setFont(font2);
				// one player
			if (onePlayer.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(centerButtonX, centerButton1Y, buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(centerButtonX, centerButton1Y, buttonWidth, buttonHeight);
				g.setColor(Color.BLACK);
				int widthOnePlayer = g.getFontMetrics().stringWidth("One player");
				g.drawString("One player", (w - widthOnePlayer) / 2, (centerButton1Y) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(centerButtonX, centerButton1Y, buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(centerButtonX, centerButton1Y, buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				int widthOnePlayer = g.getFontMetrics().stringWidth("One player");
				g.drawString("One player", (w - widthOnePlayer) / 2, (centerButton1Y) + fontSize);
			}	// 2 players
			if (twoPlayer.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(centerButtonX, centerButton2Y, buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(centerButtonX, centerButton2Y, buttonWidth,buttonHeight);
				g.setColor(Color.BLACK);
				int widthTwoPlayers = g.getFontMetrics().stringWidth("Two players");
				g.drawString("Two players", (w - widthTwoPlayers) / 2,centerButton2Y + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(centerButtonX, centerButton2Y, buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(centerButtonX, centerButton2Y, buttonWidth,buttonHeight);
				g.setColor(Color.WHITE);
				int widthTwoPlayers = g.getFontMetrics().stringWidth("Two players");
				g.drawString("Two players", (w - widthTwoPlayers) / 2,centerButton2Y + fontSize);
			}	// leaderboard
			if (leaderboard.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(centerButtonX, centerButton3Y, buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(centerButtonX, centerButton3Y, buttonWidth,buttonHeight);
				g.setColor(Color.BLACK);
				int widthLeaderboard = g.getFontMetrics().stringWidth("Leaderboard");
				g.drawString("Leaderboard", (w - widthLeaderboard) / 2,centerButton3Y + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(centerButtonX, centerButton3Y, buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(centerButtonX, centerButton3Y, buttonWidth,buttonHeight);
				g.setColor(Color.WHITE);
				int widthLeaderboard = g.getFontMetrics().stringWidth("Leaderboard");
				g.drawString("Leaderboard", (w - widthLeaderboard) / 2,centerButton3Y + fontSize);
			}	// settings
			if (settings.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(centerButtonX, centerButton4Y, buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(centerButtonX, centerButton4Y, buttonWidth,buttonHeight);
				g.setColor(Color.BLACK);
				int widthSettings = g.getFontMetrics().stringWidth("Settings");
				g.drawString("Settings", (w - widthSettings) / 2, centerButton4Y + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(centerButtonX, centerButton4Y, buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(centerButtonX, centerButton4Y, buttonWidth,buttonHeight);
				g.setColor(Color.WHITE);
				int widthSettings = g.getFontMetrics().stringWidth("Settings");
				g.drawString("Settings", (w - widthSettings) / 2, centerButton4Y + fontSize);
			}	// help
			if (help.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(centerButtonX, centerButton5Y, buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(centerButtonX, centerButton5Y, buttonWidth,buttonHeight);
				g.setColor(Color.BLACK);
				int widthHelp = g.getFontMetrics().stringWidth("Help");
				g.drawString("Help", (w - widthHelp) / 2, centerButton5Y + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(centerButtonX, centerButton5Y, buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(centerButtonX, centerButton5Y, buttonWidth,buttonHeight);
				g.setColor(Color.WHITE);
				int widthHelp = g.getFontMetrics().stringWidth("Help");
				g.drawString("Help", (w - widthHelp) / 2, centerButton5Y + fontSize);
			}	// quit
			if (quit.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(centerButtonX, centerButton6Y, buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(centerButtonX, centerButton6Y, buttonWidth,buttonHeight);
				g.setColor(Color.BLACK);
				int widthQuit = g.getFontMetrics().stringWidth("Quit");
				g.drawString("Quit", (w - widthQuit) / 2, centerButton6Y + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(centerButtonX, centerButton6Y, buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(centerButtonX, centerButton6Y, buttonWidth,buttonHeight);
				g.setColor(Color.WHITE);
				int widthQuit = g.getFontMetrics().stringWidth("Quit");
				g.drawString("Quit", (w - widthQuit) / 2, centerButton6Y + fontSize);
			}
			g.drawRect(offset, offset, w - (2 * (offset)), (offset) * 3);
			g.drawRect(offset, h - (4 * (offset)), w - (2 * (offset)), (offset) * 3);
			g.setColor(c);
			g.fillRect(offset, offset, w - (2 * (offset)), (offset) * 3);
			g.fillRect(offset, h - (4 * (offset)), w - (2 * (offset)), (offset) * 3);
		}
//HELP//////////////////////////////////////////////HELP///////////////////////////////////////////////HELP//
		if (game.gameState == STATE.Help) {
			// title
			g.setFont(font);
			g.setColor(Color.WHITE);
			int widthHelpTitle = g.getFontMetrics().stringWidth("Help");
			g.drawString("Help", (w - widthHelpTitle) / 2, (h / 120 * 29));
			g.setFont(font2);
			g.setColor(Color.WHITE);
			g.drawRect(offset, offset, w - (2 * (offset)), (offset) * 3);
			g.drawRect(offset, h - (4 * (offset)), w - (2 * (offset)), (offset) * 3);
			g.setColor(c);
			g.fillRect(offset, offset, w - (2 * (offset)), (offset) * 3);
			g.fillRect(offset, h - (4 * (offset)), w - (2 * (offset)), (offset) * 3);
				// back
			if (back.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(centerButtonX, centerButton6Y, buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(centerButtonX, centerButton6Y, buttonWidth,buttonHeight);
				g.setColor(Color.BLACK);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, centerButton6Y + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.setColor(Color.WHITE);
				g.drawRect(centerButtonX, centerButton6Y, buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(centerButtonX, centerButton6Y, buttonWidth,buttonHeight);
				g.setColor(Color.WHITE);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, centerButton6Y + fontSize);
			}
		}

//LEADERBOAD/////////////////////////////////////LEADEBOARD/////////////////////////////////////LEADERBOARD//
		if (game.gameState == STATE.Leaderboard) {
			g.setFont(font);
			g.setColor(Color.WHITE);
			int widthLeaderboardTitle = g.getFontMetrics().stringWidth("Leaderboard");
			g.drawString("Leaderboard", (w - widthLeaderboardTitle) / 2, (h / 120 * 29));
			g.setColor(Color.WHITE);
			g.drawRect(offset, offset, w - (2 * (offset)), (offset) * 3);
			g.drawRect(offset, h - (4 * (offset)), w - (2 * (offset)), (offset) * 3);
			g.setColor(c);
			g.fillRect(offset, offset, w - (2 * (offset)), (offset) * 3);
			g.fillRect(offset, h - (4 * (offset)), w - (2 * (offset)), (offset) * 3);
			g.setFont(font2);
				// back
			if (back.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(centerButtonX, centerButton6Y, buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(centerButtonX, centerButton6Y, buttonWidth,buttonHeight);
				g.setColor(Color.BLACK);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, centerButton6Y + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.setColor(Color.WHITE);
				g.drawRect(centerButtonX, centerButton6Y, buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(centerButtonX, centerButton6Y, buttonWidth,buttonHeight);
				g.setColor(Color.WHITE);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, centerButton6Y + fontSize);
			}
		}
//DIFFICULTY 1//////////////////////////////////DIFFICULTY 1///////////////////////////////////DIFFICULTY 1//
		if (game.gameState == STATE.Difficulty1) {
			g.setFont(font);
			g.setColor(Color.WHITE);
			int widthLengthTitle = g.getFontMetrics().stringWidth("Select game length");
			g.drawString("Select game length", (w - widthLengthTitle) / 2, (h / 120 * 29));
			g.setColor(Color.WHITE);
			g.setFont(font2);
				// same like in one menu...
			if (onePlayer.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(centerButtonX, centerButton1Y, buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(centerButtonX, centerButton1Y, buttonWidth, buttonHeight);
				g.setColor(Color.BLACK);
				int widthOnePlayer = g.getFontMetrics().stringWidth("3 lives");
				g.drawString("3 lives", (w - widthOnePlayer) / 2, (centerButton1Y) + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(centerButtonX, centerButton1Y, buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(centerButtonX, centerButton1Y,buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				int widthOnePlayer = g.getFontMetrics().stringWidth("3 lives");
				g.drawString("3 lives", (w - widthOnePlayer) / 2, (centerButton1Y) + fontSize);
			}
			if (twoPlayer.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(centerButtonX, centerButton2Y, buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(centerButtonX, centerButton2Y, buttonWidth,buttonHeight);
				g.setColor(Color.BLACK);
				int widthTwoPlayers = g.getFontMetrics().stringWidth("5 lives");
				g.drawString("5 lives", (w - widthTwoPlayers) / 2, centerButton2Y + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(centerButtonX, centerButton2Y, buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(centerButtonX, centerButton2Y, buttonWidth,buttonHeight);
				g.setColor(Color.WHITE);
				int widthTwoPlayers = g.getFontMetrics().stringWidth("5 lives");
				g.drawString("5 lives", (w - widthTwoPlayers) / 2, centerButton2Y  + fontSize);
			}
			if (leaderboard.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(centerButtonX, centerButton3Y, buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(centerButtonX, centerButton3Y, buttonWidth,buttonHeight);
				g.setColor(Color.BLACK);
				int widthLeaderboard = g.getFontMetrics().stringWidth("7 lives");
				g.drawString("7 lives", (w - widthLeaderboard) / 2,centerButton3Y + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.drawRect(centerButtonX, centerButton3Y, buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(centerButtonX, centerButton3Y, buttonWidth,buttonHeight);
				g.setColor(Color.WHITE);
				int widthLeaderboard = g.getFontMetrics().stringWidth("7 lives");
				g.drawString("7 lives", (w - widthLeaderboard) / 2,centerButton3Y + fontSize);
			}	// back
			if (back.contains(pointerX, pointerY)) {
				g.setColor(c);
				g.drawRect(centerButtonX, centerButton6Y, buttonWidth, buttonHeight);
				g.setColor(Color.WHITE);
				g.fillRect(centerButtonX, centerButton6Y, buttonWidth,buttonHeight);
				g.setColor(Color.BLACK);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, centerButton6Y + fontSize);
				g.setColor(Color.WHITE);
			} else {
				g.setColor(Color.WHITE);
				g.drawRect(centerButtonX, centerButton6Y, buttonWidth, buttonHeight);
				g.setColor(c);
				g.fillRect(centerButtonX, centerButton6Y, buttonWidth,buttonHeight);
				g.setColor(Color.WHITE);
				int widthQuit = g.getFontMetrics().stringWidth("Back");
				g.drawString("Back", (w - widthQuit) / 2, centerButton6Y + fontSize);
			}
			g.drawRect(offset, offset, w - (2 * (offset)), (offset) * 3);
			g.drawRect(offset, h - (4 * (offset)), w - (2 * (offset)), (offset) * 3);
			g.setColor(c);
			g.fillRect(offset, offset, w - (2 * (offset)), (offset) * 3);
			g.fillRect(offset, h - (4 * (offset)), w - (2 * (offset)), (offset) * 3);
		}
	}
}
