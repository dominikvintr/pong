package gameCore;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import gameCore.GameClass.STATE;
import gamePlayer_NPC.Ball;
import gamePlayer_NPC.GameObject;
import gamePlayer_NPC.ID;
import gamePlayer_NPC.Opponent;
import gamePlayer_NPC.Player;
//import gamePlayer_NPC.Spawn;

public class GameClass extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4106619175266317446L;

	static Screen sc = new Screen();
	static int scWidth = sc.getScreenWidth();
	static int scHeight = sc.getScreenHeight();
	static int scWinHeight = sc.windowsSize();

	public static final int WIDTH = scWidth, HEIGHT = scHeight;

	private Thread thread;
	private boolean running = false;
	
	public static boolean paused = false;

	private Random r;
	private Handler handler;
	private HUD hud;
	private Menu menu;
	
	private Counter counter;
	public int options;
	private int handlerOption = 1;
	public GameObject tempObject;
	
	public void setHandler (int handlerNum) {
		handlerOption = handlerNum;
	}

	public enum STATE {
		Menu, GameClass, Counter, Help, Settings, Leaderboard, Paused, Difficulty1, Difficulty2
	};

	public STATE gameState = STATE.Menu;

	public GameClass() throws InterruptedException {

		handler = new Handler();
		menu = new Menu(this, handler);
		counter = new Counter();
		this.addKeyListener(new KeyInput(handler,this));
		this.addMouseListener(menu);
		this.addMouseListener(new MouseInput(this, handler));

		new Window(WIDTH, HEIGHT, "Let's do this!", this);

		hud = new HUD();
		r = new Random();
	
	}

	public synchronized void start() throws InterruptedException {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(("FPS: " + frames));
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {

		if (gameState == STATE.GameClass) {
			if(!paused){ 
				
				handler.tick();
				hud.tick();
				if (gameState == STATE.Menu) {
				menu.tick();
				}
				if (gameState == STATE.Counter) {
				counter.tick();
				}
			}
		}
			
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		
		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(paused) {
			int buttonHeight = (GameClass.HEIGHT - ((GameClass.HEIGHT / 120) * 52)) / 17 * 2;
			int buttonWidth = GameClass.WIDTH / 3;
			int fontSize = (int) (buttonHeight * 0.75);
			Color c = new Color(1, 1, 1, .1f);
			
			Font font = new Font("arial", 1, 90);
			g.setFont(font);
			g.setColor(Color.WHITE);

			int widthPongTitle = g.getFontMetrics().stringWidth("PAUSED");
			g.drawString("PAUSED", (GameClass.WIDTH - widthPongTitle) / 2, (GameClass.HEIGHT / 120 * 29));

			Font font2 = new Font("calibri light", 1, fontSize);
			g.setFont(font2);
			g.setColor(Color.WHITE);
		}
		
		// keep this one up
		
		if (handlerOption == 1) {
			handler.render(g);
		}
		if (!(handlerOption == 1)) {
			handler.clear();
		}
		if (gameState == STATE.GameClass) {
			hud.render(g);
		} else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.Settings || gameState == STATE.Leaderboard || gameState == STATE.Difficulty1){
			menu.render(g);
		} else if (gameState == STATE.Counter) {
			counter.render(g);
		}

		g.dispose();
		bs.show();
	}

	public static int clamp(int var, int min, int max) {
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
	}

	public static void main(String args[]) throws InterruptedException {
		new GameClass();
	}
}
