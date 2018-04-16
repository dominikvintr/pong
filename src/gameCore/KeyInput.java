package gameCore;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import gameCore.GameClass.STATE;
import gamePlayer_NPC.GameObject;
import gamePlayer_NPC.ID;
/**
 * Class which reads keyboard input
 * @author dominikvintr
 *
 */
public class KeyInput extends KeyAdapter {

	private Handler handler;
	private GameClass game;
	private boolean[] keyDown = new boolean[4];

	/**
	 * 
	 * @param handler
	 * @param game
	 */
	public KeyInput(Handler handler, GameClass game) {
		this.handler = handler;
		this.game = game;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}

	/**
	 * Observes which key is being pressed
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (double mili = 0; mili < 10; mili = mili + 0.200) {
			for (int i = 0; i < handler.getObject().size(); i++) {
				GameObject tempObject = handler.getObject().get(i);

				if (tempObject.getId() == ID.Player) {
					// key events for player 1

					if (key == KeyEvent.VK_W) {
						keyDown[0] = true;
						tempObject.setVelY(-5 - mili);
					}	
					if (key == KeyEvent.VK_S) {
						keyDown[1] = true;
						tempObject.setVelY(5 + mili); 
					}
				}
				if (tempObject.getId() == ID.Player2) {
					// key events for player 2

					if (key == KeyEvent.VK_UP) {
						keyDown[2] = true;
						tempObject.setVelY(-5 - mili);
					}
					if (key == KeyEvent.VK_DOWN) {
						keyDown[3] = true;
						tempObject.setVelY(5 + mili);
					}
				}
			}
		}
		
		if (key == KeyEvent.VK_ESCAPE) {
			if (game.gameState == STATE.Help || game.gameState == STATE.Leaderboard || game.gameState == STATE.Settings || game.gameState == STATE.Difficulty1) {
				game.gameState = STATE.Menu;
			}
		}
		
		if (key == KeyEvent.VK_P || key == KeyEvent.VK_ESCAPE) {
			if (game.gameState == STATE.GameClass) {
				if (GameClass.paused) {
					GameClass.paused = false; 
				} else {
					GameClass.paused = true;
				}
			}
			if (game.gameState == STATE.Paused) {
				if (GameClass.paused) {
					GameClass.paused = false; 
				} else {
					GameClass.paused = true;
				}
			}
		}

	}
	/**
	 * Observes when pressed key is released
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.getObject().size(); i++) {
			GameObject tempObject = handler.getObject().get(i);

			if (tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2) {
				// key events for player 1

				if (key == KeyEvent.VK_W) {
					keyDown[0] = false;
				}
				if (key == KeyEvent.VK_S) {
					keyDown[1] = false;
				}
				if (key == KeyEvent.VK_UP) {
					keyDown[2] = false;
				}
				if (key == KeyEvent.VK_DOWN) {
					keyDown[3] = false;
				}
				
				if(!(keyDown[0] && keyDown[1])) {
					tempObject.setVelY(0);
				} 
				if (!(keyDown[2] && keyDown[3])) {
					tempObject.setVelY(0);
				}
			}
		}

	}
}
