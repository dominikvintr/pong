package gamePlayer_NPC;

import java.util.Random;

import gameCore.GameClass;
import gameCore.HUD;
import gameCore.Handler;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private Random r = new Random();

	private int scoreKeep = 0;

	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}

	public void tick() {
//		if (hud.getHealth() == 0) {
//			System.exit(1);
//		}
	

//		if (scoreKeep % 500 == 0) {
//			hud.setLevel(hud.getLevel() + 1);
//			handler.addObject(new BasicEnemy(r.nextInt(GameClass.WIDTH), r.nextInt(GameClass.HEIGHT), ID.BasicEnemy, handler));
//		}
		scoreKeep++;
	}
	
}
