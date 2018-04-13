package gameCore;

import java.awt.Graphics;
import java.util.LinkedList;

import gamePlayer_NPC.GameObject;
import gamePlayer_NPC.ID;

public class Handler {

	private LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		for (int i = 0; i < getObject().size(); i++) {
			GameObject tempObject = getObject().get(i);

			tempObject.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < getObject().size(); i++) {
			GameObject tempObject = getObject().get(i);

			tempObject.render(g);
		}
	}
	
	public void clear() {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			if (tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2 || tempObject.getId() == ID.Opponent) {
				object.clear();
			}
		}
	}

	public void addObject(GameObject object) {
		this.getObject().add(object);
	}

	public void removeObject(GameObject object) {
		this.getObject().remove(object);
	}

	public LinkedList<GameObject> getObject() {
		return object;
	}

	public void setObject(LinkedList<GameObject> object) {
		this.object = object;
	}

}
