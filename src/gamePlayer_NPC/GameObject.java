package gamePlayer_NPC;

import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * Game Object abstract class
 * Includes all important getters and setters for game objects
 * @author dominikvintr
 *
 */
public abstract class GameObject {
	
	protected int x;
	protected  int y; 
	protected ID id;
	protected int velX;
	double velY;
	/**
	 * 
	 * @param x
	 * @param y
	 * @param id
	 */
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	/**
	 * Tick abstract method
	 */
	public abstract void tick();
	/**
	 * Render abstract method
	 * @param g
	 */
	public abstract void render(Graphics g);
	/**
	 * Abstract rectangle
	 * @return
	 */
	public abstract Rectangle getBounds();
	/**
	 * Sets x coordinate
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Sets y coordinate
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Gets x coordinate
	 * @return
	 */
	public int getX() {
		return x;
	}
	/**
	 * Gets y coordinate
	 * @return
	 */
	public int getY() {
		return y;
	}
	/**
	 * Sets ID
	 * @param id
	 */
	public void setId(ID id) {
		this.id = id;
	}
	/**
	 * Gets ID
	 * @return
	 */
	public ID getId() {
		return id;
	}
	/**
	 * Sets Velocity for x coordinate
	 * @param velX
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}
	/**
	 * Sets Velocity for y coordinate
	 * @param velY
	 */
	public void setVelY(double d) {
		this.velY = d;
	}
	/**
	 * Gets Velocity for x coordinate
	 * @return
	 */
	public int getVelX() {
		return velX;
	}
	/**
	 * Gets Velocity for y coordinate
	 * @return
	 */
	public double getVelY() {
		return velY;
	}
}
