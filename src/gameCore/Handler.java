package gameCore;

import java.awt.Graphics;
import java.util.LinkedList;

import gamePlayer_NPC.GameObject;
import gamePlayer_NPC.ID;
/**
 * Handler class adds requested objects to the game
 * @author dominikvintr
 *
 */
public class Handler {

	private LinkedList<GameObject> object = new LinkedList<GameObject>();
	/**
	 * tick method
	 */
	public void tick() {
		for (int i = 0; i < getObject().size(); i++) {
			GameObject tempObject = getObject().get(i);

			tempObject.tick();
		}
	}
	/**
	 * render method
	 * @param g
	 */
	public void render(Graphics g) {
		for (int i = 0; i < getObject().size(); i++) {
			GameObject tempObject = getObject().get(i);

			tempObject.render(g);
		}
	}
	/**
	 * Method for clearing unwanted objects of the game
	 */
	public void clear() {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			if (tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2 || tempObject.getId() == ID.Opponent) {
				object.clear();
			}
		}
	}
	/**
	 * Method to add an object
	 * @param object
	 */
	public void addObject(GameObject object) {
		this.getObject().add(object);
	}
	/**
	 * Method to remove an object
	 * @param object
	 */
	public void removeObject(GameObject object) {
		this.getObject().remove(object);
	}
	/**
	 * Lists game objects
	 * @return
	 */
	public LinkedList<GameObject> getObject() {
		return object;
	}
	/**
	 * Sets game objects
	 * @param object
	 */
	public void setObject(LinkedList<GameObject> object) {
		this.object = object;
	}

}
